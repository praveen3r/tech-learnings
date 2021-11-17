package com.demo.model;

import java.util.Date;
import java.util.List;

import com.demo.entity.User;

public class UserVO1 {

	private List<User> user;
	private Date date;
	
	public UserVO1(List<User> user, Date date) {
		this.user = user;
		this.date = date;
	}
	
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
