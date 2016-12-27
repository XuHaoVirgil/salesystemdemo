<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>salesystem</title>
	<link rel="stylesheet" href="<c:url value="/res/css/style.css"/>"/>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="g-doc" id="settleAccount">
	    <div class="m-tab m-tab-fw m-tab-simple f-cb" >
	        <h2>已添加到购物车的内容</h2>
	    </div>
	 	<table id="newTable" class="m-table m-table-row n-table g-b3">
	 	</table>
	 	<div id="act-btn"><button class="u-btn u-btn-primary" id="back">退出</button>
	 	<button class="u-btn u-btn-primary" id="Account">购买</button></div>
	</div>
	<%@include file="footer.jsp"%>
<script type="text/javascript" src="<c:url value="/res/js/global.js"/>"></script>
<script type="text/javascript" src="<c:url value="/res/js/settleAccount.js"/>"> </script>
</body>
</html>