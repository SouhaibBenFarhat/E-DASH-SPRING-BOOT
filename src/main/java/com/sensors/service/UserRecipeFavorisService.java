package com.sensors.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.Recipe;
import com.sensors.entities.User;
import com.sensors.entities.UserRecipeFavoris;
import com.sensors.implementation.RecipeImplementation;
import com.sensors.implementation.UserImplementation;
import com.sensors.implementation.UserRecipeFavorisImplementation;

@RestController
public class UserRecipeFavorisService {

	@Autowired
	private UserImplementation userImplementation;
	@Autowired
	private RecipeImplementation recipeImplementation;
	@Autowired
	private UserRecipeFavorisImplementation userRecipeFavorisImplementation;

	@RequestMapping(value = "/recipe/favoris/{userId}/{recipeId}", method = RequestMethod.POST)
	public UserRecipeFavoris saveUserRecipeFavoris(@RequestBody UserRecipeFavoris userRecipeFavovris,
			@PathVariable Long userId, @PathVariable Long recipeId) {

		User u = userImplementation.findOneById(userId);
		Recipe r = recipeImplementation.findRecipeById(recipeId);

		UserRecipeFavoris favoris = userRecipeFavorisImplementation.findRecipeFavorisByUserAndRecipe(userId, recipeId);

		if (favoris != null) {
			return userRecipeFavovris;

		} else {
			if (u != null && r != null) {

				userRecipeFavovris.setRecipe(r);
				userRecipeFavovris.setUser(u);
				userRecipeFavorisImplementation.addUserRecipeFavoris(userRecipeFavovris);
				return userRecipeFavovris;
			} else {
				return null;
			}
		}

	}

	@RequestMapping(value = "/recipe/favoris/{userId}", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> getUserRecipeFavoris(@PathVariable Long userId) {

		ArrayList<Recipe> recipes = new ArrayList<>();
		List<UserRecipeFavoris> urfs = new ArrayList<>();
		urfs = userRecipeFavorisImplementation.findFavorisByUser(userId);

		for (UserRecipeFavoris urf : urfs) {
			recipes.add(urf.getRecipe());
		}
		return recipes;

	}
	
	@RequestMapping(value = "/recipe/favoris/{userId}/{recipeId}", method = RequestMethod.DELETE)
	public String deleteUserRecipeFavoris(@PathVariable Long userId, @PathVariable Long recipeId) {
		
		UserRecipeFavoris urf = userRecipeFavorisImplementation.findRecipeFavorisByUserAndRecipe(userId, recipeId);

		if (urf !=null) {
			
			userRecipeFavorisImplementation.deleteUserRecipeFavoris(urf);
			return "success";
			
		}
		return "error";

	}
	
	@RequestMapping(value = "/recipe/favoris/find/{userId}/{recipeId}", method = RequestMethod.GET)
	public @ResponseBody Recipe getRecipeFavoris(@PathVariable Long userId, @PathVariable Long recipeId) {

		
		if (userRecipeFavorisImplementation.findRecipeFavorisByUserAndRecipe(userId, recipeId) != null) {
			return userRecipeFavorisImplementation.findRecipeFavorisByUserAndRecipe(userId, recipeId).getRecipe();

		}else{
			return null;
		}

	}

}
