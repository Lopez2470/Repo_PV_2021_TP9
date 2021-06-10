package ar.edu.unju.fi.tp9.service;

import java.util.List;

import ar.edu.unju.fi.tp9.model.Beneficio;

public interface IBeneficioService {
	
	public void guardarBeneficio(Beneficio beneficio);

	public List<Beneficio> obtenerBeneficios();
	
	public Beneficio buscarBeneficio(Long id);
}
