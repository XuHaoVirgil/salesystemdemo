package com.netease.salesystem.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.netease.salesystem.service.ISessionService;

@Service
public class SessionService implements ISessionService{

	@Override
	public int getUserRole(HttpServletRequest request) {
		Integer userRole = (Integer)request.getSession().getAttribute("userRole");
        if (null == userRole){
            return -1;
        }
        return userRole.intValue();
	}

	@Override
	public void setUserRole(Integer role, HttpServletRequest request) {
		request.getSession().setAttribute("userRole", role);		
	}

	@Override
	public String getUserName(HttpServletRequest request) {
		String userName = request.getSession().getAttribute("userName").toString();
        return userName;
	}

	@Override
	public void setUserName(String userName, HttpServletRequest request) {
		request.getSession().setAttribute("userName", userName);
		
	}

	@Override
	public String getUserId(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String userId = request.getSession().getAttribute("userId").toString();
        return userId;
	}

	@Override
	public void setUserId(Integer userid, HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("userId", userid);
	}

}
