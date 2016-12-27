<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.netease.salesystem.pojo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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
	    <div class="m-tab m-tab-fw m-tab-simple f-cb">
	        <h2>已购买的内容</h2>
	    </div>
	    <c:choose>
	    		<c:when test="${fn:length(list) > 0 }">
	    			<table class="m-table m-table-row n-table g-b3">
			        <colgroup><col class="img"/><col/><col class="time"/><col/><col class="num"/><col/><col class="price"/><col/></colgroup>
			        <thead>
			            <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>购买数量</th><th>购买价格</th></tr>
			        </thead>
			        <tbody>
			        		<c:forEach items="${list }" var="item">
			        			<tr>
				                <td><a href="/show?id=${item.goodsid }"><img src="${item.imageurl }" alt=""></a></td>
				                <td><h4><a href="/show?id=${item.goodsid }">${item.title }</a></h4></td>
				                <td><span class="v-time"><fmt:formatDate value="${item.paytime }" pattern="yyyy-MM-dd HH:mm:ss" /> </span></td>
				                <td><span class="v-num">${item.paynum }</span></td>
				                <td><span class="v-unit">¥</span><span class="value"><fmt:formatNumber value="${item.payprice }" pattern="0.00"/> </span></td>
			            		</tr>
			        		</c:forEach>    
			        </tbody>
			        <tfoot>
			            <tr>
			                <td colspan="4"><div class="total">总计：</div></td>
			                <td><span class="v-unit">¥</span><span class="value"><fmt:formatNumber value="${sum }" pattern="0.00"/></span></td>
			            </tr>
			        </tfoot>
			    </table>
	    		</c:when>
	    		<c:otherwise>
	    			<div class="n-result">
					<h3>暂无购买内容</h3>
				</div>
	    		</c:otherwise>
	    </c:choose>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>