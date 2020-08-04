 package com.app.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.app.dao.ICustomer;
import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Services;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	private ICustomer dao;
	@Autowired
	private JavaMailSender sender;

	public CustomerController() {
		System.out.println("In Constructore of Customer");
	}
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/customer/login";
	}
	
	@PostMapping("/login") // @RequestMapping + method=post
	public String processLoginForm(@RequestParam String em, @RequestParam String pass, Model map,
			RedirectAttributes flashMap, HttpSession hs) {
		System.out.println("in process login form");
		// invoke dao's method for auth.
		try {
			Customer c = dao.auntheticateUser(em, pass);
			// valid login
			hs.setAttribute("customer_dtls", c);// till logout
			//flashMap.addFlashAttribute("mesg", "Login Successful");// till next request
			// chk role
		
			return "redirect:/customer/welcome";
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			map.addAttribute("mesg", "Invalid Login");
			// invalid login
			return "/customer/login";
		}

	}

	// request handling method for user logout
	@GetMapping("/logout")
	public String customerLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) {
		System.out.println("in customer logout");
		//copy session attr ---> model map
		map.addAttribute("customer_dtls",hs.getAttribute("customer_dtls"));
		//set refresh hdr
		resp.setHeader("refresh", "5;url="+request.getContextPath());
		//discard session
		hs.invalidate();
		return "/customer/logout";
	}
	@GetMapping("/welcome")
	public String welcome() {
		System.out.println("in welcome");
		return "/customer/welcome";
	}
	@GetMapping("/register")
	public String RegisterCustomer(Customer c) {
		System.out.println("in customer register controller");
		return "/customer/register";
	}
	@PostMapping("/register")
	public String RegisterCustomer( Customer c,HttpSession hs,Model map)
	{
		try
		{
		System.out.println(c+"-------------------------------------------------->");
		hs.setAttribute("regcust",dao.RegisterCustomer(c));
		//flashMap.addFlashAttribute("registeredUser",dao.registeruser(u));
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(c.getEmail());
		mesg.setSubject("You have registered successfully on ShubhSanket");
		mesg.setText("Thanks for registration"+"\nEmail Id:"+c.getEmail()+"\n"+"pass:"+c.getPassword()+"\nWe are eagerly waiting for your SHUBHSANKET ;)");
		sender.send(mesg);
		return "redirect:/customer/login";
		}
		catch(Exception e)
		{
			map.addAttribute("mesg", "Registration failed you might have registered before or try again");
			return "/customer/register";
		}
	}
	@GetMapping("/searchservice")
	public String SearchServices(RedirectAttributes flashMap,Services s,HttpSession hs,Model map) {
		System.out.println("in get searchservice");
		try {
			List<String>a=dao.placelist(s);
			List<String>b=dao.servicelist(s);
			System.out.println("service location list"+a.isEmpty());
			
		if(!a.isEmpty())
		{
		hs.setAttribute("placeselectionlist",a);
		
		}
		if(!b.isEmpty())
		{
		hs.setAttribute("serviceselectionlist",b);
		
		}
	
	
		return "/customer/searchservice";
		}
		catch(Exception e) {
			flashMap.addFlashAttribute("mesg","Right now service is not available on any location");
		return"redirect:/customer/welcome";
		}
	}
	@PostMapping("/searchservice")
	public String SearchServices( Services s, Model map,
			RedirectAttributes flashMap, HttpSession hs)
	{System.out.println(s);
		try {
		System.out.println("-------------------------------------------------->");
		List <Services> p=dao.SearchServices (s.getLocation(),s.getServiceType());
		if(p.isEmpty())
		{
			map.addAttribute("mesg", "No search found for selected service at selected location");
			return "/customer/searchservice";
		}
		hs.setAttribute("searchserv",p);
		//map.addAttribute("searchserv",dao.SearchServices (location,serviceType));
		//flashMap.addFlashAttribute("registeredUser",dao.registeruser(u));
		//return "redirect:/customer/bookservice";
		return "/customer/bookservice";}
	catch(Exception e)
	{
		map.addAttribute("mesg", "Search Service Failed");
		return "/customer/searchservice";
	}
	}
	@GetMapping("/bookservice")
	public String bookservice() {
		System.out.println("in get searchservice");
		return "/customer/bookservice";
	
	}
	@GetMapping("/history")
	public String bookingList(@RequestParam int cid, Model map,RedirectAttributes flashMap, HttpSession hs) 
	{
		try 
		{
		List<Booking>b=dao.history(cid);
		if(b.isEmpty())
		{
			map.addAttribute("mesg", "You don't have any history");
			return "/customer/welcome";
		}
		System.out.println("in get history"+" ------ ");
		hs.setAttribute("history", b);
		return "/customer/history";
		}
	catch(Exception e)
	{
		map.addAttribute("mesg", "Error in History");
		return "/customer/welcome";	
	}
	}
	/*@GetMapping("/history")
	public String bookingList(Model map,RedirectAttributes flashMap, HttpSession hs) 
	{
		System.out.println("in get history");
		map.addAttribute("bookingList", dao.history());
		return "/customer/welcome";
	}*/
	
	/* @GetMapping("/book") 
	  public String bookservice(@RequestParam int sid,@RequestParam int pid,@RequestParam String pname,HttpSession hs, Model Map) {
	  System.out.println("in book " + sid+" "+pid+" "+pname);
	  hs.setAttribute("temp_sid", sid);
	  hs.setAttribute("temp_pid", pid);
	  hs.setAttribute("temp_pname", pname);
	  //Map.addAttribute("trainer", dao.bookservice(sid));
	  	  return "/booking/booking";
	  }
	  
	  @PostMapping("/book") 
	  public String updateTrainerDetails(Booking b, Model Map) {
	  System.out.println(b);
	  Map.addAttribute("msg",dao.book(b));
	  return "/customer/welcome";
	  }*/
	@GetMapping("/forgot")
	public String forgotPassword()
	{
		System.out.println("in get Forgot Password");
		return "/customer/forgot";
	}
	@PostMapping("/forgot")
	public String forgotPassword(Model map,Customer c,
			RedirectAttributes flashMap,@RequestParam String email, @RequestParam String password,
			@RequestParam String cpass,HttpSession hs)
	{
		try {
		System.out.println(email+" ---"+password+"---"+cpass);
		if(password.equals(cpass) && password!="")
		{
		System.out.println("-------------if forgot------"+dao.resetpassword (c,email,password,cpass)+"------------------------------->");
		hs.setAttribute("custresetpass",dao.resetpassword (c,email,password,cpass));
		
		map.addAttribute("mesg1", "Password successfully updated");
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(c.getEmail());
		mesg.setSubject("Your password updated successfully on ShubhSanket");
		mesg.setText("Please Login to set your next ShubhSanket ^-^"+"\nYour updated information is::"+"\nEmail Id:"+email+"\n"+"pass:"+password+"\nWe are eagerly waiting for your SHUBHSANKET ;)\n---------!!! Thank You !!!---------");
		sender.send(mesg);
		//hs.setAttribute("mesg1", "Password successfully updated");
		return "redirect:/customer/login";
		}
	else {
		System.out.println("-------------else forgot------------------------------------->");
		map.addAttribute("mesg", "Passwords are not matching or empty");
		return "/customer/forgot";
	}
	}
		catch(Exception e)
		{
			map.addAttribute("mesg", "Email Id is wrong");
			return "/customer/forgot";
		}
	}
}
