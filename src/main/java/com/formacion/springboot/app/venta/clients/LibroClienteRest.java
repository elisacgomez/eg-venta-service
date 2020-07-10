package com.formacion.springboot.app.venta.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.formacion.springboot.app.common.models.entity.Libro;

@FeignClient(name = "servicio-libros")
public interface LibroClienteRest {

	@GetMapping("/libros")
	public List<Libro> obtenerLibros();

	@GetMapping("/libros/{id}")
	public Libro obtenerLibro(@PathVariable Long id);
	
	@PostMapping("/libros")
	public Libro crearLibro(@RequestBody Libro libro);

	@PutMapping("/libros/{id}")
	public Libro actualizarLibro(@RequestBody Libro libro, @PathVariable Long id);
	
	@DeleteMapping("/libros/{id}")
	public void eliminarLibro(@PathVariable Long id);
}
