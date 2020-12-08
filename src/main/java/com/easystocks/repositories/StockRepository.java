package com.easystocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easystocks.entities.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {

}
