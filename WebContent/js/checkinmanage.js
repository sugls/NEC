//身份证验证异步处理
function checkIdcard(){
	var idcard = $("#idcard").val();
	var checkresult = $("#checkresult");
	if(idcard == ""){
		checkresult.html("身份证号不能为空");
		$("#idcard").focus();
	}else{
		$.get("checkidcard?idcard="+idcard,null,callback);
	}
}
function callback(data){
	var checkresult = $("#checkresult");
	checkresult.html(data);
}

//客户信息添加
function check(){
	if($("#customername").val() == ""){
		window.alert("客户姓名不能为空！");
		return false;
	}else if($("#idcard").val() == ""){
		window.alert("身份证号不能为空！");
		return false;
	}else{
		return true;
	}
}