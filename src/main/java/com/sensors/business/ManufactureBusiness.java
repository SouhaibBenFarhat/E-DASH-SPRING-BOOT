package com.sensors.business;

import java.util.List;

import com.sensors.entities.Manufacture;

public interface ManufactureBusiness {

	public void addManufacture(Manufacture manufacture);
	public List<Manufacture> getAllManufacture();
	public void deleteManufacture(Manufacture manufacture);
	public void updateManufacture(Manufacture manufacture);
	public Manufacture findManufactureById(Long manufactureId);
}
