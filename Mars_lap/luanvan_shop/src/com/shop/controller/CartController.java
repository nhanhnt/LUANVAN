package com.shop.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ftl.util.DateUtil;
import com.shop.services.CityStub;
import com.shop.services.CityStub.Getcity;
import com.shop.services.GiamslStub;
import com.shop.services.GiamslStub.Giamsl;
import com.shop.services.GiamslStub.GiamslResponse;
import com.shop.services.Km2CityStub;
import com.shop.services.Km2CityStub.Km2City;
import com.shop.services.Km2CityStub.Km2CityResponse;
import com.shop.services.MuahangStub;
import com.shop.services.MuahangStub.Getlistmh;
import com.shop.services.MuahangStub.Getlistmh_sum;
import com.shop.services.TangslStub;
import com.shop.services.TangslStub.Tangsl;
import com.shop.services.TangslStub.TangslResponse;
import com.shop.services.UpdatehoadonStub;
import com.shop.services.UpdatehoadonStub.Capnhathoadon;
import com.shop.services.UpdatehoadonStub.CapnhathoadonResponse;
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
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession httpsession = request.getSession();
		String action = request.getParameter("action");
		String logout_display = request.getParameter("logout_display");
		String login_display = request.getParameter("login_display");
		String account_display = request.getParameter("account_display");
		String tong_display = request.getParameter("tong_display");
		String hoadon_display = request.getParameter("hoadon_display");
		String ngaynhan = request.getParameter("ngaynhan");
		String error = request.getParameter("error");
		String cong = request.getParameter("cong");
		cong = "cong";
		String tru = request.getParameter("tru");
		tru = "tru";
		tong_display = "none";
		String cart_display = request.getParameter("cart_display");
		String username = (String) httpsession.getAttribute("username");
		String id_user = (String) httpsession.getAttribute("id_user");
		String id_hoadon = (String) httpsession.getAttribute("id_hoadon");
		String phuongthucthanhtoan = request.getParameter("phuongthucthanhtoan");
		String diachigiaohang = request.getParameter("diachigiaohang");
		String city = request.getParameter("city");
		String phiship = request.getParameter("phiship");
		String pship="";
		String dcgh = request.getParameter("dcgh");
		if (dcgh == null) {
			dcgh = "GIA TRI RONG";
		}
		String tongtien = "0";
		String tpgh = "", ptthh = "", ngayghh = "", psh = "";
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
			hoadon_display="return false;";
		} else {
			logout_display = "block";
			account_display = "return false;";
			try {
				MuahangStub muahangstub = new MuahangStub();
				Getlistmh getlistmh = new Getlistmh();
				getlistmh.setId_hoadon(Integer.parseInt(id_hoadon));
				mv.addObject("listmuahang", muahangstub.getlistmh(getlistmh).get_return());

				DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				date = DateUtil.addDay(date, 3);
				ngaynhan = dateformat.format(date);

				CityStub citystub = new CityStub();
				Getcity ct = new Getcity();
				mv.addObject("listcity", citystub.getcity(ct).get_return());

				phiship = request.getParameter("phiship");

				NumberFormat nf = NumberFormat.getInstance();
				nf.setMinimumIntegerDigits(0);
				// Lấy về phí ship
				Km2CityStub kmstub = new Km2CityStub();
				Km2City km2 = new Km2City();
				km2.setTp1("TP Huế");
				km2.setTp2(city);
				Km2CityResponse kmres = kmstub.km2City(km2);
				
				phiship = kmres.get_return();
				pship=nf.format(Math.round(Integer.parseInt(kmres.get_return().toString())));
				Getlistmh_sum s = new Getlistmh_sum();
				s.setId_hoadon(Integer.parseInt(id_hoadon));
				double tongt = muahangstub.getlistmh_sum(s).get_return()
						+ Double.parseDouble(kmres.get_return().toString());
				tongtien = Double.toString(tongt);
				// tongtien =
				// nf.format(Math.round(muahangstub.getlistmh_sum(s).get_return()));
				tongtien = nf.format(Math.round(Double.parseDouble(tongtien)));

				try {
					if (action.equals("thanhtien")) {

						if (phuongthucthanhtoan.equals("") || diachigiaohang.equals("")) {
							tong_display = "none";
							error = "Chưa nhập đủ dữ liệu";
						} else {
							tong_display = "block";
							httpsession.setAttribute("diachigiaohang", diachigiaohang);
							httpsession.setAttribute("city", city);
							httpsession.setAttribute("phuongthucthanhtoan", phuongthucthanhtoan);
							httpsession.setAttribute("ngaynhan", ngaynhan);
							httpsession.setAttribute("phiship", phiship);
						}
					}
					if (action.equals("thanhtoan")) {

						dcgh = (String) httpsession.getAttribute(diachigiaohang);
						tpgh = (String) httpsession.getAttribute(city);
						ptthh = (String) httpsession.getAttribute(phuongthucthanhtoan);
						ngayghh = (String) httpsession.getAttribute(ngaynhan);
						psh = (String) httpsession.getAttribute(phiship);

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
		mv.addObject("hoadon_display", hoadon_display);
		mv.addObject("tpgh", tpgh);
		mv.addObject("ptthh", ptthh);
		mv.addObject("ngayghh", ngayghh);
		mv.addObject("psh", psh);
		mv.addObject("pship", pship);
		return mv;
	}

	@RequestMapping(value = "/cart.html/{id_chitiethoadon}")
	protected ModelAndView detail(@PathVariable("id_chitiethoadon") String id_chitiethoadon, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("cart");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		HttpSession httpsession = request.getSession();
		try {
			XoahangStub xhstub = new XoahangStub();
			Xoahang xh = new Xoahang();
			xh.setId_cthoadon(id_chitiethoadon);
			XoahangResponse res = xhstub.xoahang(xh);
			response.sendRedirect("/luanvan_shop/cart.html");
		} catch (Exception e) {
			e.toString();
		}
		return mv;
	}

	@RequestMapping(value = "/cart.html/cong/{id_chitiethoadon}")
	protected ModelAndView detail211(@PathVariable("id_chitiethoadon") String id_chitiethoadon,
			HttpServletRequest request, HttpServletResponse response) throws AxisFault {
		ModelAndView mv = new ModelAndView("cart");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		try {
			TangslStub tangstub = new TangslStub();
			Tangsl tang = new Tangsl();
			tang.setId_cthoadon(id_chitiethoadon);
			TangslResponse res = tangstub.tangsl(tang);
			response.sendRedirect("/luanvan_shop/cart.html");

		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

		} catch (Exception e) {
			e.toString();
		}
		return mv;
	}

	@RequestMapping(value = "/cart.html/tru/{id_chitiethoadon}")
	protected ModelAndView detail2111(@PathVariable("id_chitiethoadon") String id_chitiethoadon,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView("cart");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			GiamslStub giamstub = new GiamslStub();
			Giamsl giam = new Giamsl();
			giam.setId_cthoadon(id_chitiethoadon);
			GiamslResponse res = giamstub.giamsl(giam);
			response.sendRedirect("/luanvan_shop/cart.html");

		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

		} catch (Exception e) {
			e.toString();
		}
		return mv;
	}

	@RequestMapping(value = "/cart.html/{idhd}/{dcgh}/{tp}/{ptth}/{ngiao}/{pship}")
	protected ModelAndView detail21111(@PathVariable("idhd") String idhd, @PathVariable("dcgh") String dcgh,
			@PathVariable("tp") String tp, @PathVariable("ptth") String ptth, @PathVariable("ngiao") String ngiao,
			@PathVariable("pship") String pship, HttpServletRequest request, HttpServletResponse response)
					throws IOException {
		ModelAndView mv = new ModelAndView("cart");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		UpdatehoadonStub upstub = new UpdatehoadonStub();
		Capnhathoadon cp = new Capnhathoadon();
		cp.setId_hoadon(idhd);
		cp.setDiachi(dcgh);
		cp.setTp(tp);
		cp.setPhuongthuc(ptth);
		cp.setNgaygiao(ngiao);
		cp.setPhiship(pship);
		CapnhathoadonResponse cnhdres = upstub.capnhathoadon(cp);
		if (cnhdres.get_return().toString().equals("1")) {
			response.sendRedirect("/luanvan_shop/index.html");
		} else {
			response.sendRedirect("/luanvan_shop/cart.html");
		}

		return mv;
	}

}
