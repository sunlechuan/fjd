<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/login.css" />
		<script type="text/javascript" src="js/login.js" ></script>
	</head>
	<body>
	${user }
		<hr style="margin-top: 100px;" />
		<div id="logind1">
			<!--
				背景图片
				
			-->
			<div class="logincls" style="border: 0px solid red;width: 600px;height: 400px;">
				<img src="img/loadimg.jpg" />
			</div>
			<!--
            	作者：offline
            	时间：2019-12-17
            	描述：--登陆表单
            -->
			<div style="border: 0px solid red;width: 400px;height: 400px;">
				<form action="${pageContext.request.contextPath}/LoginServlet" onsubmit="return check();" method="post">
						<h3 >1号店用户登录</h3>
						<div style="margin:0px;margin-bottom:10px;width:300px ;height: 46px;">
							<input id="uname" name="username" value="${user.username }" style="width:100%;height:40px" type="text" placeholder="用户名"  />
						</div>
						
				        <br />
				        <div style="margin:0px;margin-bottom:10px;width:300px ;height: 46px;">
							<input name="password" value="${user.password }" style="width:100%;height:40px" type="password" placeholder="密码" />
						</div>
						
					    <br />
					    <div style="text-align:center;padding-top:20px;margin:0px;background-color:#ff3c3c;width:300px ;height: 46px;">
					    	
					    	<input style="background-color: #ff3c3c;color: white;font-size:larger;border: 0px #ff3c3c solid;" type="submit" value="登陆" />
					         
					    </div>
					      
				</form>
			</div>
		</div>
	</body>
</html>
