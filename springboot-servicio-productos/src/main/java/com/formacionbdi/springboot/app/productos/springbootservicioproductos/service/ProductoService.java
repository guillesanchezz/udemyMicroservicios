package com.formacionbdi.springboot.app.productos.springbootservicioproductos.service;

import java.util.List;

import com.formacionbdi.springboot.app.commons.models.Producto;

public interface ProductoService {
	
	public List<Producto> findAll();
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);
	
}
