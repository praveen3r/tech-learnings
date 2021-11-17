package com.demo.model;

import java.util.Date;
import java.util.List;

import com.demo.entity.User;

public class UserVO {

	private User user;
	private Date date;
	
	public UserVO(User user, Date date) {
		this.user = user;
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
