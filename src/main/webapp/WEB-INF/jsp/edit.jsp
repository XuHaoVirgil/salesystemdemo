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
	    <div class="m-tab m-tab-fw m-tab-simple f-cb">
	        <h2>内容编辑</h2>
	    </div>
	    <div class="n-public">
	        <form class="m-form m-form-ht" id="form" method="post" action="/editSubmit" onsubmit="return false;" autocomplete="off">
	            <div class="fmitem">
	                <label class="fmlab">标题：</label>
	                <div class="fmipt">
	                    <input type="hidden" name="id" value="${goods.goodsid }"/>
	                    <input class="u-ipt ipt" name="title" value="${goods.title }" placeholder="2-80字符"/>
	                </div>
	            </div>
	            <div class="fmitem">
	                <label class="fmlab">摘要：</label>
	                <div class="fmipt">
	                    <input class="u-ipt ipt" name="summary" value="${goods.summary }" placeholder="2-140字符"／>
	                </div>
	            </div>
	            <div class="fmitem">
	            <label class="fmlab">图片：</label>
	            	<div class="fmipt" id="uploadType">
		                <input name="pic" type="radio" value="url" checked /> 图片地址
						<input name="pic" type="radio" value="file" /> 本地上传
					</div>	
	            </div>
	            <div class="fmitem">
	                <label class="fmlab"></label>
	                <div class="fmipt" id="urlUpload">
	                    <input class="u-ipt ipt"  name="image" placeholder="图片地址"/>
	                </div>
	                <div class="fmipt" id="fileUpload"  style="display:none">
	                    <input class="u-ipt ipt" name="file" type="file" id="fileUp"/>
	                    <button class="u-btn u-btn-primary" id="upload">上传</button>
	                </div>
	            </div>
	            <div class="fmitem">
	                <label class="fmlab">正文：</label>
	                <div class="fmipt">
	                    <textarea class="u-ipt" name="detail" rows="10" placeholder="2-1000个字符">${goods.description }</textarea>
	                </div>
	            </div>
	            <div class="fmitem">
	                <label class="fmlab">价格：</label>
	                <div class="fmipt">
	                    <input class="u-ipt price" name="price" value="${goods.price }"/>元
	                </div>
	            </div>
	            <div class="fmitem fmitem-nolab fmitem-btn">
	                <div class="fmipt">
	                    <button type="submit" class="u-btn u-btn-primary u-btn-lg">保 存</button>
	                </div>
	            </div>
	        </form>
	        <span class="imgpre"><img src="<c:url value="${goods.imageurl }"/>" alt="" id="imgpre"></span>
	    </div>
	</div>

	<%@include file="footer.jsp"%>
<script type="text/javascript" src="<c:url value="/res/js/global.js"/>"></script>
<script type="text/javascript" src="<c:url value="/res/js/public.js"/>"></script>
</body>
</html>