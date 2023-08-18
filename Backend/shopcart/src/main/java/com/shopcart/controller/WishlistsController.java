package com.shopcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopcart.entity.Wishlists;
import com.shopcart.service.WishlistsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WishlistsController {
	
	@Autowired
	private WishlistsService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addWishlist")
	public boolean addWishlist(@RequestBody Wishlists wishlist) {
		return service.addWishlists(wishlist);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getWishlists/{user_id}")
	public List<Wishlists> getWishlists(@PathVariable int user_id){
		return service.getWishlists(user_id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteWishlist/{wishlist_id}")
	public boolean deleteWishlist(@PathVariable int wishlist_id) {
		return service.deleteWishlist(wishlist_id);
	}

	
	
}
