package com.sensors.business;

import java.util.List;

import com.sensors.entities.Arome;

public interface AromeBusiness {

	
	public void addArome(Arome arome);
	public void deleteArome(Arome arome);
	public Arome findAromeById(Long aromeId);
	public List<Arome> getAllArome();
	public List<Arome> findAromeByManufacture(Long manufactureId);
	public List<Arome> findAromeByCategory(Long categoryId);
	public List<Arome> findEnabledAroma();
	public List<Arome> findDisabledAroma();
	
	public List<Arome> findEnabledAromaByUser(Long userId);
	public List<Arome> findDisabledAromaByUser(Long userId);
	public List<Arome> findAromaByUser(Long userId);
}