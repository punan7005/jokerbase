package com.jokerbase.business.common;

import javax.servlet.http.HttpServletRequest;

import com.jokerbase.business.bean.User;





public final class SystemUtil {
	
	public static void setLoginUser(HttpServletRequest request, User user){
		request.getSession().setAttribute(Constants.SESSION_USER_KEY, user);
	}
	
	public static User getCurrentUser(HttpServletRequest request){
		Object user = request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		if(user != null) return (User)user;
		else return null;
	}
	
	public static boolean isLogin(HttpServletRequest request){
		if(request.getSession().getAttribute(Constants.SESSION_USER_KEY) == null) return false;
		else return true;
	}
	
	public static boolean clearLogin(HttpServletRequest request){
		request.getSession().removeAttribute(Constants.SESSION_USER_KEY);
		return true;
	}
	
}
