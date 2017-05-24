package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.RecipeBusiness;
import com.sensors.dao.RecipeRepository;
import com.sensors.entities.Recipe;
@Service
public class RecipeImplementation implements RecipeBusiness {

	@Autowired
	RecipeRepository recipeRepository;
	
		
	@Override
	public void addRecipe(Recipe recipe) {

		
		
			recipeRepository.save(recipe);
	}

	@Override
	public List<Recipe> getAllRecipe() {
		// TODO Auto-generated method stub
		return recipeRepository.findAllOrderByDate();
	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		recipeRepository.delete(recipe);
		
	}

	@Override
	public Recipe findRecipeById(Long idRecipe) {
		return recipeRepository.findOne(idRecipe);
		
	}

	@Override
	public List<Recipe> findRecipeByUser(Long userId) {
		// TODO Auto-generated method stub
		return recipeRepository.findRecipeByUser(userId);
	}

	@Override
	public List<Recipe> findRecipeByTag(int tag) {
		// TODO Auto-generated method stub
		return recipeRepository.findRecipeByTag(tag);
	}

	
	
}
