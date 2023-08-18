package com.shopcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopcart.entity.Cart;
import com.shopcart.service.CartService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartController {

	@Autowired
	private CartService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCart")
	public boolean addCart(@RequestBody Cart cart) {
		return service.addCart(cart);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCartByUserId/{user_id}")
	public List<Cart> getCartByUserId(@PathVariable int user_id) {
		return service.getCartByUserId(user_id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteItemFromCart/{item_id}/{user_id}")
	public boolean deleteItemFromCart(@PathVariable int item_id, @PathVariable int user_id) {
		return service.deleteItemFromCart(item_id,user_id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getSubtotal/{user_id}")
	public float getSubtotal(@PathVariable int user_id) {
		return service.getSubtotal(user_id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value ="/minusItem/{item_id}/{user_id}")
	public boolean minusItem(@PathVariable int item_id, @PathVariable int user_id) {
		return service.minusItem(item_id,user_id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value ="/plusItem/{item_id}/{user_id}")
	public boolean plusItem(@PathVariable int item_id, @PathVariable int user_id) {
		return service.plusItem(item_id,user_id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteCart/{user_id}")
	public boolean deleteCart(@PathVariable int user_id) {
		return service.deleteCart(user_id);
	}
	
}
