package com.sensors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.UserRecipeFavoris;

public interface UserRecipeFavorisRepository extends JpaRepository<UserRecipeFavoris, Long> {

	@Query("select f from UserRecipeFavoris  f where f.user.id = :userId and f.recipe.id = :recipeId ")
	public UserRecipeFavoris findRecipeFavorisByUserAndRecipe(@Param("userId") Long userId,
			@Param("recipeId") Long recipeId);
	
	
	@Query("select f from UserRecipeFavoris  f where f.user.id = :userId")
	public List<UserRecipeFavoris> findRecipeFavorisByUser(@Param("userId") Long userId);

}
