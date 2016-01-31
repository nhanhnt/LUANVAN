package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/welcome")
	protected ModelAndView helloword(){
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("msg", "Hello World aaaaaa");
		return mv;
	}

}
