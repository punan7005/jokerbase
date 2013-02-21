package com.jokerbase.plugins.interceptor;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jokerbase.business.common.SystemUtil;




/** 
 * 类说明 :核心拦截器
 * @author  joker 
 * 创建时间：2012-9-22 下午4:17:53 
 */
public class CoreInterceptor implements HandlerInterceptor{

	//afterCompletion()方法在DispatcherServlet完全处理完请求后被调用
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception e)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//postHandle()方法在业务处理器处理请求之后被调用
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//preHandle()方法在业务处理器处理请求之前被调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		// TODO Auto-generated method stub
		String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
//		String ctx = request.getScheme()+"://"+request.getServerName()+request.getContextPath()+"/";
		String requestURL = request.getRequestURL().toString();
		if(SystemUtil.isLogin(request)){
			return true;
		}else{
			if(requestURL.equals(ctx + "login.shtml") || requestURL.equals(ctx + "tologin.shtml") || requestURL.equals(ctx + "captcha-image.shtml")){
				return true;
			}else{
//				request.getRequestDispatcher("/index.jsp").forward(request, response);
				SystemUtil.isLogin(request);
				response.sendRedirect(ctx+"index.jsp");
			}
		}
		return false;
	}

}
