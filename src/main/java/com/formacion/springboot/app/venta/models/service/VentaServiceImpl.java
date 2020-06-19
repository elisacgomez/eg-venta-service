package com.formacion.springboot.app.venta.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.springboot.app.venta.clientes.LibroClienteRest;
import com.formacion.springboot.app.venta.models.Venta;


@Service("serviceFeign")
public class VentaServiceImpl implements VentaService{
	
	@Autowired
	private LibroClienteRest clienteFeign;

	@Override
	public List<Venta> findAll() {
		return clienteFeign.obtenerLibros().stream().map(p -> new Venta(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Venta findById(Long id, Integer cantidad) {
		return new Venta(clienteFeign.obtenerLibro(id), cantidad);
	}


}
