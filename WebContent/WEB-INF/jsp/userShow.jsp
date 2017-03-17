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
                <div class="panel-heading">
                    用户列表
                </div>
                <div class="panel-body">
                <s:if test="#request.emplist.size() > 0">
                
                	 <table class="table">
                        <tr>
                        <th>员工编号</th><th>员工姓名</th><th>用户名</th><th>性别</th><th>联系电话</th><th>更新</th><th>删除</th>
                        </tr>
                        <s:iterator value="#request.emplist" var="emp">
                        <tr>
                            
							<td id='<s:property value="#emp.employeeid"/>'><s:property value="#emp.employeeid"/> </td>
                            <td><s:property value="#emp.realname"/> <s:if test="#session.employee.employeeid == #emp.employeeid">  &nbsp;<i class="fa fa-bell"></i></s:if> </td>
                            <td><s:property value="#emp.username"/></td>
                            <td><s:property value="#emp.sex"/></td>
                            <td><s:property value="#emp.phone"/></td>
                            <td><button class="btn btn-info"  
                            <s:if test="#session.employee.employeeid == #emp.employeeid"> onclick="location.href='updateUser?employeeid=<s:property value="#emp.employeeid"/>'" </s:if>
                           <s:else> onclick="location.href='adUpdateUser?employeeid=<s:property value="#emp.employeeid"/>' </s:else> ">更新</button></td>
                            <td>
                                <a class="btn btn-warning" data-toggle="modal" onclick="$('#del').attr('name', 'deleteEmps?employeeid=' + $(this).parent().parent().children('td').eq(0).html())" data-backdrop="false" href="#myModal"> <i class="glyphicon glyphicon-trash"></i> 删除</a>
                            </td>
                        </tr>
                        </s:iterator>
                        
                    </table>
                    
                    <nav>
					  <ul class="pager">
					    <li><button class="btn btn-default"  <s:if test="#request.pages == 1"> disabled  </s:if> onclick="location.href='showUser?pages=${pages-1}'">上一页</button></li>
					    <li><button class="btn btn-default" <s:if test="#request.pages == #session.totalpages"> disabled </s:if>  onclick="location.href='showUser?pages=${pages+1}'">下一页</button></li>
					    <li><span id="page"><s:property value="#request.pages"/> / <s:property value="#session.totalpages"/></span></li>
					  </ul>
					</nav>
                
                </s:if>
                </div>
            </div>
            



<div class="modal fade" tabindex="-1" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <a class="close" data-dismiss="modal">&times;</a>
                <h4 class="modal-title">删除确认</h4>
            </div>
            <div class="modal-body">
                <p>确认删除该用户吗？</p>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn" data-dismiss="modal">关闭</a>
                <a id="del" class="btn btn-primary" data-dismiss="modal">确认删除</a>
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
                <a href="#" class="btn btn-primary" data-dismiss="modal">确认</a>
            </div>

        </div>
    </div>
    </div>       
    
    <script type="text/javascript">
    $("#del").on('click',function(){
        var str = $(this).attr("name");
   	 $.ajax({
            type:"POST",
            url:str,
            dataType:"json",
            async: false,
            cache: true,
            success:function (result) {
                var d = eval("("+result+")");
                $("#message").text(d.message);
                $("#showMessage").modal();
                $('#'+str.substring(str.indexOf("employeeid=")+11)).parent().remove();
                console.log(d.pages +'/'+ d.totalpages);
                $("#page").text(d.pages +'/'+ d.totalpages);
            }
        });
   });
	
    </script>

</body>
</html>