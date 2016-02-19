package com.shop.services;

import java.util.List;

import com.shop.controller.processdb;
import com.shop.model.DSMuahang;

public class muahang {
	public List<DSMuahang> getlistmh(int id_hoadon, int count) {
		List<DSMuahang> list = null;
		try {
			list = processdb.processgetdsmuahang(id_hoadon, count);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public double getlistmh_sum(int id_hoadon, int count) {
		double result = 0;
		try {
			result = processdb.processgetdsmuahang_count(id_hoadon, count);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
