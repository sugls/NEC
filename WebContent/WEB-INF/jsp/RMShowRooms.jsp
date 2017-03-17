<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NEC酒店管理服务系统</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    
</head>
<body>



            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">查询房间记录</div>
                    <form action="RMShowRooms" class="navbar-form" role="form" method="get">
                        <div class="form-group">
                            <div class="input-group">
                                <span for="condition" class="input-group-addon">查询条件</span>
                               
                                <select name="conditionid" id="condition" class="form-control">
                                    <option value="-1">--请选择--</option>                                 
                                    <option value="1" <s:if test='conditionid == "1"'>selected="selected"</s:if>>房间编号</option>
                                    <option value="2" <s:if test='conditionid == "2"'>selected="selected"</s:if>>房间位置</option>
                                    <option value="3" <s:if test='conditionid == "3"'>selected="selected"</s:if>>房间类型</option>
                                    <option value="4" <s:if test='conditionid == "4"'>selected="selected"</s:if>>状态</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group margin-bottom-sm">
                                <span for="keyword" class="input-group-addon">关键字：</span>
                              
                                <input class="form-control" type="text" placeholder="请输入查询关键字" id="keyword" name="condition"  value='<s:property value='condition'/>'>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">查询</button>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">房间信息列表</div>
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <th>房间编号</th><th>房间类型</th><th>房间位置</th><th>设备信息</th><th>房间状态</th><th>删除</th><th>修改</th>
                            </tr>
                            <s:iterator value="#request.roomqueries" var="roomqueries">
                            <tr>	
                                <td><s:property value="#roomqueries.roomid"/> </td>
                                <td><s:property value="#roomqueries.typename"/></td>
                                <td><s:property value="#roomqueries.locations"/></td>
                                <td><s:property value="#roomqueries.remark"/></td>
                                <td><s:property value="#roomqueries.status"/></td>
                                <td>
                                    <a  class="delete btn btn-warning <s:if test='#roomqueries.status != "空" '>disabled</s:if>" data-toggle="modal" data-backdrop="false" href="#myModal">删除</a>
                                </td>
                                <td>
                                    <a href="modifyRoom?reqonly=1&roomid=<s:property value="#roomqueries.roomid"/>" class="btn btn-info">修改</a>
                                </td>
                            </tr>
                            </s:iterator>                      
                        </table>
                        <nav aria-label="...">
						  <ul class="pager">
						    <li><a href="RMShowRooms?pages=${requestScope.pages-1}&conditionid=<s:property value="conditionid"/>&condition=<s:property value="condition"/> ">Previous</a></li>
						    <li><a href="RMShowRooms?pages=${requestScope.pages+1}&conditionid=<s:property value="conditionid"/>&condition=<s:property value="condition"/> ">Next</a></li>
						    <span class="col-md-offset-1">${requestScope.pages}/${requestScope.pageSize}页</span>
						  </ul>
						</nav>
						
                    </div>
                </div>
            </div>


<div class="modal fade" tabindex="-1" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <a class="close" data-dismiss="modal">×</a>
                <h4 class="modal-title">删除确认</h4>
            </div>
            <div class="modal-body">
                <p>确认删除该客房吗？</p>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn" data-dismiss="modal">取消</a>
                <a href="" class="btn btn-primary" id="delete">删除</a>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(
        function () {
            var $buttons = $(".delete");

            for(var i = 0; i < $buttons.length; i++){
                $buttons.eq(i).on('click', function () {
                    var $text = $(this).parent().parent().children().eq(0).html().trim()//获取客房编号
                    var $text2 = $("#conditionid").val()//获取条件编号
                    var $text3 = $("#keyword").val()//获取条件内容
                    $("#delete").attr("href", "deleteRoom?roomid=" + $text + "&conditionid=" + $text2 + "&condition=" + $text3);
                })
            }
        }
    )
    
</script>
</body>
</html>