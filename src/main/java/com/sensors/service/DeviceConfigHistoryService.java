package com.sensors.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.DeviceConfigHistory;
import com.sensors.implementation.AromaPerRecipeImplementation;
import com.sensors.implementation.DeviceConfigHistoryImplementation;
import com.sensors.implementation.UserImplementation;

@RestController
public class DeviceConfigHistoryService {

	
	
	
	@Autowired
	private DeviceConfigHistoryImplementation deviceConfigImplementation;
	@Autowired
	private UserImplementation userImplementation;

	@Autowired
	private AromaPerRecipeImplementation aromaPerRecipeImplementation;

	@RequestMapping(value = "/device_config_history/{userId}", method = RequestMethod.POST)
	public DeviceConfigHistory saveDeviceConfig(@RequestBody DeviceConfigHistory deviceConfing, @PathVariable Long userId) {

		if (userImplementation.findOneById(userId) != null)
			deviceConfing.setUser(userImplementation.findOneById(userId));

		aromaPerRecipeImplementation.addAromaPerRecipe(deviceConfing.getAromes());
		deviceConfigImplementation.addDeviceConfigHistory(deviceConfing);
		return deviceConfing;

	}
	
	
	@RequestMapping(value = "/device_config_history/{userId}", method = RequestMethod.GET)
	public List<DeviceConfigHistory> getDeviceConfigByUser(@PathVariable Long userId) {

		
		
		return deviceConfigImplementation.findDeviceConfigHistoryByUser(userId);

	}
	


	@RequestMapping(value = "/device_config_history/find_default/{userId}", method = RequestMethod.PUT)
	public Response findDeviceDefaultDeviceConfig(@PathVariable Long userId){
		List<DeviceConfigHistory> dcs = deviceConfigImplementation.findDeviceConfigHistoryByUser(userId);
		for(DeviceConfigHistory d : dcs){
			if(d.getIsDefault() == true){
				d.setIsDefault(false);
				deviceConfigImplementation.addDeviceConfigHistory(d);
				return Response.ok().build();
				
			}
		}
		return Response.serverError().build();
		
		
		
	}
	
	@RequestMapping(value = "/device_config_history/find_default/{userId}", method = RequestMethod.GET)
	public DeviceConfigHistory findDefaultDeviceConfig(@PathVariable Long userId){
		List<DeviceConfigHistory> dcs = deviceConfigImplementation.findDeviceConfigHistoryByUser(userId);
		for(DeviceConfigHistory d : dcs){
			if(d.getIsDefault() == true){
				return d;
				
			}
		}
		return null;
		
		
		
	}
	
	
}
