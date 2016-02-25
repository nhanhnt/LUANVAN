package com.shop.services;

import java.util.List;

import com.shop.controller.processdb;
import com.shop.model.DSMuahang;
import com.shop.model.HoaDon;

public class dshoadon {
	public List<HoaDon> dshoadon(int id_user,int pages, int count) {
		List<HoaDon> list = null;
		try {
			list = processdb.processgetdshoadon(id_user, pages, count);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public int dshoadon_countpage(int id_user,int pages, int count) {
		int result = 0;
		try {
			result = processdb.processgetdshoadon_count(id_user, pages, count);
		} catch (Exception e) {
		}
		return result;
	}
}
