<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
		<link rel="stylesheet" href="css/index.css" />
		<script type="text/javascript" src="js/index.js" ></script>
		<script src="js/jquery-1.11.0.js"></script>
	</head>
	<body >
		<div>
			<!--
				广告图片
			-->
			<div id="d2">
				<img onclick="closeGD()" src="img/close.jpg" style="position: absolute;right: 50px;top: 10px;"/>
				<img src="img/gd.jpg" />
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
			<!--
				搜索
			-->
			<div id="d4">
				<div style="margin-left: 200px;">
				   <img src="img/logo.jpg" />
				</div>
				<div style="padding:20px 40px;width: 480px;">
				<input type="text" id="txtwd" name="word"  style="width: 80%;height: 35px;"/>
				<input type="button" value="查询" onclick="search()" style="width: 10%;height: 35px;"/>
				</div>
				
			</div>
			<div class="cls"></div>
			<!--
				导航栏
				商品分类  cate
			-->
			<jsp:include page="/dh.jsp"></jsp:include>
			
			<!--
				图片切换
			-->
			<div id="d1" style="text-align: left;margin-left:200px">
				<div style="margin: 0 1px;margin-top:10px;margin-bottom10px;width: 100%;">
					<img id="i1" src="img/bg1.jpg" width="1000px" height="300px"/>
				</div>
			</div>
			<!--
				秒杀商品展示
			-->
			<div id="d3">
				<h1 style="margin-left: 100px;">秒杀商品</h1>
				<hr style="width: 990px;" />
				<c:forEach items="${varList }" var="var"> 
					<div>
						<a href="#">
							<img width="180px" height="220px" src="img/p2.png">
						</a>
						<p>${var.pname }</p>
						<p>价钱:${var.pprice }</p>	
					</div>
				</c:forEach>
			</div>
			<!--
				底部
			-->
			<div>
				<hr style="width: 990px;" />
			</div>
			
			<div style="margin-left: 120px;">
				<img src="img/foot.jpg" />
				<img src="img/link.jpg" />
			</div>
		</div>
	</body>
	
	<script type="text/javascript">
		/*$(function(){
			console.log("                      __                 __          ___ _                   \n		 			 / _\\ _   _ _ _     / /  ___    / __\ | __  _   _  __ _ _ __   \n					 \\ \| | | | '_ \\    / /  / _\\ \  / /   |'_ \| | | | / _` | '_  \\  \n				 	 _\\ \ |_| | | | |  / /__ | __/ / /___ | | | | |_| |( _ | | | |   \n					 \\__/\__,_|_| |_|  \\____/\\___| \\____/ |_| |_|\__,_ |\__,_|_| |_| ");
		})*/
		
		$(function(){
			console.log("                      __                 __          ___ _                   \n		 			 / _\\ _   _ _ _     / /  ___    / __\ | __  _   _  __ _ _ __   \n					 \\ \| | | | '_ \\    / /  / _\\ \  / /   |'_ \| | | | / _` | '_  \\  \n				 	 _\\ \ |_| | | | |  / /__ | __/ / /___ | | | | |_| |( _ | | | |   \n					 \\__/\__,_|_| |_|  \\____/\\___| \\____/ |_| |_|\__,_ |\__,_|_| |_| ");
			var i = 1;
			setInterval(function(){
				i++;
				if(i>=3){
					i=1;
				}
				var objImg=document.getElementById("i1");
				objImg.src="img/bg"+i+".jpg";
				
			},3000);
		})
	</script>
</html>

