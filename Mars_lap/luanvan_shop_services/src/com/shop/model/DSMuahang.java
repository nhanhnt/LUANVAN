package com.shop.model;

public class DSMuahang {
	private String id_chitiethoadon;
	private String id_sanpham;
	private String tentaikhoan;
	private String hinhanh;
	private String tensanpham;
	private String soluong;
	private String dongia;
	private String giamgia;
	private String diachigiaohang;
	private String phuongthucthanhtoan;
	private String ngaygiaohang;
	private String tpgiaohang;
	public DSMuahang() {
		super();
	}
	public DSMuahang(String id_chitiethoadon, String id_sanpham, String tentaikhoan, String hinhanh, String tensanpham,
			String soluong, String dongia, String giamgia, String diachigiaohang, String phuongthucthanhtoan,
			String ngaygiaohang, String tpgiaohang, String tong) {
		super();
		this.id_chitiethoadon = id_chitiethoadon;
		this.id_sanpham = id_sanpham;
		this.tentaikhoan = tentaikhoan;
		this.hinhanh = hinhanh;
		this.tensanpham = tensanpham;
		this.soluong = soluong;
		this.dongia = dongia;
		this.giamgia = giamgia;
		this.diachigiaohang = diachigiaohang;
		this.phuongthucthanhtoan = phuongthucthanhtoan;
		this.ngaygiaohang = ngaygiaohang;
		this.tpgiaohang = tpgiaohang;
		this.tong = tong;
	}
	public String getId_chitiethoadon() {
		return id_chitiethoadon;
	}
	public void setId_chitiethoadon(String id_chitiethoadon) {
		this.id_chitiethoadon = id_chitiethoadon;
	}
	public String getId_sanpham() {
		return id_sanpham;
	}
	public void setId_sanpham(String id_sanpham) {
		this.id_sanpham = id_sanpham;
	}
	public String getTentaikhoan() {
		return tentaikhoan;
	}
	public void setTentaikhoan(String tentaikhoan) {
		this.tentaikhoan = tentaikhoan;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public String getSoluong() {
		return soluong;
	}
	public void setSoluong(String soluong) {
		this.soluong = soluong;
	}
	public String getDongia() {
		return dongia;
	}
	public void setDongia(String dongia) {
		this.dongia = dongia;
	}
	public String getGiamgia() {
		return giamgia;
	}
	public void setGiamgia(String giamgia) {
		this.giamgia = giamgia;
	}
	public String getDiachigiaohang() {
		return diachigiaohang;
	}
	public void setDiachigiaohang(String diachigiaohang) {
		this.diachigiaohang = diachigiaohang;
	}
	public String getPhuongthucthanhtoan() {
		return phuongthucthanhtoan;
	}
	public void setPhuongthucthanhtoan(String phuongthucthanhtoan) {
		this.phuongthucthanhtoan = phuongthucthanhtoan;
	}
	public String getNgaygiaohang() {
		return ngaygiaohang;
	}
	public void setNgaygiaohang(String ngaygiaohang) {
		this.ngaygiaohang = ngaygiaohang;
	}
	public String getTong() {
		return tong;
	}
	public void setTong(String tong) {
		this.tong = tong;
	}
	
	public String getTpgiaohang() {
		return tpgiaohang;
	}
	public void setTpgiaohang(String tpgiaohang) {
		this.tpgiaohang = tpgiaohang;
	}

	private String tong;
}
