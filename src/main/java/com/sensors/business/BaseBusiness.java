package com.sensors.business;

import java.util.List;

import com.sensors.entities.Base;

public interface BaseBusiness {

	
	public void addBase(com.sensors.entities.Base base);
	public void deleteBase(Base base);
	public List<com.sensors.entities.Base> getAllBase();
}
