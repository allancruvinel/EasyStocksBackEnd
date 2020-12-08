package com.easystocks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easystocks.entities.Category;
import com.easystocks.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public Category registerCategory(Category at) {
		repository.save(at);
		return at;
	}
	
	public Category findById(Long id) {
		Optional<Category> u = repository.findById(id);
		return u.get();
	}
	
	public List<Category> findAll() {
		List<Category> stocks = repository.findAll();
		return stocks;
	}
}
