package com.jokerbase.business.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jokerbase.business.dao.IUserDao;

/** 
 * 类说明 :登录控制器
 * @author  joker 
 * 创建时间：2013-2-1 下午4:23:41 
 */
@Controller
public class LoginController {
	@Autowired
	private IUserDao userDao;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> message = new HashMap();
		try {
			System.out.println("go");
			return new ModelAndView("/manage/manageindex");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("登录出错");
			return new ModelAndView("/error");
		}
	}
	
}
