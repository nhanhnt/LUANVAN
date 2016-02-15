package com.shop.controller;

import java.rmi.RemoteException;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.services.DmchaStub;
import com.shop.services.DmchaStub.Getdmcha;
import com.shop.services.DmconStub;
import com.shop.services.DmconStub.Getdmcon;
import com.shop.services.HelloworldStub;
import com.shop.services.HelloworldStub.Helo;
import com.shop.services.HelloworldStub.HeloResponse;
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
		String username = (String) httpsession.getAttribute("username");
		if (username == null || username.equals("Account")) {
			httpsession.setAttribute("username", "Account");
			logout_display = "none";
		} else {
			logout_display = "block";
			account_display="return false;";
		}
		if (logout_display.equals("none")){
			login_display= "block";
		}else{
			login_display= "none";
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
		return mv;
	}

	// @RequestMapping(value="/detail.html/{idsp}")
	// protected ModelAndView detail(@PathVariable("idsp") String idsp) {
	// ModelAndView mv = new ModelAndView("detail");
	// String hinhanh = "";
	// String tensanpham = "";
	// String gia = "";
	// String soluong = "";
	// String giamgia = "";
	// String chitiet = "";
	// try {
	// SanphamctStub spstub = new SanphamctStub();
	// Getspct sp = new Getspct();
	// NumberFormat nf = NumberFormat.getInstance();
	// nf.setMinimumIntegerDigits(0);
	// sp.setId_sp(Integer.parseInt("1"));
	// GetspctResponse ress = spstub.getspct(sp);
	// for (int i = 0; i < ress.get_return().length; i++) {
	// hinhanh = ress.get_return()[i].getHinhanh();
	// tensanpham = ress.get_return()[i].getTensanpham();
	// gia = nf.format(Math.round(ress.get_return()[i].getDongia()));
	// soluong = Integer.toString(ress.get_return()[i].getSoluong());
	// giamgia = Integer.toString(ress.get_return()[i].getGiamgia());
	// chitiet = ress.get_return()[i].getMota();
	//
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// mv.addObject("msg", "11111111111111111111111");
	// mv.addObject("idsp", idsp);
	// mv.addObject("hinhanh", hinhanh);
	// mv.addObject("tensanpham", tensanpham);
	// mv.addObject("gia", gia);
	// mv.addObject("soluong", soluong);
	// mv.addObject("giamgia", giamgia);
	// mv.addObject("chitiet", chitiet);
	//
	// return mv;
	// }

}
