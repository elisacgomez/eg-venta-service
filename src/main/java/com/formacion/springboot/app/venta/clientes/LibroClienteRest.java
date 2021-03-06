package com.formacion.springboot.app.venta.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacion.springboot.app.venta.models.Libro;

@FeignClient(name="servicio-libros")
public interface LibroClienteRest {

	@GetMapping("/libros/{id}")
	public Libro obtenerLibro(@PathVariable Long id);
	
	@GetMapping("/libros")
	public List<Libro> obtenerLibros();
}
