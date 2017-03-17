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
	<div class="row">
		<div class="panel panel-primary">
			<div class="panel-heading">客户信息列表</div>
			<div class="panel-body">
				<div style="text-align:center"><s:property value="#request.message"/></div>
				<table class="table">
					<tr>
						<th>客户编号</th>
						<th>客户姓名</th>
						<th>身份证号</th>
						<th>性别</th>
						<th>住址</th>
						<th>联系电话</th>
						<th>修改</th>
						<th>删除</th>
					</tr>
					<s:iterator value="#request.RPcustomers" var="rpcustomer">
						<tr>
							<td><s:property value="#rpcustomer.customerid" /></td>
							<td><s:property value="#rpcustomer.customername" /></td>
							<td><s:property value="#rpcustomer.idcard" /></td>
							<td><s:property value="#rpcustomer.sex" /></td>
							<td><s:property value="#rpcustomer.address" /></td>
							<td><s:property value="#rpcustomer.phone" /></td>
							<td>
							
							<button class="btn btn-info" onclick="location.href='rpshowonecustomer?id=<s:property value="#rpcustomer.customerid" />'">修改</button>
							</td>
							<td><a class="btn btn-warning" href='rpdeleteonecustomer?id=<s:property value="#rpcustomer.customerid"/>' onclick="return checkDel('确定需要删除吗？')">删除</a></td>
						</tr>
					</s:iterator>
				</table>
				<nav>
					<ul class="pager">
						<s:if test="pages!=1">
							<li><a
								href="rpshowcustomers?pages=<s:property value="pages-1"/>">上一页</a></li>
						</s:if>
						<s:else>
							<li>上一页</li>
						</s:else>
						<s:if test="pages!=#session.totalpages">
							<li><a
								href="rpshowcustomers?pages=<s:property value="pages+1"/>">下一页</a></li>
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
					<s:property value="#session.totalpages" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>