<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-1.11.0.js"></script>
<title>收银</title>
</head>
<body>
			<div>
			<!--
				导航栏
			-->
			 <div id="d4">
				<div style="margin-left: 200px;">
				   <img src="img/logo.jpg" />
				</div>
				<div style="padding:20px 40px;width: 480px;">
				<input type="text" id="txtwd" name="word"  style="width: 80%;height: 35px;"/>
				<input type="button" value="查询" onclick="search()" style="width: 10%;height: 35px;"/>
				</div>
				<div style="text-align: right;width:400px;padding-top:30px;">
					<a href="${pageContext.request.contextPath}/myOrderServlet">我的订单</a>
					欢迎${user.name }登陆
				</div>
				
			</div>
			<div style="clear:both"></div>
			<!--
			导航栏	
			-->
			<jsp:include page="/dh.jsp"></jsp:include>
			<!--
				
			-->
			<div>
				<h1>收银台</h1>
				<span>
				<p>
				
				订单提交成功，请尽快付款！
				应付金额 <span style="color:red">${cart.totalMoney } </span>元
				</p>
				</span>
				<p>
					<img src="img/pay.png">
				</p>
			</div>
			
			<!--
            	作者：offline
            	时间：2019-12-18
            	描述：底部
            -->
            <hr />
            <div style="margin-left: 120px;">
				<img src="img/foot.jpg" />
				<img src="img/link.jpg" />
			</div>
		</div>
</body>
</html>