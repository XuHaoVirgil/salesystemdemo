package com.netease.salesystem.service;

import javax.servlet.http.HttpServletRequest;

public interface ISessionService {

	public int getUserRole(HttpServletRequest request);
	
	public void setUserRole(Integer role,HttpServletRequest request);
	
	public String getUserName(HttpServletRequest request);
	
	public void setUserName(String userName,HttpServletRequest request);
	
	public String getUserId(HttpServletRequest request);
	
	public void setUserId(Integer userid,HttpServletRequest request);
}
