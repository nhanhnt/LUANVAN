package com.shop.model;

import java.util.TreeMap;

public class GioHang {
	private TreeMap<SanPham, Integer> list;
	private long cartID;

	public GioHang(TreeMap<SanPham, Integer> list, long cartID) {
		super();
		this.list = list;
		this.cartID = cartID;
	}

	public GioHang() {
		list = new TreeMap<>();
		cartID = System.currentTimeMillis();
	}

	public TreeMap<SanPham, Integer> getList() {
		return list;
	}

	public void setList(TreeMap<SanPham, Integer> list) {
		this.list = list;
	}

	public long getCartID() {
		return cartID;
	}

	public void setCartID(long cartID) {
		this.cartID = cartID;
	}

	public void insertToCart(SanPham sp, int soluong) {
		boolean bln = list.containsKey(sp);
		if (bln) {
			int sl = list.get(sp);
			soluong += sl;
			list.put(sp, soluong);
		} else {
			list.put(sp, soluong);
		}
	}
}
