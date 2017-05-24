package com.sensors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.DeviceConfig;

public interface DeviceConfigRepository extends JpaRepository<DeviceConfig, Long> {

	
	@Query("select dc from DeviceConfig dc where dc.user.id = :id order by dc.id desc ")
	public List<DeviceConfig> findDeviceConfigByUser(@Param("id") Long userId);
	

}
