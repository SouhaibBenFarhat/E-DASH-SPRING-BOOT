package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sensors.entities.Product;
import com.sensors.implementation.ProductImplementation;

@RestController
public class ProductRestService {

	@Autowired
	private ProductImplementation productImplementation;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product saveProduct(@RequestBody  Product p) {
		return productImplementation.saveProduct(p);
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)

	public List<Product> productList() {
		return productImplementation.productList();
	}

	@RequestMapping(value = "/products/{name}", method = RequestMethod.GET)

	public List<Product> searchProduct(@PathVariable String name) {
		return productImplementation.findProduct("%" + name + "%");
	}

}
