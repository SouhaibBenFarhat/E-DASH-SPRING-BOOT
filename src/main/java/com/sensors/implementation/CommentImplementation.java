package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.CommentBusiness;
import com.sensors.dao.CommentRepository;
import com.sensors.entities.Comment;


@Service
public class CommentImplementation implements CommentBusiness {

	
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public List<Comment> findCommentByRecipe(Long recipeId) {
		// TODO Auto-generated method stub
		return commentRepository.findCommentByRecipe(recipeId);
	}

	@Override
	public void addComment(Comment comment) {

		commentRepository.save(comment);
	}

	@Override
	public void deleteComment(Comment comment) {

		commentRepository.delete(comment);
		
	}

	@Override
	public Comment findCommentById(Long commentId) {
		// TODO Auto-generated method stub
		return commentRepository.findOne(commentId);
	}
	
	

}
