package com.sensors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.DeviceConfigRecipe;

public interface DeviceConfigRecipeRepository extends JpaRepository<DeviceConfigRecipe, Long>{

	@Query("select dcr from DeviceConfigRecipe dcr where dcr.user.id = :id ")
	public List<DeviceConfigRecipe> findDeviceConfigRecipeByUser(@Param("id") Long userId);
	
	@Query("select dcr from DeviceConfigRecipe dcr where dcr.deviceConfig.id = :id ")
	public List<DeviceConfigRecipe> findDeviceConfigRecipeByDeviceConfig(@Param("id") Long deviceConfigId);
	
}
