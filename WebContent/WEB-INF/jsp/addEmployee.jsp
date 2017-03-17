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
                <div class="panel-heading">添加员工信息</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-1">
                        <s:if test="#request.message != null">
                        <div class="alert alert-info col-md-offset-4">   
	                        <button type="button" class="close" data-dismiss="alert">
							  <span>&times;</span>
							</button>
	                        	<s:property value="#request.message"/>
	                        </div>
                        </s:if>
                        
                            <form action="addEmployee" method="post" class="form-horizontal">
								
								<s:token/>
								<div class="form-group">
                                    <label for="employeeid" class="col-md-4 control-label">员工编号</label>
                                    <div class="col-md-8">
                                        <input data-trigger="focus"
                                        name="employee.employeeid"  data-toggle="popover" data-placement="top" data-content="员工编号自动生成。"	
                                         type="text" class="form-control" id="employeeid" readonly />
                                    </div>
                                </div>
                               
								<div class="form-group">
                                    <label for="postname" class="col-md-4 control-label">员工角色</label>
                                    <div class="col-md-8">
                                        <select name="employee.postname" id="postname" class="form-control">
                                        	<option value="RP">前台接待</option>
                                        	<option value="CS">收银员</option>
                                        	<option value="RM">房管员</option>
                                        	<option value="AD">管理员</option>
                                        </select>
                                    </div>
                                </div>
								
                                <div class="form-group">
                                    <label for="realname" class="col-md-4 control-label">真实姓名</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="employee.realname" id="realname"  
                                       data-trigger="focus"  data-toggle="popover" data-placement="top" data-content="请输入2~7位中文真实姓名。"
                                        >
                                    </div>
                                </div>
                               
                                <div class="form-group">
                                    <label for="sex" class="col-md-4 control-label">性别</label>
                                    <div class="col-md-8" id="sex">
                                        
                                        
                                           
                                           <label class="radio-inline">
                                           <input type="radio" class="radio-group-item" name="employee.sex" checked   value="1">男 <i class="fa fa-mars"></i>
                                           </label><label class="radio-inline">
                                            <input type="radio" class="radio-group-item" name="employee.sex"   value="0">女 <i class="fa fa-venus"></i>                            
                                         </label>
                                      
                                     
                                    </div>
                                </div>
                              
                                <div class="form-group">
                                    <label for="phone"  class="col-md-4 control-label">联系电话</label>
                                    <div class="col-md-8">
                                        <input 
                                        data-trigger="focus"  data-toggle="popover" data-placement="top" data-content="非必填！输入正确的电话号码。"
                                        type="text" class="form-control" id="phone" name="employee.phone">
                                    </div>
                                </div>
                                
                               
                                
                                <div class="form-group">
                                    <div class="col-md-5 col-md-offset-2">
                                        <button class="btn btn-primary form-control" style="color: #fff;background-color: #337ab7;border-color: #2e6da4;" disabled type="submit">添加</button>
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
            
            
   
            
            
            <script>



    $(document).ready(function () {
    	

    	 $('[data-toggle="popover"]').popover();
    	 
    	 $('[data-toggle="tooltip"]').tooltip();


        $('form').find('input[type="text"]').each(function(){
				
        	
                $(this).on('blur',function () {

                    $('form').find('input[type="text"]').each(function () {
                    	
                    		$(this).nextAll('.tips').remove();
                    	
                    });
                    
                    
                    if (checkEmpid($("#employeeid")) & checkRealname($("#realname"))){
                    	$("button[type='submit']").removeAttr("disabled");
                    	checkPhone($("#phone"));
                    	console.log($("#phone").nextAll('.tips').length != 0);
                    	if($("#phone").nextAll('.tips').length){
                    		$("button[type='submit']").attr("disabled",'disabled');
                    	}
                    }

                });


        });
        
        
        $("#employeeid").on('click',function getEmpid() {                                 
                $.get("getNextEmpId",null,function (data) {
                    $("#employeeid").val(data);
                });
        });
        
        
        $("button[type='reset']").on('click',function(){
        	$(".tips").remove();
        });
        
     
        
    });

    function checkEmpid(o){
    
    	if (o.val()==""){
    	
    		o.after($('<div class="alert alert-danger tips"></div>').html('<i class="fa fa-exclamation-triangle"></i>'+'用户编号不能为空，请点击输入框自动生成！'));
    		return false;
    	} else{
    		return true;
    	}
    	
    }


    function checkPhone(o){
    	 	if (o.val().trim()==""){
    	 		return true;
    	 	}
    		var checkPhone = /^\d{7,11}$/;
        	if (!checkPhone.test(o.val().trim())){
        		o.after($('<div class="alert alert-danger tips"></div>').html('<i class="fa fa-exclamation-triangle"></i>'+'  请输入有效的电话号码！'));
                return false;
        	} else{
        		return true;
        	}
    	
    }
    
    /* function checkPostname(o){
    	if(o.val()=="-1"){
    		o.after($('<div class="alert alert-danger tips"></div>').text('请选择角色！'));
    	}
    } */
    
    function checkRealname(o) {
        if (o.val().trim()==""){
            o.after($('<div class="alert alert-danger tips"></div>').html('<i class="fa fa-exclamation-triangle"></i>  '+$('label[for='+o.attr('id')+']').html() + '不能为空'));
            return false;
        } else {
            var checkname = /^([\u4e00-\u9fa5]){2,7}$/;     
            if (!checkname.test(o.val())){
                o.after($('<div class="alert alert-danger tips"></div>').html('<i class="fa fa-exclamation-triangle"></i>  '+'请输入2~7位中文姓名！'));
                return false;
            }
            return true;
        }
    }
                

</script>
            
            

            
</body>
</html>