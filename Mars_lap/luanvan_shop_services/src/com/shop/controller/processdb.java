package com.shop.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.ConnectDatabase;
import com.shop.model.DanhMuc;
import com.shop.model.SanPham;

public class processdb {
	public static List<DanhMuc> processgetdmcha() throws SQLException {
		List<DanhMuc> list = new ArrayList<DanhMuc>();
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{call pro_getdmcha()}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			ResultSet result = myQuery.executeQuery();
			while (result.next()) {
				DanhMuc dm = new DanhMuc();
				dm.setId_danhmuc(result.getString("id_danhmuc"));
				dm.setTendanhmuc(result.getString("tendanhmuc"));
				dm.setDanhmuccha(result.getString("danhmuccha"));
				dm.setCreated(result.getString("created"));
				list.add(dm);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			myConnection.close();
		}

		return list;

	}
	public static List<DanhMuc> processgetdmcon(int dmcha) throws SQLException {
		List<DanhMuc> list = new ArrayList<DanhMuc>();
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{call pro_getdmcon(?)}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			myQuery.setInt(1,dmcha);
			ResultSet result = myQuery.executeQuery();
			while (result.next()) {
				DanhMuc dm = new DanhMuc();
				dm.setId_danhmuc(result.getString("id_danhmuc"));
				dm.setTendanhmuc(result.getString("tendanhmuc"));
				dm.setDanhmuccha(result.getString("danhmuccha"));
				dm.setCreated(result.getString("created"));
				list.add(dm);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			myConnection.close();
		}

		return list;

	}
	public static String thongtin() throws SQLException {
		String tt="";
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{call pro_test()}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			ResultSet result = myQuery.executeQuery();
			while (result.next()) {
				tt=result.getString("tt");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			myConnection.close();
		}

		return tt;

	}
	public static List<SanPham> processgetsp(int dm) throws SQLException {
		List<SanPham> list = new ArrayList<SanPham>();
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{call pro_getsanpham(?)}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			myQuery.setInt(1,dm);
			ResultSet result = myQuery.executeQuery();
			while (result.next()) {
				SanPham sp = new SanPham();
				sp.setId_sanpham(result.getString("id_sanpham"));
				DanhMuc danhmuc=new DanhMuc(result.getString("id_danhmuc"), "", "","");
				sp.setDanhmuc(danhmuc);
				sp.setTensanpham(result.getString("tensanpham"));
				sp.setHinhanh(result.getString("hinhanh"));
				sp.setSoluong(result.getInt("soluong"));
				sp.setMota(result.getString("mota"));
				sp.setDongia(result.getInt("dongia"));
				sp.setGiamgia(result.getInt("giamgia"));
				sp.setCreated(result.getString("id_sanpham"));
				list.add(sp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			myConnection.close();
		}

		return list;

	}
	public static List<SanPham> processgetspct(int id_sanpham) throws SQLException {
		List<SanPham> list = new ArrayList<SanPham>();
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{call pro_getdetailsp(?)}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			myQuery.setInt(1,id_sanpham);
			ResultSet result = myQuery.executeQuery();
			while (result.next()) {
				SanPham sp = new SanPham();
				sp.setId_sanpham(result.getString("id_sanpham"));
				DanhMuc danhmuc=new DanhMuc(result.getString("id_danhmuc"), "", "","");
				sp.setDanhmuc(danhmuc);
				sp.setTensanpham(result.getString("tensanpham"));
				sp.setHinhanh(result.getString("hinhanh"));
				sp.setSoluong(result.getInt("soluong"));
				sp.setMota(result.getString("mota"));
				sp.setDongia(result.getInt("dongia"));
				sp.setGiamgia(result.getInt("giamgia"));
				sp.setCreated(result.getString("id_sanpham"));
				list.add(sp);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			myConnection.close();
		}

		return list;

	}
	
	public static String processreg(String username, String password,String email) throws SQLException {
        String result = "0";
        Connection myConnection=null;
        try {
            myConnection = ConnectDatabase.getConnsql();
            String sql = "{?=call func_registry(?,?,?)}";
            CallableStatement myQuery = myConnection.prepareCall(sql);
            myQuery.registerOutParameter(1, java.sql.Types.INTEGER);
            myQuery.setString(2, username);
            myQuery.setString(3, password);
            myQuery.setString(4, email);
            myQuery.execute();
            result = myQuery.getString(1);
            myConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            myConnection.close();
        }

        return result;
    }
	public static String processlogin(String username, String password) throws SQLException {
        String result = "0";
        Connection myConnection=null;
        try {
            myConnection = ConnectDatabase.getConnsql();
            String sql = "{?=call func_login(?,?)}";
            CallableStatement myQuery = myConnection.prepareCall(sql);
            myQuery.registerOutParameter(1, java.sql.Types.INTEGER);
            myQuery.setString(2, username);
            myQuery.setString(3, password);
            myQuery.execute();
            result = myQuery.getString(1);
            myConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            myConnection.close();
        }

        return result;
    }
	// public static String process2city(String thanhpho1, String thanhpho2)
	// throws SQLException {
	// String result = "0";
	// Connection myConnection=null;
	// try {
	// myConnection = ConnectDatabase.getConnsql();
	// String sql = "{?=call func_getkm(?,?)}";
	// CallableStatement myQuery = myConnection.prepareCall(sql);
	// myQuery.registerOutParameter(1, java.sql.Types.INTEGER);
	// myQuery.setString(2, thanhpho1);
	// myQuery.setString(3, thanhpho2);
	// myQuery.execute();
	// result = myQuery.getString(1);
	// myConnection.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }finally{
	// myConnection.close();
	// }
	//
	// return result;
	// }

	public static void main(String[] args) throws SQLException {
//		 List<DanhMuc> list = processgetdmcha();
//		 for (int i = 0; i < list.size(); i++) {
//		 DanhMuc dm = list.get(i);
//		 System.out.println("-----------------------");
//		 System.out.println(dm.getId_danhmuc());
//		 System.out.println(dm.getTendanhmuc());
//		 System.out.println(dm.getDanhmuccha());
//		 System.out.println(dm.getCreated());
//		 System.out.println("-----------------------");
//		 }

//		int a=1;
//		ArrayList<DanhMuc> list = processgetdmcon(a);
//		 for (int i = 0; i < list.size(); i++) {
//		 DanhMuc dm = list.get(i);
//		 System.out.println("-----------------------");
//		 System.out.println(dm.getId_danhmuc());
//		 System.out.println(dm.getTendanhmuc());
//		 System.out.println(dm.getDanhmuccha());
//		 System.out.println(dm.getCreated());
//		 System.out.println("-----------------------");
//		 }

		// System.out.println(" Khoáº£ng cÃ¡ch hai thÃ nh phá»‘ :
		// "+process2city("TP Huáº¿","TP Ä�Ã  Náºµng"));
		
		//System.out.println(thongtin());
		
//		List<SanPham> list = processgetsp(12);
//		 for (int i = 0; i < list.size(); i++) {
//		 SanPham dm = list.get(i);
//		 System.out.println("-----------------------");
//		 System.out.println(dm.getId_sanpham());
//		 System.out.println(dm.getTensanpham());
//		 System.out.println(dm.getDanhmuc().getTendanhmuc());
//		 System.out.println(dm.getCreated());
//		 System.out.println("-----------------------");
//		 }
//		List<SanPham> list = processgetspct(12);
//		 for (int i = 0; i < list.size(); i++) {
//		 SanPham dm = list.get(i);
//		 System.out.println("-----------------------");
//		 System.out.println(dm.getId_sanpham());
//		 System.out.println(dm.getTensanpham());
//		 System.out.println(dm.getDanhmuc().getTendanhmuc());
//		 System.out.println(dm.getCreated());
//		 System.out.println("-----------------------");
//		 }
		//System.out.println(processreg("nhanhnt1","wb/1JnRshCLfYbpGEpitiA==", "honguyenthanhnhan2@gmail.com"));
		System.out.println(processlogin("nhanhnt1","wb/1JnRshCLfYbpGEpitiA=="));
	}

}
