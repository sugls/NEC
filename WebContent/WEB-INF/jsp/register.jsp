<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NEC酒店管理服务系统</title>
    <style>
        .input-error{
            border: #ff3a36 solid 1px;
        }
    </style>
</head>
<body>
<s:if test="#session.employee == null">
    <div class="container">
</s:if>
    <div class="panel panel-primary">
            <div class="panel-heading">员工注册</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-6 col-md-offset-2">
                        <div class="col-md-offset-4">
                        <s:if test="#request.message!=null">
                        	<div class="alert alert-info" role="alert"><s:property value="#request.message"/></div>
                        </s:if>
                        <div class="alert alert-warning" role="alert">此页面供新员工注册登录账号，员工编号请联系管理员获取。</div>
                        </div>
                        <form action="register" method="post" class="form-horizontal">
                           

                            <div class="form-group">
                                <label for="employeeid" class="col-md-4 control-label">员工编号</label>
                                <div class="col-md-7">
                                    <input type="text" class="form-control" id="employeeid" name="user.employeeid">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="postname" class="col-md-4 control-label">角色</label>
                                <div class="col-md-7">
                                    <input type="text" class="form-control" id="postname" name="user.postname" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="username" class="col-md-4 control-label">用户名</label>
                                <div class="col-md-7">
                                    <input type="text" class="form-control" name="user.username" id="username">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-md-4 control-label">密码</label>
                                <div class="col-md-7">
                                    <input type="password" class="form-control" name="user.userpwd" id="password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="confirm" class="col-md-4 control-label">确认密码</label>
                                <div class="col-md-7">
                                    <input type="password" class="form-control" name="confirm" id="confirm">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-3 col-md-offset-5">
                                    <button class="btn btn-primary form-control disabled" style="color: #fff;background-color: #337ab7;border-color: #2e6da4;" disabled  type="submit" onclick="return submit()">注册</button>
                                </div>
                                <div class="col-md-3">
                                    <button class="btn btn-warning form-control" type="reset">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
    </div>
<s:if test="#session.employee == null">
    </div>
</s:if>
<div class="modal fade" tabindex="-1" id="alertModal" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <a class="close" data-dismiss="modal">×</a>
                <h4 class="modal-title">警告信息</h4>
            </div>
            <div class="modal-body">
                <p>该员工编号为管理员权限，只有管理员权限才能注册管理员，注册管理员请先登录。</p>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn btn-primary" data-dismiss="modal">确定</a>
            </div>

        </div>
    </div>
</div>
<script>



    $(document).ready(function () {


//        $("button[type='submit']").addClass("disabled");


        $('form').find('input[type="text"], input[type="password"]').each(function(){

                $(this).on('blur',function () {
//                    console.log(checkEmpid($("#employeeid")));
//                    console.log(checkUsername($("#username")));
//                    console.log(checkPwd($("#password")));
//                    console.log(checkConfirm($("#confirm")));
                    $('form').find('input[type="text"], input[type="password"]').each(function () {
                    	
                    	$(this).nextAll('.tips').remove();
                    	$(this).parent().nextAll('.fa').remove();
                    });
                    
                    
                    if (checkEmpid($("#employeeid")) & checkUsername($("#username")) & checkPwd($("#password")) & checkConfirm($("#confirm"))){
                        $("button[type='submit']").removeAttr("disabled").removeClass("disabled");

                    }

                });

//            $(this).on('focus',function () {
//                $(this).next().remove();
//            });

        });
        
        
        $("button[type='reset']").on('click',function(){
        	$(".tips").remove();
    		$(".fa-check-circle").remove();
    		$(".fa-times-circle").remove();
        });
        
        
    });


    function checkEmpid(o) {
        var result;
        if (o.val().trim()==""){
            o.after($('<div class="alert alert-danger tips"><i class="fa fa-exclamation-triangle"></i></div>').text($('label[for='+o.attr('id')+']').html() + '不能为空'));
            
                o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
            
            result =  false;
            return result;
        }else {
            var checkNum = /^[0-9]+$/;
            if (!checkNum.test(o.val())){
               
                    o.after($('<div class="alert alert-danger tips"></div>').text('员工编号只包含数字！'));
                
                
                	o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
                
                result =  false;
                return result;
            } else {
                $.ajax({
                    type:"post",
                    url:"checkUser?employeeid="+o.val(),
    
                    dataType:"json",
                    async:false,
                    cache:false,
                    success:function (data) {
                        var d = eval("("+data+")");
                        if (d.message != "ok"){
                        	$("#postname").val("");
                        	
                                o.after($('<div class="alert alert-danger tips"></div>').text(d.message));
                                $("#postname").parent().next('i').remove();

                                o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
                      
                                
                            result =  false;
                        } else {
                            if (d.postname == "管理员"){
                            	if ('${sessionScope.employee.postname}'!='管理员'){
                            		 $("#alertModal").modal();
                                     $("#postname").val("");
                              
                                         o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
                               
                                     result =  false;
                            	} else{
                            		$("#postname").val(d.postname);
                            		 o.parent().after($('<i class="fa fa-check-circle fa-2x" style="color: green"></i>'));
                            		 $("#postname").parent().after($('<i class="fa fa-check-circle fa-2x" style="color: green"></i>'));
                            		result = true;
                            	}
                               
                            } else {
                                $("#postname").val(d.postname);
                              
                                    o.parent().after($('<i class="fa fa-check-circle fa-2x" style="color: green"></i>'));
                                
                                if ($("#postname").val()!=""){
                                   
                                        $("#postname").parent().after($('<i class="fa fa-check-circle fa-2x" style="color: green"></i>'));
                                    
                                }
                                
                                result = true;
                            }
                        }
                    }
                });
                return result;
            }
        }


    }

    function checkUsername(o) {
        var result;
        if (o.val().trim()==""){
            o.after($('<div class="alert alert-danger tips"></div>').text($('label[for='+o.attr('id')+']').html() + '不能为空'));
            o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
            result = false;
            
            return result;
        } else {
            var checkUsername = /^[a-zA-Z0-9]+$/;
            if (!checkUsername.test(o.val())){
                o.after($('<div class="alert alert-danger tips"></div>').text('用户名只能为字母和数字组合'));
                o.parent().after($('<i class="fa fa-times-circle fa-2x" style="color: #ff5b0c"></i>'));
                result = false;
                return result;
            } else {
                  $.ajax({
                    type:"post",
                    url:"checkUsername?username="+o.val(),
                    dataType:"json",
                      async:false,
                      cache:false,
                    success:function (data) {
                        var d = eval("("+data+")");
                        if (d.message != "ok"){
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