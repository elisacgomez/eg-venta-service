package com.formacion.springboot.app.venta.service;

import java.util.List;

import com.formacion.springboot.app.common.models.entity.Libro;
import com.formacion.springboot.app.venta.models.Venta;

public interface VentaService {

	public List<Venta> findAll();
	public Venta findById(Long id, Integer cantidad);
	
	public Libro save(Libro libro);
	
	public Libro update(Libro libro, Long id);
	
	public void delete(Long id);
	
}
