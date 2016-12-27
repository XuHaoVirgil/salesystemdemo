<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>salesystem</title>
	<link rel="stylesheet" href="<c:url value="/res/css/style.css"/>"/>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="g-doc">
	    <div class="n-result">
	    		<c:choose>
	    			<c:when test="${operate eq 'public' && status eq 'success'}">
	    				<h3>发布成功！</h3>
	        			<p><a href="/show?id=${goodsid}">[查看内容]</a><a href="/">[返回首页]</a></p>
	    			</c:when>
	    			<c:when test="${operate eq 'public' && status eq 'failed'}">
	    				<h3>发布失败！</h3>
	        			<p><a href="/public">[重新发布]</a><a href="/">[返回首页]</a></p>
	    			</c:when>
	    			<c:when test="${operate eq 'edit' && status eq 'success'}">
	    				<h3>编辑成功！</h3>
	        			<p><a href="/show?id=${goodsid}">[查看内容]</a><a href="/">[返回首页]</a></p>
	    			</c:when>
	    			<c:otherwise>
	    				<h3>编辑失败！</h3>
	        			<p><a href="/edit?id=${goodsid}">[重新编辑]</a><a href="/">[返回首页]</a></p>
	    			</c:otherwise>
	    		</c:choose>	
	    </div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>