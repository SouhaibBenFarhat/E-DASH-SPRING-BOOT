package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.BoitierBusiness;
import com.sensors.dao.BoitierRepository;
import com.sensors.entities.Boitier;

@Service
public class BoitierImplementation implements BoitierBusiness {

	@Autowired
	BoitierRepository boitierRepository;
	
	@Override
	public List<Boitier> findAllBoitier() {
		// TODO Auto-generated method stub
		return boitierRepository.findAll();
	}

	@Override
	public void AddBoitier(Boitier b) {
		// TODO Auto-generated method stub
		
		boitierRepository.save(b);
		
	}

	@Override
	public void deleteBoitier(Boitier b) {
		// TODO Auto-generated method stub
		boitierRepository.delete(b);
		
	}

	@Override
	public Boitier findBoitierByMacAddress(String macAddress) {
		// TODO Auto-generated method stub
		
		return boitierRepository.findBoitierByMacAddress(macAddress);
		
		
	}

}
