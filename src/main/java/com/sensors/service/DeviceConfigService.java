package com.sensors.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.AromaPerRecipe;
import com.sensors.entities.DeviceConfig;
import com.sensors.implementation.AromaPerRecipeImplementation;
import com.sensors.implementation.DeviceConfigImplementation;
import com.sensors.implementation.UserImplementation;

@RestController
public class DeviceConfigService {

	@Autowired
	private DeviceConfigImplementation deviceConfigImplementation;
	@Autowired
	private UserImplementation userImplementation;

	@Autowired
	private AromaPerRecipeImplementation aromaPerRecipeImplementation;

	@RequestMapping(value = "/device_config/{userId}", method = RequestMethod.POST)
	public DeviceConfig saveDeviceConfig(@RequestBody DeviceConfig deviceConfing, @PathVariable Long userId) {

		int deviceConfigTag = 0;

		
		if (userImplementation.findOneById(userId) != null)
			deviceConfing.setUser(userImplementation.findOneById(userId));

		aromaPerRecipeImplementation.addAromaPerRecipe(deviceConfing.getAromes());
		
		for(AromaPerRecipe apr : deviceConfing.getAromes()){
			deviceConfigTag = (int) (deviceConfigTag + apr.getArome().getId());
		}
		deviceConfing.setDeviceConfigTag(deviceConfigTag);
		deviceConfigImplementation.addDeviceConfig(deviceConfing);
		return deviceConfing;

	}
	
	
	@RequestMapping(value = "/device_config/{userId}", method = RequestMethod.GET)
	public List<DeviceConfig> getDeviceConfigByUser(@PathVariable Long userId) {

		
		
		return deviceConfigImplementation.findDeviceConfigByUser(userId);

	}
	


	@RequestMapping(value = "/device_config/find_default/{userId}", method = RequestMethod.PUT)
	public Response findDeviceDefaultDeviceConfig(@PathVariable Long userId){
		List<DeviceConfig> dcs = deviceConfigImplementation.findDeviceConfigByUser(userId);
		for(DeviceConfig d : dcs){
			if(d.getIsDefault() == true){
				d.setIsDefault(false);
				deviceConfigImplementation.addDeviceConfig(d);
				return Response.ok().build();
				
			}
		}
		return Response.serverError().build();
		
		
		
	}
	
	@RequestMapping(value = "/device_config/find_default/{userId}", method = RequestMethod.GET)
	public DeviceConfig findDefaultDeviceConfig(@PathVariable Long userId){
		List<DeviceConfig> dcs = deviceConfigImplementation.findDeviceConfigByUser(userId);
		for(DeviceConfig d : dcs){
			if(d.getIsDefault() == true){
				return d;
				
			}
		}
		return null;
		
		
		
	}

}
