package com.jokerbase.business.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jokerbase.business.bean.Channel;
import com.jokerbase.business.bean.Media;
import com.jokerbase.business.common.Constants;
import com.jokerbase.business.common.SystemUtil;
import com.jokerbase.business.service.IChannelService;
import com.jokerbase.business.service.IMediaService;
import com.jokerbase.tools.DateUtils;
import com.jokerbase.tools.FileUpload;
import com.jokerbase.tools.Logger;
import com.jokerbase.tools.Page;
import com.jokerbase.tools.UuidFactory;


/***
 * 
 * @author jokerpu
 *
 */
@Controller
public class MediaController {
	
	private Logger logger = new Logger();
	
	@Autowired
	private IMediaService mediaService;
	
	
	@Autowired
	private IChannelService channelService;
	
	@RequestMapping("/media/tomedialist")
	public ModelAndView toMediaList(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "pageNo" ,required=false)Integer pageNo){
		Map<String, Object> message = new HashMap<String, Object>();
		if(pageNo == null || pageNo == 0){
			pageNo = 1;
		}
		int mediaCount = mediaService.count(new String[]{"isDelete"}, new Object[]{0});
		if(mediaCount == 1){
			pageNo = 1;
		}
		Page page = new Page(pageNo, Page.DEFAULT_PAGE_ROW_COUNT, mediaCount);
		List<Media> mediaList = mediaService.findByMap(new String[]{}, new Object[]{}, null, null);
		message.put("mediaList", mediaList);
		message.put("pagestring", page.getPageStringForJokerBase());
		return new ModelAndView("/media/medialist",message);
	}
	
	@RequestMapping("/media/tocreatemedia")
	public ModelAndView toCreateMedia(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> message = new HashMap<String, Object>();
		List<Channel> channelList = channelService.findByMap(new String[]{"isDelete", "channelStatus", "channelType"}, new Object[]{0, 0, 1}, null, null);
		message.put("channelList", channelList);
		return new ModelAndView("/media/createmedia", message);
	}
}
