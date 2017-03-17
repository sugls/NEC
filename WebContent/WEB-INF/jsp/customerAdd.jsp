<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>NEC酒店管理服务系统</title>
<script type="text/javascript">
	function checkIdcard() {
		var idcard = $("#idcard").val();
		var checkresult = $("#checkresult");
		if (idcard == "") {
			checkresult.html("身份证号不能为空");
			$("#idcard").focus();
		} else {
			$.get("checkidcard?idcard=" + idcard, null, callback);
		}
	}
	function callback(data) {
		var checkresult = $("#checkresult");
		checkresult.html(data);
	}

	//客户信息添加
	function check() {
		if ($("#customername").val() == "") {
			window.alert("客户姓名不能为空！");
			return false;
		} else if ($("#idcard").val() == "") {
			window.alert("身份证号不能为空！");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>

	<div class="panel panel-primary">
		<div class="panel-heading">添加客户信息</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-8">
					<form action="addcustomer" method="post" class="form-horizontal">
						<div style="text-align: center">
							<s:actionmessage />
						</div>
						<div class="form-group">
							<label for="customername" class="col-md-4 control-label">客户姓名</label>
							<div class="col-md-5">
								<input type="text" class="form-control" id="customername"
									name="customer.customername">
							</div>
							<span class="col-md-3"><s:fielderror
									value="customer.customername"></s:fielderror></span>
						</div>
						<div class="form-group">
							<label for="idcard" class="col-md-4 control-label">身份证号码</label>
							<div class="col-md-5">
								<input type="text" class="form-control" id="idcard"
									name="customer.idcard" onblur="checkIdcard()">
							</div>
							<label id="checkresult"></label>
						</div>
						<div class="form-group">
							<label for="sex" class="col-md-4 control-label">性别</label>
							<div class="col-md-5" id="sex">
								<label class="radio-inline"> <input type="radio"
									name="customer.sex" value="1" checked>男
								</label> <label class="radio-inline"> <input type="radio"
									name="customer.sex" value="0">女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="address" class="col-md-4 control-label">住址</label>
							<div class="col-md-5">
								<input type="text" class="form-control" id="address"
									name="customer.address">
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-md-4 control-label">联系电话</label>
							<div class="col-md-5">
								<input type="text" class="form-control" id="phone"
									name="customer.phone">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-5 col-md-offset-2">
								<input class="btn btn-primary form-control" type="submit"
									onclick="return check()" value="添加">
							</div>
							<div class="col-md-5">
								<input class="btn btn-warning form-control" type="reset"
									value="重置">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>