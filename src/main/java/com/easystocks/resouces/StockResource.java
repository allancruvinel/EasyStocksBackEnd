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
import com.easystocks.entities.Stock;
import com.easystocks.services.CategoryService;
import com.easystocks.services.StockService;

@RestController
@RequestMapping(value = "/stocks")
public class StockResource {

	@Autowired
	StockService stockService;
	@Autowired
	CategoryService categoryService;

	@PostMapping
	public ResponseEntity<Stock> registerStock(@RequestBody Stock stock) {
		Stock saved = stockService.registerStock(stock);
		if(saved!=null) {
			return ResponseEntity.ok().body(stock);
		}
		return ResponseEntity.ok().body(stock);
		
	}
	@GetMapping
	public ResponseEntity<List<Stock>> findAll() {
		List<Stock> stocks = stockService.findAll();
		return ResponseEntity.ok().body(stocks);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Stock> findById(@PathVariable Long id) {
		try {
		Stock stock = stockService.findById(id);
		return ResponseEntity.ok().body(stock);
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	@PostMapping(value = "/{id}")
	public ResponseEntity<Stock> addCategories(@PathVariable Long id,@RequestBody Category name) {
		try {
		Stock stock = stockService.findById(id);
		Category ctg = new Category(name.getName(),stock);
		
		
		categoryService.registerCategory(ctg);
		stock = stockService.findById(id);
		return ResponseEntity.ok().body(stock);
		}catch(Exception e) {
			System.out.println("deu erro "+e.getMessage());
			return ResponseEntity.notFound().build();
		}
		
	}
}
