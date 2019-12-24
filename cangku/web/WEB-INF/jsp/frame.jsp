<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/6
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="publicHeaderR">
    <p><span>下午好！</span><span style="color: #fff21b"> ${userSession.realName }</span> , 欢迎你！</p>
    <a href="${pageContext.request.contextPath }/logout.html">退出</a>
</div>


<li><a href="${pageContext.request.contextPath }/sys/fc/add">销售</a></li>
<li><a href="${pageContext.request.contextPath }/sys/fc/fclist1.html">销售信息查询</a></li>
<li><a href="${pageContext.request.contextPath }/cha.html">查看库存</a></li>


</body>
</html>
