package cn.fc.interceptor;

import cn.fc.pojo.Users;
import cn.fc.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SysInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = Logger.getLogger(SysInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		logger.debug("SysInterceptor preHandle ==========================");
		HttpSession session = request.getSession();

		Users user = (Users)session.getAttribute(Constants.USER_SESSION);

		if(null == user){
			response.sendRedirect(request.getContextPath()+"/401.jsp");
			return false;
		}
		return true;
	}

}
