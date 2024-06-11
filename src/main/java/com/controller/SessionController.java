package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class SessionController {
	
	@GetMapping("/login")
	public String login()
	{
		return "Login";
	}
	
	@GetMapping("/signup")
	public String signup()
	{
		return "Signup";
	}
	
	@GetMapping("/forgotPassword")
	public String forgotPassword()
	{
		return "ForgotPassword";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(UserBean userBean, Model model) {
		System.out.println("First Name: "+userBean.getFirstName());
		System.out.println("Email: "+userBean.getEmail());
		System.out.println("Password: "+userBean.getPassword());
		
		model.addAttribute("user",userBean);
		
		return "Welcome";
	}
}
