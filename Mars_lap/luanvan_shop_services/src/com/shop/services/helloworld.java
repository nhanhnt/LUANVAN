package com.shop.services;

import java.sql.SQLException;

import com.shop.controller.processdb;

public class helloworld {
	public String helo(String param) {
		String a = "";

		try {
			a = processdb.thongtin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Nhanhnt said that: " + param + "   " + a;
	}
}
