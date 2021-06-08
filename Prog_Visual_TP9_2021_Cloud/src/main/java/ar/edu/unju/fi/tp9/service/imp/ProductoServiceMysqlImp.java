package ar.edu.unju.fi.tp9.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Producto;
import ar.edu.unju.fi.tp9.repository.IProductoRepository;
import ar.edu.unju.fi.tp9.service.IProductoService;

@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;
		
	@Override
	public void altaProducto(Producto producto) {
		productoRepository.save(producto);		
	}
		
	@Override
	public Producto getUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}
		
	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Producto> getAllProductos() {
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		return productos;
	}
		
	@Override
	public Producto getProductoPorCodigo(int codigo) {
		Producto producto = productoRepository.findByCodigo(codigo);
		return producto;
	}
		
	@Override
	public void generarTablaProducto() {
		// TODO Auto-generated method stub	
	}

	@Override
	public Optional<Producto> getProductoPorId(Long id) {
		Optional<Producto> producto = productoRepository.findById(id);
		return producto;
	}

	@Override
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);	
	}	
}