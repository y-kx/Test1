package cn.fc.controller;

import cn.fc.pojo.Real_estate;
import cn.fc.pojo.Sale;
import cn.fc.pojo.Users;
import cn.fc.service.UserService;
import cn.fc.tools.Constants;
import cn.fc.tools.PageSupport;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.jboss.logging.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/sys/fc")
public class UserController extends BaseController {
	private Logger logger = Logger.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@RequestMapping(value = "/fclist1.html")
	public String getUserList(Model model,@RequestParam(value = "name", required = false) String name, @RequestParam(value = "pageIndex", required = false) String pageIndex) {
		/*logger.info("getUserList ---- > queryUserName: " + queryUserName);
		logger.info("getUserList ---- > queryUserRole: " + queryUserRole);
		logger.info("getUserList ---- > pageIndex: " + pageIndex);*/

		System.out.println("getUserList ---- > name: " + name);
		System.out.println("getUserList ---- > pageIndex: " + pageIndex);
		/*Integer _queryUserRole = null;*/
		/*		List<Users> userList = null;*/
		List<Sale> roleList = null;
		//设置页面容量
		int pageSize = Constants.pageSize;
		//当前页码
		int currentPageNo = 1;
		if (name != null && !name.equals("")) {
			name = (name);
		}

		if (pageIndex != null) {
			try {
				currentPageNo = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				return "redirect:/syserror.html";
			}
		}
		//总数量（表）
		int totalCount = 0;
		try {
			totalCount = userService.getUserCount(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		//控制首页和尾页
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		try {
			roleList = userService.getUserList(name,currentPageNo, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*	model.addAttribute("userList", userList);*/
		model.addAttribute("roleList", roleList);
		model.addAttribute("name", name);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		System.out.println("============================>"+name);
		return "fclist1";
	}



/*
	@RequestMapping(value="/login.html")
	public String login(){
		logger.debug("LoginController welcome SMBMS==================");
		return "login";
	}

	@RequestMapping(value="/dologin.html",method=RequestMethod.POST)
	public String doLogin(@RequestParam String cardId,@RequestParam String password,HttpServletRequest request,HttpSession session) throws Exception {
		System.out.println("doLogin====================================");
		//调用service方法，进行用户匹配
		Users user = userService.login(cardId, password);
		if (null != user) {//登录成功
			//放入session
			session.setAttribute(Constants.USER_SESSION, user);
			//页面跳转（frame.jsp）
			return "redirect:/main.html";
		} else {
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "login";
		}
	}
	@RequestMapping(value="/main.html")
	public String main(){
		return "frame";
	}
*/




	/*@RequestMapping(value="/reg.html",method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user") Users user){
		return "reg";
	}

	@RequestMapping(value="/reg.html",method=RequestMethod.POST)
	public String addUserSave(Users user,HttpSession session) throws Exception {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	int gender=0;
	Users u=new  Users();
	u.setCardId(user.getCardId());
	u.setName(user.getName());
	gender=user.getCardId().charAt(16);
	if(gender%2==0){
		u.setGender(0);
	}else{
		u.setGender(1);
	}
	u.setCreateTime(new Date());
	u.setPassword(user.getPassword());
		try {
			if(userService.reg(u)){
				return "redirect:sys/fc/dologin.html";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "reg";
	}*/

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser( Model model) throws Exception {
		List<Real_estate> aaa = null;
		aaa=userService.cha();
		model.addAttribute("aaa", aaa);
		System.out.println(aaa.toString());
		return "addfc";
	}
	@RequestMapping(value = "/add.html", method = RequestMethod.POST)
	public String addUserSave(String productName,int price ,int quantity, HttpSession session) throws Exception {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+productName);
		Sale sale=new Sale();
		sale.setPrice(price);
		sale.setQuantity(quantity);
		int a=price*quantity;
		sale.setTotalPrice(a);
		int aa=Integer.parseInt(productName);
		if (aa==0) {
			return "addfc";
		}
		sale.setProductId(aa);
		sale.setUserId(((Users)session.getAttribute(Constants.USER_SESSION)).getId());


		try {
			if (userService.add(sale)) {
				return "redirect:/sys/fc/fclist1.html";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addfc";
	}

	@RequestMapping(value="/xgfc.html",method=RequestMethod.GET)
	public String getUserById(@RequestParam Integer id,Model model) throws Exception {
		logger.debug("view id===================== "+id);
		Real_estate real_estate= userService.getRealById(id);
		model.addAttribute(real_estate);
		return "xgfc";
	}

	@RequestMapping(value="/xgfc.html",method=RequestMethod.POST)
	public String modifyUserSave(Real_estate real_estate,HttpSession session) throws Exception {
		logger.debug("modifyUserSave userid===================== "+real_estate.getId());

		if(userService.modify(real_estate)){
			return "redirect:/sys/fc/fclist1.html";
		}
		return "xgfc";
	}

	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Real_estate r, @RequestParam("id") Integer id, Model model, HttpServletRequest request){
		logger.debug("view id===================== "+id);
		System.out.println("bbbdddddddddddddddddd");
		try {
			r = userService.getRealById(7);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute(r);
		return "fcview";
	}
}