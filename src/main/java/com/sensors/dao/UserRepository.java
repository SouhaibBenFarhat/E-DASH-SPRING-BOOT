package com.sensors.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sensors.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.email=:email")
	public User findUserByEmail(@Param("email") String email);

	@Query("select u from User u where u.email=:email AND u.password=:password")
	public Object findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
}
