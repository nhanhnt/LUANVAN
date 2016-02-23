package com.shop.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.services.DangkyStub;
import com.shop.services.DangkyStub.Registry;
import com.shop.services.DangkyStub.RegistryResponse;
import com.shop.services.DangnhapStub;
import com.shop.services.DangnhapStub.Login;
import com.shop.services.DangnhapStub.LoginResponse;
import com.shop.services.HelloworldStub.HeloResponse;
import com.shop.services.HoadonStub;
import com.shop.services.HoadonStub.Createdhoadon;
import com.shop.services.HoadonStub.CreatedhoadonResponse;
import com.shop.util.encrypt;

@Controller
public class AccountController {

	@RequestMapping(value = "/account.html", method = { RequestMethod.POST, RequestMethod.GET })
	protected ModelAndView account(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView("account");
		String taikhoan = request.getParameter("taikhoan");
		String email = request.getParameter("email");
		String matkhau = request.getParameter("matkhau");
		String tkdangnhap = request.getParameter("tkdangnhap");
		String mkdangnhap = request.getParameter("mkdangnhap");
		String action = request.getParameter("action");
		String account_display = request.getParameter("account_display");
		String cart_display = request.getParameter("cart_display");
		String hoadon_display = request.getParameter("hoadon_display");
		String error = "", errordn = "";
		HttpSession httpsession = request.getSession();
		httpsession.setAttribute("username", "Account");
		String username = (String) request.getAttribute("username");
		String logout_display;
		String id_user = (String) httpsession.getAttribute("id_user");
		String id_hoadon = (String) httpsession.getAttribute("id_hoadon");
		if(id_hoadon==null){
			id_hoadon="";
		}
		if(id_user==null){
			id_user="";
		}else{
			HoadonStub hoadonstb=new HoadonStub();
			Createdhoadon hd=new Createdhoadon();
			hd.setId_user(id_user);
			CreatedhoadonResponse hdrespones=hoadonstb.createdhoadon(hd);
			httpsession.setAttribute("id_hoadon", hdrespones.get_return());
		}
		mv.addObject("id_user", id_user);
		if (username == null || username.equals("Account")) {
			httpsession.setAttribute("username", "Account");
			logout_display = "none";
			cart_display = "return false;";
			account_display = "return false;";
			hoadon_display="return false;";
		} else {
			logout_display = "block";
			cart_display = "return false;";
			hoadon_display="return false;";
			account_display = "return false;";
		}
		try {
			if (action.equals("registry")) {
				if (taikhoan.equals("")) {
					error = "Vui lòng nhập tên tài khoản";
					return mv;

				} else if (email.equals("")) {
					error = "Vui lòng nhập email";
					return mv;
				} else if (matkhau.equals("")) {
					error = "Vui lòng nhập mật khẩu";
					return mv;
				}

				DangkyStub dkstub = new DangkyStub();
				Registry reg = new Registry();
				reg.setUsername(taikhoan);
				reg.setEmail(email);
				reg.setPassword(encrypt.Password(matkhau));
				RegistryResponse responsedk = dkstub.registry(reg);
				String kq = responsedk.get_return();
				if (kq.equals("1")) {
					// httpsession.setAttribute("taikhoanlogin", taikhoan);
					response.sendRedirect("/luanvan_shop/index.html");
				} else if (kq.equals("-1")) {
					error = "Tài khoản đã tồn tại";
				} else if (kq.equals("-2")) {
					error = "Email đã tồn tại";
				} else {
					error = "Lỗi hệ thống";
				}
			} else if (action.equals("login")) {
				if (tkdangnhap.equals("")) {
					errordn = "Vui lòng nhập tài khoản";
					return mv;

				} else if (mkdangnhap.equals("")) {
					errordn = "Vui lòng nhập mật khẩu";
					return mv;
				}
				DangnhapStub dnstub = new DangnhapStub();
				Login lg = new Login();
				lg.setUsername(tkdangnhap);
				lg.setPassword(encrypt.Password(mkdangnhap));
				LoginResponse reslg = dnstub.login(lg);
				String kqdn = reslg.get_return();
				if (!kqdn.equals("-1")) {
					httpsession.setAttribute("username", tkdangnhap);
					httpsession.setAttribute("id_user", kqdn);
					response.sendRedirect("/luanvan_shop/index.html");
				} else {
					errordn = "Tài khoản hoặc mật khẩu sai";
				}
			}

		} catch (Exception e) {
		} finally {
			// mv.addObject("taikhoan_err", taikhoan_err);
			// mv.addObject("email_err", email_err);
			// mv.addObject("matkhau_err", matkhau_err);
			mv.addObject("taikhoan", taikhoan);
			mv.addObject("email", email);
			mv.addObject("matkhau", matkhau);
			mv.addObject("error", error);
			mv.addObject("tkdangnhap", tkdangnhap);
			mv.addObject("errordn", errordn);
			mv.addObject("mkdangnhap", mkdangnhap);
			mv.addObject("logout_display", logout_display);
			mv.addObject("account_display", account_display);
			mv.addObject("cart_display", cart_display);
			mv.addObject("id_hoadon", id_hoadon);
			mv.addObject("hoadon_display", hoadon_display);
		}
		return mv;
	}

	@RequestMapping(value = "/account.html/{logout}")
	protected ModelAndView detail(@PathVariable("logout") String logout, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("account");
		HttpSession httpsession = request.getSession();
		try {
			Enumeration e = httpsession.getAttributeNames();
			while (e.hasMoreElements()) {
				httpsession.removeAttribute(e.nextElement().toString());
			}
			response.sendRedirect("/luanvan_shop/index.html");
		} catch (Exception e) {
			e.toString();
		}
		return mv;
	}
}
