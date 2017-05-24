package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.DeviceConfigBusiness;
import com.sensors.dao.DeviceConfigRepository;
import com.sensors.entities.DeviceConfig;

@Service
public class DeviceConfigImplementation implements DeviceConfigBusiness {

	@Autowired
	DeviceConfigRepository deviceConfigRepository;

	@Override
	public void addDeviceConfig(DeviceConfig deviceConfig) {

		deviceConfigRepository.save(deviceConfig);

	}

	@Override
	public void deleteDeviceConfig(DeviceConfig deviceConfig) {
		deviceConfigRepository.delete(deviceConfig);

	}

	@Override
	public List<DeviceConfig> findDeviceConfigByUser(Long userId) {

		return deviceConfigRepository.findDeviceConfigByUser(userId);
	}

	@Override
	public DeviceConfig findDeviceConfigById(Long deviceConfigId) {
		// TODO Auto-generated method stub
		return deviceConfigRepository.findOne(deviceConfigId);
	}

}
