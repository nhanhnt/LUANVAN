package com.shop.services;

import java.util.List;

import com.shop.controller.processdb;
import com.shop.model.SanPham;

public class sanphamct {
	public List<SanPham> getspct(int id_sp) {
		List<SanPham> list = null;
		try {
			list = processdb.processgetspct(id_sp);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
}
