package com.shop.model;

public class ChiTietHoaDon {
	private String id_chitiethoadon;

	public String getId_chitiethoadon() {
		return id_chitiethoadon;
	}

	public void setId_chitiethoadon(String id_chitiethoadon) {
		this.id_chitiethoadon = id_chitiethoadon;
	}

	public HoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getDongia() {
		return dongia;
	}

	public void setDongia(double dongia) {
		this.dongia = dongia;
	}

	public int getGiamgia() {
		return giamgia;
	}

	public void setGiamgia(int giamgia) {
		this.giamgia = giamgia;
	}

	public int getPhiphip() {
		return phiphip;
	}

	public void setPhiphip(int phiphip) {
		this.phiphip = phiphip;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	private HoaDon hoadon;
	private SanPham sanpham;
	private int soluong;
	private double dongia;
	private int giamgia;
	private int phiphip;
	private String created;

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(String id_chitiethoadon, HoaDon hoadon, SanPham sanpham, int soluong, double dongia,
			int giamgia, int phiphip, String created) {
		super();
		this.id_chitiethoadon = id_chitiethoadon;
		this.hoadon = hoadon;
		this.sanpham = sanpham;
		this.soluong = soluong;
		this.dongia = dongia;
		this.giamgia = giamgia;
		this.phiphip = phiphip;
		this.created = created;
	}

}
