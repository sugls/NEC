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

<div class="panel panel-primary">
    <div class="panel-heading">房间列表</div>
    <div class="panel-body">
                一楼: <s:iterator value="#request.emptyRoomQueries" var="emptyroom">
        	<s:if test='#emptyroom.roomid.substring(0,2)=="01"'>
            	&nbsp;&nbsp;<a class="rooms btn btn-info" data-toggle="modal" data-backdrop="false" href="#myModal"><s:property value="#emptyroom.roomid"></s:property> </a>
        	</s:if>
        </s:iterator>
        <br><br>
            二楼: <s:iterator value="#request.emptyRoomQueries" var="emptyroom">
        	<s:if test='#emptyroom.roomid.substring(0,2)=="02"'>
            	&nbsp;&nbsp;<a class="rooms btn btn-info" data-toggle="modal" data-backdrop="false" href="#myModal"><s:property value="#emptyroom.roomid"></s:property> </a>
        	</s:if>
        </s:iterator>
        <br><br>
        三楼: <s:iterator value="#request.emptyRoomQueries" var="emptyroom">
        	<s:if test='#emptyroom.roomid.substring(0,2)=="03"'>
            	&nbsp;&nbsp;<a class="rooms btn btn-info" data-toggle="modal" data-backdrop="false" href="#myModal"><s:property value="#emptyroom.roomid"></s:property> </a>
        	</s:if>
        </s:iterator>
        <br><br>
        四楼: <s:iterator value="#request.emptyRoomQueries" var="emptyroom">
        	<s:if test='#emptyroom.roomid.substring(0,2)=="04"'>
            	&nbsp;&nbsp;<a class="rooms btn btn-info" data-toggle="modal" data-backdrop="false" href="#myModal"><s:property value="#emptyroom.roomid"></s:property> </a>
        	</s:if>
        </s:iterator>
        <br><br>
        五楼: <s:iterator value="#request.emptyRoomQueries" var="emptyroom">
        	<s:if test='#emptyroom.roomid.substring(0,2)=="05"'>
            	&nbsp;&nbsp;<a class="rooms btn btn-info" data-toggle="modal" data-backdrop="false" href="#myModal"><s:property value="#emptyroom.roomid"></s:property> </a>
        	</s:if>
        </s:iterator>
    </div>
</div>
  


<div class="modal fade" tabindex="-1" id="myModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <a class="close" data-dismiss="modal">×</a>
                    <h4 class="modal-title">房间信息</h4>
                </div>
                <div class="modal-body">
                    <img src="${pageContext.request.contextPath}/img/backgrounds/20063.jpg" alt="" width="200px">
                    <ul class="roomDetail list-group">
                        <li class="list-group-item"></li>
                        <li class="list-group-item"></li>
                        <li class="list-group-item"></li>
                        <li class="list-group-item"></li>
                        <li class="list-group-item"></li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn" data-dismiss="modal">关闭</a>
                    <a id="gotoOrder" class="btn btn-primary">预订</a>
                </div>

            </div>
    </div>
</div>

<script>
    $(".rooms").each(function () {
        $(this).on("click", function () {
            $.ajax({
                url : "getEmptyRoomById",
                type : "GET",
                data: "roomid=" + $(this).html(),
                dataType: "json",
                success : function(data) {
                    var d = eval("("+data+")");
                    var details = $(".roomDetail").eq(0).children();
                    details.eq(0).html("客房编号:" + d.roomid);
                    details.eq(1).html("类型名称：" + d.typename);
                    details.eq(2).html("客房位置：" + d.locations);
                    details.eq(3).html("设备详情：" + d.remark);
                    details.eq(4).html("客房价格:" + d.price + "元");
                    $("#gotoOrder").attr("href", "gotoOrder?roomid=" + d.roomid);
                }
            })
        })
    })
    
    
    
    


</script>
</body>
</html>