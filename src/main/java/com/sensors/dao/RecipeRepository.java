package com.sensors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

	@Query("select r from Recipe r order by r.id desc ")
	public List<Recipe> findAllOrderByDate();
	
	@Query("select r from Recipe r where r.user.id = :id order by r.id desc ")
	public List<Recipe> findRecipeByUser(@Param("id") Long userId);
	
	
	@Query("select r from Recipe r where r.recipeTag = :tag order by r.id desc ")
	public List<Recipe> findRecipeByTag(@Param("tag") int tag);
	
}
