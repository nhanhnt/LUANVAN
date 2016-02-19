package com.shop.services;

import com.shop.controller.processdb;

public class km2city {
	public String km2city(String tp1, String tp2) {
		String response = "0";
		int km = 0;
		try {
			km = Integer.parseInt(processdb.processkc2city(tp1, tp2));
			if (km > 0 && km <= 500) {
				response = "100000";
			} else if (km > 500 && km <= 1000) {
				response = "140000";
			} else if (km > 1000 && km < 1500) {
				response = "180000";
			} else if (km > 1500) {
				response = "210000";
			} else if (km == 0) {
				response = "0";
			} else {
				response = "0";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}
}
