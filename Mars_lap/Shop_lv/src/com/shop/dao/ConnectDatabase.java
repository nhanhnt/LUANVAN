package com.shop.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.shop.common.Configuration;
import com.shop.util.encrypt;

public class ConnectDatabase {

	public static Connection getConnsql() throws SQLException, Exception {
		Connection cn = null;
		String url = Configuration.getIDsValue("url");
		String driver = "com.mysql.jdbc.Driver";
		String userName = Configuration.getIDsValue("username_database");
		String password = Configuration.getIDsValue("password_database");
		try {
			Class.forName(driver);
			cn = (Connection) DriverManager.getConnection(url, encrypt.decryptttth(userName, "nhanhnt1@ttth"),
					encrypt.decryptttth(password, "nhanhnt1@ttth"));
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return cn;
	}

	public static void main(String[] args) throws SQLException, Exception {
		String url = Configuration.getIDsValue("url");

		System.out.println(url);
		System.out.println(getConnsql());

	}

}
