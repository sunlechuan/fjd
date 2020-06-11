function check(){
	
	var f=true;
	//用户名如果为空，那么不允许提交
	//1获得用户名所在标签
	var usernameHTML=document.getElementById("uname");
	//2获取用户名的值
	var uvalue=usernameHTML.value;
	
	if(uvalue.length==0&&uvalue==''){
		f=false;
		alert("用户名不允许为空");
		return f;
	}
	//密码如果为空，那么不允许提交
	
	
	
	
	return f;
}
