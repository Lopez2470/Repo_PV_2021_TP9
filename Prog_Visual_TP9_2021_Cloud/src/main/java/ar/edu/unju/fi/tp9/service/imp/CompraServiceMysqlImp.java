package ar.edu.unju.fi.tp9.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Compra;
import ar.edu.unju.fi.tp9.repository.ICompraRepository;
import ar.edu.unju.fi.tp9.service.ICompraService;

@Service("compraServiceMysql")
public class CompraServiceMysqlImp implements ICompraService{

	@Autowired
	private ICompraRepository compraRepository;
	
	@Override
	public void generarTablaCompra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCompra(Compra compra) {
		compraRepository.save(compra);	
	}

	@Override
	public List<Compra> obtenerCompras() {
		List<Compra> compras = (List<Compra>) compraRepository.findAll();
		return compras;
	}

	@Override
	public Optional<Compra> getCompraPorId(Long id) {
		Optional<Compra> compra = compraRepository.findById(id);
		return compra;
	}

	@Override
	public void eliminarCompra(Long id) {
		compraRepository.deleteById(id);
		
	}

	@Override
	public List<Compra> buscarCompras(String prod_nombre, double comp_total) {
		List<Compra> compras = new ArrayList<Compra>();
		if(!prod_nombre.isEmpty() && comp_total>=0)
			compras = compraRepository.findByProductoNombreAndTotalGreaterThanEqual(prod_nombre, comp_total);
		else if(prod_nombre.isEmpty() && comp_total>=0)
			compras = compraRepository.findByTotalGreaterThanEqual(comp_total);
		return compras;
	}
}
