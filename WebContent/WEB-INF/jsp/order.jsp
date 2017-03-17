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
                <div class="panel-heading">预订</div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-2">
                            <label><s:property value="info"></s:property></label>
                            <form action="addOrder" method="post" class="form-horizontal">
                                <div class="form-group">
                                    <label for="customername" class="col-md-4 control-label">客户姓名</label>
                                    <div class="col-md-8">
                                        <input name="customername" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="customername" class="col-md-4 control-label">客房编号</label>
                                    <div class="col-md-8">
                                        <input name="roomid" value='<s:property value="roomid"></s:property>' type="text" class="form-control" id="roomid" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-5 col-md-offset-2">
                                        <button class="btn btn-primary form-control" type="submit">预订</button>
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