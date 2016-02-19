package com.shop.services;

import java.sql.SQLException;

import com.shop.controller.processdb;

public class updatehoadon {
	public String capnhathoadon(String id_hoadon, String diachi, String tp, String phuongthuc, String ngaygiao,
			String phiship) {
		String a = "";

		try {
			a = processdb.processupdatehoadon(id_hoadon, diachi, tp, phuongthuc, ngaygiao, phiship);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}
