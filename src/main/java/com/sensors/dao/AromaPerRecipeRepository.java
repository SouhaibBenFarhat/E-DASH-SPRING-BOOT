package com.sensors.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sensors.entities.AromaPerRecipe;

public interface AromaPerRecipeRepository extends JpaRepository<AromaPerRecipe	, Long> {

}
