package com.example.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductsRepository extends CrudRepository<Products, Long> {
	

}
