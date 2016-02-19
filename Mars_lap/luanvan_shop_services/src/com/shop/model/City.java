package com.shop.model;

public class City {
	private String id_city;
	private String city;
	private String city2;
	private String khoangcach;
	public City(String id_city, String city, String city2, String khoangcach) {
		super();
		this.id_city = id_city;
		this.city = city;
		this.city2 = city2;
		this.khoangcach = khoangcach;
	}
	public City() {
		super();
	}
	public String getId_city() {
		return id_city;
	}
	public void setId_city(String id_city) {
		this.id_city = id_city;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public String getKhoangcach() {
		return khoangcach;
	}
	public void setKhoangcach(String khoangcach) {
		this.khoangcach = khoangcach;
	}
	
}
