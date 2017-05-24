package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.UserRecipeFavorisBusiness;
import com.sensors.dao.UserRecipeFavorisRepository;
import com.sensors.entities.UserRecipeFavoris;

@Service
public class UserRecipeFavorisImplementation implements UserRecipeFavorisBusiness {

	@Autowired
	private UserRecipeFavorisRepository userRecipeFavorisImplementation;

	@Override
	public void addUserRecipeFavoris(UserRecipeFavoris favovris) {
		userRecipeFavorisImplementation.save(favovris);

	}

	@Override
	public List<UserRecipeFavoris> findFavorisByUser(Long userId) {
		// TODO Auto-generated method stub
		return userRecipeFavorisImplementation.findRecipeFavorisByUser(userId);
	}

	@Override
	public UserRecipeFavoris findRecipeFavorisByUserAndRecipe(Long userId, Long recipeId) {
		// TODO Auto-generated method stub
		return userRecipeFavorisImplementation.findRecipeFavorisByUserAndRecipe(userId, recipeId);
	}

	@Override
	public void deleteUserRecipeFavoris(UserRecipeFavoris favoris) {
		userRecipeFavorisImplementation.delete(favoris.getId());
		
	}

}
