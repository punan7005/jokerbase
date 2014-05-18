package com.jokerbase.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jokerbase.business.bean.Channel;
import com.jokerbase.business.bean.Media;
import com.jokerbase.business.bean.User;
import com.jokerbase.business.common.Constants;
import com.jokerbase.business.common.SystemUtil;
import com.jokerbase.business.service.IChannelService;
import com.jokerbase.business.service.IMediaService;
import com.jokerbase.business.service.IUserService;
import com.jokerbase.tools.MD5Util;

/** 
 * 类说明 :登录控制器
 * @author  joker 
 * 创建时间：2013-2-1 下午4:23:41 
 */
@Controller
public class LoginController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IMediaService mediaService;
	
	
	@RequestMapping("/tologin")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, User user){
		Map<String, Object> message = new HashMap();
		User loginUser = null;
		try {
			if(user == null){
				return new ModelAndView("/login");
			}
			String password = MD5Util.getMD5String(user.getUserPassword());
			user.setUserPassword(password);
			loginUser = userService.loginByMap(user);
			if(loginUser == null){
				return new ModelAndView("/login");
			}
			SystemUtil.setLoginUser(request, loginUser);
			message.put("currentUser", SystemUtil.getCurrentUser(request));
			return new ModelAndView("/manage/manageindex", message);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("登录出错");
			return new ModelAndView("/login");
		}
	}
	@RequestMapping("/index")
	public ModelAndView toIndex(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> message = new HashMap();
		List<Channel> channellist = channelService.findByMap(new String[]{"isDelete"}, new Object[]{0}, "create_time", null);
		message.put("channellist", channellist);
		
		List<Media> medias = mediaService.pageQueryBy(new String[]{"isDelete"}, new Object[]{0}, "create_time", "desc", 8, 1);
		message.put("medias", medias);
		message.put("REALMEDIAURL",Constants.REALMEDIAURL);
		return new ModelAndView("az/index", message);
	}
}
