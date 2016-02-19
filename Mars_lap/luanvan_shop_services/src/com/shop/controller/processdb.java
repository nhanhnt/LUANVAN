package com.shop.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.ConnectDatabase;
import com.shop.model.City;
import com.shop.model.DSMuahang;
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
			myQuery.setInt(1, dmcha);
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
		String tt = "";
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{call pro_test()}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			ResultSet result = myQuery.executeQuery();
			while (result.next()) {
				tt = result.getString("tt");
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
			myQuery.setInt(1, dm);
			ResultSet result = myQuery.executeQuery();
			while (result.next()) {
				SanPham sp = new SanPham();
				sp.setId_sanpham(result.getString("id_sanpham"));
				DanhMuc danhmuc = new DanhMuc(result.getString("id_danhmuc"), "", "", "");
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
			myQuery.setInt(1, id_sanpham);
			ResultSet result = myQuery.executeQuery();
			while (result.next()) {
				SanPham sp = new SanPham();
				sp.setId_sanpham(result.getString("id_sanpham"));
				DanhMuc danhmuc = new DanhMuc(result.getString("id_danhmuc"), "", "", "");
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

	public static String processreg(String username, String password, String email) throws SQLException {
		String result = "0";
		Connection myConnection = null;
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
		} finally {
			myConnection.close();
		}

		return result;
	}

	public static String processlogin(String username, String password) throws SQLException {
		String result = "0";
		Connection myConnection = null;
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
		} finally {
			myConnection.close();
		}

		return result;
	}

	public static String processhoadon(String id_user) throws SQLException {
		String result = "0";
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{?=call func_hoadon(?)}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			myQuery.registerOutParameter(1, java.sql.Types.INTEGER);
			myQuery.setString(2, id_user);
			myQuery.execute();
			result = myQuery.getString(1);
			myConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close();
		}

		return result;
	}
	public static String processcthoadon(String id_hoadon,String id_sanpham,String soluong,String dongia, String giamgia) throws SQLException {
		String result = "0";
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{?=call func_cthoadon(?,?,?,?,?)}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			myQuery.registerOutParameter(1, java.sql.Types.INTEGER);
			myQuery.setString(2, id_hoadon);
			myQuery.setString(3, id_sanpham);
			myQuery.setString(4, soluong);
			myQuery.setString(5, dongia);
			myQuery.setString(6, giamgia);		
			
			myQuery.execute();
			result = myQuery.getString(1);
			myConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close();
		}

		return result;
	}
	public static String processupdatehoadon(String id_hoadon,String diachigiaohang,String tpgiaohang,String ptth,String ngaygiaohang, String phiship) throws SQLException {
		String result = "0";
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{?=call func_update_hoadon(?,?,?,?,?,?)}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			myQuery.registerOutParameter(1, java.sql.Types.INTEGER);
			myQuery.setString(2, id_hoadon);
			myQuery.setString(3, diachigiaohang);
			myQuery.setString(4, tpgiaohang);
			myQuery.setString(5, ptth);
			myQuery.setString(6, ngaygiaohang);
			myQuery.setString(7, phiship);		
			
			myQuery.execute();
			result = myQuery.getString(1);
			myConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close();
		}

		return result;
	}
	
	
	
	public static List<DSMuahang> processgetdsmuahang(int id_hoadon,int count) throws SQLException {
		List<DSMuahang> list = new ArrayList<DSMuahang>();
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{call pro_getcart(?,?)}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			myQuery.setInt(1, id_hoadon);
			myQuery.setInt(2, count);
			ResultSet result = myQuery.executeQuery();
			while (result.next()) {
				DSMuahang dsmh = new DSMuahang();
				dsmh.setId_sanpham(result.getString("id_sanpham"));
				dsmh.setId_chitiethoadon(result.getString("id_chitiethoadon"));
				dsmh.setTentaikhoan(result.getString("tentaikhoan"));
				dsmh.setHinhanh(result.getString("hinhanh"));
				dsmh.setTensanpham(result.getString("tensanpham"));
				dsmh.setSoluong(result.getString("soluong"));
				dsmh.setDongia(result.getString("dongia"));
				dsmh.setGiamgia(result.getString("giamgia"));
				dsmh.setDiachigiaohang(result.getString("diachigiaohang"));
				dsmh.setPhuongthucthanhtoan(result.getString("phuongthucthanhtoan"));
				dsmh.setNgaygiaohang(result.getString("ngaygiaohang"));
				dsmh.setTong(result.getString("tong"));
				dsmh.setTpgiaohang(result.getString("tpgiaohang"));
			
				list.add(dsmh);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			myConnection.close();
		}

		return list;

	}
	
	public static double processgetdsmuahang_count(int id_hoadon,int count) throws SQLException {
		int result=0;
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{call pro_getcart(?,?)}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			myQuery.setInt(1, id_hoadon);
			myQuery.registerOutParameter(2,java.sql.Types.DOUBLE);
			myQuery.execute();
			result = myQuery.getInt(2);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			myConnection.close();
		}

		return result;

	}
	
	public static List<City> processgetcity() throws SQLException {
		List<City> list = new ArrayList<City>();
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql2();
			String sql = "{call pro_getcity()}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			ResultSet result = myQuery.executeQuery();
			while (result.next()) {
				City city = new City();
				city.setCity(result.getString("thanhpho1"));
				list.add(city);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			myConnection.close();
		}

		return list;

	}
	public static String processkc2city(String tp1,String tp2) throws SQLException {
		String result = "0";
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql2();
			String sql = "{?=call func_getkm(?,?)}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			myQuery.registerOutParameter(1, java.sql.Types.INTEGER);
			myQuery.setString(2, tp1);
			myQuery.setString(3, tp2);	
			
			myQuery.execute();
			result = myQuery.getString(1);
			myConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close();
		}

		return result;
	}
	public static String processdeletehang(String id_cthoadon) throws SQLException {
		String result = "0";
		Connection myConnection = null;
		try {
			myConnection = ConnectDatabase.getConnsql();
			String sql = "{?=call func_deletecthd(?)}";
			CallableStatement myQuery = myConnection.prepareCall(sql);
			myQuery.registerOutParameter(1, java.sql.Types.INTEGER);
			myQuery.setString(2, id_cthoadon);
						
			myQuery.execute();
			result = myQuery.getString(1);
			myConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		// List<DanhMuc> list = processgetdmcha();
		// for (int i = 0; i < list.size(); i++) {
		// DanhMuc dm = list.get(i);
		// System.out.println("-----------------------");
		// System.out.println(dm.getId_danhmuc());
		// System.out.println(dm.getTendanhmuc());
		// System.out.println(dm.getDanhmuccha());
		// System.out.println(dm.getCreated());
		// System.out.println("-----------------------");
		// }

		// int a=1;
		// ArrayList<DanhMuc> list = processgetdmcon(a);
		// for (int i = 0; i < list.size(); i++) {
		// DanhMuc dm = list.get(i);
		// System.out.println("-----------------------");
		// System.out.println(dm.getId_danhmuc());
		// System.out.println(dm.getTendanhmuc());
		// System.out.println(dm.getDanhmuccha());
		// System.out.println(dm.getCreated());
		// System.out.println("-----------------------");
		// }

		// System.out.println(" KhoÃ¡ÂºÂ£ng cÃƒÂ¡ch hai thÃƒÂ nh phÃ¡Â»â€˜ :
		// "+process2city("TP HuÃ¡ÂºÂ¿","TP Ã„ï¿½ÃƒÂ  NÃ¡ÂºÂµng"));

		// System.out.println(thongtin());

		// List<SanPham> list = processgetsp(12);
		// for (int i = 0; i < list.size(); i++) {
		// SanPham dm = list.get(i);
		// System.out.println("-----------------------");
		// System.out.println(dm.getId_sanpham());
		// System.out.println(dm.getTensanpham());
		// System.out.println(dm.getDanhmuc().getTendanhmuc());
		// System.out.println(dm.getCreated());
		// System.out.println("-----------------------");
		// }
		// List<SanPham> list = processgetspct(12);
		// for (int i = 0; i < list.size(); i++) {
		// SanPham dm = list.get(i);
		// System.out.println("-----------------------");
		// System.out.println(dm.getId_sanpham());
		// System.out.println(dm.getTensanpham());
		// System.out.println(dm.getDanhmuc().getTendanhmuc());
		// System.out.println(dm.getCreated());
		// System.out.println("-----------------------");
		// }
		// System.out.println(processreg("nhanhnt1","wb/1JnRshCLfYbpGEpitiA==",
		// "honguyenthanhnhan2@gmail.com"));
		// System.out.println(processlogin("nhanhnt1","wb/1JnRshCLfYbpGEpitiA=="));

//		System.out.println(processhoadon("10"));
//		System.out.println(processcthoadon("10","1","1","319000","41"));
//		System.out.println(processupdatehoadon("12","93 nguyễn trãi 2","Lấy tiền","2016-02-20","21000"));
		
//		List<DSMuahang> list = processgetdsmuahang(14,1);
//		for (int i = 0; i < list.size(); i++) {
//			DSMuahang ds = list.get(i);
//			System.out.println("-----------------------");
//			System.out.println(ds.getId_sanpham());
//			System.out.println(ds.getTensanpham());
//			System.out.println(ds.getSoluong());
//			System.out.println(ds.getDongia());
//			System.out.println(ds.getGiamgia());
//			System.out.println(ds.getTong());
//			System.out.println("-----------------------");
//		}
//		System.out.println("tổng tiền " + processgetdsmuahang_count(14,1));
		
//		List<City> list = processgetcity();
//		for (int i = 0; i < list.size(); i++) {
//			City ds = list.get(i);
//			System.out.println("-----------------------");
//			System.out.println(ds.getCity());
//			System.out.println("-----------------------");
//		}
//		
		
		//System.out.println(processkc2city("TP Huế","TP Đà Nẵng"));
		
		System.out.println("Xóa mặt hàng " + processdeletehang(Integer.toString(14)));
	}

}
