/*package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IAdmin;
import com.app.dao.IHome;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private IHome dao;

	public HomeController() {
		System.out.println("In Constructore of Home");
	}
	@GetMapping("/home")
	public String Home() {
		System.out.println("in home");
		return "/";
	}
	@GetMapping("/aboutUs")
	public String AboutUs() {
		System.out.println("in aboutUs");
		return "/home/aboutUs";
	}
	

}*/
