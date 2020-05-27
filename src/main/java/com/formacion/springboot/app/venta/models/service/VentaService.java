package com.formacion.springboot.app.venta.models.service;

import java.util.List;

import com.formacion.springboot.app.venta.models.Venta;

public interface VentaService {

	public List<Venta> findAll();
	public Venta findById(Long id, Integer cantidad);
	 
}
