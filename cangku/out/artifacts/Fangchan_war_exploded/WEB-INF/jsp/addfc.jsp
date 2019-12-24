<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/8
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>添加销售</title>
</head>
<body>
<div>
    <h1>新增销售信息</h1>
    <form action="${pageContext.request.contextPath }/sys/fc/add.html" method="post" >
        <select  name="productName" id="productName">
            <option value="0">请选择</option>
            <c:forEach var="aaa" items="${aaa}" varStatus="status">
                <option value="${aaa.id}">${aaa.productName}</option>
            </c:forEach>
        </select>
        <input type="text" name="price">
        <input type="text" name="quantity">

        <input	value="提交" type="submit" id="searchbutton">
    </form>
    <a href="${pageContext.request.contextPath }/sys/fc/fclist1.html">
        <button type="button" class="login.html">返回</button>
    </a>

</div>
</body>
</html>
