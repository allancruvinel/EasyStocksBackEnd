package com.easystocks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easystocks.entities.Product;
import com.easystocks.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product registerProduct(Product at) {
		repository.save(at);
		return at;
	}
	
	public Product findById(Long id) {
		Optional<Product> u = repository.findById(id);
		return u.get();
	}
	
	public List<Product> findAll() {
		List<Product> stocks = repository.findAll();
		return stocks;
	}
}
