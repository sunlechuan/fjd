<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品分页</title>
		<link rel="stylesheet" href="css/mobile.css" />
		<link rel="stylesheet" href="css/index.css" />
		<script src="js/jquery-1.11.0.js"></script>
		
		
		<script type="text/javascript">
			
		</script>
</head>
<body>

<input type="hidden" id="currPage" value = "${dataPage[0].currPage}">
	<div>
			<!--
            	作者：offline
            	时间：2019-12-17
            	描述logo 搜索 
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
				商品列表
			-->
			
			<div class="p1" id="ee">
			<c:forEach items="${data}" var="var">
				<div>
				<div id="ee2">
					<a id ="hh" href="detailServlet?pid=${var.pid}">
						<img src="img/1.jpg">
					</a>
					
					<p>￥ ${var.pprice }</p>
					<p>${var.pname }</p>
					<p>${var.pspec }</p>
					<p>已有<a href="#">23万+</a>人评价</p>
					</div>
				</div>
			</c:forEach>
				
			</div>
			<div style="clear:both"></div>
			<div style="text-align: right;margin-bottom:10px;margin-right: 100px;margin-top:20px">
				<a href="#" id="sy" onclick="sy()">上一页</a>
				<span id="djy"></span>
				<a href="#" id="xy" onclick="xy()">下一页</a>
				共${dataPage[0].totalCount }条数据 &nbsp;  共${dataPage[0].totalPage }页 &nbsp;
				当前页：${dataPage[0].currPage}
			</div>
			<!--
				猜你喜欢
			-->
			
			<!--
				广告
				
			-->
			<div>
				<img src="img/pgd.png" width="100%" />
			</div>
			<!--
				售后服务
			-->
			<div style="margin-left: 120px;">
				<img src="img/foot.jpg" />
				<img src="img/link.jpg" />
			</div>
		</div>
</body>
<script type="text/javascript">
	$(function(){
		var cid = getParams("cid");
		var totalPage = ${dataPage[0].totalPage };
		for(var i=1;i<=totalPage;i++){
			var div = '<a href = "';
			var hr = 'flp2?currPage=';
			var hr2 = '&cid=';
			var div2 = '">';
			var div3 = '</a>';
			$("#djy").append(div + hr + i + hr2 + cid + div2 + i + div3);
		}
	})
		
		
</script>
<script type="text/javascript">
/*上一页*/
function sy(){
	var currPage = $("#currPage").val();
	var cid = getParams("cid");
	if(currPage == 1){
		
	}else{
		currPage = currPage-1;
		$("#currPage").val(currPage);
		document.getElementById("sy").href = "flp2?currPage="+ currPage + "&cid=" + cid;
	}
	
	
}
</script>
<script type="text/javascript">
/* 下一页 */
function xy(){
	var currPage =parseInt($("#currPage").val())  + 1;

	var totalPage = ${dataPage[0].totalPage};
	var cid = getParams("cid");
	
	if(currPage<=totalPage){
		$("#currPage").val(currPage);
		document.getElementById("xy").href = "flp2?currPage="+ currPage + "&cid=" + cid;
		
	}
	
	
}

/*获取get参数*/
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

/**
 * $.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath}/flp2",
		data:{currPage:currPage,cid:cid},
		cache : false,
		dataType:"json",
		success : function(data) {
			
			$("#ee").empty();
			var div1 = '<div id="ee2"><a id ="hh" href=""><img src="mobile/2.jpg" onclick=(';
			var div2 = ')"></a><p>';
			var div3 = '</p><p>';
			var div4 = '</p><p>';
			var div5 = '</p></div>';
			$.each(data,function(index,item){
			 console.log(data);
			 $("#ee").append(div1+item.pid+div2+item.pprice+div3+item.pname+div4+item.pspec+div5);
			})
		},error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("请求错误");

		}
	});
 */
</script>
</html>