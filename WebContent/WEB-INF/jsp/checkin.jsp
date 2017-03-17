<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NEC酒店管理服务系统</title>
    <script type="text/javascript">
    	function SelectRoom(){
    		var type = $("#roomtype").val();
    		window.location.href="showroomsbytype?roomtype="+type;
    	}
    </script>
</head>
<body>
<div class="panel panel-primary">
    <div class="panel-heading">入住办理</div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
            		<div style="text-align:center"><s:actionmessage/></div>
                        <div class="col-md-8">
                            <div class="input-group">
                                <span class="input-group-addon">客房类型</span>
                                <select name="roomtype" id="roomtype" class="form-control ">
                                    <option value="-1">--请选择房间类型--</option>
                                    <option value="单人标准间" <s:if test='roomtype=="单人标准间"'>selected</s:if>>单人标准间</option>
                                    <option value="双人标准间" <s:if test='roomtype=="双人标准间"'>selected</s:if>>双人标准间</option>
                                    <option value="豪华双人间" <s:if test='roomtype=="豪华双人间"'>selected</s:if>>豪华双人间</option>
                                    <option value="豪华三人间" <s:if test='roomtype=="豪华三人间"'>selected</s:if>>豪华三人间</option>
                                    <option value="总统套房" <s:if test='roomtype=="总统套房"'>selected</s:if>>总统套房</option>
                                </select>
                                <a class="btn btn-primary input-group-addon" onclick="SelectRoom()">搜索空房</a>
                            </div>
                        </div>

                <hr class="divider">

				<s:if test="ic==null">
                <table class="table">
                    <tr>
                        <th>房间编号</th><th>房间位置</th><th>房间类型</th><th>设备情况</th><th>价格</th><th>操作</th>
                    </tr>
                    <s:iterator value="#request.showroombytype" var="showroombytypes">
                    <tr>
                        <td><s:property value="#showroombytypes.roomid"/></td>
                        <td><s:property value="#showroombytypes.locations"/></td>
                        <td><s:property value="#showroombytypes.typename"/></td>
                        <td><s:property value="#showroombytypes.remark"/></td>
                        <td><s:property value="#showroombytypes.price"/></td>
                        <td>
                            <a data-toggle="modal" data-backdrop="false" href='showcustomerbyischeckin?rid=<s:property value="#showroombytypes.roomid"/>&ic=1'>入住</a>
                        </td>
                    </tr>
                    </s:iterator>
                </table>
				</s:if>
				
				<s:if test="ic==1">
                <table class="table">
                    <tr>
                        <th>客户编号</th><th>姓名</th><th>电话</th><th>身份证</th><th>操作</th>
                    </tr>
                    <s:iterator value="#request.showcustomerbyischeckin" var="customerbyic">
                    <tr>
                        <td><s:property value="#customerbyic.customerid"/></td>
                        <td><s:property value="#customerbyic.customername"/></td>
                        <td><s:property value="#customerbyic.phone"/></td>
                        <td><s:property value="#customerbyic.idcard"/></td>
                        <td>
                            <a data-toggle="modal" data-backdrop="false" href="#myModal"
                            onclick="$('#ckid').val(<s:property value='#customerbyic.customerid'/>)">入住办理</a>
                        </td>
                    </tr>
                    </s:iterator>
                </table>
				</s:if>
				
            </div>
        </div>
    </div>
</div>

<div class="modal fade" tabindex="-1" id="myModal" role="dialog">
    <div class="modal-dialog" role="document">
        <form class="modal-content" method="post" action="customercheckin">

            <div class="modal-header">
                <a class="close" data-dismiss="modal">×</a>
                <h4 class="modal-title">入住办理</h4>
            </div>
            <div class="modal-body">
                <div class="input-group">
                	<input type="hidden" name="checkin.customerid" id="ckid" value='<s:property value="#customerbyic.customerid"/>'>
                	<input type="hidden" name="checkin.roomid" value='<s:property value="rid"/>'>
                    <span class="input-group-addon">押金</span>
                    <input type="number" step="any" class="form-control" name="checkin.pledge" id="money">
                    <span class="input-group-addon">￥</span>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">是否开通网络</span>
                    <label class="radio-inline">
                        <input type="radio" name="checkin.network" checked value="0">否
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="checkin.network" value="1">是
                    </label>
                </div>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn" data-dismiss="modal">关闭</a>
                <input type="submit" class="btn btn-primary" value="确认入住" id="ckin">
            </div>

        </form>
    </div>
</div>
</body>
</html>