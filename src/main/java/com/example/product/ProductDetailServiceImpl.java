package com.example.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailServiceImpl {

	@Autowired
	private ProductDetailRepository productDetailRepository;

	public List<ProductDetail> getAllProductDetail() {
		List<ProductDetail> productDetails = new ArrayList<ProductDetail>();
		productDetailRepository.findAll().forEach(productDetails::add);
		return productDetails;

	}

	public void addProductDetail(ProductDetail productDetail) {

		productDetailRepository.save(productDetail);
	}

}
