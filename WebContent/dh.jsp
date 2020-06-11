<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>

<script type="text/javascript">
	onload=function(){
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/cateServlet",
			success : function(data) {
			    obj= $.parseJSON(data);//转化为对应js对象
			    console.log(obj);
					 $.each(obj,function(index,item){
						 var div1 = '<a';
						 var div2 = '>';
						 var div3 = '<font style="color: #666699;padding:10px" onclick="tz(';
						 var div5 = ')">';
						 var div4 = '</font></a>';
						 var div6 = "'";
						 var div7 = "'";
						 $("#navicate").append(div1+div2+div3+div6+item.cname+div7+div5+item.cname+div4);
		            })
			},
		});
		
		
	}
	</script>
    </head>
<body>
			<div id="navicate" >			
            </div>
            <br />
 <hr style="border:1px solid red"/>
</body>

<script type="text/javascript">
	function tz(cname){
		
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/fenyeServlet",
			data:{"cname":cname},
			success : function(data) {
				obj= $.parseJSON(data);//转化为对应js对象
				console.log(data);
				var cid = obj[0].cid;
				window.location.href="${pageContext.request.contextPath}/flproductServlet?cid=" + cid;
			},error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("请求错误");

			}
		});
		
	}
 
 </script>
 </html>
 
 