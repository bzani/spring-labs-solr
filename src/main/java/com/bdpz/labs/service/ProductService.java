package com.bdpz.labs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdpz.labs.model.Product;
import com.bdpz.labs.repository.ProductRepository;
import com.bdpz.labs.utils.CollectionUtils;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> getAll() {
		return CollectionUtils.iterableToList(repository.findAll());
	}
	
	public Product get(String id) {
		return repository.findById(id).get();
	}
	
	public String create(Product product) {
		Product entity = repository.save(product);
		return entity.getId();
	}
	
	public void update(Product product) {
		repository.save(product);
	}
	
	public void delete(String id) {
		Product product = repository.findById(id).get();
		repository.delete(product);
	}
	
}
