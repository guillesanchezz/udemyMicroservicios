package com.formacionbdi.springboot.app.productos.springbootservicioproductos.repository;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.productos.springbootservicioproductos.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
