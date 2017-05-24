package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.Arome;
import com.sensors.entities.Category;
import com.sensors.entities.Manufacture;
import com.sensors.entities.User;
import com.sensors.implementation.AromeImplementation;
import com.sensors.implementation.CategoryImplementation;
import com.sensors.implementation.ManufactureImplementation;
import com.sensors.implementation.UserImplementation;

@RestController
public class AromeService {
	
	private String defaultImageUrl="https://firebasestorage.googleapis.com/v0/b/brackets-157800.appspot.com/o/aroma%2Fdefault_aroma.jpg?alt=media&token=896f32ff-a085-46c8-9992-a4478aa528c9";

	@Autowired
	private AromeImplementation aromeImplementation;
	@Autowired
	private CategoryImplementation categoryImplementation;
	@Autowired
	private ManufactureImplementation manufactureImplementation;
	@Autowired
	private UserImplementation userImplementation;

	@RequestMapping(value = "/arome", method = RequestMethod.POST)
	public Arome saveArome(@RequestBody Arome arome) {

		arome.setEnabled(true);
		aromeImplementation.addArome(arome);
		return arome;

	}
	
	
	
	@RequestMapping(value = "/arome/similar", method = RequestMethod.GET)
	public void findSimilarRacipe(@RequestBody List<Category> categories) {

		for(Category c : categories){
			System.out.println("hahahaha");
			System.out.println(c.getId());
		}

	}
	
	
	

	@RequestMapping(value = "/arome/{userId}/{manufactureId}/{categoryId}", method = RequestMethod.POST)
	public Arome saveAromeByUser(@RequestBody Arome arome, @PathVariable Long userId, @PathVariable Long manufactureId,
			@PathVariable Long categoryId) {

		User u = userImplementation.findOneById(userId);
		Manufacture m = manufactureImplementation.findManufactureById(manufactureId);
		Category c = categoryImplementation.findCategoryById(categoryId);
		
		arome.setUser(u);
		arome.setManufacture(m);
		arome.setCategory(c);
		arome.setEnabled(false);
		if (arome.getImageUrl().equals("")) {
			arome.setImageUrl(defaultImageUrl);
		}
		aromeImplementation.addArome(arome);
	
		return arome;

	}
	
	@RequestMapping(value = "/arome/enabled", method = RequestMethod.GET)
	public @ResponseBody List<Arome> findEnabledAroma() {
		return aromeImplementation.findEnabledAroma();
	}
	
	@RequestMapping(value = "/arome/disabled", method = RequestMethod.GET)
	public @ResponseBody List<Arome> findDisabledAroma() {
		return aromeImplementation.findDisabledAroma();
	}
	

	@RequestMapping(value = "/arome", method = RequestMethod.GET)
	public @ResponseBody List<Arome> findAllArome() {
		return aromeImplementation.findEnabledAroma();
	}

	@RequestMapping(value = "/arome", method = RequestMethod.DELETE)
	public void deleteArome(@RequestBody Arome arome) {

		aromeImplementation.deleteArome(arome);

	}

	@RequestMapping(value = "/arome/manufacturer/{manufactureId}", method = RequestMethod.GET)
	public @ResponseBody List<Arome> findAromeByManufacture(@PathVariable Long manufactureId) {
		return aromeImplementation.findAromeByManufacture(manufactureId);
	}

	@RequestMapping(value = "/arome/category/{categoryId}", method = RequestMethod.GET)
	public @ResponseBody List<Arome> findAromeByCategory(@PathVariable Long categoryId) {
		return aromeImplementation.findAromeByCategory(categoryId);
	}

	@RequestMapping(value = "/arome/{aromeId}", method = RequestMethod.PUT)
	public Arome enableAroma(@PathVariable Long aromeId) {

		Arome a = aromeImplementation.findAromeById(aromeId);
		a.setEnabled(true);
		aromeImplementation.addArome(a);
		return a;

	}
	

	@RequestMapping(value = "/arome/enabled/{userId}", method = RequestMethod.GET)
	public @ResponseBody List<Arome> findEnabledAromaByUser(@PathVariable Long userId) {
		return aromeImplementation.findEnabledAromaByUser(userId);
	}
	
	@RequestMapping(value = "/arome/disabled/{userId}", method = RequestMethod.GET)
	public @ResponseBody List<Arome> findDisabledAromaByUser(@PathVariable Long userId) {
		return aromeImplementation.findDisabledAromaByUser(userId);
	}

	
	@RequestMapping(value = "/arome/{userId}", method = RequestMethod.GET)
	public @ResponseBody List<Arome> findAromaByUser(@PathVariable Long userId) {
		return aromeImplementation.findAromaByUser(userId);
	}
}
