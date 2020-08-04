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

import com.app.dao.IAdmin;
import com.app.pojos.Admin;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdmin dao;

	public AdminController() {
		System.out.println("In Constructore of Admin");
	}
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/admin/login";
	}
	
	@PostMapping("/login") // @RequestMapping + method=post
	public String processLoginForm(@RequestParam String nm, @RequestParam String pass, Model map,
			RedirectAttributes flashMap, HttpSession hs) {
		System.out.println("in process login form");
		// invoke dao's method for auth.
		try {
			Admin a = dao.auntheticateUser(nm, pass);
			// valid login
			hs.setAttribute("admin_dtls", a);// till logout
			flashMap.addFlashAttribute("mesg", "Login Successful");// till next request
			// chk role
		
			return "redirect:/admin/welcome";
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			map.addAttribute("mesg", "Invalid Login");
			// invalid login
			return "/admin/login";
		}

	}

	// request handling method for user logout
	@GetMapping("/logout")
	public String adminLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) {
		System.out.println("in admin logout");
		//copy session attr ---> model map
		map.addAttribute("a_dtls",hs.getAttribute("admin_dtls"));
		//set refresh hdr
		resp.setHeader("refresh", "5;url="+request.getContextPath());
		//discard session
		hs.invalidate();
		return "/admin/logout";
	}
	@GetMapping("/welcome")
	public String welcome() {
		System.out.println("in welcome");
		return "/admin/welcome";
	}
	@GetMapping("/register")
	public String register() {
		System.out.println("in register");
		return "/admin/register";
	}
	@GetMapping("/providerList")
	public String ProviderList(Model map,RedirectAttributes flashMap, HttpSession hs) 
	{
		System.out.println("in get providerlist");
		map.addAttribute("ProviderList", dao.ProviderList());
		return "/admin/providerList";
	}
	
	@GetMapping("/providerServices")
	public String ProviderServiceList(Model map,RedirectAttributes flashMap, HttpSession hs) 
	{
		System.out.println("in get ProviderServiceList");
		map.addAttribute("ProviderServiceList", dao.ProviderServiceList());
		return "/admin/providerServices";
	}
	@GetMapping("/customerList")
	public String customerList(Model map,RedirectAttributes flashMap, HttpSession hs) 
	{
		System.out.println("in get customerList");
		map.addAttribute("customerList", dao.customerList());
		return "/admin/customerList";
	}
	@GetMapping("/bookingList")
	public String bookingList(Model map,RedirectAttributes flashMap, HttpSession hs) 
	{
		System.out.println("in get bookList");
		map.addAttribute("bookingList", dao.bookingList());
		return "/admin/bookingList";
	}
	@GetMapping("/aboutUs")
	public String aboutUs() {
		System.out.println("in aboutUs");
		return "/admin/aboutUs";
	}
	@GetMapping("/services")
	public String services() {
		System.out.println("in services");
		return "/admin/services";
	}
	@GetMapping("/photogallery")
	public String photogallery() {
		System.out.println("in photogallery");
		return "/admin/photoGallery";
	}
	@GetMapping("/contact")
	public String contact() {
		System.out.println("in contact");
		return "/admin/contact";
	}
	@GetMapping("/deletecustomer")
	public String deletecustomer(@RequestParam String email,@RequestParam int cid,Model map,RedirectAttributes flashMap, HttpSession hs)
	{
		System.out.println("in contact");
		hs.setAttribute("deletecustomer", dao.deletecustomer(email,cid));
		return "/admin/welcome";
	}
	@GetMapping("/providerdelete")
	public String providerdelete(@RequestParam int pid,Model map,RedirectAttributes flashMap, HttpSession hs)
	{
		System.out.println("in providerdelete  "+pid);
		hs.setAttribute("deletecustomer", dao.providerdelete(pid));
		return "/admin/welcome";
	}
	
	@GetMapping("/deleteservice")
	public String deleteservice(@RequestParam int pid,@RequestParam int sid,Model map,RedirectAttributes flashMap, HttpSession hs)
	{
		System.out.println("in deleteservice");
		hs.setAttribute("deleteservice", dao.deleteservice(sid));
		return "/admin/welcome";
	}
	@GetMapping("/bookingdelete")
	public String bookingdelete(@RequestParam int bid,Model map,RedirectAttributes flashMap, HttpSession hs)
	{
		System.out.println("in contact");
		hs.setAttribute("bookingdelete", dao.bookingdelete(bid));
		return "/admin/welcome";
	}
	
	@GetMapping("/verifyservice")
	public String verifyservice(@RequestParam int sid,Model map,RedirectAttributes flashMap, HttpSession hs)
	{
		System.out.println("in verification");
		hs.setAttribute("verifyservice", dao.verifyservice(sid));
		return "/admin/welcome";
	}
	
}
