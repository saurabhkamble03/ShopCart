package com.shopcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopcart.login.Login;
import com.shopcart.service.AdminService;

@CrossOrigin(
////    allowCredentials = "true",
		origins = "http://localhost:3000", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
				RequestMethod.DELETE, RequestMethod.PUT })
@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@RequestMapping(method = RequestMethod.POST, value = "/adminLogin")
	public boolean adminLogin(@RequestBody Login login) {
		return service.adminLogin(login);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adminLogout")
	public String adminLogout() {
		return service.adminLogout();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAdminSession")
	public int getAdminSession() {
		return service.getAdminSession();
	}
}
