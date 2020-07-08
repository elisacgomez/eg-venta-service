package com.formacion.springboot.app.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.springboot.app.venta.models.Venta;
import com.formacion.springboot.app.venta.service.VentaService;

@RestController
public class VentaController {
	
	@Autowired
	@Qualifier("serviceFeign")
	private VentaService ventaService;
	
	@GetMapping("/listar")
	public List<Venta> listar(){
		return ventaService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Venta detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return ventaService.findById(id, cantidad);
	}

}
