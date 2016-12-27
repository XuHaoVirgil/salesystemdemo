<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.netease.salesystem.pojo.User"%>
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
	    <div class="n-show f-cb" id="showContent">
	        <div class="img"><img src="<c:url value="${goods.imageurl }"/>" alt="" ></div>
	        <div class="cnt">
	            <h2>${goods.title }</h2>
	            <p class="summary">${goods.summary }</p>
	            <div class="price">
	                <span class="v-unit">¥</span><span class="v-value">${goods.price }</span>
	            </div>
	            <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">1</span><span id="addNum" class="moreNum"><a>+</a></span></div>
	            <div class="oprt f-cb">
	                <c:choose>
						<c:when test="${sessionScope.userRole == User.BUYER_ROLE && goods.salednum > 0}">
							<span class="u-btn u-btn-primary z-dis">已购买</span>
                    			<span class="buyprice">当时购买价格：¥${payedprice }</span>		
						</c:when>
						<c:when test="${sessionScope.userRole == User.SELLER_ROLE}">
							 <a href="/edit?id=${goods.goodsid }" class="u-btn u-btn-primary">编 辑</a>
						</c:when>
						<c:when test="${sessionScope.userRole == User.BUYER_ROLE	&& goods.salednum == 0}">
							<button class="u-btn u-btn-primary" id="add" data-id="${goods.goodsid }" data-title="${goods.title }" data-price="${goods.price }">
                             	加入购物车
                             </button>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
	            </div>
	        </div>
	    </div>
	    <div class="m-tab m-tab-fw m-tab-simple f-cb">
	        <h2>详细信息</h2>
	    </div>
	    <div class="n-detail">
	        ${goods.description }
	    </div>
	</div>
	
	<%@include file="footer.jsp"%>
<script type="text/javascript" src="<c:url value="/res/js/global.js"/>"></script>
<script type="text/javascript" src="<c:url value="/res/js/pageShow.js"/>"></script>
</body>
</html>