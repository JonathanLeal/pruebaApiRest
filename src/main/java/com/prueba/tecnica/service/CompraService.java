package com.prueba.tecnica.service;

import java.util.Date;
import java.util.List;

import com.prueba.tecnica.entity.Compra;

public interface CompraService {
	public void registrarCompra(Compra compra);
	public List<Compra> getComprasByComercioNombre(String nombre);
	public List<Compra> getComprasByFecha(Date fecha);
	public List<Compra> getComprasByMedioDeCompra(String medioDePago);
}
