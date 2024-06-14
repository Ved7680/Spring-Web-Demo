package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.BoxCricketStudentBean;
import com.util.Validators;

@Controller 
public class StudentController {
	
	@GetMapping("/BoxCricketRegistration")
	public String BoxCricketRegistration()
	{
		return "BoxCricketRegistration";
	}
	
	@PostMapping("/saveStudentReg")
	public String saveStudentRegistration(BoxCricketStudentBean stdbean, Model model)
	{
		System.out.println("Name: "+stdbean.getStdName());
		System.out.println("Player Type: "+stdbean.getPlayerType());
		System.out.println("Food Preference: "+stdbean.getFoodPreference());
		System.out.println("Drinks: "+stdbean.getDrink());
		
		boolean isError = false;
		String alphaRegEx = "[a-z A-Z]+";
		
		if(Validators.isBlank(stdbean.getStdName()))
		{
			model.addAttribute("stdNameError", "Please Enter Student Name");
			isError = true;
		}
		else if (Validators.isAlpha(stdbean.getStdName())){
			model.addAttribute("stdNameError", "Please Enter Valid Student Name");
			isError = true;
		}
//		else {
//			model.addAttribute("stdNameValue", stdbean.getStdName());
//		}
		
		if (Validators.isBlank(stdbean.getPlayerType())) {
			model.addAttribute("playerTypeError", "Please Select Player Type");
			isError = true;
		}
//		else {
//			model.addAttribute("playerTypeValue", stdbean.getPlayerType());
//		}
		
		if (Validators.isBlank(stdbean.getFoodPreference())) {
			model.addAttribute("foodPreferenceError", "Please Select Food Preference");
			isError = true;
		}
//		else {
//			model.addAttribute("foodPreferenceValue", stdbean.getFoodPreference());
//		}
		
		if (Validators.isBlank(stdbean.getDrink())) {
			model.addAttribute("drinkError", "Please Select Drink");
			isError = true;
		}
//		else {
//			model.addAttribute("drinkValue", stdbean.getDrink());
//		}
		
		model.addAttribute("reg_details", stdbean);
		
		if (isError == true) {
			return "BoxCricketRegistration";
		}
		else {
			return "BoxCricketDetails";
		}
		
	}
}
