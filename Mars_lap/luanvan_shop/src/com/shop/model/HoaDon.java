package com.shop.model;

import java.sql.Timestamp;

public class HoaDon {
	private String id_hoadon;

	public String getId_hoadon() {
		return id_hoadon;
	}

	public void setId_hoadon(String id_hoadon) {
		this.id_hoadon = id_hoadon;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
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

	public Timestamp getNgaymuahang() {
		return ngaymuahang;
	}

	public void setNgaymuahang(Timestamp ngaymuahang) {
		this.ngaymuahang = ngaymuahang;
	}

	public Timestamp getNgaygiaohang() {
		return ngaygiaohang;
	}

	public void setNgaygiaohang(Timestamp ngaygiaohang) {
		this.ngaygiaohang = ngaygiaohang;
	}

	private TaiKhoan taikhoan;
	private String diachigiaohang;
	private String phuongthucthanhtoan;
	private Timestamp ngaymuahang;
	private Timestamp ngaygiaohang;

	public HoaDon(String id_hoadon, TaiKhoan taikhoan, String diachigiaohang, String phuongthucthanhtoan,
			Timestamp ngaymuahang, Timestamp ngaygiaohang) {
		super();
		this.id_hoadon = id_hoadon;
		this.taikhoan = taikhoan;
		this.diachigiaohang = diachigiaohang;
		this.phuongthucthanhtoan = phuongthucthanhtoan;
		this.ngaymuahang = ngaymuahang;
		this.ngaygiaohang = ngaygiaohang;
	}

	public HoaDon() {
		super();
	}

}
