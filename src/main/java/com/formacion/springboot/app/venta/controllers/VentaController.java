package com.formacion.springboot.app.venta.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.springboot.app.venta.models.Venta;
import com.formacion.springboot.app.venta.service.VentaService;

@RestController
public class VentaController {
	
	private static Logger log = LoggerFactory.getLogger(VentaController.class);
	
	@Autowired
	@Qualifier("serviceFeign")
	private VentaService ventaService;
	
	@Value("${configuracion.texto}")
	private String texto;
	
	@GetMapping("/listar")
	public List<Venta> listar(){
		return ventaService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Venta detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return ventaService.findById(id, cantidad);
	}
	
	@GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfig(){
		
		log.info(texto);
		Map<String, String> json = new HashMap<>();
		json.put("Texto", texto);
		return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK);
	}
}
