package com.easystocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easystocks.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
