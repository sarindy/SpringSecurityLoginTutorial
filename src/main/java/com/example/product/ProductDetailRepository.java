package com.example.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("productDetailRepository")
public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long> {
	

}
