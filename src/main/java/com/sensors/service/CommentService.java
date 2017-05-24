package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.Arome;
import com.sensors.entities.Comment;
import com.sensors.entities.Recipe;
import com.sensors.entities.User;
import com.sensors.implementation.CommentImplementation;
import com.sensors.implementation.RecipeImplementation;
import com.sensors.implementation.UserImplementation;

@RestController
public class CommentService {

	
	@Autowired
	private CommentImplementation commentImplementation;
	@Autowired
	private RecipeImplementation recipeImplementation;
	@Autowired
	private UserImplementation userImplementation;
	
	@RequestMapping(value = "/comment/{userId}/{recipeId}", method = RequestMethod.POST)
	public Comment saveComment(@RequestBody Comment comment, @PathVariable Long recipeId,@PathVariable Long userId) {

		User u = userImplementation.findOneById(userId);
		Recipe r = recipeImplementation.findRecipeById(recipeId);
		r.setComments(r.getComments()+1);
		recipeImplementation.addRecipe(r);
		comment.setUser(u);
		comment.setRecipe(r);
		commentImplementation.addComment(comment);
		return comment;

	}
	
	@RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
	public Comment deleteComment(@PathVariable Long commentId) {

		Comment c = commentImplementation.findCommentById(commentId);
		commentImplementation.deleteComment(c);
		return c;

	}
	
	@RequestMapping(value = "/comment/{recipeId}", method = RequestMethod.GET)
	public @ResponseBody List<Comment> findCommentByRecipe(@PathVariable Long recipeId) {
		return commentImplementation.findCommentByRecipe(recipeId);
	}
	
}
