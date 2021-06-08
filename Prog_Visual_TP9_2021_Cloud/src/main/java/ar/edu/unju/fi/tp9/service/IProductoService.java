package ar.edu.unju.fi.tp9.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp9.model.Producto;

public interface IProductoService {
	
	/* Agrega un nuevo producto a la base de datos*/
	public void altaProducto(Producto producto);
	
	/*Visualiza al ultimo producto dado de alta*/
	public Producto getUltimoProducto();
	
	public Producto getProducto();
	
	/*Visualiza todos los productos dados de alta*/
	public List<Producto> getAllProductos();
	
	/*Encontrar un producto a travez de su codigo*/
	public Producto getProductoPorCodigo(int codigo);
	
	public void generarTablaProducto();

	public Optional<Producto> getProductoPorId(Long id);
	
	public void eliminarProducto(Long id);
}
