package com.shop.services;

import java.sql.SQLException;

import com.shop.controller.processdb;

public class cthoadon {
	public String muahang(String id_hoadon,String id_sanpham,String soluong,String dongia,String giamgia) {
		String a = "";

		try {
			a = processdb.processcthoadon(id_hoadon, id_sanpham, soluong, dongia, giamgia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}
