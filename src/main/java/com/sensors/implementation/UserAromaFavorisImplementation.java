package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.UserAromaFavorisBusiness;
import com.sensors.dao.UserAromaFavorisRepository;
import com.sensors.entities.UserAromaFavoris;
@Service
public class UserAromaFavorisImplementation implements UserAromaFavorisBusiness {

	
	@Autowired
	UserAromaFavorisRepository userAromaFavorisRepository;
	
	@Override
	public void addUserAromaFavoris(UserAromaFavoris favovris) {
		userAromaFavorisRepository.save(favovris);
		
	}

	@Override
	public List<UserAromaFavoris> findFavorisByUser(Long userId) {
		// TODO Auto-generated method stub
		return userAromaFavorisRepository.findAromaFavorisByUser(userId);
	}

	@Override
	public UserAromaFavoris findAromaFavorisByUserAndAroma(Long userId, Long aromaId) {
		// TODO Auto-generated method stub
		return userAromaFavorisRepository.findAromaFavorisByUserAndAroma(userId, aromaId);
	}

	@Override
	public void deleteUserAromaFavoris(UserAromaFavoris favoris) {
		// TODO Auto-generated method stub
		userAromaFavorisRepository.delete(favoris);
		
		
	}

}
