package com.prueba.tecnica.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.entity.Compra;
import com.prueba.tecnica.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService compraSer;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> registrar(@Valid @RequestBody Compra compra, BindingResult result){
		try {
			if (result.hasErrors()) {
				return validaciones(result);
			}
			compraSer.registrarCompra(compra);
			return ResponseEntity.status(HttpStatus.OK).body("Compra realizada con exito");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/{nombre}")
    public List<Compra> getComprasByComercioNombre(@PathVariable String nombre) {
        return compraSer.getComprasByComercioNombre(nombre);
    }
	
	@GetMapping("/{fecha}")
    public List<Compra> getComprasByFecha(@PathVariable Date fecha) {
        return compraSer.getComprasByFecha(fecha);
    }
	
	@GetMapping("/{medioDeCompra}")
    public List<Compra> getComprasByMedioDeCompra(@PathVariable String medioDeCompra) {
        return compraSer.getComprasByMedioDeCompra(medioDeCompra);
    }
	
	//se usara para validar los post
	public ResponseEntity<?> validaciones(BindingResult result){
		Map<String, String> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), "El campo: " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
	}
}
