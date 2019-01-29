package com.vin.dao;

import com.vin.requestmodel.LoginModel;

public interface LoginLogoutDao {
	String ValidateUser(LoginModel model);
	boolean isLoggedinUser(String sessionID);
}
