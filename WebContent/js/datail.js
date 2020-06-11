function context(){
	//获取输入的文本的内容
	var context=document.getElementById("ccontext");
	//获取得评论的表格
	var tb=document.getElementById("t1");
	//通过表格动态创建一行
	var tbRow=tb.insertRow(1);
	//通过行对象创建列对象
	var tbc1=tbRow.insertCell(0);
	//动态设置列标签元素的标签体的内容
	tbc1.innerHTML="s10";
	var tbc2=tbRow.insertCell(1);
	tbc2.innerHTML=context.value;
	var tbc3=tbRow.insertCell(2);
	tbc3.innerHTML=new Date();
	//发送请求到servlet
	//sends(tbc1,tbc2,tbc3);
}
function sends(tbc1,tbc2,tbc3){
	//数据库保存。
	var str=tbc1.innerHTML+tbc2.innerHTML+tbc3.innerHTML;
	//发送请求给后台servlet
	//bom对象发送请求
	window.location.href="url?str="+str;
}

//增加商品购买数量
function add(){
	//1 获取intput 对象
	var obj=document.getElementById("num1");
	//2 获取value
	var n1=obj.value;
	//3 自增 value
	n1++;
	alert(n1);
	//4 重新设置value
	obj.value=n1;
}

//减少商品购买数量
function sub(){
	//1 获取intput 对象
	var obj=document.getElementById("num1");
	//2 获取value
	var n1=obj.value;
	//3 自增 value
	n1--;
	alert(n1);
	//4 重新设置value
	obj.value=n1;
}
