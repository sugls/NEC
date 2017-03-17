<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>NEC酒店管理服务系统</title>
<script type="text/javascript">
	function checkDel(msg){
		if(window.confirm(msg)){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
	<s:if test="is==null">
	<div class="row">
		<div class="panel panel-primary">
			<div class="panel-heading">网络管理信息查询</div>
			<form action="showallnetwork" class="navbar-form" role="form" method="post">
				<div class="form-group">
					<div class="input-group margin-bottom-sm">
						<span for="customername" class="input-group-addon">客户姓名：</span> <input class="form-control"
							type="text" placeholder="请输入客户姓名" id="customername" <s:if test="network.customername!=null">value='<s:property value="network.customername"/>'</s:if>
							name="network.customername">
					</div>
				</div>
				<input type="submit" class="btn btn-primary" value="查询">
			</form>
		</div>
	</div>
	<div class="row">
		<div class="panel panel-primary">
			<div class="panel-heading">网络管理信息</div>
			<div class="panel-body">
				<div style="text-align: center">
					<s:property value="#request.closemessage"/>
				</div>
				
				<table class="table">
					<tr>
						<th>房间编号</th>
						<th>客户姓名</th>
						<th>开通时间</th>
						<th>关闭时间</th>
						<th>操作</th>
					</tr>
					<s:iterator value="#request.allnetwork" var="networks">
					<form action="networkcost" method="post">
						<tr>
							<td><s:property value="#networks.roomid" /><input type="hidden" value='<s:property value="#networks.roomid" />' name="network.roomid"></td>
							<td><s:property value="#networks.customername" /><input type="hidden" value='<s:property value="#networks.networkid"/>' name="network.networkid"></td>
							<td><s:property value="#networks.strondate" /></td>
							<td><s:property value="#networks.stroffdate" /></td>
							<td>
							<s:if test="#networks.stroffdate==null"><input type="hidden" value="1" name="is">
								<input type="submit" class="btn btn-info" data-toggle="modal" data-backdrop="false" onclick="return checkDel('确定需要关闭网络吗？')" value="关闭网络">
							</s:if>
							<s:else>
								<input type="submit" class="btn btn-info" data-toggle="modal" data-backdrop="false" onclick="return checkDel('确定需要关闭网络吗？')" value="关闭网络" disabled>
							</s:else>
							</td>
						</tr>
					</form>
					</s:iterator>
				</table>
				<nav>
					<ul class="pager">
						<s:if test="pages!=1">
							<li><a
								href='showallnetwork?pages=<s:property value="pages-1"/>&network.customername=<s:property value="network.customername"/>'>上一页</a></li>
						</s:if>
						<s:else>
							<li>上一页</li>
						</s:else>
						<s:if test="pages!=#session.networktotalpages">
							<li><a
								href='showallnetwork?pages=<s:property value="pages+1"/>&network.customername=<s:property value="network.customername"/>'>下一页</a></li>
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
					<s:property value="#session.networktotalpages" />
				</div>
			</div>
		</div>
	</div>
	</s:if>
	<s:else>
	<form action="showallnetwork" method="post">
	<div class="modal-header">
		<h4 class="modal-title">网费账单信息</h4>
	</div>
	<div class="modal-body">
		<img
			src="${pageContext.request.contextPath}/img/backgrounds/20063.jpg"
			alt="" width="200px">
		<ul class="list-group">
			<h4>网费信息</h4>
			<li class="list-group-item">房间号：<s:property
					value="#request.networkcostmsg.roomid" /></li>
			<li class="list-group-item">姓名：<s:property
					value="#request.networkcostmsg.customername" /></li>
			<li class="list-group-item">开通时间：<s:property
					value="#request.networkcostmsg.strondate" /></li>
			<li class="list-group-item">关闭时间：<s:property
					value="#request.networkcostmsg.stroffdate"/></li>
			<li class="list-group-item">应收网费：<s:property
					value="#request.networkcostmsg.netmoney" /></li>
			<li class="list-group-item pull-right">
			<strong>
			合计金额：<s:property value="#request.networkcostmsg.netmoney" />￥
			</strong></li>
		</ul>
	</div>
	<div class="modal-footer">
		<input type="submit" class="btn btn-primary" value="确认">
	</div>
	</form>
	</s:else>
	
</body>
</html>