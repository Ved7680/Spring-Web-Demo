package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EcomUserBean;
import com.dao.EUserDao;
import com.service.EFileUploadService;
import com.util.Validators;

import jakarta.servlet.http.HttpSession;

@Controller
public class EcomSessionController {

	@Autowired
	EUserDao userDao;
	
	@Autowired
	EFileUploadService fileUploadService;
	
	@GetMapping("/esignup")
	public String esignup() {
		return "Ecomsignup";
	}
	
	@GetMapping(value = {"/elogin","/"})
	public String elogin() {
		return "Ecomlogin";
	}
	
	@PostMapping("/elogin")
	public String eLogin(EcomUserBean userbean, Model model, HttpSession session) {
		System.out.println("line 35 =>"+userbean.getEmail());
		System.out.println("line 35 =>"+userbean.getPassword());
		
		
		EcomUserBean dbUser = userDao.authenticate(userbean.getEmail(), userbean.getPassword());
		if (dbUser == null) {
			model.addAttribute("loginerror", "Invalid Credentials");
			return "Ecomlogin";
		}
		else {
			session.setAttribute("user", dbUser);
			model.addAttribute("firstName", dbUser.getFirstName());
			System.out.println("line 49 =>"+dbUser.getProfilePicPath());
			model.addAttribute("profilePicPath", dbUser.getProfilePicPath());	
			return "EComHome";
		}
	}
	
	@PostMapping("/esignup")
	public String signupPost(EcomUserBean userbean, Model model) {
		
		// Validation starts 
		boolean isError = false;
		
		if ( Validators.isBlank(userbean.getFirstName()) ) {
			model.addAttribute("firstNameError", "Please Enter Your First Name");
			isError = true;
		}
		else if ( Validators.isAlpha(userbean.getFirstName()) == false) {
			model.addAttribute("firstNameError", "Please Enter Valid First Name");
			isError = true;
		}
		
		if ( Validators.isBlank(userbean.getEmail()) ) {
			model.addAttribute("emailError", "Please Enter Your Email");
			isError = true;
		}
		else if ( Validators.isEmail(userbean.getEmail()) == false) {
			model.addAttribute("emailError", "Please Enter Valid Email");
			isError = true;
		}
		
		if( Validators.isBlank(userbean.getPassword()) ) {
			model.addAttribute("passwordError", "Please Enter Your Password");
			isError = true;
		}
		else if ( Validators.isAlphaNumeric(userbean.getPassword()) == false) {
			model.addAttribute("passwordError", "Please Enter Valid Password");
			isError = true;
		}
		// Validation ends
		
		model.addAttribute("user_details", userbean);
		
		
		if (isError == true) {
			return "Ecomsignup";
		}
		else {
			
			fileUploadService.uploadUserImage(userbean.getProfilePic(), userbean.getEmail());
			
			userbean.setProfilePicPath("images//profilepic//"+userbean.getEmail()+"//"+userbean.getProfilePic().getOriginalFilename());
			
			userDao.insertUser(userbean);
			return "Ecomlogin";
		}
	}
	
	@GetMapping("/elogout")
	public String elogout(HttpSession session) {
		// Destroy Session
		session.invalidate();
		return "redirect:/elogin";
	}
}
