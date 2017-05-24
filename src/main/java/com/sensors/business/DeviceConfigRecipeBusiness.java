package com.sensors.business;

import java.util.List;

import com.sensors.entities.DeviceConfigRecipe;

public interface DeviceConfigRecipeBusiness {

	public void addDeviceConfigRecip(DeviceConfigRecipe deviceConfigRecipe);
	public List<DeviceConfigRecipe> getAllDeviceConfigRecip();
	public void deleteDeviceConfigRecip(DeviceConfigRecipe deviceConfigRecipe);
	public DeviceConfigRecipe findDeviceConfigRecipe(Long idDeviceConfigRecipe);
	public List<DeviceConfigRecipe> findDeviceConfigRecipeByUser(Long userId);
	public List<DeviceConfigRecipe> findDeviceConfigRecipeByDeviceConfig(Long deviceConfigId);
	
}
