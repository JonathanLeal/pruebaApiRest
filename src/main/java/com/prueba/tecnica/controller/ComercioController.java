package com.prueba.tecnica.controller;

import java.util.HashMap;
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

import com.prueba.tecnica.entity.Comercio;
import com.prueba.tecnica.service.ComercioService;

@RestController
@RequestMapping("/comercio")
public class ComercioController {
	
	@Autowired
	private ComercioService comerSer;
	
	@GetMapping("/lista")
	public ResponseEntity<?> listar(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(comerSer.listarComercios());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> obtener(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(comerSer.encontrarComercio(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody Comercio comercio, BindingResult result){
		try {
			if (result.hasErrors()) {
				return validaciones(result);
			}
			comerSer.guardarComercio(comercio);
			return ResponseEntity.status(HttpStatus.OK).body("Comercio guardado con exito");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> eliminar(@RequestBody Comercio comercio){
		try {
			comerSer.eliminarComercio(comercio);
			return ResponseEntity.status(HttpStatus.OK).body("Comercio eliminado con exito");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
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
