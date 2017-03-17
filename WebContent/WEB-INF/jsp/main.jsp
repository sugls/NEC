<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NEC酒店管理服务系统</title>
</head>
<body>
    <s:if test="#session.employee == null">
        <jsp:forward page="${pageContext.request.contextPath}/login.jsp"/>
    </s:if>
     <div class="jumbotron">
     	<h2>欢迎使用NEC酒店服务系统</h2>
     </div>
</body>
</html>