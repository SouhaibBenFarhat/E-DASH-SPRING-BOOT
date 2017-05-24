package com.sensors.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.Arome;


public interface AromeRepository extends JpaRepository<Arome, Long>{
	@Query("select a from Arome a where a.manufacture.id = :id ")
	public List<Arome> findAromaByManufacture(@Param("id") Long manufactureId);
	
	@Query("select a from Arome a where a.category.id = :id ")
	public List<Arome> findAromaByCategory(@Param("id") Long categoryId);
	
	@Query("select a from Arome a where a.enabled = :enabled ")
	public List<Arome> findAromaUsers(@Param("enabled") Boolean enabled);
	
	
	@Query("select a from Arome a where a.enabled = :enabled and a.user.id = :userId ")
	public List<Arome> findEnabledAromaByUser(@Param("enabled") Boolean enabled, @Param("userId") Long userId);
	
	
	@Query("select a from Arome a where a.enabled = :enabled and a.user.id = :userId ")
	public List<Arome> findDisabledAromaByUser(@Param("enabled") Boolean enabled, @Param("userId") Long userId);
	
	
	@Query("select a from Arome a where  a.user.id = :userId ")
	public List<Arome> findAromaByUser(@Param("userId") Long userId);
	
}
