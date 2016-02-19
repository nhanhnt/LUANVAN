package com.shop.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ftl.util.DateUtil;
import com.shop.services.CityStub;
import com.shop.services.CityStub.Getcity;
import com.shop.services.Km2CityStub;
import com.shop.services.Km2CityStub.Km2City;
import com.shop.services.Km2CityStub.Km2CityResponse;
import com.shop.services.MuahangStub;
import com.shop.services.MuahangStub.Getlistmh;
import com.shop.services.MuahangStub.Getlistmh_sum;
import com.shop.services.XoahangStub;
import com.shop.services.XoahangStub.Xoahang;
import com.shop.services.XoahangStub.XoahangResponse;

@Controller
public class CartController {
	@RequestMapping(value = "/cart.html", method = { RequestMethod.POST, RequestMethod.GET })
	protected ModelAndView cart(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("cart");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession httpsession = request.getSession();
		String action = request.getParameter("action");
		String logout_display = request.getParameter("logout_display");
		String login_display = request.getParameter("login_display");
		String account_display = request.getParameter("account_display");
		String tong_display = request.getParameter("tong_display");
		String ngaynhan = request.getParameter("ngaynhan");
		String error = request.getParameter("error");
		String cong = request.getParameter("cong");
		cong="cong";
		String tru = request.getParameter("tru");
		tru="tru";
		tong_display = "none";
		String cart_display = request.getParameter("cart_display");
		String username = (String) httpsession.getAttribute("username");
		String id_user = (String) httpsession.getAttribute("id_user");
		String id_hoadon = (String) httpsession.getAttribute("id_hoadon");
		String phuongthucthanhtoan = request.getParameter("phuongthucthanhtoan");
		String diachigiaohang = request.getParameter("diachigiaohang");
		String city = request.getParameter("city");
		String phiship = request.getParameter("phiship");
		String tongtien = "0";
		if (id_hoadon == null) {
			id_hoadon = "";
		}
		if (id_user == null) {
			id_user = "";
		}
		mv.addObject("id_user", id_user);
		if (username == null || username.equals("Account")) {
			httpsession.setAttribute("username", "Account");
			logout_display = "none";
			cart_display = "return false;";
			account_display = "return false;";
		} else {
			logout_display = "block";
			account_display = "return false;";
			try {
				MuahangStub muahangstub = new MuahangStub();
				Getlistmh getlistmh = new Getlistmh();
				getlistmh.setId_hoadon(Integer.parseInt(id_hoadon));
				mv.addObject("listmuahang", muahangstub.getlistmh(getlistmh).get_return());
//				for (int i = 0; i < muahangstub.getlistmh(getlistmh).get_return().length; i++) {
//					// phuongthucthanhtoan =
//					// muahangstub.getlistmh(getlistmh).get_return()[i].getPhuongthucthanhtoan();
//					// diachigiaohang =
//					// muahangstub.getlistmh(getlistmh).get_return()[i].getDiachigiaohang();
//					ngaynhan = muahangstub.getlistmh(getlistmh).get_return()[i].getNgaygiaohang();
//
//				}
				DateFormat dateformat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date=new Date();
				date=DateUtil.addDay(date,3);
				ngaynhan=dateformat.format(date);
				//System.out.println(dateformat.format(date));
			
				
				// httpsession.setAttribute("phuongthucthanhtoan",
				// phuongthucthanhtoan);
				// httpsession.setAttribute("diachigiaohang", diachigiaohang);
				// httpsession.setAttribute("city", city);
				CityStub citystub = new CityStub();
				Getcity ct = new Getcity();
				mv.addObject("listcity", citystub.getcity(ct).get_return());
				
				try {
					if (action.equals("thanhtien")) {
						
						if (phuongthucthanhtoan.equals("") || diachigiaohang.equals("")) {
							tong_display = "none";
							error="Chưa nhập đủ dữ liệu";
						} else {
							tong_display = "block";
						}
						phiship = request.getParameter("phiship");

						NumberFormat nf = NumberFormat.getInstance();
						nf.setMinimumIntegerDigits(0);
						// Lấy về phí ship
						Km2CityStub kmstub = new Km2CityStub();
						Km2City km2 = new Km2City();
						km2.setTp1("TP Huế");
						km2.setTp2(city);
						Km2CityResponse kmres = kmstub.km2City(km2);
						// phiship=nf.format(Math.round(Integer.parseInt(kmres.get_return().toString())));
						phiship = nf.format(Math.round(Integer.parseInt(kmres.get_return().toString())));

						Getlistmh_sum s = new Getlistmh_sum();
						s.setId_hoadon(14);
						tongtien = nf.format(Math.round(muahangstub.getlistmh_sum(s).get_return()));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (logout_display.equals("none")) {
			login_display = "block";
		} else {
			login_display = "none";
		}

		mv.addObject("logout_display", logout_display);
		mv.addObject("login_display", login_display);
		mv.addObject("account_display", account_display);
		mv.addObject("cart_display", cart_display);
		mv.addObject("username", username);
		mv.addObject("tong_display", tong_display);
		mv.addObject("phuongthucthanhtoan", phuongthucthanhtoan);
		mv.addObject("diachigiaohang", diachigiaohang);
		mv.addObject("city", city);
		mv.addObject("ngaynhan", ngaynhan);
		mv.addObject("phiship", phiship);
		mv.addObject("tongtien", tongtien);
		mv.addObject("error", error);
		return mv;
	}
	@RequestMapping(value = "/cart.html/{id_chitiethoadon}")
	protected ModelAndView detail(@PathVariable("id_chitiethoadon") String id_chitiethoadon, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("cart");
		HttpSession httpsession = request.getSession();
		try {
			XoahangStub xhstub=new XoahangStub();
			Xoahang xh=new Xoahang();
			xh.setId_cthoadon(id_chitiethoadon);
			XoahangResponse res=xhstub.xoahang(xh);
			response.sendRedirect("/luanvan_shop/cart.html");
		} catch (Exception e) {
			e.toString();
		}
		return mv;
	}
//	@RequestMapping(value = "/cart.html/soluong/cong")
//	protected ModelAndView detail21( HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView("cart");
//		HttpSession httpsession = request.getSession();
//		try {
//			XoahangStub xhstub=new XoahangStub();
//			Xoahang xh=new Xoahang();
//			xh.setId_cthoadon(id_chitiethoadon);
//			XoahangResponse res=xhstub.xoahang(xh);
//			response.sendRedirect("/luanvan_shop/cart.html");
//		} catch (Exception e) {
//			e.toString();
//		}
//		return mv;
//	}



}
