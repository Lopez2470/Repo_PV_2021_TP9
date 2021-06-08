package ar.edu.unju.fi.tp9.service.imp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Cliente;
import ar.edu.unju.fi.tp9.service.IClienteService;
import ar.edu.unju.fi.tp9.util.TablaCliente;

/*@Service("clienteUtilService")*/
@Service("clienteServiceSimple")
public class ClienteServiceImp implements IClienteService {

	private List<Cliente> clientes;
	@Autowired
	Cliente cliente;

	@Override
	public void generarTablaCliente() {
		clientes = TablaCliente.listaClientes;
		/*clientes.add(new Cliente("Documento", 20159753, "Maria Diaz", "email@hot.com","password", LocalDate.of(1980,05,20), 20, 388, 5123963, LocalDate.of(2020, 10,20)));*/
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		if (clientes==null) {
			generarTablaCliente();
		}
		//cliente.getEdad();
		clientes.add(cliente);

	}
	
	@Override
	public List<Cliente> obtenerClientes() {
		return clientes;
	}

	@Override
	public Cliente getCliente() {
		return cliente;
	}
	
	
	@Override
	public Cliente getClientePorDni(int nroDocumento) {
		return null;
	}


	@Override
	public Optional<Cliente> getClientePorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCliente(Long id) {
		// TODO Auto-generated method stub
	}
}
