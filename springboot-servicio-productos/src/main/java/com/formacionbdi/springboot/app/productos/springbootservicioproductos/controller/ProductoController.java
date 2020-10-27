package com.formacionbdi.springboot.app.productos.springbootservicioproductos.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.springbootservicioproductos.entity.Producto;
import com.formacionbdi.springboot.app.productos.springbootservicioproductos.service.ProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private Environment env;

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar() {
		return productoService.findAll().stream().map(producto->{
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) throws Exception {
		Producto producto = productoService.findById(id); 
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
	/*	
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		return producto;
	}
}	
