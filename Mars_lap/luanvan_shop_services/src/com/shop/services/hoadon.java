package com.shop.services;

import java.sql.SQLException;

import com.shop.controller.processdb;

public class hoadon {
	public String createdhoadon(String id_user) {
		String a = "";

		try {
			a = processdb.processhoadon(id_user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}
