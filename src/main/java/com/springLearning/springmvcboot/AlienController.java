package com.springLearning.springmvcboot;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springLearning.springmvcboot.model.Alien;


@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	//@GetMapping("aliens") 
	 @GetMapping(path="aliens", produces= {"application/xml"}) //This is to restrict to XML, before that jackson xml dependency has to be added.
	 @ResponseBody 						//This annotation will return ur data in json format, Jackson jar does the job.
	 public List<Alien> getAliens() {
		
		 List<Alien> aliens=repo.findAll();
		 System.out.println("Fetching Aliens");
		 	return aliens;	
		  
		  
		  }
	 
	// @PostMapping("aliens")
	 //@PostMapping(path="aliens", consumes= {MediaType.APPLICATION_JSON_VALUE}) -this is also correct. Consumes is use to restrict datatype white
	 @PostMapping(path="aliens", consumes= {"application/json"})
	 public Alien addAlien(@RequestBody Alien a) {
		 
		repo.save(a);
		
		return a;
		 
	 }
	 
	
	 
	 @GetMapping("alien/{aid}") 
	 //@ResponseBody //No need to mention if ur controller itself is RestController
	 public Alien getAlien(@PathVariable("aid") int aid) {
	 //public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		 Alien alien=repo.findById(aid).orElse(new Alien(0 ,""));
		 
		 //Optional<Alien> alien=repo.findById(aid);
		 
		 	return alien;	
		  
		  
		  }
	 
	 @GetMapping("alien/name:{aname}") 
	 //@ResponseBody //No need to mention if ur controller itself is RestController
	 public List<Alien> getAlienbyname(@PathVariable("aname") String aname) {
		 //public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
			
		 List<Alien> aliens=repo.findByAname(aname);
			 
			 //Optional<Alien> alien=repo.findById(aid);
			 
			 	return aliens;	
			  
			  
			  }
	 
	
}
