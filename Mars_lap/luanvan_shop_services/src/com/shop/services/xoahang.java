package com.shop.services;

import java.sql.SQLException;

import com.shop.controller.processdb;

public class xoahang {
	public String xoahang(String id_cthoadon) {
		String a = "";

		try {
			a = processdb.processdeletehang(id_cthoadon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	} 
}
