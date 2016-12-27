package com.netease.salesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.salesystem.dao.UserDao;
import com.netease.salesystem.pojo.User;
import com.netease.salesystem.service.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		User user = userDao.findUserByName(username);
		if(user != null && user.getPassword().equals(password)){
			return user;
		}
		return null;
	}
	
}
