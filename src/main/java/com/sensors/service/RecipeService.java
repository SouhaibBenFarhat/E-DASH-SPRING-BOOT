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

import com.sensors.entities.AromaPerRecipe;
import com.sensors.entities.Recipe;
import com.sensors.entities.User;
import com.sensors.implementation.AromaPerRecipeImplementation;
import com.sensors.implementation.RecipeImplementation;
import com.sensors.implementation.UserImplementation;

@RestController
public class RecipeService {

	
	@Autowired
	private RecipeImplementation recipeImplementation;
	@Autowired
	private UserImplementation userImplementation;
	
	@Autowired
	private AromaPerRecipeImplementation aromaPerRecipeImplementation;
	
	
	
	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
	public Recipe saveRecipe(@RequestBody Recipe recipe) {

		int recipeTag = 0;
		
		aromaPerRecipeImplementation.addAromaPerRecipe(recipe.getAromes());
		recipe.setComments(0);
		recipe.setLikes(0);
		recipe.setVotes(0);
		
		for(AromaPerRecipe apr : recipe.getAromes()){
			recipeTag = (int) (recipeTag +apr.getArome().getId());
		}
		recipe.setRecipeTag(recipeTag);
		recipeImplementation.addRecipe(recipe);
		return recipe;

	}
	
	@RequestMapping(value = "/recipe/user/{userId}", method = RequestMethod.POST)
	public Recipe saveUserRecipe(@RequestBody Recipe recipe, @PathVariable Long userId) {

		int recipeTag = 0;

		User u = userImplementation.findOneById(userId);
		recipe.setUser(u);
		aromaPerRecipeImplementation.addAromaPerRecipe(recipe.getAromes());
		recipe.setComments(0);
		recipe.setLikes(0);
		recipe.setVotes(0);
		for(AromaPerRecipe apr : recipe.getAromes()){
			recipeTag = (int) (recipeTag +apr.getArome().getId());
		}
		recipe.setRecipeTag(recipeTag);
		recipeImplementation.addRecipe(recipe);
		return recipe;

	}

	@RequestMapping(value = "/recipe", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> findAllRecipe() {
		return recipeImplementation.getAllRecipe();
	}
	
	@RequestMapping(value = "/recipe", method = RequestMethod.DELETE)
	public void deleteRecipe(@RequestBody Recipe recipe) {

		recipeImplementation.deleteRecipe(recipe);
	

	}
	
	@RequestMapping(value = "/recipe/{recipeId}", method = RequestMethod.GET)
	public Recipe findRecipeById(@PathVariable Long recipeId) {

		return recipeImplementation.findRecipeById(recipeId);
	

	}
	
	@RequestMapping(value = "/recipe/user/{userId}", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> findRecipeByUser(@PathVariable Long userId) {

		return recipeImplementation.findRecipeByUser(userId);
	

	}
	
	
	@RequestMapping(value = "/recipe/arome/{aromeId}", method = RequestMethod.GET)
	public List<Recipe> findRecipeByArome(@PathVariable Long aromeId) {

		List<Recipe> recipes = recipeImplementation.getAllRecipe();
		List<Recipe> recipesToReturn = new ArrayList<>();
		for (Recipe r : recipes){
			for(AromaPerRecipe apr : r.getAromes()){
				if (apr.getArome().getId() == aromeId) {
					recipesToReturn.add(r);
				}
			}
		}
		return recipesToReturn;	

	}
	
	@RequestMapping(value = "/recipe/tag/{tag}", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> findRecipeByTag(@PathVariable int tag) {

		return recipeImplementation.findRecipeByTag(tag);
	

	}
	
}
