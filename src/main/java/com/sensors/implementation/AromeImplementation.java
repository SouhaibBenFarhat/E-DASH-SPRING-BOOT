package com.sensors.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.business.AromeBusiness;
import com.sensors.dao.AromeRepository;
import com.sensors.entities.Arome;

@Service
public class AromeImplementation implements AromeBusiness {

	@Autowired
	AromeRepository aromeRepository;

	@Override
	public void addArome(Arome arome) {

		aromeRepository.save(arome);

	}

	@Override
	public List<Arome> getAllArome() {
		// TODO Auto-generated method stub
		return aromeRepository.findAll();
	}

	@Override
	public void deleteArome(Arome arome) {
		aromeRepository.delete(arome);

	}

	@Override
	public List<Arome> findAromeByManufacture(Long manufactureId) {
		// TODO Auto-generated method stub
		return aromeRepository.findAromaByManufacture(manufactureId);
	}

	@Override
	public List<Arome> findAromeByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return aromeRepository.findAromaByCategory(categoryId);
	}

	@Override
	public Arome findAromeById(Long aromeId) {
		// TODO Auto-generated method stub
		return aromeRepository.findOne(aromeId);
	}

	@Override
	public List<Arome> findEnabledAroma() {
		// TODO Auto-generated method stub
		return aromeRepository.findAromaUsers(true);
	}

	@Override
	public List<Arome> findDisabledAroma() {
		// TODO Auto-generated method stub
		return aromeRepository.findAromaUsers(false);
	}

	@Override
	public List<Arome> findEnabledAromaByUser(Long userId) {
		// TODO Auto-generated method stub
		return aromeRepository.findEnabledAromaByUser(true, userId);
	}

	@Override
	public List<Arome> findDisabledAromaByUser(Long userId) {
		// TODO Auto-generated method stub
		return aromeRepository.findDisabledAromaByUser(false, userId);
	}

	@Override
	public List<Arome> findAromaByUser(Long userId) {
		// TODO Auto-generated method stub
		return aromeRepository.findAromaByUser(userId);
	}



}
