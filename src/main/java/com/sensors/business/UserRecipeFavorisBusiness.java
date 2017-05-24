package com.sensors.business;

import java.util.List;

import com.sensors.entities.UserRecipeFavoris;

public interface UserRecipeFavorisBusiness {

	public void addUserRecipeFavoris(UserRecipeFavoris favovris);
	public List<UserRecipeFavoris> findFavorisByUser(Long userId);
	public UserRecipeFavoris findRecipeFavorisByUserAndRecipe(Long userId, Long recipeId);
	public void deleteUserRecipeFavoris(UserRecipeFavoris favoris);
}
