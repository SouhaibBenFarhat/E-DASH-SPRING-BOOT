package com.sensors.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.Boitier;
import com.sensors.entities.Message;
import com.sensors.entities.User;
import com.sensors.implementation.BoitierImplementation;
import com.sensors.implementation.UserImplementation;

@RestController
public class UserService {

	@Autowired
	private UserImplementation userImplementation;

	@Autowired
	private BoitierImplementation boitierImplementation;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		
		User u = userImplementation.findUserbyEmail(user.getEmail());
		
		if (u == null) {
			try {
				userImplementation.addUser(user);
			} catch (DataIntegrityViolationException e) {
				return userImplementation.findUserbyEmail(user.getEmail());
			}
			return user;
		}
		else{
			return userImplementation.findUserbyEmail(user.getEmail());

		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userImplementation.findAllUsers();
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public Message registerUser(@RequestBody User user) {

		return userImplementation.registerUser(user);
	}

	@RequestMapping(value = "/user/signin", method = RequestMethod.POST)
	public Object signinUser(@RequestBody User user) {
		if (userImplementation.findUserByEmailAndPassword(user.getEmail(), user.getPassword()) != null) {
				return userImplementation.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		}else{
			Message m = new Message();
			m.setError("user not found");
			return m;
		}
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public User findUserById(@PathVariable Long userId) {
		return userImplementation.findOneById(userId);
	}
	
	@RequestMapping(value = "/user/boitier/{userId}/{macAddress}", method = RequestMethod.POST)
	public Object setUserBoitier(@PathVariable String macAddress, @PathVariable Long userId) {


		User u = userImplementation.findOneById(userId);
		Boitier b = boitierImplementation.findBoitierByMacAddress(macAddress);
		if(b != null){
			b.setEnabled(true);
			u.setBoitier(b);
			userImplementation.addUser(u);
			return u;
		}
		return new Message("Device Not Found","");
	}

}
