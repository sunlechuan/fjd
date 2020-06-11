//页面加载完成后
	onload=function(){
		//js 自动执行一个函数
		//bom:window
		//定时器 定时执行一段代码
		var id=window.setInterval(change,3000);
	}
	//每隔3s切换图片
	var i=1;
	function change(){
		i++;
		//获取图片标签
		var objImg=document.getElementById("i1");
		//动态修改图片的src的值
		objImg.src="img/bg"+i+".jpg";
		if(i>=3){
			i=0;
		}
	}
	//关闭广告
	function closeGD(){
		//点击图片，动态关闭 div
		var objDiv=document.getElementById("d2");
		//动态关闭div
		objDiv.style.display="none";
	}
	
	//搜索关键字的函数
	function search(){
		//1获取关键字的标签对象
		var txtsearchOBJ=document.getElementById("txtwd");
	    //2获取关键字内容
	    var wd=txtsearchOBJ.value;
	    //3发送这个关键字给服务器
	    document.write(wd);
	    //4响应
	}
	
	$(function(){
		console.log("                      __                 __          ___ _                   \n		 			 / _\\ _   _ _ _     / /  ___    / __\ | __  _   _  __ _ _ __   \n					 \\ \| | | | '_ \\    / /  / _\\ \  / /   |'_ \| | | | / _` | '_  \\  \n				 	 _\\ \ |_| | | | |  / /__ | __/ / /___ | | | | |_| |( _ | | | |   \n					 \\__/\__,_|_| |_|  \\____/\\___| \\____/ |_| |_|\__,_ |\__,_|_| |_| ");
	})