package com.prueba.tecnica.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Min(value = 1)
    private int comercioId;
    
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date fecha;
    
    @NotBlank
    private String medioCompra;
    
    @NotBlank
    private String comprador;
    
    @NotBlank
    private String lugar;
    
    @NotNull
    private float montoTotal;

    @ManyToOne
    @JoinColumn(name = "ComercioID")
    private Comercio comercio;

	public Compra() {
		super();
	}

	public Compra(Long id, @NotNull @Min(1) int comercioId, Date fecha, @NotBlank String medioCompra,
			@NotBlank String comprador, @NotBlank String lugar, @NotNull float montoTotal) {
		super();
		this.id = id;
		this.comercioId = comercioId;
		this.fecha = fecha;
		this.medioCompra = medioCompra;
		this.comprador = comprador;
		this.lugar = lugar;
		this.montoTotal = montoTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getComercioId() {
		return comercioId;
	}

	public void setComercioId(int comercioId) {
		this.comercioId = comercioId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMedioCompra() {
		return medioCompra;
	}

	public void setMedioCompra(String medioCompra) {
		this.medioCompra = medioCompra;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
}
