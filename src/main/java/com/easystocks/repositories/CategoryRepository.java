package com.easystocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easystocks.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
