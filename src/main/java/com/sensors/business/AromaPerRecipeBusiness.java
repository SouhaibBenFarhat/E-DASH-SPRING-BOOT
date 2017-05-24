package com.sensors.business;

import java.util.List;

import com.sensors.entities.AromaPerRecipe;

public interface AromaPerRecipeBusiness {

	
	public void addAromaPerRecipe(List<AromaPerRecipe> aromasPerRecipe);
	public List<AromaPerRecipe> getAllAromaPerRecipe();
}
