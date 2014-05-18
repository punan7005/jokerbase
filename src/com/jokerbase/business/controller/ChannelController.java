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

import com.jokerbase.business.bean.Channel;
import com.jokerbase.business.common.SystemUtil;
import com.jokerbase.business.service.IChannelService;
import com.jokerbase.tools.DateUtils;
import com.jokerbase.tools.Page;
import com.jokerbase.tools.UuidFactory;

/** 
 * 类说明 :分类控制器
 * @author  joker 
 * 创建时间：2013-2-21 下午2:00:48 
 */
@Controller
@RequestMapping("/channel")
public class ChannelController {
	
	@Autowired
	private IChannelService channelService;
	
	@RequestMapping("/tochannellist")
	public ModelAndView toChannellist(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="pageNo",required=false) Integer pageNo){
		Map<String, Object> message = new HashMap();
		if(pageNo == null || pageNo == 0){
			pageNo = 1;
		}
		int channelCount = channelService.count(new String[]{"isDelete"}, new Object[]{0});
		if(channelCount == 1){
			pageNo = 1;
		}
		Page page = new Page(pageNo, Page.DEFAULT_PAGE_ROW_COUNT, channelCount);
		List<Map<String, Object>> channelList = channelService.selectPageByMap(new String[]{"isDelete"}, new Object[]{0}, "createTime", "desc", Page.DEFAULT_PAGE_ROW_COUNT, pageNo);
		message.put("channelList", channelList);
		message.put("pagestring", page.getPageStringForJokerBase());
		return new ModelAndView("channel/channellist", message);
	}
	
	@RequestMapping("/tocreatechannel")
	public ModelAndView toCreateChannel(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> message = new HashMap();
		return new ModelAndView("channel/createchannel");
	}
	
	@RequestMapping("/createchannel")
	public ModelAndView createChannel(HttpServletRequest request, HttpServletResponse response, Channel channel){
		Map<String, Object> message = new HashMap();
		if(channel == null){
			return null;
		}
		channelService.createChannel(request, channel);
		return new ModelAndView("redirect:/channel/tochannellist.shtml");
	}
	
	@RequestMapping("/toupdatechannel")
	public ModelAndView toUpdateChannel(HttpServletRequest request, HttpServletResponse response, String channelId){
		Map<String, Object> message = new HashMap();
		if(channelId == null || "".equals(channelId)){
			return null;
		}
		Channel channel = channelService.findById(channelId);
		Channel parentChannel = channelService.findById(channel.getChannelParentId());
		message.put("channel", channel);
		message.put("parentChannel", parentChannel);
		return new ModelAndView("channel/modifychannel", message);
	}
	
	@RequestMapping("/updatechannel")
	public ModelAndView updateChannel(HttpServletRequest request, HttpServletResponse response, Channel channel){
		Map<String, Object> message = new HashMap();
		if(channel == null){
			return null;
		}
		channelService.updateChannel(request, channel);
		return new ModelAndView("redirect:/channel/tochannellist.shtml");
	}
	
	@RequestMapping("/deletechannel")
	public ModelAndView deleteChannel(HttpServletRequest request, HttpServletResponse response, String channelId){
		Map<String, Object> message = new HashMap();
		if(channelId == null){
			return null;
		}
		channelService.deleteChannel(request, channelId);
		return new ModelAndView("redirect:/channel/tochannellist.shtml");
	}
}
