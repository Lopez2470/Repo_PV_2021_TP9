package ar.edu.unju.fi.tp9.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Compra;
import ar.edu.unju.fi.tp9.service.ICompraService;
import ar.edu.unju.fi.tp9.util.TablaCompra;

@Service("compraServiceSimple")
public class CompraServiceImp implements ICompraService {
	
	List<Compra> compras = TablaCompra.listaCompras;
	
	@Override
	public void generarTablaCompra() {
	}
	
	@Override
	public void guardarCompra(Compra compra) {
		if (compras==null) {
			generarTablaCompra();
		}
		compras.add(compra);
	}

	@Override
	public List<Compra> obtenerCompras() {
		return compras;
	}

	@Override
	public Optional<Compra> getCompraPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCompra(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Compra> buscarCompras(String prod_nombre, double comp_total) {
		// TODO Auto-generated method stub
		return null;
	}
}

