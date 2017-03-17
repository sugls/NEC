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

            <div class="panel panel-primary">
                <div class="panel-heading">修改预订信息</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-2">
                            <form action="orderModify" method="post" class="form-horizontal">
                                <label><s:property value="info"></s:property> </label>
                                <div class="form-group">
                                    <label for="orderid" class="col-md-4 control-label">预订编号</label>
                                    <div class="col-md-8">
                                        <input type="text" name="order.orderid" class="form-control" id="orderid" readonly value='<s:property value="order.orderid"></s:property>'>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="orderdate" class="col-md-4 control-label">预定日期</label>
                                    <div class="col-md-8">
                                        <input type="text" name="order.orderdate" readonly class="form-control" id="orderdate" value="<s:property value="order.orderdate"></s:property>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="customername" class="col-md-4 control-label">客户姓名</label>
                                    <div class="col-md-8">
                                        <input type="text" name="order.customername" class="form-control" id="customername" value="<s:property value="order.customername"></s:property>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="roomid" class="col-md-4 control-label">房间号</label>
                                    <div class="col-md-8">
                                        <input hidden name="oldRoomId" value="<s:property value="order.roomid"></s:property>">
                                        <input type="text" name="order.roomid" class="form-control" id="roomid" value="<s:property value="order.roomid"></s:property>">
                                        <div class="alert alert-danger message" hidden><i class="fa fa-close"></i></div>
                                        <div class="alert alert-success message" hidden><i class="fa fa-check"></i></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-5 col-md-offset-2">
                                        <button class="btn btn-primary form-control" disabled style="background-color: #2e6da4 " id="submit"  type="submit">修改</button>
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
        var roomid = $("#roomid");
        roomid.on("blur", function () {
            var checkNum = /^[0][1-5][0][0-9]$/;
            if(!checkNum.test(roomid.val().trim())){
                changeMessage(1);
            }else{
                $.ajax({
                    url : "checkORoomId",
                    type : "GET",
                    data: "roomid=" + $("#roomid").val(),
                    dataType: "json",
                    success : function(data) {
                        var d = eval("("+data+")");
                        if(d.result == "true"){
                            changeMessage(3);
                            $("#submit").removeAttr("disabled");
                        }else{
                            changeMessage(2);
                        };
                    }
                });
            }
        })
    })

    function changeMessage(result){
        var messages = $(".message");
        for(var i = 0; i < messages.length; i++){
            messages.eq(i).attr("hidden", "hidden")
        }
        $("#submit").eq(0).attr("disabled","disabled");
        if(result == 1){//格式不符合要求时的提示
            messages.eq(0).removeAttr("hidden");
            messages.eq(0).children().eq(0).html("格式有误");
        } else if (result == 2){
            messages.eq(0).removeAttr("hidden");
            messages.eq(0).children().eq(0).html("客房号不可用");
        } else {
            messages.eq(1).removeAttr("hidden");
            messages.eq(1).children().eq(0).html("客房号可用");
        }

    }

</script>
</body>
</html>