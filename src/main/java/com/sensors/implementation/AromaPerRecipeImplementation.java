package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.AromaPerRecipeBusiness;
import com.sensors.dao.AromaPerRecipeRepository;
import com.sensors.entities.AromaPerRecipe;

@Service
public class AromaPerRecipeImplementation implements AromaPerRecipeBusiness {

	@Autowired
	AromaPerRecipeRepository aromaPerRecipeRepository;

	@Override
	public void addAromaPerRecipe(List<AromaPerRecipe> aromasPerRecipe) {
		aromaPerRecipeRepository.save(aromasPerRecipe);
	}

	@Override
	public List<AromaPerRecipe> getAllAromaPerRecipe() {

		return aromaPerRecipeRepository.findAll();
	}

}
