package com.app.controller;

//import java.sql.Date;
import java.util.*;

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

import com.app.dao.IProvider;
import com.app.pojos.*;

@Controller
@RequestMapping("/provider")
public class ProviderController {

	@Autowired
	private IProvider dao;
	@Autowired
	private JavaMailSender sender;
	public ProviderController() {
		System.out.println("In Constructore of Provider");
	}
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/provider/login";
	}
	
	@PostMapping("/login") // @RequestMapping + method=post
	public String processLoginForm(@RequestParam String em, @RequestParam String pass, Model map,
			RedirectAttributes flashMap, HttpSession hs) {
		System.out.println("in process login form");
		// invoke dao's method for auth.
		try {
			Provider p = dao.auntheticateUser(em, pass);
			// valid login
			hs.setAttribute("provider_dtls", p);// till logout
			//flashMap.addFlashAttribute("mesg", "Login Successful");// till next request
			// chk role
		
			return "redirect:/provider/welcome";
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			map.addAttribute("mesg", "Invalid Login");
			// invalid login
			return "/provider/login";
		}

	}

	// request handling method for user logout
	
	  @GetMapping("/logout") 
	  public String userLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp)
	  {
		  System.out.println("in provider logout");
		  //copy session attr ---> model map
		  map.addAttribute("provider_dtls",hs.getAttribute("provider_dtls")); //set refresh hdr
		  resp.setHeader("refresh", "1;url="+request.getContextPath()); 
		  //discard session 
		  hs.invalidate();
		  return "/provider/logout";
	  }
	 
	@GetMapping("/welcome")
	public String welcome() {
		System.out.println("in welcome");
		return "/provider/welcome";
	}
	@GetMapping("/register")
	public String RegisterProvider(Provider p) {
		System.out.println("in register");
		return "/provider/register";
	}
	@PostMapping("/register")
	public String RegisterProvider( Provider p,HttpSession hs,Model map)
	{try {
		System.out.println(p+"-------------------------------------------------->");
		hs.setAttribute("regprov",dao.RegisterProvider(p));
		//flashMap.addFlashAttribute("registeredUser",dao.registeruser(u));
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(p.getEmail());
		mesg.setSubject("You have registered successfully on ShubhSanket");
		mesg.setText("Thanks for registration"+"\nEmail Id:"+p.getEmail()+"\n"+"pass:"+p.getPassword()+"\nI hope, you will enjoy the application and we will be business parteners for long period.\n----!! All The BEST !!---\nand\n Get ready for the SHUBHSANKET ;)");
		sender.send(mesg);
		return "redirect:/provider/login";}
	catch(Exception e)
	{
		map.addAttribute("mesg", "Registration failed, you might have registered before or try again");
	return "/provider/register";}
	}
	// request handling method for provider logout
/*		@GetMapping("/logout")
		public String providerLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) 
		{
			System.out.println("in user logout");
			//copy session attr ---> model map
			map.addAttribute("prov_dtls",hs.getAttribute("prov_dtls"));
			//set refresh hdr
			resp.setHeader("refresh", "5;url="+request.getContextPath());
			//discard session
			hs.invalidate();
			return "/index";
		}
*/
		@GetMapping("/details")
		public String Eventdetails()
	{
		System.out.println("in details");
		return "/provider/details";
	}
		@GetMapping("/forgot")
	public String forgotPassword()
	{
		System.out.println("in get Forgot Password");
		return "/provider/forgot";
	}
	@PostMapping("/forgot")
	public String forgotPassword(Model map,Provider p,
			RedirectAttributes flashMap,@RequestParam String email, @RequestParam String password,
			@RequestParam String cpass,HttpSession hs)
	{try {
		System.out.println(email+" ---"+password+"---"+cpass);
		if(password.equals(cpass) && password!="")
		{
		System.out.println("-------------if forgot------------------------------------->");
		hs.setAttribute("protresetpass",dao.resetpassword (p,email,password,cpass));
		map.addAttribute("mesg1", "Password successfully updated");
		//hs.setAttribute("mesg1", "Password successfully updated");
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(p.getEmail());
		mesg.setSubject("Your password updated successfully on ShubhSanket");
		mesg.setText("Please Login to set your next ShubhSanket ^-^"+"\nYour updated information is::"+"\nEmail Id:"+email+"\n"+"pass:"+password+"\nWe are happy to have you as a business partener ;)\n---------!!! Thank You !!!---------");
		sender.send(mesg);
		return "redirect:/provider/login";
		}
		
	else
		{
		System.out.println("-------------else forgot------------------------------------->");
		map.addAttribute("mesg", "Passwords are not matching or empty");
		return "/provider/forgot";
		}
		}
	catch(Exception e)
	{
		map.addAttribute("mesg", "Email Id is wrong");
		return "/customer/forgot";
	}
		
	}
	@GetMapping("/booking")
	public String bookingList(@RequestParam int pid, Model map,RedirectAttributes flashMap, HttpSession hs) 
	{
		try{
			List<Booking>b=dao.BookingList(pid);
			if(b.isEmpty())
			{
				map.addAttribute("mesg", "You don't have any Booking");
				return "/provider/welcome";
			}
		System.out.println("in get history"+" ------ ");
		hs.setAttribute("probooking",b );
		return "/provider/booking";}
		catch(Exception e)
		{
			map.addAttribute("mesg", "Error in Booking");
			return "/provider/welcome";	
		}
	}
	@GetMapping("/acceptbooking")
	public String acceptbooking(@RequestParam int cid,@RequestParam int pid,@RequestParam int sid,@RequestParam int bid, Model map,RedirectAttributes flashMap, HttpSession hs) 
	{try {
		System.out.println("in get history"+" ------ ");
		hs.setAttribute("acceptbooking", dao.acceptbooking(pid,sid,bid));
		Customer p=dao.acceptmail(cid);
		hs.setAttribute("acceptmail", p);
		System.out.println(p);
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(p.getEmail());
		mesg.setSubject("Your service accepted successfully on ShubhSanket");
		mesg.setText("Dear customer, "+p.getCname()+" your service is accepted by provider\nFor more information go to the ShubhSanket"+"\nThank You!!!" );
		sender.send(mesg);
		
		return "/provider/welcome";}
	catch(Exception e)
	{map.addAttribute("mesg", "Error in Accepting the booking");
		return "/provider/welcome";
	}
	}
	@GetMapping("/rejectbooking")
	public String rejectbooking(@RequestParam int pid,@RequestParam int cid,@RequestParam int sid,@RequestParam int bid, Model map,RedirectAttributes flashMap, HttpSession hs) 
	{try {
		System.out.println("in get history"+" ------ ");
		hs.setAttribute("rejectbooking", dao.rejectbooking(pid,sid,bid));
		Customer p=dao.rejectmail(cid);
		hs.setAttribute("rejectmail", p);
		System.out.println(p);
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(p.getEmail());
		mesg.setSubject("Your service request rejected on ShubhSanket");
		mesg.setText("Dear customer, "+p.getCname()+" your service is rejected by provider\nFor more information go to the ShubhSanket"+"\nThank You!!!" );
		sender.send(mesg);
		
		return "/provider/welcome";
	}
	catch(Exception e)
	{map.addAttribute("mesg", "Error in Rejecting the booking");
		return "/provider/welcome";
	}
	}
	
	@GetMapping("/providerservices")
	public String ProviderServices(@RequestParam int pid, Model map,RedirectAttributes flashMap, HttpSession hs) 
	{
		try 
		{
		List<Services>b=dao.ProviderServices(pid);
		if(b.isEmpty())
		{
			map.addAttribute("mesg", "You don't provide any service");
			return "/provider/welcome";
		}
		System.out.println("in get ProviderServices"+" ------ ");
		hs.setAttribute("ProviderServices", b);
		return "/provider/providerservices";
		}
	catch(Exception e)
	{
		map.addAttribute("mesg", "Error in providerservices");
		return "/provider/welcome";	
	}
	}
	@GetMapping("/deleteservice")
	public String deleteservice(@RequestParam int pid,@RequestParam int sid,Model map,RedirectAttributes flashMap, HttpSession hs)
	{
		System.out.println("in deleteservice");
		hs.setAttribute("deleteservice", dao.deleteservice(sid));
		return "/provider/welcome";
	}
	
	@GetMapping("/updateservice")
	public String updateservice(@RequestParam int pid,@RequestParam int sid,RedirectAttributes flashMap, HttpSession hs)
	{
		System.out.println("in get updateservice");
		return "/provider/updateservice";
	}
	
	/*@PostMapping("/updateservice")
	public String updateservice(Services s,@RequestParam int pid,@RequestParam int sid,Model map,RedirectAttributes flashMap, HttpSession hs)
	{try 
	{
		System.out.println(pid+" ---In Post Update Service---"+sid);
		hs.setAttribute("protresetpass",dao.updateservice (s,sid,pid));
		map.addAttribute("mesg1", "Service successfully updated");
		//hs.setAttribute("mesg1", "Password successfully updated");
		return "redirect:/provider/welcome";
		}
		
	catch(Exception e)
	{
		map.addAttribute("mesg", "Service updation failed");
		return "/provider/updateservice";
	}
	sid=${v.sid}&pid=${v.pid}&pname=${v.pname}&rate=${v.rate}&location=${v.location}&sname=${v.serviceType}	
	}*/
	
}
