package com.sensors.business;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.sensors.entities.Message;
import com.sensors.entities.User;

public interface UserBusiness {

	public void addUser(User user) throws DataIntegrityViolationException;
	public List<User> findAllUsers();
	public User findOneById(User user);
	public User findUserbyEmail(String email);
	public Object findUserByEmailAndPassword(String email, String password);
	public Message registerUser(User user);
	public User findOneById(Long id);
	
}
