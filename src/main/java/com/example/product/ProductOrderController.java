package com.example.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOrderController {

	@Autowired
	private ProductOrderServiceImpl productOrderServiceImpl;

	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductOrder> placeOrder(@RequestBody ProductOrder productOrder) {
		productOrderServiceImpl.placeOrder(productOrder);

		return new ResponseEntity<ProductOrder>(HttpStatus.OK);

	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductOrder>> getOrderByProduct(@PathVariable long id) {
		List<ProductOrder> productsOrder = productOrderServiceImpl.findByProductId(id);

		return new ResponseEntity<List<ProductOrder>>(productsOrder,HttpStatus.OK);

	}

}
