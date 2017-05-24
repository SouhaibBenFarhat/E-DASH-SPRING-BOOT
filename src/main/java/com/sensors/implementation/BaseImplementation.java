package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.BaseBusiness;
import com.sensors.dao.BaseRepository;
import com.sensors.entities.Base;

@Service
public class BaseImplementation implements BaseBusiness {

	
	@Autowired
	BaseRepository baseRepository;

	@Override
	public void addBase(Base base) {
		baseRepository.save(base);
		
	}

	@Override
	public List<Base> getAllBase() {
		// TODO Auto-generated method stub
		return baseRepository.findAll();
	}

	@Override
	public void deleteBase(Base base) {
		baseRepository.delete(base);
		
	}
	
	
}
