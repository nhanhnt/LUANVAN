package com.shop.model;

public class TaiKhoan {
	private String id_taikhoan;

	public String getId_taikhoan() {
		return id_taikhoan;
	}

	public void setId_taikhoan(String id_taikhoan) {
		this.id_taikhoan = id_taikhoan;
	}

	public String getTentaikhoan() {
		return tentaikhoan;
	}

	public void setTentaikhoan(String tentaikhoan) {
		this.tentaikhoan = tentaikhoan;
	}

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	private String tentaikhoan;
	private String tendangnhap;
	private String matkhau;
	private String diachi;
	private String sodienthoai;
	private String email;
	private String status;
	private String created;
	private int rore;

	public int getRore() {
		return rore;
	}

	public void setRore(int rore) {
		this.rore = rore;
	}

	public TaiKhoan() {	
		super();
	}

	public TaiKhoan(String id_taikhoan, String tentaikhoan, String tendangnhap, String matkhau, String diachi,
			String sodienthoai, String email, String status,int role, String created) {
		super();
		this.id_taikhoan = id_taikhoan;
		this.tentaikhoan = tentaikhoan;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.email = email;
		this.status = status;
		this.created = created;
		this.rore=role;
	}
}
