package com.shop.services;

import com.shop.controller.processdb;

public class dangnhap {
	public String login(String username, String password) {
		String response = "0";
		try {
			response = processdb.processlogin(username, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}
}
