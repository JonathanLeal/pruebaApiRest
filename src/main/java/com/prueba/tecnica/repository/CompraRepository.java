package com.prueba.tecnica.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
	
	@Query("SELECT c FROM Compra c RIGHT JOIN c.comercio co WHERE co.Nombre = :nombre")
    List<Compra> getComprasByComercioNombre(String nombre);
	
	@Query("SELECT c FROM Compra c RIGHT JOIN c.comercio co WHERE c.Fecha = :fecha")
    List<Compra> getComprasByFecha(Date fecha);
	
	@Query("SELECT c FROM Compra c RIGHT JOIN c.comercio co WHERE co.medioDeCompra = :medioDeCompra")
    List<Compra> getComprasByMedioDeCompra(String medioDeCompra);
}
