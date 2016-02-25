package com.shop.services;

import com.shop.controller.processdb;

public class giamsl {
	public String giamsl(String id_cthoadon) {
		String response = "0";
		int km = 0;
		try {
			response=processdb.processgiamsl(id_cthoadon);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}
}
