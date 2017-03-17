<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NEC酒店管理服务系统</title>
</head>
<body>



            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">查询预订记录</div>
                    <form action="showOrders" class="navbar-form" role="form" method="post">
                        <div class="form-group">
                            <div class="input-group margin-bottom-sm">
                                <span for="customername" class="input-group-addon">客户姓名：</span>
                              
                                <input value="<s:property value="order.customername"/>" class="form-control" type="text" placeholder="请输入客户姓名" id="customername" name="order.customername">
                            </div>
                            <div class="input-group">
                                <span for="orderdate" class="input-group-addon">预定日期：</span>
                  
                                <input value="<s:property value="order.orderdate"/>" class="form-control" type="date" id="orderdate" name="order.orderdate">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">查询</button>
                    </form>
                </div>
            </div>
            <div class="row">
            <div class="panel panel-primary">
                <div class="panel-heading">预订列表</div>
                <div class="panel-body">
                    <table class="table">
                        <tr>
                            <th>预订编号</th><th>预订日期</th><th>客户姓名</th><th>房间号</th><th>修改</th><th>删除</th><th>转接待</th>
                        </tr>
                        <s:iterator value="#request.orders" var="order">
                            <tr>
                                <td><s:property value="#order.orderid"/></td>
                                <td><s:property value="#order.orderdate"/></td>
                                <td><s:property value="#order.customername"/></td>
                                <td><s:property value="#order.roomid"/></td>
                                <td><a href="gotoModifyOrder?orderid=<s:property value="#order.orderid"/>" class="btn btn-info" >修改</a></td>
                                <td>
                                    <a class="btn btn-warning delete" data-toggle="modal" data-backdrop="false" href="#myModal">删除</a>
                                </td>
                                <td>
                                    <a href="gotoOrderToCheckin?orderid=<s:property value="#order.orderid"/>" class="btn btn-info">预订转接待</a>
                                </td>
                            </tr>
                        </s:iterator>
                    </table>
                </div>
                <nav aria-label="...">
                    <ul class="pager">
                        <li><a href="showOrders?pages=${requestScope.pages-1}&order.customername=<s:property value="order.customername"/>&order.orderdate=<s:property value="order.orderdate"/> ">Previous</a></li>
                        <li><a href="showOrders?pages=${requestScope.pages+1}&order.customername=<s:property value="order.customername"/>&order.orderdate=<s:property value="order.orderdate"/> ">Next</a></li>
                        <span class="col-md-offset-1">${requestScope.pages}/${requestScope.pageSize}页</span>
                    </ul>
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
                <p>确认删除该订单吗？</p>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn" data-dismiss="modal">关闭</a>
                <a href="#" id="delete" class="btn btn-primary">删除</a>
            </div>

        </div>
    </div>
</div>
<script>
    $(document).ready(
        function () {
            var $buttons = $(".delete");

            for(var i = 0; i < $buttons.length; i++){
                $buttons.eq(i).on('click', function () {
                    var $text = $(this).parent().parent().children().eq(3).html()//获取客房编号
                    var $text1 = $(this).parent().parent().children().eq(0).html()//获取订单id
                    var $text2 = $("#customername").val();//获取条件编号
                    var $text3 = $("#orderdate").val();//获取条件内容
                    $("#delete").attr("href", "deleteOrder?orderid="+ $text1 + "&roomid=" + $text + "&customername=" + $text2 + "&orderdate=" + $text3);
                })
            }
        }
    )

</script>
</body>
</html>