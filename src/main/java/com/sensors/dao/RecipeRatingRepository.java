package com.sensors.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.RecipeRating;

public interface RecipeRatingRepository extends JpaRepository<RecipeRating, Long > {

	@Query("select r from RecipeRating r where r.user.id = :userId and r.recipe.id = :recipeId ")
	public RecipeRating findRecipeRatingByUserAndRecipe(@Param("userId") Long userId,@Param("recipeId") Long recipeId);
	
	
	@Query("select r from RecipeRating r where r.recipe.id = :recipeId ")
	public List<RecipeRating> findRecipeRatingByRecipe(@Param("recipeId") Long recipeId);
	
}
