<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>
<s:if test="#session.employee != null">
			<div class="media">
                    <div class="media-left media-middle">
                    <img
                    <c:choose>
                            <c:when test="${sessionScope.employee.sex == '男'}">src='${pageContext.request.contextPath}/img/1.png'</c:when>
                            <c:when test="${sessionScope.employee.sex == '女'}">src='${pageContext.request.contextPath}/img/0.png'</c:when>
                            <c:otherwise>src='${pageContext.request.contextPath}/img/1.png'</c:otherwise>
                    </c:choose>
                    class="media-object img-circle" alt="head">
                    </div>
                <div class="media-body media-middle">
                    <h4 class="media-heading"><s:property value="#session.employee.realname"/></h4>
                    <h4 class="small">性别：<s:property value="#session.employee.sex"/></h4>
                    <h4 class="small">角色：<s:property value="#session.employee.postname"/></h4>

                        <h4 class="small">登录时间：<s:property value="#session.employee.logindate"/></h4>
                </div>
            </div>
            <hr class="divider">
            <div class="list-group">
            	<s:if test="#session.employee.postname == '房管员'">
                <a class="collapsed list-group-item" role="button" data-toggle="collapse" href="#list1">房务信息管理</a>
                <div id="list1" class="panel-collapse collapse" role="tabpanel" style="height: 0px;">
                    <div class="list-group">
                        <a href="addRoom?reqonly=1" class="list-group-item">添加客房信息</a>
                        <a href="RMShowRooms?reqonly=1" class="list-group-item">查看客房信息</a>
                        <a href="getCheckins" class="list-group-item">开通网络处理
                        <span class="badge" style="background-color: red"><s:property value="#session.netCounts"/> </span>
                        </a>
                    </div>
                </div>
                </s:if>
                <s:if test="#session.employee.postname == '前台接待'">
                <a class="collapsed list-group-item" role="button" data-toggle="collapse" href="#list2">预定信息管理</a>
                 <div id="list2" class="panel-collapse collapse" role="tabpanel" style="height: 0px;">
                    <div class="list-group">
                        <a href="showEmptyRooms" class="list-group-item">预定客房</a>
                        <a href="showOrders" class="list-group-item">查询预定</a>
                        
                    </div>
                </div>
               </s:if>
               
                <!-- checkin模块功能链接修改 -->
               <a class="collapsed list-group-item" role="button" data-toggle="collapse" href="#list3"><i class="fa fa-renren"></i> &nbsp;客户信息管理</a>
                <div id="list3" class="panel-collapse collapse" role="tabpanel" style="height: 0px;">
                    <div class="list-group">
                        <a href="allshowcustomers" class="list-group-item">&nbsp;&nbsp;<i class="glyphicon glyphicon-eye-open"></i>&nbsp;&nbsp;查看客户信息</a>
                    </div>
                </div>

				<s:if test="#session.employee.postname == '前台接待'">
                 <a class="collapsed list-group-item" role="button" data-toggle="collapse" href="#list10"> 接待信息管理</a>
                <div id="list10" class="panel-collapse collapse" role="tabpanel" style="height: 0px;">
                    <div class="list-group">
                        <a href="showroomsstatus" class="list-group-item">查看房态信息</a>
                        <a href="addcustomerlink" class="list-group-item">登记客户信息</a>
                        <a href="rpshowcustomers" class="list-group-item">查询客户信息</a>
                        <a href="checkinlink" class="list-group-item">办理客户入住</a>
                    </div>
                </div>
                </s:if>
                
                <s:if test="#session.employee.postname == '收银员'">
                <a class="collapsed list-group-item" role="button" data-toggle="collapse" href="#list4">收银信息管理</a>
                <div id="list4" class="panel-collapse collapse" role="tabpanel" style="height: 0px;">
                    <div class="list-group">
                        <a href="checkinmessage" class="list-group-item">办理退房</a>
                        <a href="showallnetwork" class="list-group-item">结算网费</a>
                    </div>
                </div>
                </s:if>
                
                
                 <a class="collapsed list-group-item" role="button" data-toggle="collapse" href="#list6"> <i class="glyphicon glyphicon-cog"></i> &nbsp;系统信息管理</a>
                <div id="list6" class="panel-collapse collapse" role="tabpanel" style="height: 0px;">
                    <div class="list-group">
                       <a href='updateUser?employeeid=<s:property value="#session.employee.employeeid"/>' class="list-group-item">&nbsp;&nbsp;<i class="glyphicon glyphicon-edit"></i>&nbsp;&nbsp;修改个人信息 </a>
                        <s:if test="#session.employee.postname == '管理员'">
                        <a href="addEmployee-link" class="list-group-item"> &nbsp;&nbsp;<i class="fa fa-user-plus"></i>&nbsp;&nbsp;添加员工</a>
                         <a href="showUser" class="list-group-item">&nbsp;&nbsp;<i class="fa fa-user-md"></i>&nbsp;&nbsp;管理用户信息</a>
                    	<a href="register-link" class="list-group-item">&nbsp;&nbsp;<i class="fa fa-sign-in"></i>&nbsp;&nbsp;员工注册</a>   
                    	</s:if>                 
                    </div>
                </div>
            </div>
</s:if>
</body>
</html>