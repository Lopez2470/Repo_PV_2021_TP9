package ar.edu.unju.fi.tp9.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Beneficio;
import ar.edu.unju.fi.tp9.repository.IBeneficioRepository;
import ar.edu.unju.fi.tp9.service.IBeneficioService;

@Service("beneficioServiceMysql")
public class BeneficioServiceMysqlmp implements IBeneficioService{

	@Autowired
	IBeneficioRepository beneficioRepository;
	
	@Override
	public void guardarBeneficio(Beneficio beneficio) {
		beneficioRepository.save(beneficio);		
	}

	@Override
	public List<Beneficio> obtenerBeneficios() {
		return (List<Beneficio>)beneficioRepository.findAll();
	}

	@Override
	public Beneficio buscarBeneficio(Long id) {
		return beneficioRepository.findById(id).orElse(null);
	}
}