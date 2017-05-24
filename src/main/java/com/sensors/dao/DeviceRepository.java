package com.sensors.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sensors.entities.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}
