
var cardId = null;
var name = null;
var password = null;

$(function(){
    cardId = $("#cardId");
    name = $("#userName");
    password = $("#userPassword");
    ruserPassword = $("#ruserPassword");
    //初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
    cardId.next().html("*");
    name.next().html("*");
    password.next().html("*");
    ruserPassword.next().html("*");

	/*
	 * 验证
	 * 失焦\获焦
	 * jquery的方法传递
	 */
	cardId.bind("blur",function(){
		//ajax后台验证--userCode是否已存在
		alert("aaaaaa")
		$.ajax({
			type:"GET",//请求类型
			url:path+"/ucexist/"+cardId.val,//请求的url
			data:{},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.cardId == "exist"){//账号已存在，错误提示
					validateTip(cardId.next(),{"color":"red"},+ " 该身份证已注册过",false);
				}else{//账号可用，正确提示
					validateTip(cardId.next(),{"color":"green"},+" 该身份证可以使用",true);
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				validateTip(cardId.next(),{"color":"red"},+" 您访问的页面不存在",false);
			}
		});
	}).bind("focus",function(){
		//显示友情提示
		validateTip(cardId.next(),{"color":"#666666"},"* 身份证是您登录系统的账号",false);
	}).focus();
	
	cardId.bind("focus",function(){
		validateTip(cardId.next(),{"color":"#666666"},"* 身份证长度必须是等于18的字符",false);
	}).bind("blur",function(){
		if(userName.val() != null && userName.val().length ==18
				){
			validateTip(cardId.next(),{"color":"green"},true);
		}else{
			validateTip(userName.next(),{"color":"red"},+" 用户名输入的不符合规范，请重新输入",false);
		}
		
	});
	
	password.bind("focus",function(){
		validateTip(userPassword.next(),{"color":"#666666"},"* 密码长度必须是大于6小于20",false);
	}).bind("blur",function(){
		if(userPassword.val() != null && userPassword.val().length > 6
				&& userPassword.val().length < 20 ){
			validateTip(userPassword.next(),{"color":"green"},true);
		}else{
			validateTip(userPassword.next(),{"color":"red"} + " 密码输入不符合规范，请重新输入",false);
		}
	});
	
	ruserPassword.bind("focus",function(){
		validateTip(ruserPassword.next(),{"color":"#666666"},"* 请输入与上面一只的密码",false);
	}).bind("blur",function(){
		if(ruserPassword.val() != null && ruserPassword.val().length ==18
				 && password.val() == ruserPassword.val()){
			validateTip(ruserPassword.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(ruserPassword.next(),{"color":"red"},imgNo + " 两次密码输入不一致，请重新输入",false);
		}
	});
	

	
	addBtn.bind("click",function(){
		if(cardId.attr("validateStatus") != "true"){
			userCode.blur();
		}else if(name.attr("validateStatus") != "true"){
			userName.blur();
		}else if(password.attr("validateStatus") != "true"){
			userPassword.blur();
		}else if(ruserPassword.attr("validateStatus") != "true"){
			ruserPassword.blur();
		}
		else{
			if(confirm("是否确认提交数据")){
				$("#userForm").submit();
			}
		}
	});
});
/*
	backBtn.on("click",function(){
		if(referer != undefined
			&& null != referer
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
*/

