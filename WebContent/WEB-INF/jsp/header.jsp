<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<nav class="nav navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <span class="navbar-brand">NEC酒店管理服务系统</span>
        </div>
        
        <div class="collapse navbar-collapse" id="navbar-collapse-1">

            <ul class="nav navbar-nav">
                <li><a href="main">首页</a></li>

                <li><a href="help-manual" target="_blank">帮助</a></li>
                <li><a href="#" data-toggle="modal" data-backdrop="false" data-target="#aboutModal">关于</a></li>
            </ul>
            <s:if test="#session.employee != null">
                <a href="logout" class="navbar-text  navbar-link navbar-right"> <i class="fa fa-sign-out"></i> 注销登录</a>
            </s:if>
        <s:if test="#session.employee == null">
            <form action="${pageContext.request.contextPath}/index.jsp" class="navbar-form navbar-right" role="form">
                <button type="submit" class="btn btn-info"> <i class="fa fa-sign-in"></i> 登录</button>
            </form>
        </s:if>

        <p class="navbar-text navbar-right">当前时间：<span id="today"></span></p>
           
           
    </div>
    </div>
</nav>
<div class="modal fade" tabindex="-1" id="aboutModal" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <a class="close" data-dismiss="modal">×</a>
                <h4 class="modal-title">关于</h4>
            </div>
            <div class="modal-body">
                <p>NEC酒店服务管理系统。。。。。</p>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn btn-primary" data-dismiss="modal">知道了</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>