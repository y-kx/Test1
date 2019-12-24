package cn.fc.controller;

import cn.fc.pojo.Real_estate;
import cn.fc.pojo.Sale;
import cn.fc.pojo.Users;
import cn.fc.service.UserService;
import cn.fc.tools.Constants;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class LoginController {
private Logger logger = Logger.getLogger(LoginController.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login.html")
	public String login(){
		logger.debug("LoginController welcome SMBMS==================");
		return "login";
	}
	
	@RequestMapping(value="/dologin.html",method= RequestMethod.POST)
	public String doLogin(@RequestParam String userName, @RequestParam String password, HttpServletRequest request, HttpSession session) throws Exception{
		logger.debug("doLogin====================================");
		//调用service方法，进行用户匹配
		Users user = userService.login(userName,password);
		if(null != user){//登录成功
			//放入session
			session.setAttribute(Constants.USER_SESSION, user);
			//页面跳转（frame.jsp）
			return "redirect:/sys/main.html";
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "login";
		}
	}
	
	@RequestMapping(value="/logout.html")
	public String logout(HttpSession session){
		//清除session
		session.removeAttribute(Constants.USER_SESSION);
		return "login";
	}
	@RequestMapping(value="/sys/main.html")
	public String main(){
		return "frame";
	}



	@RequestMapping(value="/reg1.html",method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user") Users user){
		return "reg";
	}

    @RequestMapping(value="/cha.html",method=RequestMethod.GET)
    public String cha( HttpSession session) throws Exception {
        List<Real_estate> roleList = null;
        roleList=userService.cha();
        session.setAttribute("roleList", roleList);
        return "cha";
    }
	@RequestMapping(value="/chaa.html",method=RequestMethod.POST)
	public String chaa(String productName, HttpServletRequest request) throws Exception {
		List<Real_estate> roleList = null;
		System.out.println("<================================>"+productName);
       if (productName.equals("0")){
  	    productName=null;
  	    return "cha";
       }
		roleList=userService.chaa(productName);

		request.setAttribute("a", roleList);
		return "cha";
	}





//	@RequestMapping(value="/reg.html",method=RequestMethod.POST)
//	public String addUserSave(Users user,HttpSession session) throws Exception {
//		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		int gender=0;
//		Users u=new  Users();
//		u.setCardId(user.getCardId());
//		u.setName(user.getName());
//		gender=user.getCardId().charAt(16);
//		if(gender%2==0){
//			u.setGender(0);
//		}else{
//			u.setGender(1);
//		}
//		u.setCreateTime(new Date());
//		u.setPassword(user.getPassword());
//		try {
//			if(userService.reg(u)){
//				return "redirect:/login.html";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "reg";
//	}

//	@RequestMapping(value="/ucexist.json")
//	@ResponseBody
//	public Object userCodeIsExit(@RequestParam String cardId){
//		System.out.println("userCodeIsExit userCode===================== "+cardId);
//		HashMap<String, String> resultMap = new HashMap<String, String>();
//		if(StringUtils.isNullOrEmpty(cardId)){
//			resultMap.put("cardId", "exist");
//		}else{
//			Users user = null;
//			try {
//				user = userService.selectUserCodeExist(cardId);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if(null != user){
//				resultMap.put("cardId", "exist");
//			} else{
//				resultMap.put("cardId", "noexist");
//			}
//		}
//		return JSONArray.toJSONString(resultMap);
//	}


}
