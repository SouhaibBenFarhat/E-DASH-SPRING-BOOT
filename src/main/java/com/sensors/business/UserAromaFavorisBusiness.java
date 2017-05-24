package com.sensors.business;

import java.util.List;

import com.sensors.entities.UserAromaFavoris;

public interface UserAromaFavorisBusiness {
	public void addUserAromaFavoris(UserAromaFavoris favovris);
	public List<UserAromaFavoris> findFavorisByUser(Long userId);
	public UserAromaFavoris findAromaFavorisByUserAndAroma(Long userId, Long aromaId);
	public void deleteUserAromaFavoris(UserAromaFavoris favoris);
}
