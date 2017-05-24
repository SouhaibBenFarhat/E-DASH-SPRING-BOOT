package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.AromaPerRecipe;
import com.sensors.entities.Boitier;
import com.sensors.entities.Recipe;
import com.sensors.implementation.BoitierImplementation;

@RestController
public class BoitierService {

	
	@Autowired
	BoitierImplementation boitierImplementation;
	
	
	
	@RequestMapping(value = "/boitier", method = RequestMethod.POST)
	public Boitier saveBoitier(@RequestBody Boitier boitier) {


		boitierImplementation.AddBoitier(boitier);
		return boitier;

	}
	
	@RequestMapping(value = "/boitier", method = RequestMethod.GET)
	public List<Boitier> findAllBoitier() {


		return boitierImplementation.findAllBoitier();

	}
	
	@RequestMapping(value = "/boitier", method = RequestMethod.DELETE)
	public Boitier deleteBoitier(@RequestBody Boitier boitier) {

		boitierImplementation.deleteBoitier(boitier);


		return boitier;
	}
	

	@RequestMapping(value = "/boitier/mac/{macAddress}", method = RequestMethod.GET)
	public Boitier findBoitierByMacAddress(@PathVariable String macAddress) {

		return boitierImplementation.findBoitierByMacAddress(macAddress);


	
	}
}
