package com.shop.services;

import java.util.List;

import com.shop.controller.processdb;
import com.shop.model.SanPham;

public class sanpham {
	public List<SanPham> getsp(int dm) {
		List<SanPham> list = null;
		try {
			list = processdb.processgetsp(dm);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
}
