<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="zh_CN">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>NEC酒店管理服务系统</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/form-elements.css">
    <link rel="stylesheet" href="css/style.css">

    <link rel="shortcut icon" href="favicon.ico">
    <script src="js/jquery-1.12.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.backstretch.min.js"></script>
	<script src="js/scripts.js"></script>

    <style type="text/css">
        .select{
            background-color: #f8f8f8;
            position: relative;
        }
         .select:after{
            content: '';
            display: block;
            width: 10px;
            height: 10px;
            border-left: 1px #000 solid;
            border-bottom: 1px #000 solid;
            position: absolute;
            top: 18px;
            right: 14px;
            transform: rotate(-45deg);
            transition: transform 0.3s ease-out, top 0.3s ease-out;
        }
         .select p{
            height: 50px;
             line-height: 47px;
            cursor: pointer;
             padding-left: 20px;
             margin: auto;
             border: #ddd solid 3px;
             border-top-right-radius: 3px;
             border-bottom-right-radius: 3px;
        }
         .select ul{
            list-style-type: none;
            background-color: #fff;
            width: 100%;
            overflow-y: auto;
            position: absolute;
            top: 52px;
            left: 0;
            max-height: 0;
            transition: max-height 0.3s ease-out;
            z-index: 3;
        }
        .select ul li{
            padding: 0 15px;
            line-height: 40px;
            cursor: pointer;
        }
         .select ul li:hover{
            background-color: #e0e0e0;
        }
        .select ul li.selected{
            background-color: #39f;
            color: #fff;
        }
        @-webkit-keyframes slide-down{
            0%{transform: scale(1,0);}
            25%{transform: scale(1,1.2);}
            50%{transform: scale(1,0.85);}
            75%{transform: scale(1,1.05);}
            100%{transform: scale(1,1);}
        }
         .select.open ul{
            max-height: 250px;
            transform-origin: 50% 0;
            -webkit-animation:slide-down .5s ease-in;
            transition: max-height .2s ease-out;
        }
        .select.open:after{
            transform: rotate(-225deg);
            top: 18px;
            transition: all 0.3s ease-in;
        }
    </style>

</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3><strong>NEC酒店管理服务系统登录</strong></h3>
                            <p>请选择登录角色，输入用户名和密码登录。</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="checklogin" method="post" class="login-form">
                            <s:if test="#request.error != null">
                                <div class="alert alert-danger" role="alert">
                                    <span class="glyphicon glyphicon-alert"></span>&nbsp;&nbsp;
                                    <s:property value="#request.error"/></div>
                            </s:if>
                            <div class="form-group">
                                <label class="sr-only" for="form-role">角色</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-hand-o-right fa-2x"></i></span>
                                    <div class="select">
                                        <p id="form-role">请选择登录角色</p>
                                        <input type="hidden" name="userinfo.postname" id="postname" value="-1">
                                        <ul class="">
                                            <li data-value="RP">前台接待</li>
                                            <li data-value="CS">收银员</li>
                                            <li data-value="RM">房管员</li>
                                            <li data-value="AD">管理员</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-username">用户名</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa-2x"></i></span>
                                    <input type="text" name="userinfo.username" placeholder="请输入用户名" class="form-username form-control" id="form-username">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">密码</label>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-2x"></i></span>
                                    <input type="password" name="userinfo.userpwd" placeholder="请输入密码" class="form-password form-control" id="form-password">
                                </div>
                            </div>
                            <button type="submit" class="btn">登录</button>
                            <br/><br/>
                            <span class="pull-right">新员工?<a href="register-link">去注册登录账号</a></span>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- Javascript -->


<!--[if lt IE 10]>
<script src="js/placeholder.js"></script>
<![endif]-->


<script type="text/javascript">
    $(function(){
        $('.select > p').on('click',function(e){
            $('.select').toggleClass('open');
            e.stopPropagation();
        });
        $('.select ul li').on('click',function(e){
            var _this = $(this);
            $('.select > p').text(_this.html());
            $('#postname').attr("value",_this.attr("data-value"));
            _this.addClass('selected').siblings().removeClass('selected');
            $('.select').removeClass('open');
            e.stopPropagation();
        });
        $(document).on('click',function(){
            $('.select').removeClass('open');
        });
    });
</script>

</body>

</html>