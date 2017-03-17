<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NEC酒店管理服务系统</title>
</head>
<body>


            <div class="panel panel-primary">
                <div class="panel-heading">修改员工信息</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-1">
                       
                        
                            <form id="myForm" class="form-horizontal">
								
								
								<div class="form-group">
                                    <label for="employeeid" class="col-md-4 control-label">员工编号</label>
                                    <div class="col-md-7">
                                        <input data-trigger="focus"  data-toggle="popover" data-placement="top" data-content="员工编号不可更改。"	
                                         type="text" class="form-control" id="employeeid" name="emp.employeeid" readonly value='<s:property value="#request.employee.employeeid"/>'/>
                                    </div>
                                </div>
                               
								<div class="form-group">
                                    <label for="postname" class="col-md-4 control-label">员工角色</label>
                                    <div class="col-md-7">
                                        <select name="emp.postname" id="postname" class="form-control" >
                                        	<option value="RP">前台接待</option>
                                        	<option value="CS">收银员</option>
                                        	<option value="RM">房管员</option>
                                        	<option value="AD">管理员</option>
                                        </select>
                                    </div>
                                </div>
								
                                <div class="form-group">
                                    <label for="realname" class="col-md-4 control-label">真实姓名</label>
                                    <div class="col-md-7">
                                        <input type="text" name="emp.realname" class="form-control" id="realname" value='<s:property value="#request.employee.realname"/>' 
                                       data-trigger="focus"  data-toggle="popover" data-placement="top" data-content="请输入2~7位中文真实姓名。"
                                        >
                                    </div>
                                </div>
                               
                                <div class="form-group">
                                    <label for="sex" class="col-md-4 control-label">性别</label>
                                    <div class="col-md-7" id="sex">
                                        
                                        <s:if test='#request.employee.sex == "男"'>
                                        <label class="radio-inline">
                                          <input type="radio" class="radio-group-item" name="emp.sex" checked  value="1">男
                                          </label>
                                          <label class="radio-inline">
                                            <input type="radio" class="radio-group-item" name="emp.sex"  value="0">女
                                       </label>
                                        </s:if>
                                          <s:if test='#request.employee.sex == "女"'>
                                          <label class="radio-inline">
                                           <input type="radio" class="radio-group-item" name="emp.sex"   value="1">男
                                          </label> <label class="radio-inline">
                                            <input type="radio" class="radio-group-item" name="emp.sex" checked  value="0">女                                      
                                          </label></s:if>
                                           <s:if test='#request.employee.sex == ""'>
                                           <label class="radio-inline">
                                           <input type="radio" class="radio-group-item" name="emp.sex"   value="1">男
                                           </label><label class="radio-inline">
                                            <input type="radio" class="radio-group-item" name="emp.sex" checked  value="0">女                                      
                                         </label>
                                          </s:if>
                                     
                                    </div>
                                </div>
                              
                                <div class="form-group">
                                    <label for="phone"  class="col-md-4 control-label">联系电话</label>
                                    <div class="col-md-7">
                                        <input 
                                        data-trigger="focus"  data-toggle="popover" data-placement="top" data-content="非必填！输入正确的电话号码。"
                                        type="text" class="form-control" id="phone" name="emp.phone" value='<s:property value="#request.employee.phone"/>'>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="username"  class="col-md-4 control-label">用户名</label>
                                    <div class="col-md-7">
                                        <input
                                          data-trigger="focus"  data-toggle="popover" data-placement="top" data-content="请输入包含字母或数字的用户名"
                                         type="text" class="form-control" id="username" name="emp.username" value='<s:property value="#request.employee.username"/>'>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="password"  class="col-md-4 control-label">密码</label>
                                    <div class="col-md-7">
                                        <input   data-trigger="focus"  data-toggle="popover" data-placement="top" data-content="请输入8位及以上字母或数字密码"
                                        type="password" class="form-control" id="password" name="emp.userpwd">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="confirm"  class="col-md-4 control-label">确认密码</label>
                                    <div class="col-md-7">
                                        <input type="password" class="form-control" id="confirm" name="">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-md-5 col-md-offset-2">
                                        <button id="submit" class="btn btn-primary form-control" style="color: #fff;background-color: #337ab7;border-color: #2e6da4;" disabled type="button">修改</button>
                                    </div>
                                    <div class="col-md-5">
                                        <button class="btn btn-warning form-control" type="reset">重置</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
            
     <div class="modal fade" tabindex="-1" id="alertModal" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <a class="close" data-dismiss="modal">×</a>
                <h4 class="modal-title">警告信息</h4>
            </div>
            <div class="modal-body">
                <p>只有管理员权限才能修改用户角色！</p>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn btn-primary" data-dismiss="modal">确定</a>
            </div>

        </div>
    </div>
    </div>       
    
    
    
    
    
    <div class="modal fade" tabindex="-1" id="showMessage" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <a class="close" data-dismiss="modal">&times;</a>
                <h4 class="modal-title">提示信息</h4>
            </div>
            <div class="modal-body">
                <p id="message"></p>
            </div>
            <div class="modal-footer">
                <a href="showUser" class="btn btn-primary"  >确认</a>
            </div>

        </div>
    </div>
    </div>       
            
            
            <script>

            
            
            
            
           
            
            
            


    $(document).ready(function () {
    	
    	
    	 $("#submit").on('click',function(){
        	 $.ajax({
                 type:"POST",
                 url:"updateEmps",
                 data:$("#myForm").serialize(),
                 dataType:"json",
                 async: false,
                 cache: true,
                 success:function (result) {
                     var d = eval("("+result+")");  
                     console.log($("#message"));
                     $("#message").text(d.message);
                     console.log($("#showMessage"));
                     $("#showMessage").modal();
                 }
             });
        });
    	
    	



    	

    	 $('[data-toggle="popover"]').popover();
    	 
    	 $('[data-toggle="tooltip"]').tooltip();

    	


        $('form').find('input[type="text"], input[type="password"]').each(function(){

                $(this).on('blur',function () {

                    $('form').find('input[type="text"], input[type="password"]').each(function () {
                    	$(this).nextAll('.tips').remove();
                    	$(this).parent().nextAll('.fa').remove();
                    });
                    
                    
                    if (checkRealname($("#realname")) & checkPhone($("#phone")) & checkUsername($("#username")) & checkPwd($("#password")) & checkConfirm($("#confirm"))){
                        $("#submit").removeAttr("disabled").removeClass("disabled");

                    }

                });


        });
        
        
        $("button[type='reset']").on('click',function(){
        	$("form").find('input[type="text"], input[type="password"]').each(function(){
        		$(".tips").remove();
        		$(".fa-check-circle").remove();
        		$(".fa-times-circle").remove();
        	});
        });
        
       $("#postname").val("${employee.postname}");
		

    	$("#postname").on('change',function(){
            if ("${sessionScope.employee.postname}" != '管理员'){
           	$("#alertModal").modal();
           	$("#postname").val("${employee.postname}");
            }
        });
       
        
    });


   
    
    
    
    
    var oldval = $("#username").val();
    function checkUsername(o) {
    	
        var result;
        if (o.val().trim()==""){
        	o.parent().next(".tips").remove();
            o.after($('<div class="alert alert-danger tips"></div>').text($('label[for='+o.attr('id')+']').html() + '不能为空'));
            o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
            result = false;
            return result;
            
        } else if(o.val().trim() == oldval){
       	 o.parent().after($('<i class="fa fa-check-circle fa-2x" style="color: green"></i>'));
        	return true;
        } else {
            var checkUsername = /^[a-zA-Z0-9]+$/;
            if (!checkUsername.test(o.val())){
            	o.parent().next(".tips").remove();
                o.after($('<div class="alert alert-danger tips"></div>').text('用户名只能为字母和数字组合'));
                o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
                result = false;
                return result;
            } else {
                  $.ajax({
                    type:"post",
                    url:"checkUsername?username="+o.val()+"&employeeid="+$("#employeeid").val(),
                    dataType:"json",
                      async:false,
                      cache:false,
                    success:function (data) {
                        var d = eval("("+data+")");
                        if (d.message != "ok"){
                        	o.parent().next(".tips").remove();
                            o.after($('<div class="alert alert-danger tips"></div>').text(d.message));
                            o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
                            result = false;
                        } else {
                        	 o.parent().after($('<i class="fa fa-check-circle fa-2x" style="color: green"></i>'));
                            result = true;
                        }
                    }
                });
                return result;
            }
        }

    }
	
    
    
    function checkPhone(o){
    	if(o.val().trim()==""){
    		 
    		return true;
    	} else{
    		var checkPhone = /^\d{7,}$/;
        	if (!checkPhone.test(o.val().trim())){
        		o.parent().next(".tips").remove();
        		o.after($('<div class="alert alert-danger tips"></div>').text('请输入有效的电话号码！'));
        		 o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
                return false;
        	} else{
        		 o.parent().after($('<i class="fa fa-check-circle fa-2x" style="color: green"></i>'));
        		return true;
        	}
    	}
    }
    
    function checkRealname(o) {
        if (o.val().trim()==""){
        	
            o.after($('<div class="alert alert-danger tips"></div>').text($('label[for='+o.attr('id')+']').html() + '不能为空'));
            o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
            return false;
        } else {
            var checkname = /^([\u4e00-\u9fa5]){2,7}$/;     
            if (!checkname.test(o.val())){
            	
                o.after($('<div class="alert alert-danger tips"></div>').text('请输入2~7位中文姓名！'));
                o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
                return false;
            }
            o.parent().after($('<i class="fa fa-check-circle fa-2x" style="color: green"></i>'));
            return true;
        }
    }
    
    
    function checkPwd(o) {
        if (o.val().trim()==""){
        	
            o.after($('<div class="alert alert-danger tips"></div>').text($('label[for='+o.attr('id')+']').html() + '不能为空'));
            o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
            return false;
        } else {
            var checkpwd = /^[a-zA-Z0-9]{8,}$/;
            if (!checkpwd.test(o.val())){
            	
                o.after($('<div class="alert alert-danger tips"></div>').text('密码为8位以上字母数字组合！'));
                o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
                return false;
            }
            o.parent().after($('<i class="fa fa-check-circle fa-2x" style="color: green"></i>'));
            return true;
        }
    }

    function checkConfirm(o) {
        if (o.val().trim()==""){
        	
            o.after($('<div class="alert alert-danger tips"></div>').text($('label[for='+o.attr('id')+']').html() + '不能为空'));
            o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
            return false;
        } else {
            if (o.val() != $("#password").val()){
            	
                o.after($('<div class="alert alert-danger tips"></div>').text('两次密码不相同！'));
                o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
                return false;
            } else {
            	 o.parent().after($('<i class="fa fa-check-circle fa-2x" style="color: green"></i>'));
                return true;
            }
        }
    }


</script>
            
            
            
            
            
            
            
            
            
</body>
</html>