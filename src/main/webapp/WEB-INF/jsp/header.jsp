<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.netease.salesystem.pojo.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
</head>
<body>
	<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
	<div class="n-head">
	    <div class="g-doc f-cb">
	    		<div class="user">
				<c:choose>
					<c:when test="${sessionScope.userRole == User.BUYER_ROLE}">
						买家你好，<span class="name">${sessionScope.userName}</span>！<a href="/logout">[退出]</a>
					</c:when>
					<c:when test="${sessionScope.userRole == User.SELLER_ROLE}">
						卖家你好，<span class="name">${sessionScope.userName}</span>！<a href="/logout">[退出]</a>
					</c:when>
					<c:otherwise>
						请<a href="/login">[登录]</a>
					</c:otherwise>
				</c:choose>
	        </div>
	        <ul class="nav">
	            <c:choose>
					<c:when test="${sessionScope.userRole == User.BUYER_ROLE}">
						<li><a href="/">首页</a></li>
	            			<li><a href="/account">账务</a></li>
	            			<li><a href="/settleAccount">购物车</a></li>
					</c:when>
					<c:when test="${sessionScope.userRole == User.SELLER_ROLE}">
						<li><a href="/">首页</a></li>
	            			<li><a href="/public">发布</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/">首页</a></li>
					</c:otherwise>
				</c:choose>
	        </ul>        
	    </div>
	</div>
</body>
</html>