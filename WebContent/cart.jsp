<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.11.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<script src="js/cart.js"></script>
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
				<!--
				登陆，注册
			-->
			<div style="text-align: right;background-color: #E3E4E5;">
				<c:if test="${empty user }">
				
				<a href="login.jsp" style="font-size: 4px;">登陆</a>
				<a href="regis.jsp" style="font-size: 4px;">注册</a>
		
				</c:if>
				<c:if test="${not empty user }">
				<a href="login.jsp" style="font-size: 4px;">退出</a>
				<a href="${pageContext.request.contextPath}/myOrderServlet" style="font-size: 4px;">我的订单</a>
				<a href="${pageContext.request.contextPath}/buyServlet" style="font-size: 4px;">我的购物车</a>
				  <span>欢迎${user.name}登陆</span>
		     	</c:if>
			  
			</div>
				
			</div>
			<div style="clear:both"></div>
			<!--
			导航栏	
			-->
			<jsp:include page="/dh.jsp"></jsp:include>
			<!--
				购物车列表
			-->
			<div>
				<h1>全部商品</h1>
				<hr />
				<table width="1200px" style="margin-left: 30px;">
					<tr style="color:#666666;background-color: #f3f3f3;height: 50px;">
					<th>
						<input  type="checkbox" onclick="checkStatus(this)"/>全选
					</th>
					<th>商品</th>
					<th>单价</th>
					<th>数量</th>
					<th>小计</th>
					<th>操作</th>
					</tr>
					<c:forEach items="${cart.productMap}" var="var">
					<tr style="background-color: #fff4e8;">
						<td>
							<input class="items" type="checkbox" value="${var.key }"/>
						</td>
						<td>
							<img src="img/carti1.jpg">
							<p>
								${var.value.product.pspec }
							</p>
							
						</td>
						<td>${var.value.product.pprice }</td>
						<td> ${var.value.quantity }</td>
						<td>¥ ${var.value.price }</td>
						<td>
							<a href="${pageContext.request.contextPath}/deleProductItemServlet?pid=${var.value.product.pid}">删除</a>
						</td>
					</tr>
					</c:forEach>
					
				</table>
				
				
			</div>
			<div style="text-align: right;margin:20px 180px 20px 20px;">
				<a href="${pageContext.request.contextPath}/clearcartServlet">清理购物车</a>
				<span style="margin-left: 30px;">
					总价：<font color="red">
					      <strong>¥ ${cart.totalMoney} .00</strong>	
					      </font>
				</span>
				<span style="background-color: red;font-style:italic;margin-left: 30px;">
					<a href="${pageContext.request.contextPath}/judgeUserServlet">
					 	<font color="white" size="3">
							 <strong>去结算</strong></font>
					</a>
				</span>
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