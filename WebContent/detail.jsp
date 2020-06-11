<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
		<script src="js/jquery-1.11.0.js"></script>
		<link rel="stylesheet" href="css/mobile.css" />
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/detail.css" />
		<script type="text/javascript" src="js/datail.js" ></script>
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
				
			</div>
			<div style="clear:both"></div>
			<!--
			导航栏	
			-->
			<jsp:include page="/dh.jsp"></jsp:include>
			<!--
				商品详情介绍
				
			-->
			<div class="pdetail">
				<div class="pleft">
					<img src="mobile/pd1.jpg" />
				</div>
				<div class="pright">
					<p>
						<h4>
						商品名称：
						
						${data[0].pname }
					</h4>
					</p>
					<p style="font-size: 20px;">
						京 东 价
						${data[0].pprice }
					</p>
					
					
					<p style="font-size: 20px;">
						商家：${data[0].pshop }
					</p>
					
					<p style="font-size: 20px;">
						详细信息：${data[0].pspec }
					</p>
					<p style="font-size: 20px;">
						上架日期：${data[0].pdate }
					</p>
					<div style="border: 0px;">
						<input type="button" value="-" onclick="sub()">
						<input type="text" id="num1" value="1"/>
						<input type="button" onclick="add()" value="+" >
					</div>
					<div style="clear:both"></div>
					<div style="border: 0px;margin-top: 10px;margin-left: 23px;">
						<a href="#" id="goCart" onclick="goCart()">
							<img src="img/j_car.png" width="173px"/>
						</a>
					</div>
					　

				</div>
			</div>
			<div style="clear: both;"></div>
			<div>
				<hr style="border:1px solid red"/>
			</div>
			
			<!--
				商品介绍
			-->
			<div class="pdetail">
				<div class="pdleft" >
					达人选购
				</div>
				<div class="pdright">
					<p>
						品牌： 华为（HUAWEI）
					</p>
					<p>
						商品名称：华为荣耀畅玩8C商品编号：100000826642
						商品毛重：167.00g商品产地：中国大陆
					</p>
					<p>
						CPU型号：其他运行内存：4GB机身存储：32GB存储卡：支持MicroSD(TF)
					</p>
					<p>
						电池容量（mAh）：4000mAh（典型值） 3900mAh（最小值）充电器：5V/2A机身颜色：极光蓝操作系统：Android(安卓)
					</p>
					<img src="mobile/pdd.jpg" />
				</div>
			</div>
			<div style="clear: both;"></div>
			<div>
				<hr />
					<h1>商品评价</h1>
					<input id="ccontext" type="text">
					<input type="button" onclick="context()" value="我要评论">
				</div>
				<div>
					<table id="t1">
						<tr>
							<td>用户名</td>
							<td>评论内容</td>
							<td>评论时间</td>
						</tr>
						<tr>
							<td>s***8</td>
							<td>运行速度快，一点都不卡，玩游戏也ok。人脸识别和指纹识别率很高</td>
							<td>2019-06-21 14:07</td>
						</tr>
						<tr>
							<td>s***9</td>
							<td>还凑合吧，总体来说还是挺满意的</td>
							<td>2019-06-20 14:07</td>
						</tr>
						<tr>
							<td></td>
						</tr>
					</table>
					<hr />
				</div>
				<div style="margin-left: 120px;">
				<img src="img/foot.jpg" />
				<img src="img/link.jpg" />
			    </div>
		</div>
</body>
<script type="text/javascript">
//减少商品购买数量
function sub(){
	//1 获取intput 对象
	var obj=document.getElementById("num1");
	//2 获取value
	var n1=obj.value;
	//3 自增 value
	n1--;
	if(n1 == 0){
		n1 = 1;
	}
	//4 重新设置value
	obj.value=n1;
}
</script>
<script type="text/javascript">
	function goCart(){
		var pid = getParams("pid");
		var num1 = $("#num1").val();
		var href = "${pageContext.request.contextPath}/buyServlet?pid=" + pid + "&num="+num1;
		$("#goCart").attr("href",href);
	}
	
	function getParams(key){
	    var url = location.search.replace(/^\?/,'').split('&');
	    var paramsObj = {};
	    for(var i = 0, iLen = url.length; i < iLen; i++){
	        var param = url[i].split('=');
	        paramsObj[param[0]] = param[1];
	    }
	    if(key){
	        return paramsObj[key] || '';
	    }
	    return paramsObj;
	}
	
</script>
</html>