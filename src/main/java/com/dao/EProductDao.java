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
		stmt.update("Insert into products(productName, category, qty, price) values (?,?,?,?)", productBean.getProductName(), productBean.getCategory(), productBean.getQty(), productBean.getPrice());
	}
	
	public List<EProductBean> listProducts(){
		List<EProductBean> list = stmt.query("select * from products", new BeanPropertyRowMapper<>(EProductBean.class));
		
		return list;
	}
}
