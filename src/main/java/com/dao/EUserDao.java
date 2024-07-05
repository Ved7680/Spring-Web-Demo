package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomUserBean;

@Repository
public class EUserDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public void insertUser(EcomUserBean userbean) {
		stmt.update("Insert into users(firstName, email, password, profilePic) values (?,?,?,?)",userbean.getFirstName(), 
						userbean.getEmail(), userbean.getPassword(), userbean.getProfilePicPath());
	}
	
}
