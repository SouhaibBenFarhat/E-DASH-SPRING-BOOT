package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.DeviceConfigHistoryBusiness;
import com.sensors.dao.DeviceConfigHisotryRepository;
import com.sensors.entities.DeviceConfigHistory;

@Service
public class DeviceConfigHistoryImplementation implements DeviceConfigHistoryBusiness {

	
	@Autowired
	DeviceConfigHisotryRepository deviceConfigRepository;

	@Override
	public void addDeviceConfigHistory(DeviceConfigHistory deviceConfig) {

		deviceConfigRepository.save(deviceConfig);

	}

	@Override
	public void deleteDeviceConfigHistory(DeviceConfigHistory deviceConfig) {
		deviceConfigRepository.delete(deviceConfig);

	}

	@Override
	public List<DeviceConfigHistory> findDeviceConfigHistoryByUser(Long userId) {

		return deviceConfigRepository.findDeviceConfigByUser(userId);
	}

	@Override
	public DeviceConfigHistory findDeviceConfigHistoryById(Long deviceConfigId) {
		// TODO Auto-generated method stub
		return deviceConfigRepository.findOne(deviceConfigId);
	}

	
}
