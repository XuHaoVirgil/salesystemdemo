<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.netease.salesystem.pojo.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>salesystem</title>
	<link rel="stylesheet" href="<c:url value="/res/css/style.css"/>"/>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="g-doc">
	    <div class="m-tab m-tab-fw m-tab-simple f-cb">
	        <div class="tab">
	            <ul>
	                <li <c:if test="${type!=1 }"> class="z-sel" </c:if> ><a href="/">所有内容</a></li>
	                <c:if test="${sessionScope.userRole == User.BUYER_ROLE}"> <li <c:if test="${type==1 }"> class="z-sel" </c:if> ><a href="/?type=1">未购买的内容</a></li> </c:if>
	            </ul>
	        </div>
	    </div>
	    <div class="n-plist">
	        <ul class="f-cb" id="plist">
	        		<c:forEach items="${list }" var="item">
			        	<li id="p-${item.goodsid }">
	                    <a href="/show?id=${item.goodsid }" class="link">
	                        <div class="img"><img src="${item.imageurl }" alt="${item.title }"></div>
	                        <h3>${item.title }</h3>
	                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${item.price }</span></div>
	                        <c:choose>
								<c:when test="${sessionScope.userRole == User.BUYER_ROLE && item.salednum > 0}">
									<span class="had"><b>已购买</b></span>  
								</c:when>
								<c:when test="${sessionScope.userRole == User.SELLER_ROLE && item.salednum > 0}">
									<span class="had"><b>已售出</b></span>  
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
	                    </a>
	                    <c:choose>
	                    		<c:when test="${sessionScope.userRole == User.SELLER_ROLE && item.salednum == 0}">
								<span class="u-btn u-btn-normal u-btn-xs del" data-del="${item.goodsid }">删除</span>
							</c:when>
							<c:otherwise>
							</c:otherwise>
	                    </c:choose>
	                </li>
			    </c:forEach>    
	        </ul>
	    </div>
	</div>
	<%@include file="footer.jsp"%>
<script type="text/javascript" src="<c:url value="/res/js/global.js"/>"></script>
<script type="text/javascript" src="<c:url value="/res/js/pageIndex.js"/>"></script>
</body>
</html>