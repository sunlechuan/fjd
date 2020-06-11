<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单</title>
<link rel="stylesheet" href="css/mobile.css" />
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/detail.css" />
		<script src="js/jquery-1.11.0.js"></script>
</head>
<body>

<br/>
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
			<div>
				<h1>收货人信息</h1>
				<table width="600px" height="200px">
				
					<tr>
						<td>收货人:</td>
						<td>
							<input value="${user.name }" style="width: 450px;" type="text" name="username" />
						</td>
					</tr>
					<tr>
						<td> 详细地址:</td>
						<td>
							<input value="" style="width: 450px;" type="text" name="address" id="address"/>
						</td>
					</tr>
					<tr>
						<td>手机号码:</td>
						<td>
							<input value="${user.phone }" style="width: 450px;" type="text" name="usermobile" />
						</td>
					</tr>
				</table>
			</div>
			<div style="margin-top: 10px;">
				<h1 style="display: inline;">配送方式</h1>
				<span style="border: 1px solid red;margin-left: 20px;">快递运输</span>
			</div>
			<!--
				购物车列表
			-->
			<div>
				<h1>送货清单</h1>
				<hr />
				<table width="1200px" style="margin-left: 60px;">
					<tr style="color:#666666;background-color: #f3f3f3;height: 50px;">				
						<th>商品</th>
						<th>单价</th>
						<th>数量</th>
						<th>小计</th>
					</tr>
					<c:forEach items="${cart.productMap}" var="var">
						<tr style="background-color: #fff4e8;">
							<td>
								<img src="img/carti1.jpg">
								<p>
									${var.value.product.pname }
								</p>
								
							</td>
							<td>¥ ${var.value.product.pprice }</td>
							<td>${var.value.quantity }</td>
							<td>¥ ${var.value.price } .00</td>
						
						</tr>
					</c:forEach>
				</table>
				
			</div>
			<div style="text-align: right;margin:20px 180px 20px 20px;">
				
				<span style="margin-left: 30px;">
					总商品金额：<font color="red">
					      <strong>¥ ${cart.totalMoney} .00</strong>	
					      </font>
				</span>
				<br />
				<button style="margin-top: 20px;width: 150px;height: 50px;background-color: red;color: white;font-size: 25px;" onclick="subOrder()">
				    <b>提交订单</b>	
				</button>
				
				
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
<script type="text/javascript">
	function subOrder(){
		var address = $("#address").val();
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/orderServlet",
			data:{"address":address},
			success : function(data) {
				
				window.location.href="${pageContext.request.contextPath}/success.jsp";
			},error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("请求错误");

			}
		});
		
	}
</script>

<script type="text/javascript">
	function getkey(pid){
		alert(pid);
	}
</script>
</html>