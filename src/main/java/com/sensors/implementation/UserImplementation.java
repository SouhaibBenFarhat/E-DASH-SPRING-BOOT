package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.sensors.business.UserBusiness;
import com.sensors.dao.UserRepository;
import com.sensors.entities.Message;
import com.sensors.entities.User;

@Service
public class UserImplementation implements UserBusiness {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(User user) throws DataIntegrityViolationException {

		userRepository.save(user);

	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findOneById(User user) {

		return userRepository.findOne(user.getId());
	}

	@Override
	public User findUserbyEmail(String email) {

		return userRepository.findUserByEmail(email);
	}

	@Override
	public Message registerUser(User user) {
		User u = findUserbyEmail(user.getEmail());
		Message m = new Message();

		if (u != null) {
			m.setError("user already exist");
			return m;
		}else{
			userRepository.save(user);
			m.setSuccess("success");
			return m;
		}

	
	}

	@Override
	public Object findUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.findUserByEmailAndPassword(email, password);
	}

	@Override
	public User findOneById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

}
