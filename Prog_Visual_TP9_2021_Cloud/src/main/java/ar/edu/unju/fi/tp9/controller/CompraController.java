package ar.edu.unju.fi.tp9.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/*import org.springframework.beans.factory.annotation.Qualifier;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp9.model.Compra;
import ar.edu.unju.fi.tp9.model.Producto;
import ar.edu.unju.fi.tp9.service.ICompraService;
import ar.edu.unju.fi.tp9.service.IProductoService;


@Controller
public class CompraController {
	@Autowired
	private Compra compra;
	
	@Autowired
	@Qualifier("productoServiceMysql")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("compraServiceMysql")
	private ICompraService compraService;
	
	@GetMapping("/compras")
	public String getNuevaCompraPage(Model model) {
		model.addAttribute("compra", compra);
		model.addAttribute("productos", productoService.getAllProductos());
		return "compra-nueva";
	}
	
	@PostMapping("/compra/guardar")
	//public ModelAndView guardarCompraPage(@ModelAttribute("compra") Compra compra){
	public ModelAndView guardarProductoPage(@Valid @ModelAttribute("compra") Compra compra, BindingResult resultadoValidacion) {
		//ModelAndView modelView = new ModelAndView("compras-listado");
		ModelAndView modelView;
		if(resultadoValidacion.hasErrors()) {
			modelView = new ModelAndView("compra-nueva");
			modelView.addObject("productos", productoService.getAllProductos());
			return modelView;
		}else{
			modelView = new ModelAndView("compras-listado");
			
			Producto producto = productoService.getProductoPorCodigo(compra.getProducto().getCodigo());
			compra.setProducto(producto);
			compra.setTotal(compra.getCantidad()*producto.getPrecio());
			compraService.guardarCompra(compra);
			
			modelView.addObject("compras", compraService.obtenerCompras());
			return modelView;
		}	
	}
	
	@GetMapping("/compras/listado")
	public ModelAndView getComprasPage() {
		ModelAndView modelView = new ModelAndView("compras-listado");
		if (compraService.obtenerCompras()==null) {
			compraService.generarTablaCompra();
		}
		modelView.addObject("compras-listado", compraService.obtenerCompras());
		return modelView;
		
		/*public String getListadoCompraPage(Model model) {
			model.addAttribute("compra", compra);
			model.addAttribute("compras", compraService.getCompras());
			return "compras";
		*/		
	}
	
	@GetMapping("/compra/editar/{id}")
	public ModelAndView getCompraEditPage(@PathVariable(value = "id") Long id) {
		ModelAndView modelView = new ModelAndView("compra-nueva");
		Optional<Compra> compra = compraService.getCompraPorId(id);
		modelView.addObject("compra",compra);
		modelView.addObject("productos", productoService.getAllProductos());
		
		return modelView;
	}
	

	@GetMapping("/compra/eliminar/{id}")
	public ModelAndView getCompraliminar(@PathVariable(value = "id") Long id){
		ModelAndView modelView = new ModelAndView("redirect:/compras/listado");
		compraService.eliminarCompra(id);
		return modelView;
	}
	
	
	
	@GetMapping("/compra/busqueda")
	public String buscarProductoPorFiltro(@RequestParam(name = "producto.nombre")String prod_nombre, 
			@RequestParam(name = "total")double comp_total, Model model, @ModelAttribute(name = "compra")Compra compra) {
		//model.addAttribute("compra");
		model.addAttribute("compras", compraService.obtenerCompras());
		model.addAttribute("compras", compraService.buscarCompras(prod_nombre, comp_total));
		return "compras-listado";
	}
	

}
