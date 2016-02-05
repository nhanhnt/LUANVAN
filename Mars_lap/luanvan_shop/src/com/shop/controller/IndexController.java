package com.shop.controller;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.services.DmchaStub;
import com.shop.services.DmchaStub.Getdmcha;
import com.shop.services.DmconStub;
import com.shop.services.DmconStub.Getdmcon;
import com.shop.services.HelloworldStub;
import com.shop.services.HelloworldStub.Helo;
import com.shop.services.HelloworldStub.HeloResponse;

@Controller
public class IndexController {

	@RequestMapping("/index.html")
	protected ModelAndView helloword(){
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("msg", "Hello World aaaaaa");
		
		try {
			
			DmchaStub dmcha=new DmchaStub();
			mv.addObject("listdmcha", dmcha.getdmcha(new Getdmcha()).get_return());
			
			
			DmconStub dmcon=new DmconStub();
			Getdmcon dmc=new Getdmcon();
			int madmcha=1;
			dmc.setDmcha(madmcha);
			mv.addObject("listdmcon", dmcon.getdmcon(dmc).get_return());
			
			HelloworldStub helostub=new HelloworldStub();
			Helo h=new Helo();
			h.setParam("Processing DEMO");
			HeloResponse response=helostub.helo(h);
			
			mv.addObject("msgservices", response.get_return());
			mv.addObject("madmcha", madmcha);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
}
