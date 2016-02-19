package com.shop.controller;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.services.CthoadonStub;
import com.shop.services.CthoadonStub.Muahang;
import com.shop.services.CthoadonStub.MuahangResponse;
import com.shop.services.DmchaStub;
import com.shop.services.DmchaStub.Getdmcha;
import com.shop.services.DmconStub;
import com.shop.services.DmconStub.Getdmcon;
import com.shop.services.HelloworldStub;
import com.shop.services.HoadonStub;
import com.shop.services.HelloworldStub.Helo;
import com.shop.services.HelloworldStub.HeloResponse;
import com.shop.services.HoadonStub.Createdhoadon;
import com.shop.services.HoadonStub.CreatedhoadonResponse;
import com.shop.services.SanphamctStub;
import com.shop.services.SanphamctStub.Getspct;
import com.shop.services.SanphamctStub.GetspctResponse;

@Controller
public class IndexController {

	@RequestMapping(value = "/index.html")
	protected ModelAndView helloword(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("msg", "Hello World aaaaaa");
		HttpSession httpsession = request.getSession();
		String logout_display = request.getParameter("logout_display");
		String login_display = request.getParameter("login_display");
		String account_display = request.getParameter("account_display");
		String cart_display = request.getParameter("cart_display");
		String username = (String) httpsession.getAttribute("username");
		String id_user = (String) httpsession.getAttribute("id_user");
		String id_hoadon = (String) httpsession.getAttribute("id_hoadon");
		if (id_hoadon == null) {
			id_hoadon = "";
		}
		if (id_user == null) {
			id_user = "";
		} else {
			HoadonStub hoadonstb;
			try {
				hoadonstb = new HoadonStub();
				Createdhoadon hd = new Createdhoadon();
				hd.setId_user(id_user);
				CreatedhoadonResponse hdrespones = hoadonstb.createdhoadon(hd);
				httpsession.setAttribute("id_hoadon", hdrespones.get_return());
			} catch (AxisFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
		}
		if (logout_display.equals("none")) {
			login_display = "block";
		} else {
			login_display = "none";
		}

		// try {
		//
		// DmchaStub dmcha = new DmchaStub();
		// mv.addObject("listdmcha", dmcha.getdmcha(new
		// Getdmcha()).get_return());
		//
		// DmconStub dmcon = new DmconStub();
		// Getdmcon dmc = new Getdmcon();
		// int madmcha = 1;
		// dmc.setDmcha(madmcha);
		// mv.addObject("listdmcon", dmcon.getdmcon(dmc).get_return());
		//
		// HelloworldStub helostub = new HelloworldStub();
		// Helo h = new Helo();
		// h.setParam("Processing DEMO");
		// HeloResponse response = helostub.helo(h);
		//
		// mv.addObject("msgservices", response.get_return());
		// mv.addObject("madmcha", madmcha);
		// } catch (AxisFault e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (RemoteException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		mv.addObject("logout_display", logout_display);
		mv.addObject("login_display", login_display);
		mv.addObject("account_display", account_display);
		mv.addObject("cart_display", cart_display);
		mv.addObject("id_hoadon", id_hoadon);

		return mv;
	}
//	@RequestMapping(value = "/index.html/{id_sp}")
//	protected ModelAndView detail(@PathVariable("id_sp") String id_sp, HttpServletRequest request,
//			HttpServletResponse response) {
//
//		ModelAndView mv = new ModelAndView("index");
//		mv.addObject("msg", "Hello World aaaaaa");
//		HttpSession httpsession = request.getSession();
//		String logout_display = request.getParameter("logout_display");
//		String login_display = request.getParameter("login_display");
//		String account_display = request.getParameter("account_display");
//		String cart_display = request.getParameter("cart_display");
//		String username = (String) httpsession.getAttribute("username");
//		String id_user = (String) httpsession.getAttribute("id_user");
//		String id_hoadon = (String) httpsession.getAttribute("id_hoadon");
//		if (id_hoadon == null) {
//			id_hoadon = "";
//		}
//		if (id_user == null) {
//			id_user = "";
//
//		}
//		mv.addObject("id_user", id_user);
//		if (username == null || username.equals("Account")) {
//			httpsession.setAttribute("username", "Account");
//			logout_display = "none";
//			cart_display = "return false;";
//			account_display = "return false;";
//			try {
//				Enumeration e = httpsession.getAttributeNames();
//				while (e.hasMoreElements()) {
//					httpsession.removeAttribute(e.nextElement().toString());
//				}
//				response.sendRedirect("/luanvan_shop/account.html");
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		} else {
//			logout_display = "block";
//			account_display = "return false;";
//			try {
//				CthoadonStub cthoadonstub = new CthoadonStub();
//				Muahang muahang = new Muahang();
//				muahang.setId_hoadon(id_hoadon);
//				muahang.setId_sanpham(id_sp);
//				muahang.setSoluong(soluong);
//				muahang.setDongia(dongia);
//				muahang.setGiamgia(giamgia);
//				MuahangResponse mhresponse = cthoadonstub.muahang(muahang);
//			} catch (AxisFault e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//		if (logout_display.equals("none")) {
//			login_display = "block";
//		} else {
//			login_display = "none";
//		}
//
//		mv.addObject("logout_display", logout_display);
//		mv.addObject("login_display", login_display);
//		mv.addObject("account_display", account_display);
//		mv.addObject("cart_display", cart_display);
//		mv.addObject("id_hoadon", id_hoadon);
//
//		return mv;
//	}
	@RequestMapping(value = "/index.html/{id_sp}/{soluong}/{dongia}/{giamgia}")
	protected ModelAndView detail(@PathVariable("id_sp") String id_sp, @PathVariable("soluong") String soluong,
			@PathVariable("dongia") String dongia, @PathVariable("giamgia") String giamgia, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("msg", "Hello World aaaaaa");
		HttpSession httpsession = request.getSession();
		String logout_display = request.getParameter("logout_display");
		String login_display = request.getParameter("login_display");
		String account_display = request.getParameter("account_display");
		String cart_display = request.getParameter("cart_display");
		String iddm = request.getParameter("iddm");
		String username = (String) httpsession.getAttribute("username");
		String id_user = (String) httpsession.getAttribute("id_user");
		String id_hoadon = (String) httpsession.getAttribute("id_hoadon");
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
			try {
				Enumeration e = httpsession.getAttributeNames();
				while (e.hasMoreElements()) {
					httpsession.removeAttribute(e.nextElement().toString());
				}
				response.sendRedirect("/luanvan_shop/account.html");
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			logout_display = "block";
			account_display = "return false;";
			try {
				CthoadonStub cthoadonstub = new CthoadonStub();
				Muahang muahang = new Muahang();
				muahang.setId_hoadon(id_hoadon);
				muahang.setId_sanpham(id_sp);
				muahang.setSoluong(soluong);
				muahang.setDongia(dongia);
				muahang.setGiamgia(giamgia);
				MuahangResponse mhresponse = cthoadonstub.muahang(muahang);
				httpsession.setAttribute("idchitiethoadon", mhresponse.get_return());
				if(mhresponse.get_return().equals("-2") || mhresponse.get_return().equals("-1")){
					
				}else{
					response.sendRedirect("/luanvan_shop/cart.html");
				}
			} catch (AxisFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		mv.addObject("id_hoadon", id_hoadon);

		return mv;
	}

	
}
