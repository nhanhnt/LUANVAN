package com.shop.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.controller.processdb;
import com.shop.model.DanhMuc;

public class dmcon {
	public List<DanhMuc> getdmcon(int dmcha) {
		List<DanhMuc> list = null;
		try {
			list = processdb.processgetdmcon(dmcha);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
}
