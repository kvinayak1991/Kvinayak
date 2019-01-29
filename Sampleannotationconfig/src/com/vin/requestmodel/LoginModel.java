package com.vin.requestmodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "USERNAME", "PASSWORD" })
public class LoginModel {
	
	@JsonProperty("USERNAME")
	private String UserName;
	@JsonProperty("PASSWORD")
	private String Password;

	@JsonProperty("USERNAME")
	public String getUserName() {
		return UserName;
	}

	@JsonProperty("USERNAME")
	public void setUserName(String userName) {
		UserName = userName;
	}

	@JsonProperty("PASSWORD")
	public String getPassword() {
		return Password;
	}

	@JsonProperty("PASSWORD")
	public void setPassword(String password) {
		Password = password;
	}

}
