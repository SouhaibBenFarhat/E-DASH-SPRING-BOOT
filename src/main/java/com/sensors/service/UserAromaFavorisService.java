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

import com.sensors.entities.Arome;
import com.sensors.entities.User;
import com.sensors.entities.UserAromaFavoris;
import com.sensors.implementation.AromeImplementation;
import com.sensors.implementation.UserAromaFavorisImplementation;
import com.sensors.implementation.UserImplementation;

@RestController
public class UserAromaFavorisService {
	@Autowired
	private UserImplementation userImplementation;
	@Autowired
	private AromeImplementation aromeImplementation;
	@Autowired
	private UserAromaFavorisImplementation userAromaFavorisImplementation;
	
	
	@RequestMapping(value = "/aroma/favoris/{userId}/{aromaId}", method = RequestMethod.POST)
	public UserAromaFavoris saveUserAromaFavoris(@RequestBody UserAromaFavoris userAromaFavoris,
			@PathVariable Long userId, @PathVariable Long aromaId) {

		User u = userImplementation.findOneById(userId);
		Arome a = aromeImplementation.findAromeById(aromaId);

		UserAromaFavoris favoris = userAromaFavorisImplementation.findAromaFavorisByUserAndAroma(userId, aromaId);

		if (favoris != null) {
			return userAromaFavoris;

		} else {
			if (u != null && a != null) {

				userAromaFavoris.setArome(a);
				userAromaFavoris.setUser(u);
				userAromaFavorisImplementation.addUserAromaFavoris(userAromaFavoris);
				return userAromaFavoris;
			} else {
				return null;
			}
		}

	}
	
	@RequestMapping(value = "/aroma/favoris/{userId}", method = RequestMethod.GET)
	public @ResponseBody List<Arome> getUserAromeFavoris(@PathVariable Long userId) {

		ArrayList<Arome> aromas = new ArrayList<>();
		List<UserAromaFavoris> uafs = new ArrayList<>();
		uafs = userAromaFavorisImplementation.findFavorisByUser(userId);

		for (UserAromaFavoris urf : uafs) {
			aromas.add(urf.getArome());
		}
		return aromas;

	}
	
	@RequestMapping(value = "/aroma/favoris/{userId}/{aromeId}", method = RequestMethod.DELETE)
	public String deleteUserAromeFavoris(@PathVariable Long userId, @PathVariable Long aromeId) {
		
		UserAromaFavoris uaf = userAromaFavorisImplementation.findAromaFavorisByUserAndAroma(userId, aromeId);

		if (uaf !=null) {
			
			userAromaFavorisImplementation.deleteUserAromaFavoris(uaf);
			return "success";
			
		}
		return "error";

	}
	
	@RequestMapping(value = "/aroma/favoris/find/{userId}/{recipeId}", method = RequestMethod.GET)
	public @ResponseBody Arome getAromeFavoris(@PathVariable Long userId, @PathVariable Long aromeId) {

		
		if (userAromaFavorisImplementation.findAromaFavorisByUserAndAroma(userId, aromeId) != null) {
			return userAromaFavorisImplementation.findAromaFavorisByUserAndAroma(userId, aromeId).getArome();

		}else{
			return null;
		}

	}
}
