<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>NEC酒店管理服务系统</title>
<script type="text/javascript">
	function checkDel(msg) {
		if (window.confirm(msg)) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<s:if test="is==null">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">查询入住记录</div>
				<form action="checkinmessage" class="navbar-form" role="form"
					method="post">
					<div class="form-group">
						<div class="input-group margin-bottom-sm">
							<span for="customername" class="input-group-addon">客户姓名：</span>
							 <input class="form-control"
								type="text" placeholder="请输入客户姓名" id="customername" <s:if test="checkinmessage.customername!=null">value='<s:property value="checkinmessage.customername"/>'</s:if>
								name="checkinmessage.customername">
						</div>
					</div>
					<input type="submit" class="btn btn-primary" value="查询">
				</form>
			</div>
		</div>
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">入住列表</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>入住编号</th>
							<th>入住日期</th>
							<th>客户姓名</th>
							<th>房间号</th>
							<th>押金</th>
							<th>是否需要网络</th>
							<th>是否已开通</th>
							<th>房间管理</th>
						</tr>
						<s:iterator value="#request.checkinmessages" var="cm">
							<form action="costmessage" method="post">
								<tr>
									<td><s:property value="#cm.checkinid" /><input
										type="hidden" name="checkinmessage.checkinid"
										value='<s:property value="#cm.checkinid"/>'></td>
									<td><s:property value="#cm.strcheckindate" /></td>
									<td><s:property value="#cm.customername" /></td>
									<td><s:property value="#cm.roomid" /><input type="hidden"
										name="checkinmessage.roomid"
										value='<s:property value="#cm.roomid"/>'></td>
									<td><s:property value="#cm.pledge" /></td>
									<td><s:property value="#cm.network" /><input
										type="hidden" name="checkinmessage.customerid"
										value='<s:property value="#cm.customerid"/>'></td>
									<td><s:property value="#cm.neton" /><input type="hidden"
										name="is" value="1"></td>
									<td><s:if test="#cm.strcheckoutdate==null">
											<input type="submit" class="btn btn-info" data-toggle="modal"
												data-backdrop="false" onclick="return checkDel('确定退房吗？')"
												value="退房">
										</s:if> <s:else>
											<input type="submit" class="btn btn-info" data-toggle="modal"
												data-backdrop="false" onclick="return checkDel('确定退房吗？')"
												value="退房" disabled>
										</s:else></td>
								</tr>
							</form>
						</s:iterator>
					</table>
					<nav>
					<ul class="pager">
						<s:if test="pages!=1">
							<li><a
								href='checkinmessage?pages=<s:property value="pages-1"/>&checkinmessage.customername=<s:property value="checkinmessage.customername"/>'>上一页</a></li>
						</s:if>
						<s:else>
							<li>上一页</li>
						</s:else>
						<s:if test="pages!=#session.checkintotalpages">
							<li><a
								href='checkinmessage?pages=<s:property value="pages+1"/>&checkinmessage.customername=<s:property value="checkinmessage.customername"/>'>下一页</a></li>
						</s:if>
						<s:else>
							<li>下一页</li>
						</s:else>
					</ul>
				</nav>
				<div style="text-align: right">
					总页数:
					<s:property value="pages" />
					/
					<s:property value="#session.checkintotalpages" />
				</div>
				</div>
			</div>
		</div>
	</s:if>
	<s:else>
		<div class="modal-header">
			<a class="close" data-dismiss="modal">×</a>
			<h4 class="modal-title">账单信息</h4>
		</div>
		<div class="modal-body">
			<img
				src="${pageContext.request.contextPath}/img/backgrounds/20063.jpg"
				alt="" width="200px">
			<ul class="list-group">
				<h4>网费信息</h4>
				<li class="list-group-item">押金：<s:property
						value="#request.costcm.pledge" /></li>
				<h4>房间费用</h4>
				<li class="list-group-item">客户姓名：<s:property
						value="#request.costcm.customername" /></li>
				<li class="list-group-item">房间号：<s:property
						value="#request.costcm.roomid" /></li>
				<li class="list-group-item">入住日期：<s:property
						value="#request.costcm.strcheckindate" /></li>
				<li class="list-group-item">退房日期：<s:property
						value="#request.costcm.strcheckoutdate" /></li>
				<li class="list-group-item">房间类型：<s:property
						value="#request.costcm.typename" /></li>
				<li class="list-group-item">价格：<s:property
						value="#request.costcm.price" /></li>
				<li class="list-group-item">房间费用：<s:property
						value="#request.costcm.hotelprice" /></li>
				<h4>网费信息</h4>
				<li class="list-group-item">开通时间：<s:property
						value="#request.costcm.strondate" /></li>
				<li class="list-group-item">关闭时间：<s:property
						value="#request.costcm.stroffdate" /></li>
				<li class="list-group-item">应收网费：<s:property
						value="#request.costcm.netprice" /></li>
				<li class="list-group-item pull-right"><strong> <s:if
							test="(#request.costcm.hotelprice+#request.costcm.netprice)<=#request.costcm.pledge">
					退还金额：<s:property
								value="#request.costcm.pledge-#request.costcm.hotelprice-#request.costcm.netprice" />￥
				</s:if> <s:else>
					补收金额：<s:property
								value="#request.costcm.hotelprice+#request.costcm.netprice-#request.costcm.pledge" />￥
				</s:else>
				</strong></li>
			</ul>
		</div>
		<div class="modal-footer">
			<a href="checkinmessage" class="btn" data-dismiss="modal">返回</a>
			<button name='<s:property value="#request.costcm.checkinid"/>'
				class="btn btn-primary" id="jiezhang">账单入库</button>
		</div>
	</s:else>

	<script type="text/javascript">
		$("#jiezhang").on("click", function() {
			$.ajax({
				url : "exportExcel?checkinid=" + $("#jiezhang").attr("name"),
				type : "get",
				dataType : "json",
				success : function(data) {
					var d = eval("(" + data + ")");
					console.log(d.message);
				}
			})
		})
	</script>
</body>
</html>