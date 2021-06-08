package ar.edu.unju.fi.tp9.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp9.controller.ProductoController;
import ar.edu.unju.fi.tp9.model.Producto;
import ar.edu.unju.fi.tp9.service.IProductoService;

@Controller
public class ProductoController {
	private static final Log  LOGGER = LogFactory.getLog(ProductoController.class);
	
	@Autowired
	private Producto producto;
	
	@Autowired
	@Qualifier("productoServiceMysql")
	IProductoService productoService;
	
	/*Pagina para ingresar los campos de Producto*/
	@GetMapping("/producto")
	public String getProductoFormPage(Model model) {
		model.addAttribute(producto);
		LOGGER.info("METHOD: getProductoFormPage()");
		LOGGER.info("RESULT: Visualiza la pagina producto-nuevo.html");
		return "producto-nuevo";
	}
			
	/*Pagina que informa el alta del producto nuevo*/
	@PostMapping("/producto/guardar")
	public ModelAndView guardarProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult resultadoValidacion) {
		//ModelAndView modelView = new ModelAndView("producto-listado");
		ModelAndView modelView; 
		if(resultadoValidacion.hasErrors()) {
			modelView = new ModelAndView("producto-nuevo");
			return modelView;
		}else {
			productoService.altaProducto(producto);
			modelView = new ModelAndView("producto-listado");
			modelView.addObject("productos", productoService.getAllProductos());
			return modelView;
		}
	
	}	
	@GetMapping("/producto/listado")
	public ModelAndView getProductoListadoPage() {
		ModelAndView modelView = new ModelAndView("producto-listado");
		if (productoService.getAllProductos()==null) {
			productoService.generarTablaProducto();
		}
		modelView.addObject("productos", productoService.getAllProductos());
		return modelView;
	}
	
	
	@GetMapping("/home")
	public String getPageHome() {
		return("home");
	}
	
	@GetMapping("/producto/editar/{id}")
	public ModelAndView getProductoEditPage(@PathVariable(value = "id") Long id) {
		ModelAndView modelView = new ModelAndView("producto-nuevo");
		Optional<Producto> producto = productoService.getProductoPorId(id);
		modelView.addObject("producto",producto);
		return modelView;
	}
	
	@GetMapping("/producto/eliminar/{id}")
	public ModelAndView getProductoEliminar(@PathVariable(value = "id") Long id){
		ModelAndView modelView = new ModelAndView("redirect:/producto/listado");
		productoService.eliminarProducto(id);
		return modelView;
	}	
}
