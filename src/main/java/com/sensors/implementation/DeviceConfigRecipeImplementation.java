package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.DeviceConfigRecipeBusiness;
import com.sensors.dao.DeviceConfigRecipeRepository;
import com.sensors.entities.DeviceConfigRecipe;
@Service
public class DeviceConfigRecipeImplementation implements DeviceConfigRecipeBusiness {

	@Autowired
	DeviceConfigRecipeRepository deviceConfigRecipeRepository;
	
	@Override
	public void addDeviceConfigRecip(DeviceConfigRecipe deviceConfigRecipe) {
		// TODO Auto-generated method stub
		deviceConfigRecipeRepository.save(deviceConfigRecipe);
		
	}

	@Override
	public List<DeviceConfigRecipe> getAllDeviceConfigRecip() {
		// TODO Auto-generated method stub
		return deviceConfigRecipeRepository.findAll();
	}

	@Override
	public void deleteDeviceConfigRecip(DeviceConfigRecipe deviceConfigRecipe) {
		deviceConfigRecipeRepository.delete(deviceConfigRecipe);
		
	}

	@Override
	public DeviceConfigRecipe findDeviceConfigRecipe(Long idDeviceConfigRecipe) {
		// TODO Auto-generated method stub
		return deviceConfigRecipeRepository.findOne(idDeviceConfigRecipe);
	}

	@Override
	public List<DeviceConfigRecipe> findDeviceConfigRecipeByUser(Long userId) {
		// TODO Auto-generated method stub
		return deviceConfigRecipeRepository.findDeviceConfigRecipeByUser(userId);
	}

	@Override
	public List<DeviceConfigRecipe> findDeviceConfigRecipeByDeviceConfig(Long deviceConfigId) {
		// TODO Auto-generated method stub
		return deviceConfigRecipeRepository.findDeviceConfigRecipeByDeviceConfig(deviceConfigId);
	}

}
