package com.example.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {

	@Autowired
	private ProductsRepository productsRepository;

	public List<Products> getAllProducts() {
		List<Products> products = new ArrayList<Products>();
		productsRepository.findAll().forEach(products::add);
		return products;

	}

	public void addProduct(Products product) {
		productsRepository.save(product);
	}

}
