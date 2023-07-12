package com.prueba.tecnica.service;

import java.util.List;

import com.prueba.tecnica.entity.Comercio;

public interface ComercioService {
	public List<Comercio> listarComercios();
	public Comercio encontrarComercio(Long id);
	public void guardarComercio(Comercio comercio);
	public void eliminarComercio(Comercio comercio);
}
