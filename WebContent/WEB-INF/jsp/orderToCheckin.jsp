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
                <div class="panel-heading">预订转接待</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-2">
                            <label><s:property value="info"/></label>
                            <form action="orderToCheckin" method="post" class="form-horizontal">
                                <input hidden name="orderid" value='<s:property value="order.orderid"/>'>
                                <div class="form-group">
                                    <label for="customername" class="col-md-4 control-label">客户姓名</label>
                                    <div class="col-md-8">
                                        <input type="text" readonly="readonly" class="form-control" name="customer.customername" id="customername" value='<s:property value="order.customername"/>'>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="idcard" class="col-md-4 control-label">身份证号码</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="idcard" name="customer.idcard">
                                        <div class="alert alert-danger message" hidden><i class="fa fa-close"></i></div>
                                        <div class="alert alert-success message" hidden><i class="fa fa-check"></i></div>
                                        <input hidden name="repeat" id="repeat">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="sex" class="col-md-4 control-label">性别</label>
                                    <div class="col-md-8" id="sex">
                                        <div class="form-control">
                                            <input type="radio" name="customer.sex"  value="1" checked>男
                                            <input type="radio" name="customer.sex"  value="0">女
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="address"  class="col-md-4 control-label">住址</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="address" name="customer.address">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="phone"  class="col-md-4 control-label">联系电话</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="phone" name="customer.phone">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="roomid"  class="col-md-4 control-label">入住房间</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="roomid" name="roomid" readonly value='<s:property value="order.roomid"/>'>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="sex" class="col-md-4 control-label">是否开通网络</label>
                                    <div class="col-md-8" id="sex">
                                        <div class="form-control">
                                            <input type="radio" name="network"  value="1" checked>是
                                            <input type="radio" name="network"  value="0">否
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-5 col-md-offset-2">
                                        <button id="submit" disabled class="btn btn-primary form-control" type="submit">确认并入住</button>
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
        var idcard = $("#idcard");
        idcard.on("blur", function () {
            var checkNum = /^[0-9]{17}[0-9]$/;
            if(!checkNum.test(idcard.val().trim())){
                changeMessage(1);
            }else{
                $.ajax({
                    url : "checkIdCard",
                    type : "GET",
                    data: "idcard=" + $("#idcard").val() + "&customername=" + $("#customername").val(),
                    dataType: "json",
                    success : function(data) {
                        var d = eval("("+data+")");
                        console.log(d)
                        if(d.result == "true"){
                            changeMessage(3);
                            $("#submit").removeAttr("disabled");
                            if(d.id == "1"){//表示该身份证对应用户已存在不用重复添加
                                console.log(1)
                                $("#repeat").attr("value","1");
                            }else{
                                console.log(0)
                                $("#repeat").attr("value","0");
                            }
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
            messages.eq(0).children().eq(0).html("身份证号已存在但和名字不匹配");
        } else {
            messages.eq(1).removeAttr("hidden");
            messages.eq(1).children().eq(0).html("身份证号可用");
        }

    }

</script>

</body>
</html>