package com.sensors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select p from Product p where p.name like :x order by p.creationDate desc ")
	public List<Product> findByName(@Param("x") String name);
	
}
