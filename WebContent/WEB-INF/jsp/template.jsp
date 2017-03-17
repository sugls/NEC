<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NEC酒店管理服务系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <s:if test="#session.employee != null">
        <div class="container body-wrapper">
            <div class="row">
                <div class="col-md-3 sidebar">
                    <tiles:insertAttribute name="menu"/>
                </div>
                <div class="col-md-9">
                    </s:if>
                    <tiles:insertAttribute name="content"/>
                    <s:if test="#session.employee != null">
                </div>
            </div>
        </div>
    </s:if>
    <tiles:insertAttribute name="footer"/>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
</body>
</html>