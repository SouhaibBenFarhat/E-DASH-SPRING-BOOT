package com.sensors.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.ProductBusiness;
import com.sensors.dao.ProductRepository;
import com.sensors.entities.Product;
@Service
public class ProductImplementation implements ProductBusiness {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product p) {

		p.setCreationDate(new Date());
		return productRepository.save(p);
	}

	@Override
	public List<Product> productList() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> findProduct(String name) {
		// TODO Auto-generated method stub
		return productRepository.findByName(name);
	}



}
