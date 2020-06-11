<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>我的订单</title>
<script src="js/jquery-1.11.0.js"></script>
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
					<a href="myorder.html">我的订单</a>
					欢迎${user.name}登陆
				</div>
				
			</div>
			<div style="clear:both"></div>
			<!--
			导航栏	
			-->
			<jsp:include page="/dh.jsp"></jsp:include>
			<!--
				收货人信息
				
			-->
			
			
			<!--
				购物车列表
			-->
			<div>
				<h1>我的订单</h1>
				<hr />
				<table width="1200px" style="margin-left: 60px;">
					<tr style="color:#666666;background-color: #f3f3f3;height: 50px;">				
						<th>商品</th>
						<th>地址</th>
						<th>单价</th>
						<th>数量</th>
						<th>小计</th>
					</tr>
					<c:forEach items="${data}" var="var">
						<tr style="background-color: #fff4e8;">
					
							<td>
								<img src="img/carti1.jpg">
								<p>
									${var.pname }
								</p>
								
							</td>
							<td>${var.address }</td>
							<td>¥ ${var.pprice }</td>
							<td>${var.count }</td>
							<td>¥ ${var.count*var.pprice }</td>
						
						</tr>
					</c:forEach>
				</table>
				
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