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

	

	private TaiKhoan taikhoan;
	private String diachigiaohang;
	private String phuongthucthanhtoan;
	private String ngaymuahang;
	private String ngaygiaohang;
	private String phiship;
	private String status;
	private String tpgiaohang;
	private String tongtien;

	public String getPhiship() {
		return phiship;
	}

	public void setPhiship(String phiship) {
		this.phiship = phiship;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HoaDon() {
		super();
	}



	public String getNgaymuahang() {
		return ngaymuahang;
	}

	public void setNgaymuahang(String ngaymuahang) {
		this.ngaymuahang = ngaymuahang;
	}

	public String getNgaygiaohang() {
		return ngaygiaohang;
	}

	public void setNgaygiaohang(String ngaygiaohang) {
		this.ngaygiaohang = ngaygiaohang;
	}

	

	public String getTongtien() {
		return tongtien;
	}

	public void setTongtien(String tongtien) {
		this.tongtien = tongtien;
	}

	public HoaDon(String id_hoadon, TaiKhoan taikhoan, String diachigiaohang, String phuongthucthanhtoan,
			String ngaymuahang, String ngaygiaohang, String phiship, String status, String tpgiaohang,
			String tongtien) {
		super();
		this.id_hoadon = id_hoadon;
		this.taikhoan = taikhoan;
		this.diachigiaohang = diachigiaohang;
		this.phuongthucthanhtoan = phuongthucthanhtoan;
		this.ngaymuahang = ngaymuahang;
		this.ngaygiaohang = ngaygiaohang;
		this.phiship = phiship;
		this.status = status;
		this.tpgiaohang = tpgiaohang;
		this.tongtien = tongtien;
	}

	public String getTpgiaohang() {
		return tpgiaohang;
	}

	public void setTpgiaohang(String tpgiaohang) {
		this.tpgiaohang = tpgiaohang;
	}

	
	

	

}
