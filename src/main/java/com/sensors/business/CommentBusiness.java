package com.sensors.business;

import java.util.List;

import com.sensors.entities.Comment;

public interface CommentBusiness {

	
	public List<Comment> findCommentByRecipe(Long recipeId);
	public void addComment(Comment comment);
	public void deleteComment(Comment comment);
	public Comment findCommentById(Long commentId);
}
