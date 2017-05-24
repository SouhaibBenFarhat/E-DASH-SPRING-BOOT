package com.sensors.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sensors.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
	@Query("select c from Comment c where c.recipe.id = :id ")
	public List<Comment> findCommentByRecipe(@Param("id") Long recipeId);
}
