package com.shopcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopcart.entity.Items;
import com.shopcart.service.ItemsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ItemsController {
	
	@Autowired
	private ItemsService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addItem")
	public boolean addItem(@RequestBody Items item) {
		return service.addItem(item);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getItem/{item_id}")
	public Items getItem(@PathVariable int item_id) {
		return service.getItem(item_id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteItem/{item_id}")
	public boolean deleteItem(@PathVariable int item_id) {
		return service.deleteItem(item_id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getItemsByCategory/{category}")
	public List<Items> getItemsByCategory(@PathVariable String category) {
		return service.getItemsByCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateItem/{item_id}")
	public boolean updateItem(@PathVariable int item_id, @RequestBody Items item) {
		return service.updateItem(item_id,item);
	}
	
}
