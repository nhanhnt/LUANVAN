package com.shop.model;

public class DanhMuc {
	private String id_danhmuc;

	public String getId_danhmuc() {
		return id_danhmuc;
	}

	public void setId_danhmuc(String id_danhmuc) {
		this.id_danhmuc = id_danhmuc;
	}

	public String getTendanhmuc() {
		return tendanhmuc;
	}

	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

	public String getDanhmuccha() {
		return danhmuccha;
	}

	public void setDanhmuccha(String danhmuccha) {
		this.danhmuccha = danhmuccha;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public DanhMuc(String id_danhmuc, String tendanhmuc, String danhmuccha, String created) {
		super();
		this.id_danhmuc = id_danhmuc;
		this.tendanhmuc = tendanhmuc;
		this.danhmuccha = danhmuccha;
		this.created = created;
	}

	public DanhMuc() {
		super();
	}

	private String tendanhmuc;
	private String danhmuccha;
	private String created;
}
