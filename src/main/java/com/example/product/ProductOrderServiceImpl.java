package com.example.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

	@Autowired
	private ProductOrderRepository productOrderRepository;

	@Override
	public List<ProductOrder> findByProductId(long productId) {
		List<ProductOrder> productOrders = new ArrayList<ProductOrder>();
		productOrderRepository.findByProductId(productId).forEach(productOrders::add);
		;
		return productOrders;
	}

	@Override
	public void placeOrder(ProductOrder productOrder) {

		productOrderRepository.save(productOrder);
	}

	@Override
	public List<ProductOrder> getAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductOrder getOrder(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
