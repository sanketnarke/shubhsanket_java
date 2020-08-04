package com.app.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dao.IBooking;
import com.app.pojos.Booking;
import com.app.pojos.Provider;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/booking")

public class BookingController {
	@Autowired
	private IBooking dao;
	
	@Autowired
	private JavaMailSender sender;

	public BookingController() {
		System.out.println("In Constructore of BookService");
	}
	@GetMapping("/booking") 
	  public String bookservice(@RequestParam int sid,@RequestParam int pid,@RequestParam String pname,@RequestParam String serviceType,
			  @RequestParam Float rate,HttpSession hs, Model Map) {
	  System.out.println("in book " + sid+" "+pid+" "+pname);
	  hs.setAttribute("temp_sid", sid);
	  hs.setAttribute("temp_pid", pid);
	  hs.setAttribute("temp_pname", pname);
	  hs.setAttribute("temp_service", serviceType);
	  hs.setAttribute("temp_rate", rate);
	  //Map.addAttribute("trainer", dao.bookservice(sid));
	  	  return "/booking/booking";
	  }
	@PostMapping("/booking") 
	  public String updateTrainerDetails(RedirectAttributes flashMap,Booking b, Model Map,HttpSession hs) {
	  System.out.println(b);  
	  flashMap.addFlashAttribute("msg",dao.booking(b));
	  Provider p=dao.sentmail(b);
	  hs.setAttribute("providermail",p);
	  SimpleMailMessage mesg=new SimpleMailMessage();
	  mesg.setTo(p.getEmail());
	  mesg.setSubject("You have received one booking on ShubhSanket");
	  mesg.setText("\nBooking details are:"+"\nName of Customer: "+b.getCname()+"\n"+"Service: "+b.getService()+"\nDate of Booking: "+b.getDate()+
	  		"\nService Status: "+b.getStatus() +"\nPlease confirm the booking \nThank you ;)");
	  sender.send(mesg);
	 // flashMap.addFlashAttribute("payment","Payment Done Successfully");
	  return "redirect:/customer/welcome";
}	  
}