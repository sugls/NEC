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
                    <div class="panel-heading">查询入住记录</div>
                    <form action="getCheckins" class="navbar-form" role="form" method="get">
                        <div class="form-group">
                            <div class="input-group margin-bottom-sm">
                                <span for="customername" class="input-group-addon">客户姓名：</span>
                                
                                <input value='<s:property value="checkinQuery.customername"/>' class="form-control" type="text" placeholder="请输入客户姓名" id="customername" name="checkinQuery.customername">
                            </div>
                            <div class="input-group">
                                <span for="orderdate" class="input-group-addon">入住房间：</span>
                                
                                <input value='<s:property value="checkinQuery.roomid"/>' class="form-control" type="text" id="roomid" name="checkinQuery.roomid">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">查询</button>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">入住列表</div>
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <th>入住编号</th><th>入住日期</th><th>客户姓名</th><th>房间号</th><th>押金</th><th>是否需要网络</th><th>是否已开通</th><th>房间管理</th>
                            </tr>
                            <s:iterator value="#request.checkinqueries" var="checkin">
                            	<tr>
                                	<td><s:property value="#checkin.checkinid"/></td>
                                	<td><s:property value="#checkin.checkindate"/></td>
                                	<td><s:property value="#checkin.customername"/></td>
                                	<td><s:property value="#checkin.roomid"/></td>
                                	<td><s:property value="#checkin.pledge"/></td>
                                	<td><s:property value="#checkin.network"/></td>
                                	<td><s:property value="#checkin.neton"/></td>
                                    <td name="<s:property value="#checkin.customerid"/>" hidden></td>
                                	<td><a href="#myModal" class="btn btn-info neton"
                                           <s:if test='#checkin.network == "需要"  & #checkin.neton == "未开通"'>data-toggle="modal" </s:if>
                                           <s:if test='#checkin.network == "不需要"  || #checkin.neton == "已开通"'>disabled </s:if> >开通网络</a></td>
                            	</tr>
                            </s:iterator>
                        </table>
                    </div>
                    <nav aria-label="...">
                    <ul class="pager">
                        <li><a href="getCheckins?pages=${requestScope.pages-1}&checkinQuery.customername=<s:property value="checkinQuery.customername"/>&checkinQuery.roomid=<s:property value="checkinQuery.roomid"/> ">Previous</a></li>
                        <li><a href="getCheckins?pages=${requestScope.pages+1}&checkinQuery.customername=<s:property value="checkinQuery.customername"/>&checkinQuery.roomid=<s:property value="checkinQuery.roomid"/> ">Next</a></li>
                        <span class="col-md-offset-1">${requestScope.pages}/${requestScope.pageSize}页</span>
                    </ul>
                </nav>
                </div>
            </div>


            <div class="modal fade" tabindex="-1" id="myModal" role="dialog">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">

                        <div class="modal-header">
                            <a class="close" data-dismiss="modal">×</a>
                            <h4 class="modal-title">开通确认</h4>
                        </div>
                        <div class="modal-body">
                            <p>确认开通网络吗？</p>
                        </div>
                        <div class="modal-footer">
                            <a href="#" class="btn" data-dismiss="modal">取消</a>
                            <button class="btn btn-primary" data-dismiss="modal" id="goto">开通</button>
                        </div>

                    </div>
                </div>
            </div>

    <script>
        $(document).ready(function () {
            var $buttons = $(".neton");

            for(var i = 0; i < $buttons.length; i++) {
                $buttons.eq(i).on('click', function () {
                    var a = $(this);
                    var $text = $(this).parent().parent().children().eq(0).html()//获取入住编号
                    $("#goto").on("click", function () {
                        $.ajax({
                            url: "netOn",
                            type: "GET",
                            data: "checkinQuery.checkinid=" + a.parent().parent().children().eq(0).html(),
                            dataType: "json",
                            success: function (data) {
                                var d = eval("(" + data + ")");
                                console.log(d.result);
                                a.parent().parent().children().eq(6).html("已开通");
                                a.attr("disabled", "disabled");
                                a.attr("data-toggle","");
                            },
                            error: function (data) {
                                alert("开通失败");
                            }
                        })
                    })
                })
            }
        })

    </script>
</body>
</html>