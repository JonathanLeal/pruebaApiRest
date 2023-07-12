package com.prueba.tecnica.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.tecnica.entity.Compra;
import com.prueba.tecnica.repository.CompraRepository;

@Service
public class CompraServiceImpl implements CompraService{
	
	@Autowired
	private CompraRepository compraRepo;

	@Override
	@Transactional
	public void registrarCompra(Compra compra) {
		compraRepo.save(compra);
	}

	@Transactional(readOnly = true)
	public List<Compra> getComprasByComercioNombre(String nombre) {
        return compraRepo.getComprasByComercioNombre(nombre);
    }
	
	@Transactional(readOnly = true)
	public List<Compra> getComprasByFecha(Date fecha) {
        return compraRepo.getComprasByFecha(fecha);
    }
	
	@Transactional(readOnly = true)
	public List<Compra> getComprasByMedioDeCompra(String medioDeCompra) {
        return compraRepo.getComprasByMedioDeCompra(medioDeCompra);
    }
}
