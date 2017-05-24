package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.Arome;
import com.sensors.entities.Base;
import com.sensors.implementation.AromeImplementation;
import com.sensors.implementation.BaseImplementation;

@RestController
public class BaseService {

	
	@Autowired
	private BaseImplementation baseImplementation;
	
	@RequestMapping(value = "/base", method = RequestMethod.POST)
	public Base saveBase(@RequestBody com.sensors.entities.Base base) {


		baseImplementation.addBase(base);
		return base;

	}	
	
	@RequestMapping(value = "/base", method = RequestMethod.GET)
	public @ResponseBody List<Base> findAllBase() {
		return baseImplementation.getAllBase();
	}
	
	@RequestMapping(value = "/base", method = RequestMethod.DELETE)
	public void deleteBase(@RequestBody com.sensors.entities.Base base) {
		 baseImplementation.deleteBase(base);
	}

}
