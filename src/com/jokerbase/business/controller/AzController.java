package com.jokerbase.business.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jokerbase.business.bean.Channel;
import com.jokerbase.business.bean.Content;
import com.jokerbase.business.bean.Media;
import com.jokerbase.business.common.Constants;
import com.jokerbase.business.service.IChannelService;
import com.jokerbase.business.service.IContentService;
import com.jokerbase.business.service.IMediaService;
import com.jokerbase.tools.JsonUtil;


@Controller
@RequestMapping("/az")
public class AzController {
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IContentService contentService;
	@Autowired
	private IMediaService mediaService;
	
	
	@RequestMapping("/content")
	public ModelAndView getChannelContentByChannel(
			@RequestParam(value="contentId")String contentId,
			@RequestParam(value="channelId")String channelId
			){
		if("".equals(contentId) || contentId == null){
			return null;
		} 
		Channel channel = channelService.findById(channelId);
		Content content = contentService.findById(contentId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("channel", channel);
		mv.addObject("content", content);
		mv.setViewName("/az/content");
		return mv;
	}
	
	@RequestMapping("/list")
	public ModelAndView getChannelContentListByChannel(
			@RequestParam(value="channelId")String channelId){
		if("".equals(channelId) || channelId == null){
			return null;
		}
		
		List<Channel> channellist = channelService.findByMap(new String[]{"isDelete"}, new Object[]{0}, "create_time", null);
		
		Channel channel = channelService.findById(channelId);
		
		String url = this.getChannelPageForChannelType(channel.getChannelType());
		ModelAndView mv = new ModelAndView();
		mv.setViewName(url);
		
		mv.addObject("channel", channel);
		mv.addObject("channellist", channellist);
		if(channel.getChannelType()==0){
			List<Content> contents = contentService.findByMap(new String[]{"channelId"}, new Object[]{channelId}, "create_time", "desc");
			mv.addObject("contents", contents);
		}
		if(channel.getChannelType()==1){
			List<Media> medias = mediaService.pageQueryBy(new String[]{"channelId"}, new Object[]{channelId}, "create_time", "desc",12,1);
			mv.addObject("REALMEDIAURL",Constants.REALMEDIAURL);
			mv.addObject("medias", medias);
		}
		if(channel.getChannelType() ==2){
			List<Content> contents = contentService.findByMap(new String[]{"channelId"}, new Object[]{channelId}, "create_time", "desc");
			if(contents!=null && contents.size()>0){
				mv.addObject("content", contents.get(0));
			}
		}
		return mv;
	}
	
	@RequestMapping("/listhtml")
	public void getChannelContentHtmlByChannel(
			@RequestParam(value="channelId")String channelId,
			@RequestParam(value="pageNo")Integer pageNo,
			HttpServletResponse response){
		
		if(pageNo == null || pageNo == 0){
			pageNo = 1;
		}
//		int contentCount = mediaService.count(new String[]{"isDelete"}, new Object[]{0});
//		if(contentCount == 1){
//			pageNo = 1;
//		}
//		Page page = new Page(pageNo, Page.DEFAULT_PAGE_ROW_COUNT, contentCount);
//		List<Map<String, Object>> medias = mediaService.selectPageByMap(new String[]{"isDelete","channelId "}, new Object[]{0,channelId}, "createTime", "desc", 12, pageNo);
//		
		List<Media> medias = mediaService.pageQueryBy(new String[]{"isDelete","channelId"}, new Object[]{0,channelId}, "create_time", "desc",12,pageNo);
		
//		StringBuffer sb = new StringBuffer();
//		sb.append("<ul>");
//		for(Media media : medias) {
//			sb.append("<li><a href='#'><img src='");
//			sb.append(Constants.REALMEDIAURL+media.getMediaPath());
//			sb.append("' width='300px' height='200px' ></img></a></li>");
//		}
//		sb.append("</ul>");
//		try {
//			response.getWriter().write(sb.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			response.getWriter().print(mapper.writeValueAsString(medias));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public String getChannelPageForChannelType(Integer channelType){
		if(channelType == null){
			return "/az/index";
		}
		String url = null;
		//图文类
		if(channelType == 0){
			url = "/az/contents";
		}
		//媒体类
		if(channelType == 1){
			url = "/az/medias";
		}
		
		if(channelType == 2){
			url = "/az/content";
		}
		return url;
	}
}
