package com.formacion.springboot.app.venta.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.springboot.app.venta.models.Libro;
import com.formacion.springboot.app.venta.models.Venta;
import com.formacion.springboot.app.venta.service.VentaService;

@RefreshScope
@RestController
public class VentaController {
	
	@Autowired
	private Environment env;
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
		
		if(env.getActiveProfiles().length >0 && env.getActiveProfiles()[0].equals("dev")) {
			json.put("autor.nombre", env.getProperty("configuracion.autor.nombre"));
			json.put("autor.email", env.getProperty("configuracion.autor.email"));
		}
			
		
		return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Libro crear(@RequestBody Libro libro) {
		return ventaService.save(libro);
	}
	
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Libro crear(@RequestBody Libro libro, @PathVariable Long id) {
		return ventaService.update(libro, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void crear(@PathVariable Long id) {
		ventaService.delete(id);;
	}
}
