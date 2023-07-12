package com.prueba.tecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.entity.Comercio;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Long>{

}
