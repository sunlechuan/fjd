//编写标题复选框点击事件绑定的函数
function checkStatus(obj){
	//1获取标题的复选框
	//方式1：根据id来获取复选框
	//方式2：通过传递this，
	//obj.checked 表示复选框选中的状态
   //2获取到复选框的状态
   var f=obj.checked;
   //3获取其他的所有的复选框
   var objcheckboxs=document.getElementsByClassName("items");
   //4.循环遍历这个集合（数组）
   for(var i=0;i<objcheckboxs.length;i++){
   	//5设置每一个复选框的状态checked的值等于标题复选框的状态
   	objcheckboxs[i].checked=f;
   }
}
