package com.netease.salesystem.pojo;

public class User {
	
	public static final int BUYER_ROLE = 1;
	public static final int SELLER_ROLE = 2;
    private Integer userid;

    private String name;

    private String password;

    private Integer role;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}