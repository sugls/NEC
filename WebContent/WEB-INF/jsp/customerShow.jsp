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
	<div class="row">
		<div class="panel panel-primary">
			<div class="panel-heading">查询客户记录</div>
			<div class="navbar-form">
				<form action="allshowcustomers">
				<div class="form-group">
					<div class="input-group">
						<span for="condition" class="input-group-addon">查询条件</span>  <select name="condition"
							id="condition" class="form-control">
							<option value="-1" <s:if test="condition==-1">selected</s:if>>--请选择--</option>
							<option value="1" <s:if test="condition==1">selected</s:if>>客户编号</option>
							<option value="2" <s:if test="condition==2">selected</s:if>>客户姓名</option>
							<option value="3" <s:if test="condition==3">selected</s:if>>身份证号码</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group margin-bottom-sm">
						<span for="keyword" class=" input-group-addon">关键字：</span> <input class="form-control"
							type="text" placeholder="请输入查询关键字" id="keyword" name="keyword" <s:if test="keyword!=null">value='<s:property value="keyword"/>'</s:if>>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">查询</button>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="panel panel-primary">
			<div class="panel-heading">客户信息列表</div>
				<div style="text-align:center"><s:if test="#request.allShowCustomer.size==0">没有查到用户信息</s:if></div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<th>客户编号</th>
						<th>客户姓名</th>
						<th>身份证号</th>
						<th>性别</th>
						<th>住址</th>
						<th>联系电话</th>
					</tr>
					<s:iterator value="#request.allShowCustomer" var="customers">
					<tr>
						<td><s:property value="#customers.customerid"/></td>
						<td><s:property value="#customers.customername"/></td>
						<td><s:property value="#customers.idcard"/></td>
						<td><s:property value="#customers.sex"/></td>
						<td><s:property value="#customers.address"/></td>
						<td><s:property value="#customers.phone"/></td>
					</tr>
					</s:iterator>
				</table>
				<nav>
					<ul class="pager">
						<s:if test="pages!=1">
							<li><a
								href='allshowcustomers?pages=<s:property value="pages-1"/>&condition=<s:property value="condition"/>&keyword=<s:property value="keyword"/>'>上一页</a></li>
						</s:if>
						<s:else>
							<li>上一页</li>
						</s:else>
						<s:if test="pages!=#session.totalpages">
							<li><a
								href='allshowcustomers?pages=<s:property value="pages+1"/>&condition=<s:property value="condition"/>&keyword=<s:property value="keyword"/>'>下一页</a></li>
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