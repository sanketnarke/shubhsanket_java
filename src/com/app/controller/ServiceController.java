package com.app.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IService;
import com.app.pojos.Services;


@Controller
@RequestMapping("/provider")

public class ServiceController {
	@Autowired
	private IService dao;
	
	@GetMapping("/addservice")
	public String AddServices(Services s) {
		System.out.println("in get addservice");
		return "/provider/addservice";
	}
	@PostMapping("/addservice")
	public String AddServices( Services s,HttpSession hs)
	{
		System.out.println(s+"-------------------------------------------------->");
		hs.setAttribute("addserv",dao.AddServices (s));
		//flashMap.addFlashAttribute("registeredUser",dao.registeruser(u));
		return "redirect:/provider/welcome";
	}

}
