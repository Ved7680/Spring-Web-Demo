package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EProductBean;

@Repository
public class EProductDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public void addProduct(EProductBean productBean) {
		stmt.update("Insert into products(productName, category, qty, price, productImagePath) values (?,?,?,?,?)", productBean.getProductName(), productBean.getCategory(), productBean.getQty(), productBean.getPrice(), productBean.getProductImagePath());
	}
	
	public List<EProductBean> listProducts(){
		List<EProductBean> list = stmt.query("select * from products", new BeanPropertyRowMapper<>(EProductBean.class));
		
		return list;
	}
	
	public void deleteProduct(Integer productId) {
		stmt.update("delete from products where productId = ?",productId);
	}
	
	public void deleteProduct(String productName) {
		stmt.update("delete from products where productName = ?",productName);
	}
	
	public EProductBean getProductById(Integer productId) {
		EProductBean bean = stmt.queryForObject("select * from products where productId = ?", new BeanPropertyRowMapper<>(EProductBean.class), new Object[] { productId });
		
		return bean;
	}
}
