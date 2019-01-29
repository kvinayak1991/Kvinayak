package com.vin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vin.dao.LoginLogoutDao;
import com.vin.requestmodel.LoginModel;

@Service("LoginLogoutService")
public class LoginLogoutServiceImpl implements LoginLogoutService {

	@Autowired
	private LoginLogoutDao dao;
	
	@Override
	public String ValidateUser(LoginModel loginModel) {
		// TODO Auto-generated method stub
		return dao.ValidateUser(loginModel);
	}

}
