package com.shopcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopcart.entity.Orders;
import com.shopcart.service.OrdersService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addOrder")
	public boolean addOrder(@RequestBody Orders order) {
		return service.addOrder(order);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getOrders/{user_id}")
	public List<Orders> getOrder(@PathVariable int user_id) {
		return service.getOrders(user_id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteOrder/{user_id}")
	public boolean deleteOrder(@PathVariable int user_id) {
		return service.deleteOrder(user_id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateStatus/{user_id}/{order_id}")
	public boolean updateStatus(@PathVariable int user_id, @PathVariable int order_id) {
		return service.updateStatus(user_id,order_id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getPendingOrders")
	public List<Orders> getPendingOrders(){
		return service.getPendingOrders();
	}
	
}
