<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>登录</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">

<script type="text/javascript">
    function check() {
        var cardId = document.getElementById("cardId").value;
        var password = document.getElementById("password").value;
        if(cardId==""){
            alert("用户不能为空！！！！");
            return false;
        }
        if(password==""){
            alert("密码不能为空！！！！");
            return false;
        }
        return true;
    }
</script>
<body>

<div class="login-container">
    <h1>登录</h1>

    <div class="connect">

    </div>

    <form action="${pageContext.request.contextPath }/dologin.html" method="post" id="loginForm">
        <div class="info">${error }</div>
        <div>
            <input type="text" name="userName" class="cardId" placeholder="用户名" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
        </div>
        <button id="submit" type="submit">登 陆</button>
    </form>

    <%--<a href="${pageContext.request.contextPath}/reg1.html">--%>
        <%--<button type="button" class="register-tis">还有没有账号？</button>--%>
    <%--</a>--%>

</div>

<%--<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>--%>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">

</div>
</body>
</html>