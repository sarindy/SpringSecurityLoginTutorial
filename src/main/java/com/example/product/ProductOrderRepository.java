package com.example.product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("productOrderRepository")
public interface ProductOrderRepository extends CrudRepository<ProductOrder, Long> {
	
	public List<ProductOrder> findByProductId(long productId);

}
