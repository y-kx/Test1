<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/8
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="providerView">
    <p><strong>身份证号：</strong><span>${real_estate.cardId }</span></p>
    <p><strong>项目名称：</strong>
      <%--  <span>
            		<c:if test="${user.gender == 1 }">男</c:if>
					<c:if test="${user.gender == 2 }">女</c:if>
				</span>--%>
        <span>${real_estate.projectName }</span>
    </p>
    <p><strong>地址：</strong><span>${real_estate.address }</span></p>
    <p><strong>房屋类型：</strong><span>${real_estate.houseType }</span></p>
    <p><strong>房屋大小：</strong><span>${real_estate.area}</span></p>
    <p><strong>创建时间：</strong><span><fm:formatDate value="${real_estate.buildTime}" pattern="yyyy-MM-dd"/></span></p>
    <a href="${pageContext.request.contextPath }/sys/fc/fclist1.html">
        <button type="button" class="register-tis">返回</button>
    </a>
</div>
</body>
</html>
