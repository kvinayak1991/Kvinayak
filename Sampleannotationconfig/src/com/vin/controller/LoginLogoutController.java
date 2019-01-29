package com.vin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vin.requestmodel.LoginModel;
import com.vin.services.LoginLogoutService;

@RestController
@RequestMapping("api")
public class LoginLogoutController {
	
	@Autowired
	private LoginLogoutService service;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	private String getLogin(@RequestBody LoginModel loginModel) {
		//islocked
		//isExpire
		return service.ValidateUser(loginModel);
	}
}
