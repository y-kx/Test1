
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/8
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="providerAdd">
    <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/sys/fc/xgfc.html" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${real_estate.id }"/>
        <div>
            <label for="cardId">用户身份证：</label>
            <input type="text" value="${real_estate.cardId }" id="cardId">
        </div>
        <div>
            <label for="projectName">项目名称：</label>
            <input type="text" name="userName" id="projectName" value="${real_estate.projectName }">
            <font color="red"></font>
        </div>


        <div>
            <label for="address">地址：</label>
            <input type="text" name="address" id="address" value="${real_estate.address }">
            <font color="red"></font>
        </div>
        <div>
            <label for="houseType">房屋类型：</label>
            <input type="text" name="houseType" id="houseType" value="${real_estate.houseType }">
        </div>
        <div>
            <label for="area">房屋大小：</label>
            <input type="text" name="area" id="area" value="${real_estate.area }">
        </div>

        <div>
            <label for="buildTime">出生日期：</label>
            <input type="text"  id="buildTime" name="buildTime" value="<fm:formatDate value="${real_estate.buildTime}" pattern="yyyy-MM-dd"/>">

        </div>
        <button id="submit" type="submit">修改</button>
        <a href="${pageContext.request.contextPath }/sys/fc/fclist1.html">
            <button type="button" class="register-tis">返回</button>
        </a>
    </form>
</div>
</body>
</html>
