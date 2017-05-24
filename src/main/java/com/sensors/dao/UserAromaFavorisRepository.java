package com.sensors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.UserAromaFavoris;

public interface UserAromaFavorisRepository extends JpaRepository<UserAromaFavoris, Long> {

	
	@Query("select f from UserAromaFavoris  f where f.user.id = :userId and f.arome.id = :aromeId ")
	public UserAromaFavoris findAromaFavorisByUserAndAroma(@Param("userId") Long userId,
			@Param("aromeId") Long aromeId);
	
	
	@Query("select f from UserAromaFavoris  f where f.user.id = :userId")
	public List<UserAromaFavoris> findAromaFavorisByUser(@Param("userId") Long userId);
	
}
