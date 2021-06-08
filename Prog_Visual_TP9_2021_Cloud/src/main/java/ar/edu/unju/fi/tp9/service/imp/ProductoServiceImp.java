package ar.edu.unju.fi.tp9.service.imp;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Producto;
import ar.edu.unju.fi.tp9.service.IProductoService;
import ar.edu.unju.fi.tp9.service.imp.ProductoServiceImp;
import ar.edu.unju.fi.tp9.util.TablaProducto;

@Service("productoServiceSimple")
public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	Producto producto;
	
	private List<Producto> productos = new ArrayList<Producto>();
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
		
	@Override
	public void generarTablaProducto() {
		productos = TablaProducto.listaProductos;
		//productos.add(new Producto(201, "Producto 201", 2010.00, "Marca 201", 10));
		LOGGER.info("METHOD: generarTablaClientes: ");
		LOGGER.info("RESULT:" + "Tabla Generada: " );	
	}
	
	/*Se realiza el alta del producto nuevo a la lista 'productos'*/
	@Override
	public void altaProducto(Producto producto) {
		if (productos==null) {
			generarTablaProducto();	
		}
		productos.add(producto);
		LOGGER.info("METHOD: altaProducto(Producto producto): Agrega el objeto Producto a la lista de productos");
		LOGGER.info("RESULT:" + productos.get(productos.size() -1));
	}
	
	/*Se busca el ultimo objeto dado de alta*/
	@Override
	public Producto getUltimoProducto() {
		Producto aux_producto = productos.get(productos.size() -1);
		LOGGER.info("METHOD: getUltimoProducto(): Se realiza la busqueda del ultimo objeto Producto agregado a la lista de productos");
		/*LOGGER.info("RESULT:" +  productos.get(productos.size() -1));*/	
		return aux_producto;
	}
	
	@Override
	public Producto getProducto() {
		return this.producto;
	}
	
	/*Visualiza al ultimo producto dado de alta*/
	@Override
	public List<Producto> getAllProductos() {
		return productos;
	}

	@Override
	public Producto getProductoPorCodigo(int codigo) {
		Producto Aux_producto = new Producto();
		for (Producto p : productos) {
			if (p.getCodigo() == codigo) {
				Aux_producto = p;
			}
		}
		return Aux_producto;
	}

	@Override
	public Optional<Producto> getProductoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub	
	}	
}