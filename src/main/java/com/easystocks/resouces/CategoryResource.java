package com.easystocks.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easystocks.entities.Category;
import com.easystocks.entities.Product;
import com.easystocks.services.CategoryService;
import com.easystocks.services.ProductService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> stocks = categoryService.findAll();
		return ResponseEntity.ok().body(stocks);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		try {
		Category stock = categoryService.findById(id);
		return ResponseEntity.ok().body(stock);
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	@PostMapping(value = "/{id}")
	public ResponseEntity<Category> addProducts(@PathVariable Long id,@RequestBody Product name) {
		try {
		Category ctg = categoryService.findById(id);
		Product prod = new Product(name.getName(),name.getPrice(),name.getQuantity(),name.getBarCode(),ctg);
		
		
		productService.registerProduct(prod);
		ctg = categoryService.findById(id);
		return ResponseEntity.ok().body(ctg);
		}catch(Exception e) {
			System.out.println("deu erro "+e.getMessage());
			return ResponseEntity.notFound().build();
		}
		
	}
}
