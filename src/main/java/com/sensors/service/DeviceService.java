package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.Device;
import com.sensors.entities.User;
import com.sensors.implementation.DeviceImplementation;
import com.sensors.implementation.UserImplementation;

@RestController
public class DeviceService {

	@Autowired
	private DeviceImplementation deviceImplementation;
	@Autowired
	private UserImplementation userImplementation;

	@RequestMapping(value = "/device", method = RequestMethod.POST)
	public Device saveDevice(@RequestBody Device device) {

		User user = userImplementation.findOneById(device.getUser());
		System.out.println(device.getUser().getId());
		device.setUser(user);
		deviceImplementation.addDevice(device);
		return device;

	}

	@RequestMapping(value = "/device", method = RequestMethod.GET)
	public @ResponseBody List<Device> findAllDevice() {
		return deviceImplementation.getAllDevices();
	}
}
