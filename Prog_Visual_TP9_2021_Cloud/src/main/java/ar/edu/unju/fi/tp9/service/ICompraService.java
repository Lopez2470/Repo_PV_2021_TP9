package ar.edu.unju.fi.tp9.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp9.model.Compra;

public interface ICompraService {
	
	public void generarTablaCompra();
	
	public void guardarCompra(Compra compra);
	
	public List<Compra> obtenerCompras();
	
	public Optional<Compra> getCompraPorId(Long id);
	
	public void eliminarCompra(Long id);
	
	public List<Compra> buscarCompras(String prod_nombre, double comp_total);
}