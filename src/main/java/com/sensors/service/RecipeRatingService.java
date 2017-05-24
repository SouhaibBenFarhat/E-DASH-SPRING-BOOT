package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.Arome;
import com.sensors.entities.Recipe;
import com.sensors.entities.RecipeRating;
import com.sensors.entities.User;
import com.sensors.implementation.RecipeImplementation;
import com.sensors.implementation.RecipeRatingImplementation;
import com.sensors.implementation.UserImplementation;

@RestController
public class RecipeRatingService {

	@Autowired
	private RecipeRatingImplementation recipeRatingImplementation;
	@Autowired
	private RecipeImplementation recipeImplementation;
	@Autowired
	private UserImplementation userImplementation;

	@RequestMapping(value = "/rating/{userId}/{recipeId}", method = RequestMethod.POST)
	public RecipeRating saveRating(@RequestBody RecipeRating recipeRating, @PathVariable("userId") Long userId,
			@PathVariable("recipeId") Long recipeId) {
		
		RecipeRating rR= recipeRatingImplementation.findRecipeRatingByUserAndRecipe(userId, recipeId);
		if (rR != null) {
			
			rR.setValue(recipeRating.getValue());
			recipeRatingImplementation.addRecipeRating(rR);
			return rR;
		}

		else{
			User u = userImplementation.findOneById(userId);
			Recipe r = recipeImplementation.findRecipeById(recipeId);

			recipeRating.setUser(u);
			recipeRating.setRecipe(r);

			recipeRatingImplementation.addRecipeRating(recipeRating);
			return recipeRating;
		}

	}

	@RequestMapping(value = "/rating/{userId}/{recipeId}", method = RequestMethod.GET)
	public @ResponseBody RecipeRating findRecipeRatingByUserAndRecipe(@PathVariable("userId") Long userId,
			@PathVariable("recipeId") Long recipeId) {
		return recipeRatingImplementation.findRecipeRatingByUserAndRecipe(userId, recipeId);
	}
	
	@RequestMapping(value = "/rating/{recipeId}", method = RequestMethod.GET)
	public @ResponseBody float findRecipeRatingByRecipe(@PathVariable Long recipeId) {

		int ratingValue = 0;
			if (recipeRatingImplementation.findRecipeRatingByRecipe(recipeId) !=null && recipeRatingImplementation.findRecipeRatingByRecipe(recipeId).size() !=0) {
				for(RecipeRating rR : recipeRatingImplementation.findRecipeRatingByRecipe(recipeId)){
					ratingValue+=rR.getValue();
				}
				return ratingValue/recipeRatingImplementation.findRecipeRatingByRecipe(recipeId).size();
			}
		return ratingValue;
	}

}
