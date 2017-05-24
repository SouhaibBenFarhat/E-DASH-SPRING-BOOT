package com.sensors.business;

import java.util.List;

import com.sensors.entities.Product;

public interface ProductBusiness {

	public Product saveProduct(Product p);

	public List<Product> productList();

	public List<Product> findProduct(String name);

}
