package com.app.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IDetails;

import com.app.pojos.Details;

@Controller
@RequestMapping("/details")
public class DetailsController {
	@Autowired
	private IDetails dao;
	
	/*@Value("#{props.upload_location}")
	private String location;
*/
	public DetailsController() {
		System.out.println("In Constructore of Details");
	}
	@GetMapping("/adddetails")
	public String sdetails(@RequestParam double rate,@RequestParam int pid,@RequestParam int sid,
			@RequestParam String location,@RequestParam String sname,
			Model map,RedirectAttributes flashMap, HttpSession hs)
	{
		System.out.println("in deleteservice");
		 hs.setAttribute("adts_sid", sid);
		 hs.setAttribute("adts_rate", rate);
		 hs.setAttribute("adts_pid", pid);
		 hs.setAttribute("adts_loc", location);
		 hs.setAttribute("adts_sname", sname);
		return "/details/adddetails";
	}
	@PostMapping("/adddetails")
	public String details(Details d,@RequestParam double rate,@RequestParam int pid,@RequestParam int sid,
			@RequestParam String location,@RequestParam String sname,
			Model map,RedirectAttributes flashMap, HttpSession hs) 
	{
		System.out.println("-------------------------------------------------->");
		
		/*imageurl1.transferTo(new File(location, imageurl1.getOriginalFilename()));
		System.out.println( imageurl1.getOriginalFilename());
		*/
		hs.setAttribute("adddetails", dao.details(d, sid, pid, rate, sname, location));
		return "redirect:/provider/welcome";
	}
	
	@GetMapping("/details")
	public String acceptbooking(@RequestParam int sid, Model map,RedirectAttributes flashMap, HttpSession hs) 
	{try 
	{
		System.out.println("in get details"+" ------ ");
		Details s=dao.showdetails(sid);
		System.out.println(s);
		hs.setAttribute("showdtls", s);
		return "/details/details";		
	}
	catch(Exception e)
	{
		flashMap.addFlashAttribute("mesg", "No details are available");
		System.out.println("Erro in details");
		return "redirect:/customer/welcome";
	}
	}
}
