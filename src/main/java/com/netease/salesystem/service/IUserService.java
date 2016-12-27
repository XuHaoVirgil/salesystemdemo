package com.netease.salesystem.service;

import com.netease.salesystem.pojo.User;

public interface IUserService {
	
	public User checkLogin(String username,String password);
}
