package com.springLearning.springmvcboot;

import java.util.List;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springLearning.springmvcboot.model.*;
@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home page requested");
		return "index";
	}
	
	
	@ModelAttribute     
	public void modelData(Model m) {
		
		m.addAttribute("user", "gagan");

	}
	
	@GetMapping("getAliens") public String getAliens(Model m) {
		 
		  
		  m.addAttribute("result",repo.findAll()); 
		  return "showAliens";
		  
		  }
	
	
	 @GetMapping("getAlienByName") 
	 public String getAlienByname(@RequestParam String aname, Model m) {
		
		 
		 	//m.addAttribute("result",repo.findByAname(aname)); 
		 	//m.addAttribute("result",repo.findByAnameOrderByAidDesc((aname)));
		 
		//m.addAttribute("result",repo.findByAnameOrderByAidDesc((aname)));
		 
		 m.addAttribute("result",repo.find((aname)));
		 
		 	return "showAliens";	
		  
		  }
	
	 @GetMapping("getAlien") public String getAlien(@RequestParam int aid, Model m) {
		 
			/*
			  List<Alien> a = Arrays.asList(new Alien(101, "Raji"),new Alien(102, "baji"));
			  m.addAttribute("alien", a);
			 */
		 
		 	m.addAttribute("result",repo.getOne(aid));
		 
		  return "showAliens";
		  
		  }
	 
		@PostMapping("addAlien")
		public String addAlien(@ModelAttribute("a1") Alien a,Model m) {
			
			m.addAttribute("user","Its me Gagan");
			
			repo.save(a);
			return "Result";
		}
	 
	 

	/* This is hardcoded values learnt in previous sessions with database
	 @RequestMapping(value="addAlien", method = RequestMethod.POST) // this will restrict method to accept only Post/Get 
		@PostMapping("addAlien")
		public String addAlien(@ModelAttribute("a1") Alien a) {
			
			return "Result";
		}
	
	
	 @GetMapping("getAliens") public String getAliens(Model m) {
	 
	  List<Alien> a = Arrays.asList(new Alien(101, "Raji"),new Alien(102, "baji"));
	  m.addAttribute("alien", a); 
	  return "showAliens";
	  
	  }
	 
	
	//@RequestMapping("addAlien")
	//@RequestMapping(value="addAlien", method = RequestMethod.POST) // this will restrict method to accept only Post/Get 
	@PostMapping("addAlien")
	public String addAlien(@ModelAttribute("a1") Alien a) {
		
		return "Result";
	}
	
	
	
	
	  
	 
	 
	 * ***********************************************************************************************************************
	 * 		Below is the  method of using ModelMap using RequestPAram and CLass  - Type 1 - ModelAndView              *
	 * ***********************************************************************************************************************
	
	@RequestMapping("addAlien")     
	public String addAlien(@RequestParam("aid") int aid , @RequestParam("aname") String aname, ModelMap m) {
		
		Alien a = new Alien();
		a.setAid(aid);
		a.setAname(aname);
		
		m.addAttribute("alien", a);
		return "Result";
	}
	*/
	
	
	

	@RequestMapping("add")     
	public String add(@RequestParam("num1") int i , @RequestParam("num2") int j, ModelMap m) {
		
		int k = i+j;
		m.addAttribute("result", k);
		
		return "Result";
	}
	
	
	
	/*
	  
	 
	 
	 * *******************************************************************************************
	 * 				Below is the basic method of processing  - Type 2 - ModelAndView              *
	 * *******************************************************************************************
	  
	@RequestMapping("add")     TYPE 3 - ModelAndView
	public ModelAndView add(@RequestParam("num1") int i , @RequestParam("num2") int j) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Result");
		
		int k = i+j;
		mv.addObject("result", k);
		
		return mv;
	}
	
	*/
	
	/*
	 
	 
	  
	 * *******************************************************************************************
	 * 				Below is the basic method of processing  - Type 2 - HTTPSESSION              *
	 * *******************************************************************************************
	 
	@RequestMapping("add") 
	public String add(@RequestParam("num1") int i , @RequestParam("num2") int j, HttpSession session) {
		
		int k = i+j;
		
		session.setAttribute("result", k);
		
		return"Result.jsp";
	}
	*/
	
	/* 
	 
	  
	 * *****************************************************************************
	 * 				Below is the basic method of processing  - Type 1              *
	 * *****************************************************************************
	 
	@RequestMapping("add")
	public String add(HttpServletRequest req,HttpServletResponse res) {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i+j;
		
		HttpSession session = req.getSession();
		
		session.setAttribute("result", k);
		
		return"Result.jsp";
	}
	
	*/
	
	
	
	
	
}
