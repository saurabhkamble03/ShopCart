package com.shopcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopcart.entity.Categories;
import com.shopcart.service.CategoriesService;

@CrossOrigin(
////    allowCredentials = "true",
    origins = "http://localhost:3000",
    allowedHeaders = "*",
    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}
)
@RestController
public class CategoriesController {
	
	@Autowired
	private CategoriesService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCategory")
	public boolean addCategory(@RequestBody Categories categories) {
		return service.addCategory(categories);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCategory/{category_id}")
	public Categories getCategory(@PathVariable int category_id) {
		return service.getCategory(category_id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllCategories")
	public List<Categories> getAllCategories(){
		return service.getAllcategories();
	}
	
	
	
}
