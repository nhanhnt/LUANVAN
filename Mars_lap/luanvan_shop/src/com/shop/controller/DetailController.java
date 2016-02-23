package com.shop.controller;

import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.services.CthoadonStub;
import com.shop.services.SanphamctStub;
import com.shop.services.CthoadonStub.Muahang;
import com.shop.services.CthoadonStub.MuahangResponse;
import com.shop.services.SanphamctStub.Getspct;
import com.shop.services.SanphamctStub.GetspctResponse;

@Controller
public class DetailController {
	@RequestMapping(value = "/detail.html/{idsp}")
	protected ModelAndView detail(@PathVariable("idsp") String idsp, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView("detail");
		String hinhanh = "";
		String tensanpham = "";
		String gia = "";
		String dongia = "";
		String soluong = "";
		String giamgia = "";
		String chitiet = "";
		HttpSession httpsession = request.getSession();
		String logout_display = request.getParameter("logout_display");
		String login_display = request.getParameter("login_display");
		String account_display = request.getParameter("account_display");
		String cart_display = request.getParameter("cart_display");
		String hoadon_display = request.getParameter("hoadon_display");
		String username = (String) httpsession.getAttribute("username");
		String id_user = (String) httpsession.getAttribute("id_user");
		String action = request.getParameter("action");
		String id_hoadon = (String) httpsession.getAttribute("id_hoadon");
		if (id_user == null) {
			id_user = "";
		}
		mv.addObject("id_user", id_user);
		if (username == null || username.equals("Account")) {
			httpsession.setAttribute("username", "Account");
			logout_display = "none";
			cart_display = "return false;";
			account_display = "return false;";
			hoadon_display="return false;";
			if (action.equals("themhang")) {
				response.sendRedirect("/luanvan_shop/account.html");
			}
		} else {
			logout_display = "block";
			account_display = "return false;";
		}
		if (logout_display.equals("none")) {
			login_display = "block";
		} else {
			login_display = "none";
		}
		try {
			SanphamctStub spstub = new SanphamctStub();
			Getspct sp = new Getspct();
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMinimumIntegerDigits(0);
			sp.setId_sp(Integer.parseInt(idsp));
			GetspctResponse ress = spstub.getspct(sp);
			for (int i = 0; i < ress.get_return().length; i++) {
				hinhanh = ress.get_return()[i].getHinhanh();
				tensanpham = ress.get_return()[i].getTensanpham();
				gia = nf.format(Math.round(ress.get_return()[i].getDongia()));
				soluong = Integer.toString(ress.get_return()[i].getSoluong());
				giamgia = Integer.toString(ress.get_return()[i].getGiamgia());
				chitiet = ress.get_return()[i].getMota();
				dongia = Double.toString(ress.get_return()[i].getDongia());

			}
			if (action.equals("themhang")) {
				CthoadonStub cthoadonstub = new CthoadonStub();
				Muahang muahang = new Muahang();
				muahang.setId_hoadon(id_hoadon);
				muahang.setId_sanpham(idsp);
				muahang.setSoluong(soluong);
				muahang.setDongia(dongia);
				muahang.setGiamgia(giamgia);
				MuahangResponse mhresponse = cthoadonstub.muahang(muahang);
				httpsession.setAttribute("idchitiethoadon", mhresponse.get_return());
				if (mhresponse.get_return().equals("-2") || mhresponse.get_return().equals("-1")) {

				} else {
					response.sendRedirect("/luanvan_shop/cart.html");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		mv.addObject("msg", "11111111111111111111111");
		mv.addObject("idsp", idsp);
		mv.addObject("hinhanh", hinhanh);
		mv.addObject("tensanpham", tensanpham);
		mv.addObject("gia", gia);
		mv.addObject("soluong", soluong);
		mv.addObject("giamgia", giamgia);
		mv.addObject("chitiet", chitiet);
		mv.addObject("logout_display", logout_display);
		mv.addObject("login_display", login_display);
		mv.addObject("account_display", account_display);
		mv.addObject("cart_display", cart_display);
		return mv;
	}
}
