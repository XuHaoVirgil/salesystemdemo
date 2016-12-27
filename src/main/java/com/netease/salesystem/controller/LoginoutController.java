package com.netease.salesystem.controller;  
 

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netease.salesystem.pojo.ResponseFormat;
import com.netease.salesystem.pojo.User;
import com.netease.salesystem.service.ISessionService;
import com.netease.salesystem.service.IUserService;  
  
  
@Controller  
public class LoginoutController {  
    @Autowired  
    private IUserService userService;  
    
    @Autowired
    private ISessionService sessionService;
    
    @RequestMapping("/login")  
    public String showLogin(HttpServletRequest request,Model model){  
        return "login";  
    }  
    
    @RequestMapping("/checklogin")
    public @ResponseBody ResponseFormat check(HttpServletRequest request,Model model){  
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = this.userService.checkLogin(username,password);
        ResponseFormat response = new ResponseFormat();
        if (user!=null) {
        		response.setCode(200);
        		response.setResult(user);
        		sessionService.setUserRole(user.getRole(), request);
        		sessionService.setUserName(user.getName(), request);
        		sessionService.setUserId(user.getUserid(), request);
        }else{
        		response.setCode(400);
        }
        return response;  
    }  
    @RequestMapping("/logout")
    public String showLogout(HttpServletRequest request,Model model){
    		sessionService.setUserRole(null, request);
    		sessionService.setUserName(null, request);
    		sessionService.setUserId(null, request);
    		return "login";
    }
    
}  