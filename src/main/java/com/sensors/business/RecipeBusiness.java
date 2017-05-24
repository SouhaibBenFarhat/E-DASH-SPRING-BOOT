package com.sensors.business;

import java.util.List;

import com.sensors.entities.Recipe;

public interface RecipeBusiness {

	public void addRecipe(Recipe recipe);
	public List<Recipe> getAllRecipe();
	public void deleteRecipe(Recipe recipe);
	public Recipe findRecipeById(Long idRecipe);
	public List<Recipe> findRecipeByUser(Long userId);
	public List<Recipe> findRecipeByTag(int tag);
}
