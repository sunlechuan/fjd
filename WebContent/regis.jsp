<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.11.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/regisServlet" method="post" onsubmit="return check();">
			用户名<input type="text" name="username" id="username" onblur="getu()"/><span id="repu" style="display:none">用户名重复</span><br/>
			密码<input type="password" id="password" name="password"><br/>
			再次输入密码<input type="password" id="agapassword" name="agapassword"><br/>
			姓名<input type="text" id="name" name="name"><br/>
			电话<input type="text" id="phone" name="phone"><br/>
			<input type="submit" value="注册">
		</form>
</body>

<script type="text/javascript">
	function getu(){
		var f = false;
		var username = $("#username").val();
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/getuServlet",
			data:{"username":username},
			cache : false,
			success : function(data) {
				if(data == "success"){
					$("#repu").css("display","none");
					f = true;
					return f;
				}else{
					$("#repu").css("display","inline");
					return f;
				}
			},error:function(){
				alert("请求错误");
				return f;
			}
		});
	}
</script>
<script type="text/javascript">
	function check(){
		var username = $("#username").val();
		var password = $("#password").val();
		var agapassword = $("#agapassword").val();
		var name = $("#name").val();
		var phone = $("phone").val();
		if(username=='' || password=='' || name=='' || phone=='' || password!=agapassword){
			return false;
		}else{
			return true;
		}
	}
</script>
</html>