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
                <div class="panel-heading">添加房间</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-2">
                            <form action="addRoom" method="post" class="form-horizontal">
                            	
                            	<label class="col-md-offset-5" id="info"><s:property value="#request.info"/></label>
                                <div class="form-group">
                                    <label for="roomstatus" class="col-md-4 control-label">房间状态</label>
                                    <div class="col-md-8">
                                        <select name="room.status" id="roomstatus" class="form-control">
                                            <option value="0">空房</option>
                                            <option value="1">已预订</option>
                                            <option value="2">已入住</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="roomtype" class="col-md-4 control-label">房间类型</label>
                                    <div class="col-md-8">
                                        <select name="room.typeid" id="roomtype" class="form-control">
                                        	<s:iterator value="#session.roomTypes" var="roomType" >
                                        		<option value='<s:property value="#roomType.typeid"/>'><s:property value="#roomType.typename"/></option>
                                        	</s:iterator>
                                        </select>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <label for="roomid" class="col-md-4 control-label">房间号</label>
                                    <div class="col-md-8">
                                        <input type="number" name="room.roomid" id="roomid" class="form-control">
                                        <div class="alert alert-danger message" hidden><i class="fa fa-close"></i></div>
                                        <div class="alert alert-success message" hidden><i class="fa fa-check"></i></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="location"  class="col-md-4 control-label">房间位置</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="location" name="room.locations" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="remark"  class="col-md-4 control-label">设备信息</label>
                                    <div class="col-md-8">
                                        <textarea rows="3" cols="5" name="room.remark" class="form-control" id="remark" style="resize:none"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-5 col-md-offset-2">
                                        <button class="btn btn-primary form-control submit" style="background-color: #2e6da4" type="submit" disabled>添加</button>
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

<script type="text/javascript">
	$(document).ready(function () {
	    var roomid = $("#roomid");
	    roomid.on("blur", function () {
	        var checkNum = /^[0][1-5][0][0-9]$/;
	        if(!checkNum.test(roomid.val().trim())){
	            changeMessage(1);
            }else{
                $.ajax({
                    url : "checkRoomId",
                    type : "GET",
                    data: "roomid=" + $("#roomid").val(),
                    dataType: "json",
                    success : function(data) {
                        var d = eval("("+data+")");
                        if(d.result == "true"){
                            changeMessage(3);
                            $("#location").attr("value",$("#roomid").val().substr(0,2)+"楼"+$("#roomid").val().substr(2,2)+"号房")
                            $(".submit").eq(0).removeAttr("disabled");
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
            messages.eq(0).children().eq(0).html("客房号已存在");
        } else {
            messages.eq(1).removeAttr("hidden");
            messages.eq(1).children().eq(0).html("客房号可用");
        }

    }

</script>
</body>
</html>