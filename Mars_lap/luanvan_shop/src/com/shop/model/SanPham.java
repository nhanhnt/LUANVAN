package com.shop.model;

public class SanPham {
	private String id_sanpham;

	public String getId_sanpham() {
		return id_sanpham;
	}

	public void setId_sanpham(String id_sanpham) {
		this.id_sanpham = id_sanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	private DanhMuc danhmuc;

	public DanhMuc getDanhmuc() {
		return danhmuc;
	}

	public void setDanhmuc(DanhMuc danhmuc) {
		this.danhmuc = danhmuc;
	}

	private String tensanpham;
	private String hinhanh;
	private int soluong;
	private String mota;
	private double dongia;
	private int giamgia;
	private String created;

	public SanPham(String id_sanpham, DanhMuc danhmuc, String tensanpham, String hinhanh, int soluong, String mota,
			double dongia, int giamgia, String created) {
		super();
		this.id_sanpham = id_sanpham;
		this.danhmuc = danhmuc;
		this.tensanpham = tensanpham;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.mota = mota;
		this.dongia = dongia;
		this.giamgia = giamgia;
		this.created = created;
	}

	public SanPham() {
		super();
	}
}
