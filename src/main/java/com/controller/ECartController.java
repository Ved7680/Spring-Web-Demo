package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.ECartBean;
import com.bean.EcomUserBean;
import com.dao.ECartDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class ECartController {

	@Autowired
	ECartDao cartDao;
	
	@GetMapping("/addtocart")
	public String addToCart( @RequestParam("productId") Integer productId, HttpSession session) {
		
		EcomUserBean userBean = (EcomUserBean) session.getAttribute("user");
		Integer userId = userBean.getUserId();
		ECartBean cartBean = new ECartBean();
		
		cartBean.setProductId(productId);
		cartBean.setUserId(userId);
		
		cartDao.addToCart(cartBean);
		
		return "redirect:/userproducts";
	}
}
