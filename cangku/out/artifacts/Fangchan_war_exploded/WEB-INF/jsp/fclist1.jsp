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
<p><span>下午好！</span><span style="color: #fff21b"> ${userSession.realName }</span> , 欢迎你！</p>
<a href="${pageContext.request.contextPath }/logout.html">退出</a>

<form method="post" action="${pageContext.request.contextPath }/sys/fc/fclist1.html">
    <span>排序方式：</span>
    <select  name="name" class="input-text">
        <option value="saleDate" selected>销售日期</option>
        <option value="totalPrice">单笔总价</option>
    </select>
    <input type="hidden" name="pageIndex" value="1"/>
    <input	value="提交" type="submit" id="searchbutton">
    <%--<a href="${pageContext.request.contextPath}/sys/fc/add.html" >添加房产</a>--%>
</form>
<!--用户-->
<table class="providerTable" cellpadding="0" cellspacing="0" id="table" border="1">
    <tr class="firstTr">
        <th width="10%">ID</th>
        <th width="10%">商品</th>
        <th width="10%">单价</th>
        <th width="10%">数量</th>
        <th width="10%">总价</th>
        <th width="10%">销售日期</th>
        <th width="10%">销售员</th>
        <%--<th width="15%">操作</th>--%>
    </tr>
    <c:forEach var="rs" items="${roleList}" varStatus="status">
        <tr>
            <td>
                <span>${rs.id }</span>
            </td>
            <td>
                <span>${rs.productName}</span>
            </td>
            <td>
                <span>${rs.price}</span>
            </td>
            <td>
                <span>${rs.quantity}</span>
            </td>
            <td>
                <span>${rs.totalPrice}</span>
            </td>

            <td>
                <span> ${rs.saleDate}</span>
            </td>
            <td>
                <span>${rs.realName}</span>
            </td>
            <%--<td>--%>
                <%--<span><a  href="${pageContext.request.contextPath}/sys/fc/view?id=${rs.id}" >查询</a></span>--%>
                <%--<span><a  href="${pageContext.request.contextPath}/sys/fc/xgfc.html?id=${rs.id}">修改</a></span>--%>
               <%--<span><a  href="${pageContext.request.contextPath}/sys/fc/del.html" >删除</a></span>--%>
            <%--</td>--%>
        </tr>
    </c:forEach>
</table>
<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
<c:import url="rollpage.jsp">
    <c:param name="totalCount" value="${totalCount}"/>
    <c:param name="currentPageNo" value="${currentPageNo}"/>
    <c:param name="totalPageCount" value="${totalPageCount}"/>
</c:import>


<script type="text/javascript">

    // 实现隔行变色，鼠标移入高亮

    var table = document.getElementById("table");

    var oldColor = "";//声明一个变量，保存表格原来的颜色

    for(var i = 0; i < table.tBodies[0].rows.length; i++) {

        //使用判断实现隔行变色

        if(i % 2 == 0) {



            table.tBodies[0].rows[i].style.backgroundColor = "#FFFACD";

        } else {

            table.tBodies[0].rows[i].style.backgroundColor = "	#E0FFFF";

        }

        //实现鼠标移入高亮

        table.tBodies[0].rows[i].onmouseover = function() {

            oldColor = this.style.backgroundColor;

            this.style.backgroundColor = "white";

        }

        //实现鼠标移出变回原来的颜色

        table.tBodies[0].rows[i].onmouseout = function() {

            this.style.backgroundColor = oldColor;

        }

    }

</script>
</body>
</html>
