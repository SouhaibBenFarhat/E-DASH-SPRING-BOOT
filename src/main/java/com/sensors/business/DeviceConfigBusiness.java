package com.sensors.business;

import java.util.List;

import com.sensors.entities.DeviceConfig;

public interface DeviceConfigBusiness {

	
	public void addDeviceConfig(DeviceConfig deviceConfig);
	public void deleteDeviceConfig(DeviceConfig deviceConfig);
	public List<DeviceConfig> findDeviceConfigByUser(Long userId);
	public DeviceConfig findDeviceConfigById(Long deviceConfigId);
	
}
