package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EProductBean;
import com.dao.EProductDao;
import com.util.Validators;

@Controller
public class EProductController {
	
	@Autowired
	EProductDao productDao;
	
	@GetMapping("/newproduct")
	public String newProduct() {
		return "E_NewProduct";
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(EProductBean productBean, Model model) {
		
		boolean isError=false;
		
		// For productName
		if ( Validators.isBlank(productBean.getProductName()) ) {
			model.addAttribute("productNameError", "Please Enter Product Name");
			isError = true;
		}else if ( Validators.isAlpha(productBean.getProductName()) == false ) {
			model.addAttribute("productNameError", "Please Enter valid Product Name");
			isError = true;
		}
		
		// For product category
		if ( Validators.isBlank(productBean.getCategory()) ) {
			model.addAttribute("categoryError", "Please Enter Product Category");
			isError = true;
		}else if ( Validators.isAlpha(productBean.getCategory()) == false ) {
			model.addAttribute("categoryError", "Please Enter Valid Product Category");
			isError = true;
		}
		
		// For product qty
		if ( Validators.isBlank( Integer.toString(productBean.getQty()) ) ) {
			model.addAttribute("qtyError", "Please Enter Product Qty");
			isError = true;
		}else if ( Validators.isNumeric( Integer.toString(productBean.getQty()) ) == false ) {
			model.addAttribute("categoryError", "Please Enter Valid Product Qty");
			isError = true;
		}
		
		// For product price
		if ( Validators.isBlank( Float.toString(productBean.getPrice()) ) ){
			model.addAttribute("priceError", "Please Enter Product Price");
			isError = true;
		}
//		else if ( Validators.isAlpha(Float.toString(productBean.getPrice())) == false ) {
//			model.addAttribute("priceError", "Please Enter Product Valid Price");
//			isError = true;
//		}
		
		model.addAttribute("productDetails", productBean);
		
		if (isError == false) {
			productDao.addProduct(productBean);
			return "redirect:/products"; // redirect: --> using it we will be able to redirect to a url. Otherwise, it will only accept jsp file.
		}
		else {
			return "E_NewProduct";
		}
	}
	
	@GetMapping("/products")
	public String listProducts(Model model) {
		
		List<EProductBean> product_list = productDao.listProducts();
		model.addAttribute("product_list", product_list);
		
		return "EcomListProducts";
	}
	
	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("productId") Integer productId) {
		System.out.println(productId);
		productDao.deleteProduct(productId);
		
		return "redirect:/products";
	}
	
	@GetMapping("/deleteproduct_name_submit")
	public String deleteProductName() {
//		productDao.deleteProduct(productName);
		return "EDelete_Product_Name";
	}
	
	@GetMapping("/deleteproduct_name")
	public String deleteProduct(@RequestParam("productName") String productName) {
		productDao.deleteProduct(productName);
		
		return "redirect:/products";
	}
}
