package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.Manufacture;
import com.sensors.implementation.ManufactureImplementation;


@RestController
public class ManufactureService {

	
	@Autowired
	private ManufactureImplementation manufactureImplementation;
	
	
	
	@RequestMapping(value = "/manufacture", method = RequestMethod.POST)
	public Manufacture saveManufacture(@RequestBody Manufacture manufacture){
		manufactureImplementation.addManufacture(manufacture);
		return manufacture;
	}
	
	@RequestMapping(value = "/manufacture", method = RequestMethod.GET)
	public @ResponseBody List<Manufacture> findAllManufacture() {
		return manufactureImplementation.getAllManufacture();
	}
	@RequestMapping(value = "/manufacture", method = RequestMethod.DELETE)
	public @ResponseBody void deleteManufacture(@RequestBody Manufacture manufacture) {
		 manufactureImplementation.deleteManufacture(manufacture);
	}
	
	@RequestMapping(value = "/manufacture", method = RequestMethod.PUT)
	public Manufacture updateManufacture(@RequestBody Manufacture manufacture){

		manufactureImplementation.updateManufacture(manufacture);
		return manufacture;
	}
	
}
