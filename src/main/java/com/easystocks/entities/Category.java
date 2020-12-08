package com.easystocks.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="stock_id")
	private Stock stock;
	
	
	@OneToMany(mappedBy = "category")
	List<Product> products = new ArrayList<>();

	public Category() {}

	public Category(String name,Stock stock) {
		this.name = name;
		this.stock = stock;
	}


	public Long getStock() {
		return stock.getId();
	}
	
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	
	
	
}
