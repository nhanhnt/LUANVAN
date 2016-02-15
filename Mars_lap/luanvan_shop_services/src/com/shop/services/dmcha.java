package com.shop.services;

import java.util.ArrayList;
import java.util.List;

import com.shop.controller.processdb;
import com.shop.model.DanhMuc;

public class dmcha {

	public List<DanhMuc> getdmcha() {
		List<DanhMuc> list = new ArrayList<DanhMuc>();
		try {
			list = processdb.processgetdmcha();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
//	public ArrayList<DanhMuc> getdmcha() {
//		ArrayList<DanhMuc> list = null;
//		try {
//			list = processdb.processgetdmcha();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		return list;
//	}
}
