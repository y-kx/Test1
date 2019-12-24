<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/7
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>

<body>


    <form method="post" action="${pageContext.request.contextPath }/chaa.html">
    商品名称：
    <select  name="productName" id="productName">
        <option value="0">请选择</option>
        <c:forEach var="rs" items="${roleList}" varStatus="status">
        <option value="${rs.productName}">${rs.productName}</option>
        </c:forEach>
    </select>
    <input	value="提交" type="submit" id="searchbutton">
</form>
<c:forEach var="rs" items="${a}" varStatus="status">
    <c:if test="${rs.quantity!=null && rs.quantity!=''}">
        <p>该商品的数量《${rs.quantity}》</p>
    </c:if>
</c:forEach>
<!--用户-->
</body>
</html>
