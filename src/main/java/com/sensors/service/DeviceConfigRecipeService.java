package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.DeviceConfig;
import com.sensors.entities.DeviceConfigRecipe;
import com.sensors.entities.Recipe;
import com.sensors.entities.User;
import com.sensors.implementation.AromaPerRecipeImplementation;
import com.sensors.implementation.DeviceConfigImplementation;
import com.sensors.implementation.DeviceConfigRecipeImplementation;
import com.sensors.implementation.RecipeImplementation;
import com.sensors.implementation.UserImplementation;

@RestController
public class DeviceConfigRecipeService {
	@Autowired
	private DeviceConfigRecipeImplementation deviceConfigRecipeImplementation;
	@Autowired
	private UserImplementation userImplementation;
	
	@Autowired
	private AromaPerRecipeImplementation aromaPerRecipeImplementation;
	@Autowired
	private DeviceConfigImplementation deviceConfigImplementation;
	
	

	
	@RequestMapping(value = "/deviceConfigRecipe/{userId}/{deviceConfigId}", method = RequestMethod.POST)
	public @ResponseBody DeviceConfigRecipe saveDeviceConfigRecipe(@RequestBody DeviceConfigRecipe deviceConfigRecipe, @PathVariable Long userId, @PathVariable Long deviceConfigId) {

		DeviceConfig dc = deviceConfigImplementation.findDeviceConfigById(deviceConfigId);
		User u = userImplementation.findOneById(userId);
		
		
		
		deviceConfigRecipe.setUser(u);
		deviceConfigRecipe.setDeviceConfig(dc);
		aromaPerRecipeImplementation.addAromaPerRecipe(deviceConfigRecipe.getAromes());
		deviceConfigRecipeImplementation.addDeviceConfigRecip(deviceConfigRecipe);
		
		return deviceConfigRecipe;

	}
	
	@RequestMapping(value = "/deviceConfigRecipe", method = RequestMethod.DELETE)
	public void deleteDeviceConfigRecipe(@RequestBody DeviceConfigRecipe deviceConfigRecipe) {

		deviceConfigRecipeImplementation.deleteDeviceConfigRecip(deviceConfigRecipe);
	

	}
	
	@RequestMapping(value = "/deviceConfigRecipe/{userId}", method = RequestMethod.GET)
	public @ResponseBody List<DeviceConfigRecipe> findDeviceConfigRecipeByUser(@PathVariable Long userId) {
		return deviceConfigRecipeImplementation.findDeviceConfigRecipeByUser(userId);
	}
	
	@RequestMapping(value = "/deviceConfigRecipe/deviceConfig/{deviceConfigId}", method = RequestMethod.GET)
	public @ResponseBody List<DeviceConfigRecipe> findDeviceConfigRecipeByDeviceConfig(@PathVariable Long deviceConfigId) {
		return deviceConfigRecipeImplementation.findDeviceConfigRecipeByDeviceConfig(deviceConfigId);
	}
	
	
}

