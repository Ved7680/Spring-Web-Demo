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
	
	@GetMapping("/elogin")
	public String elogin() {
		return "Ecomlogin";
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
}
