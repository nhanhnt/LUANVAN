package com.shop.services;

import java.util.ArrayList;
import java.util.List;

import com.shop.controller.processdb;
import com.shop.model.City;

public class city {
	public List<City> getcity() {
		List<City> list = new ArrayList<City>();
		try {
			list = processdb.processgetcity();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
}
