package com.prueba.tecnica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.tecnica.entity.Comercio;
import com.prueba.tecnica.repository.ComercioRepository;

@Service
public class ComercioServiceImpl implements ComercioService{
	
	@Autowired
	private ComercioRepository comerRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Comercio> listarComercios() {
		List<Comercio> lista = comerRepo.findAll();
		if (lista.size() == 0) {
			throw new IllegalAccessError("No hay comercios listados");
		}
		return lista;
	}

	@Override
	@Transactional
	public void guardarComercio(Comercio comercio) {
		comerRepo.save(comercio);
	}

	@Override
	@Transactional
	public void eliminarComercio(Comercio comercio) {
		Long id = comercio.getId();
		Optional<Comercio> idOptional = comerRepo.findById(id);
		if (idOptional.isEmpty()) {
			throw new IllegalAccessError("No se encontro el id del comercio");
		}
		Comercio idEntity = idOptional.get();
		comerRepo.delete(idEntity);
	}

	@Override
	@Transactional(readOnly = true)
	public Comercio encontrarComercio(Long id) {
		Optional<Comercio> idOptional = comerRepo.findById(id);
		if (idOptional.isEmpty()) {
			throw new IllegalAccessError("No se encontro el id del comercio");
		}
		Comercio idEntity = idOptional.get();
		return idEntity;
	}

}
