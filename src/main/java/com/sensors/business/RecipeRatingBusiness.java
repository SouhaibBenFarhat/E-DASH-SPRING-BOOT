package com.sensors.business;

import java.util.List;

import com.sensors.entities.RecipeRating;

public interface RecipeRatingBusiness {

	public RecipeRating findRecipeRatingByUserAndRecipe(Long userId, Long recipeId);

	public void addRecipeRating(RecipeRating recipeRating);

	public List<RecipeRating> findRecipeRatingByRecipe(Long recipeId);
}
