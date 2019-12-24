<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">



<body>

<div class="register-container">
	<h1>注册</h1>
	
	<form action="${pageContext.request.contextPath }/reg.html" method="post" id="registerForm" >
		<div>
			<input type="text" name="cardId" class="cardId" placeholder="您的身份证" id="cardId"  value=""/>  <!-- 放置提示信息 -->
			<font color="red"></font>
		</div>
		<div>
			<input type="text" name="name" class="name" placeholder="输入姓名"  id="name"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="输入密码" id="password" />
		</div>
		<div>
			<input type="password" name="ruserPassword" class="ruserPassword" placeholder="输入密码" id="ruserPassword" />
		</div>


		<button id="submit" type="submit">注 册</button>
	</form>
	<a href="${pageContext.request.contextPath }login.html">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>

</div>

<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.12.4.js" ></script>
<script type="text/javascript">
    var cardId = $("#cardId");
    cardId.bind("blur",function(){
        //ajax后台验证--userCode是否已存在

        $.ajax({
            type:"GET",//请求类型
            url:path+"${pageContext.request.contextPath }/ucexist.json",//请求的url
            data:{cardId:cardId.val()},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                if(data.cardId == "exist"){//账号已存在，错误提示
                    validateTip(cardId.next(),{"color":"red"},+ " 该用户账号已存在",false);
                }else{//账号可用，正确提示
                    validateTip(cardId.next(),{"color":"green"},+" 该账号可以使用",true);
                }
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                validateTip(cardId.next(),{"color":"red"},+" 您访问的页面不存在",false);
            }
        });
    });
</script>
</body>

</html>