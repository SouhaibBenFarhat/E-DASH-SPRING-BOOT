package com.sensors.implementation;

import static org.mockito.Matchers.matches;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.ManufactureBusiness;
import com.sensors.dao.ManufactureRepository;
import com.sensors.entities.Manufacture;

@Service
public class ManufactureImplementation implements ManufactureBusiness {
	
	@Autowired
	ManufactureRepository manufactureImplementation;

	@Override
	public void addManufacture(Manufacture manufacture) {

		manufactureImplementation.save(manufacture);
		
	}

	@Override
	public List<Manufacture> getAllManufacture() {
		// TODO Auto-generated method stub
		return manufactureImplementation.findAll();
	}

	@Override
	public void deleteManufacture(Manufacture manufacture) {

		manufactureImplementation.delete(manufacture);
		
	}

	@Override
	public void updateManufacture(Manufacture manufacture) {
		
		manufactureImplementation.save(manufacture);
		
	}

	@Override
	public Manufacture findManufactureById(Long manufactureId) {
		// TODO Auto-generated method stub
		return manufactureImplementation.findOne(manufactureId);
	}

}
