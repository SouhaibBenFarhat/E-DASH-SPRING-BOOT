package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.DeviceBusiness;
import com.sensors.dao.DeviceRepository;
import com.sensors.entities.Device;

@Service
public class DeviceImplementation implements DeviceBusiness {

	@Autowired
	DeviceRepository deviceRepositry;

	@Override
	public void addDevice(Device device) {

		deviceRepositry.save(device);

	}

	@Override
	public List<Device> getAllDevices() {
		
		return deviceRepositry.findAll();
	}

}
