package com.sensors.business;

import java.util.List;

import com.sensors.entities.Boitier;

public interface BoitierBusiness {

	public List<Boitier> findAllBoitier();
	public void AddBoitier(Boitier b);
	public void deleteBoitier(Boitier b);
	public Boitier findBoitierByMacAddress(String macAddress);
	
	
}
