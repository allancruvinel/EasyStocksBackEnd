package com.easystocks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easystocks.entities.Atribute;
import com.easystocks.repositories.AtributeRepository;

@Service
public class AtributeService {
	
	@Autowired
	private AtributeRepository repository;
	
	public Atribute registerService(Atribute at) {
		repository.save(at);
		return at;
	}
}
