package com.vin.services;

import com.vin.requestmodel.LoginModel;

public interface LoginLogoutService {
	String ValidateUser(LoginModel loginModel);
}
