package com.sensors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.DeviceConfigHistory;

public interface DeviceConfigHisotryRepository extends JpaRepository<DeviceConfigHistory, Long> {

	@Query("select dc from DeviceConfigHistory dc where dc.user.id = :id order by dc.id desc ")
	public List<DeviceConfigHistory> findDeviceConfigByUser(@Param("id") Long userId);

}

