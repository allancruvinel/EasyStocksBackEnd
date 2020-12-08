package com.easystocks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easystocks.entities.Stock;
import com.easystocks.repositories.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository repository;
	
	public Stock registerStock(Stock at) {
		repository.save(at);
		return at;
	}
	
	public Stock findById(Long id) {
		Optional<Stock> u = repository.findById(id);
		return u.get();
	}
	
	public List<Stock> findAll() {
		List<Stock> stocks = repository.findAll();
		return stocks;
	}
}
