package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.RecipeRatingBusiness;
import com.sensors.dao.RecipeRatingRepository;

import com.sensors.entities.RecipeRating;

@Service
public class RecipeRatingImplementation implements RecipeRatingBusiness {

	@Autowired
	RecipeRatingRepository recipeRatingRepository;
	

	@Override
	public RecipeRating findRecipeRatingByUserAndRecipe(Long userId, Long recipeId) {
		// TODO Auto-generated method stub
		return recipeRatingRepository.findRecipeRatingByUserAndRecipe(userId, recipeId);
	}

	@Override
	public void addRecipeRating(RecipeRating recipeRating) {
		recipeRatingRepository.save(recipeRating);

	}

	@Override
	public List<RecipeRating> findRecipeRatingByRecipe(Long recipeId) {

		return recipeRatingRepository.findRecipeRatingByRecipe(recipeId);

	}

}
