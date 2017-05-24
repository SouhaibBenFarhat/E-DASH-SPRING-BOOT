package com.sensors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensors.entities.Category;
import com.sensors.implementation.CategoryImplementation;

@RestController
public class CategoryService {

	@Autowired
	private CategoryImplementation categoryImplementation;

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public Category saveCategory(@RequestBody Category category) {

		categoryImplementation.addCategory(category);
		return category;

	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public @ResponseBody List<Category> findAllCategory() {
		return categoryImplementation.getAllCategory();
	}

	@RequestMapping(value = "/category", method = RequestMethod.DELETE)
	public void deleteCategory(@RequestBody Category category) {

		categoryImplementation.deleteCategory(category);

	}
	
	@RequestMapping(value = "/category", method = RequestMethod.PUT)
	public Category updateCategory(@RequestBody Category category) {


		categoryImplementation.updateCategory(category);
		return category;

	}

}