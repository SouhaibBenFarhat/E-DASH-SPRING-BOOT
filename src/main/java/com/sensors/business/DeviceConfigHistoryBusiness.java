package com.sensors.business;

import java.util.List;

import com.sensors.entities.DeviceConfigHistory;

public interface DeviceConfigHistoryBusiness {

	public void addDeviceConfigHistory(DeviceConfigHistory deviceConfigHistory);
	public void deleteDeviceConfigHistory(DeviceConfigHistory deviceConfigHistory);
	public List<DeviceConfigHistory> findDeviceConfigHistoryByUser(Long userId);
	public DeviceConfigHistory findDeviceConfigHistoryById(Long deviceConfigHistoryId);
	
}
