package com.formacion.springboot.app.venta.models.dto;

public class Venta {
	
	private Integer cantidad;
	private Libro libro;
	
	public Venta() {
	}
	public Venta(Integer cantidad, Libro libro) {
		this.cantidad = cantidad;
		this.libro = libro;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public Double getTotal() {
		return libro.getValor() * cantidad;
	}

}
