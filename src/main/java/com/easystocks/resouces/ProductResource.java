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

import com.easystocks.entities.Atribute;
import com.easystocks.entities.Product;
import com.easystocks.services.AtributeService;
import com.easystocks.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	@Autowired
	AtributeService atributeService;
	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> stocks = productService.findAll();
		return ResponseEntity.ok().body(stocks);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		try {
		Product stock = productService.findById(id);
		return ResponseEntity.ok().body(stock);
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	@PostMapping(value = "/{id}")
	public ResponseEntity<Product> addAtributes(@PathVariable Long id,@RequestBody Atribute name) {
		try {
		Product prod = productService.findById(id);
		Atribute atb = new Atribute(name.getType(),name.getValue(),prod);
		
		
		atributeService.registerService(atb);
		prod = productService.findById(id);
		return ResponseEntity.ok().body(prod);
		}catch(Exception e) {
			System.out.println("deu erro "+e.getMessage());
			return ResponseEntity.notFound().build();
		}
		
	}
}
