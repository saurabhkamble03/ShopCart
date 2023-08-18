package com.shopcart.controller;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shopcart.entity.Users;
import com.shopcart.login.Login;
import com.shopcart.service.UsersService;

@CrossOrigin(
////	    allowCredentials = "true",
	    origins = "http://localhost:3000",
	    allowedHeaders = "*",
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}
)
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addUser")
	public boolean addUser(@RequestBody Users user) {
		
		boolean response = service.addUser(user);
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getUser/{user_id}")
	public Users getUser(@PathVariable int user_id) {
		
		return service.getUser(user_id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateUser/{user_id}")
	public boolean updateUser(@PathVariable int user_id, @RequestBody Users user) {
		return service.updateUser(user_id,user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/userLogin")
	public boolean userLogin(@RequestBody Login login) {
		return service.userLogin(login);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/userLogout")
	public String userLogout() {
		return service.userLogout();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getSession")
	public int getSession() {
		return service.getSession();
	}

}
