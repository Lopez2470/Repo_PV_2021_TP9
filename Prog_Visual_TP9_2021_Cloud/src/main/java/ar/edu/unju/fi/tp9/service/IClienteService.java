package ar.edu.unju.fi.tp9.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp9.model.Cliente;

public interface IClienteService {
	
	public void generarTablaCliente();
	
	public void guardarCliente(Cliente cliente);
	
	public List<Cliente> obtenerClientes();

	public Cliente getCliente();
	
	public Cliente getClientePorDni(int nroDocumento);
	
	public Optional<Cliente> getClientePorId(Long id);
	
	public void eliminarCliente(Long id);	
}