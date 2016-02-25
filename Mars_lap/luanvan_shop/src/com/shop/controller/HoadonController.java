package com.shop.controller;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ftl.util.DateUtil;
import com.shop.services.CityStub;
import com.shop.services.DshoadonStub;
import com.shop.services.Km2CityStub;
import com.shop.services.MuahangStub;
import com.shop.services.CityStub.Getcity;
import com.shop.services.DshoadonStub.Dshoadon;
import com.shop.services.DshoadonStub.DshoadonResponse;
import com.shop.services.DshoadonStub.Dshoadon_countpage;
import com.shop.services.DshoadonStub.Dshoadon_countpageResponse;
import com.shop.services.Km2CityStub.Km2City;
import com.shop.services.Km2CityStub.Km2CityResponse;
import com.shop.services.MuahangStub.Getlistmh;
import com.shop.services.MuahangStub.Getlistmh_sum;


@Controller
public class HoadonController {
	@RequestMapping(value = "/hoadon.html")
	protected ModelAndView detail(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException, RemoteException {
		ModelAndView mv = new ModelAndView("hoadon");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession httpsession = request.getSession();
		String logout_display = request.getParameter("logout_display");
		String login_display = request.getParameter("login_display");
		String account_display = request.getParameter("account_display");
		String hoadon_display = request.getParameter("hoadon_display");
		String error = request.getParameter("error");
		String cart_display = request.getParameter("cart_display");
		String username = (String) httpsession.getAttribute("username");
		String id_user = (String) httpsession.getAttribute("id_user");
		String id_hoadon = (String) httpsession.getAttribute("id_hoadon");
		String page = request.getParameter("page");
		 int total = 0;
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
			if (page == null) {
                page = "1";
            }
			int pages = Integer.parseInt(page);
			logout_display = "block";
			account_display = "return false;";
			DshoadonStub dshdstub=new DshoadonStub();
			Dshoadon hd=new Dshoadon();
			hd.setId_user(Integer.parseInt(id_user));
			hd.setCount(1);
			hd.setPages(pages);
			DshoadonResponse res=dshdstub.dshoadon(hd);
			mv.addObject("listhoadon", res.get_return());
			
			Dshoadon_countpage ds_cou=new Dshoadon_countpage();
			ds_cou.setCount(1);
			ds_cou.setId_user(Integer.parseInt(id_user));
			ds_cou.setPages(pages);
			Dshoadon_countpageResponse re_count	=dshdstub.dshoadon_countpage(ds_cou);
			
            
            mv.addObject("pages", pages);
            total=re_count.get_return();
            mv.addObject("total", total);
			int start_page = pages - 1 > 0 ? pages - 1 : 1;
            int end_page = start_page < total ? (start_page == total - 1 ? start_page + 1 : start_page + 2) : start_page;
            mv.addObject("start", start_page);
            mv.addObject("end", end_page);
			
			System.out.println("Tong trang "+re_count.get_return());
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
		
		return mv;
	}
}
