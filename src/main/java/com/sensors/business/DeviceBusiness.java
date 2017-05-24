package com.sensors.business;

import java.util.List;

import com.sensors.entities.Device;

public interface DeviceBusiness {

	public void addDevice(Device device);

	public List<Device> getAllDevices();
}
