package com.shop.services;

import com.shop.controller.processdb;

public class dangky {
	public String registry(String username,String password,String email){
		String response="0";
		try {
			response=processdb.processreg(username, password, email);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}
}
