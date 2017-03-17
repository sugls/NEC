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
                <div class="panel-heading">修改房间信息</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-2">
                            <form action="modifyRoom" method="post" class="form-horizontal">
                            <label class="col-md-offset-5" id="info"><s:property value="#request.info"/></label>
							<div class="form-group">
                                    <label for="room.roomid" class="col-md-4 control-label">房间号</label>
                                    <div class="col-md-8">
                                        <input value='<s:property value='#request.roomquery.roomid' />' type="number" name="room.roomid" id="roomid" class="form-control" readonly>
                                    </div>
                                </div>									
                                <div class="form-group">
                                    <label for="roomstatus" class="col-md-4 control-label">房间状态</label>
                                    <div class="col-md-8">
                                        <select name="room.status" id="roomstatus" class="form-control">
                                            <option value="0" <s:if test='#request.roomquery.status == "空房"'>selected="selected"</s:if>>空房</option>
                                            <option value="1" <s:if test='#request.roomquery.status == "已预订"'>selected="selected"</s:if>>已预订</option>
                                            <option value="2" <s:if test='#request.roomquery.status == "已入住"'>selected="selected"</s:if>>已入住</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="roomtype" class="col-md-4 control-label">房间类型</label>
                                    <div class="col-md-8">
                                        <select name="room.typeid" id="typeid" class="form-control">
                                            <option value="2" <s:if test='#request.roomquery.roomtype == "2"'>selected="selected"</s:if>>标准单人间</option>
                                            <option value="3" <s:if test='#request.roomquery.roomtype == "3"'>selected="selected"</s:if>>标准双人间</option>
                                            <option value="4" <s:if test='#request.roomquery.roomtype == "4"'>selected="selected"</s:if>>豪华双人间</option>
                                            <option value="5" <s:if test='#request.roomquery.roomtype == "5"'>selected="selected"</s:if>>豪华三人间</option>
                                            <option value="6" <s:if test='#request.roomquery.roomtype == "6"'>selected="selected"</s:if>>总统套房</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="location"  class="col-md-4 control-label">房间位置</label>
                                    <div class="col-md-8">
                                        <input value='<s:property value='#request.roomquery.locations' />' type="text" class="form-control" id="location" name="room.locations" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="remark"  class="col-md-4 control-label">设备信息</label>
                                    <div class="col-md-8">
                                        <textarea rows="3" cols="5" name="room.remark" class="form-control" id="remark" style="resize:none"><s:property value='#request.roomquery.remark' /></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-5 col-md-offset-2">
                                        <button class="btn btn-primary form-control" type="submit">修改</button>
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
</body>
</html>