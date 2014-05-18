package com.jokerbase.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jokerbase.business.bean.User;
import com.jokerbase.business.dao.impl.UserDao;
import com.jokerbase.business.service.IUserService;
import com.jokerbase.tools.Page;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/touserlist")
	public ModelAndView toUserList(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="pageNo",required=false) Integer pageNo){
		Map<String, Object> message = new HashMap();
		if(pageNo == null || pageNo == 0){
			pageNo = 1;
		}
		int userCount = userService.count(new String[]{}, new Object[]{});
		if(userCount == 1){
			pageNo = 1;
		}
		Page page = new Page(pageNo, Page.DEFAULT_PAGE_ROW_COUNT, userCount);
		List<User> userlist = userService.findByMap(new String[]{"isDelete"}, new Object[]{"0"}, "create_time", "desc");
		message.put("userlist", userlist);
		message.put("pagestring", page.getPageStringForJokerBase());
		return new ModelAndView("user/userlist", message);
	}
	
	@RequestMapping("/tocreateuser")
	public ModelAndView toCreateUser(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> message = new HashMap();
		return new ModelAndView("user/createuser");
	}
	
	@RequestMapping("/createuser")
	public ModelAndView createUser(HttpServletRequest request, HttpServletResponse response, User user){
		Map<String, Object> message = new HashMap();
		if(user == null){
			return null;
		}
		userService.createUser(request, user);
		return new ModelAndView("redirect:/user/touserlist.shtml");
	}
	
	@RequestMapping("/toupdateuser")
	public ModelAndView toupdateuser(HttpServletRequest request, HttpServletResponse response, String userId){
		Map<String, Object> message = new HashMap();
		if("".equals(userId) || userId == null){
			return null;
		}
		User user = userService.findById(userId);
		message.put("user", user);
		return new ModelAndView("user/modifyuser", message);
	}
	
	@RequestMapping("/updateuser")
	public ModelAndView updateuser(HttpServletRequest request, HttpServletResponse response, User user){
		Map<String, Object> message = new HashMap();
		if(user == null){
			return null;
		}
		userService.updateUser(request, user);
		return new ModelAndView("redirect:/user/touserlist.shtml");
	}
	
	@RequestMapping("/deleteuser")
	public ModelAndView deleteuser(HttpServletRequest request, HttpServletResponse response, String userId){
		Map<String, Object> message = new HashMap();
		if("".equals(userId) || userId == null){
			return null;
		}
		userService.deleteUser(request, userId);
		return new ModelAndView("redirect:/user/touserlist.shtml");
	}
}
