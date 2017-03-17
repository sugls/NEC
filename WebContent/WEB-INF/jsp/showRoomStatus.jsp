<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>NEC酒店管理服务系统</title>
</head>
<body>


	<div class="panel panel-primary">
		<div class="panel-heading">房间状态列表</div>
		<div class="panel-body" style="text-align:center">

			<div class="row">
				<!-- <div class="col-md-1">#1楼</div> -->
				<s:iterator value="#request.roomsbyfloors" var="floors">
					<div class="col-md-11">
						<s:iterator value="floors" var="rooms">

							<button
								<s:if test='#rooms.status==0'>class="btn btn-primary"</s:if>
								<s:if test='#rooms.status==1'>class="btn btn-warning"</s:if>
								<s:if test='#rooms.status==2'>class="btn btn-danger"</s:if>>
								<s:property value="#rooms.roomid" />
							</button>
							&nbsp;&nbsp;&nbsp;

						</s:iterator>
					</div>
					<div class="col-md-11">&nbsp;</div>
				</s:iterator>
			</div>
			
			<div>&nbsp;</div>
			
			<div style="text-align:right">
				<button class="btn btn-primary">空房</button>
				<button class="btn btn-warning">已预订</button>
				<button class="btn btn-danger">已入住</button>
			</div>

		</div>
	</div>

</body>
</html>