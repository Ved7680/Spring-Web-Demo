package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomUserBean;

@Repository
public class EUserDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public void insertUser(EcomUserBean userbean) {
		stmt.update("Insert into users(firstName, email, password, profilePicPath) values (?,?,?,?)",userbean.getFirstName(), 
						userbean.getEmail(), userbean.getPassword(), userbean.getProfilePicPath());
	}
	
	public EcomUserBean authenticate(String email, String password) {
		
		try {
			EcomUserBean userbean = stmt.queryForObject("select * from users where email = ? and password = ?", new BeanPropertyRowMapper<>(EcomUserBean.class), new Object[] {email, password});
			
			return userbean;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
