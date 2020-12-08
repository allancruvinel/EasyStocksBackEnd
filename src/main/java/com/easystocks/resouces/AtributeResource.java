package com.easystocks.resouces;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easystocks.entities.Atribute;
import com.easystocks.entities.Category;
import com.easystocks.entities.Product;
import com.easystocks.entities.Stock;
import com.easystocks.repositories.AtributeRepository;
import com.easystocks.repositories.CategoryRepository;
import com.easystocks.repositories.ProductRepository;
import com.easystocks.repositories.StockRepository;

@RestController
@RequestMapping(value = "/atributes")
public class AtributeResource {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	AtributeRepository atributeRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	StockRepository stockRepository;


	@PostMapping
	@ResponseBody
	public String registerProduct(@RequestBody Product product) {

		Stock stk = new Stock("Cervejaria");
		Category ctg = new Category("Destilados",stk);
		Product prod = new Product("Velho Barreiro",185.5,8,"9986558548",ctg);
		Atribute atb = new Atribute("tamanho","grande",prod);
		Atribute atb2 = new Atribute("cor","Branco",prod);
		Atribute atb3 = new Atribute("Peso","50",prod);
		Atribute atb4 = new Atribute("Vencido","Não",prod);
		
		
		stockRepository.save(stk);
		categoryRepository.save(ctg);
		productRepository.save(prod);
		atributeRepository.saveAll(Arrays.asList(atb,atb2,atb3,atb4));
		

		return "Saved";
	}
	@GetMapping
	public ResponseEntity<List<Stock>> findAll() {
		List<Stock> products = stockRepository.findAll();
		return ResponseEntity.ok().body(products);
		
	}
}
