package com.sensors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.Boitier;

public interface BoitierRepository extends JpaRepository<Boitier, Long>{
	
	@Query("select b from Boitier b order by b.id desc ")
	public List<Boitier> findAllBoitier();
	
	@Query("select b from Boitier b where b.macAddress = :macAddress")
	public Boitier findBoitierByMacAddress(@Param("macAddress") String macAddress);

}
