<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>salesystem</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/res/css/style.css"/>" />
</head>
<body>
	<%@include file="header.jsp"%>
	<form class="m-form m-form-ht n-login" id="loginForm" onsubmit="return false;" autocomplete="off">
	    <div class="fmitem">
	        <label class="fmlab">用户名：</label>
	        <div class="fmipt">
	            <input class="u-ipt" name="userName" autofocus/>
	        </div>
	    </div>
	    <div class="fmitem">
	        <label class="fmlab">密码：</label>
	        <div class="fmipt">
	            <input class="u-ipt" type="password" name="password"/>
	        </div>
	    </div>
	    <div class="fmitem fmitem-nolab fmitem-btn">
	        <div class="fmipt">
	            <button type="submit" class="u-btn u-btn-primary u-btn-lg u-btn-block">登 录</button>
	        </div>
	    </div>
	</form>
	<%@include file="footer.jsp"%>
<script type="text/javascript" src="<c:url value="/res/js/md5.js"/>" > </script>
<script type="text/javascript" src="<c:url value="/res/js/global.js"/>" > </script>
<script type="text/javascript" src="<c:url value="/res/js/pageLogin.js"/>" > </script>
</body>
</html>