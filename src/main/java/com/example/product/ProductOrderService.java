package com.example.product;

import java.util.List;

public interface ProductOrderService {
	
	public List<ProductOrder> findByProductId(long productId);
	
	public void placeOrder(ProductOrder productOrder);
	
	public List<ProductOrder> getAllOrder();
	
	public ProductOrder getOrder(long id);
	

}
