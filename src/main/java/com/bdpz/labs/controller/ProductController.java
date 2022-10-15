package com.bdpz.labs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdpz.labs.model.Product;
import com.bdpz.labs.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Product get(@PathVariable("id") String id) {
		return service.get(id);
	}
	
	@PostMapping
	public String create(@RequestBody Product product) {
		return service.create(product);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") String id, @RequestBody Product product) {
		service.update(product);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
}
