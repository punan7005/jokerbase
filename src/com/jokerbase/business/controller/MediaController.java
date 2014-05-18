package com.jokerbase.business.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * @author bluesand
 *
 */
@Controller
@RequestMapping("/media")
public class MediaController {
	
	private Logger logger = new Logger();
	
	@Autowired
	private IMediaService mediaService;
	
	
	@Autowired
	private IChannelService channelService;
	
	@RequestMapping("/index")
	public ModelAndView indexContent(
			HttpServletResponse response, 
			HttpServletRequest request,
			@RequestParam(value = "pageNo" ,required=false)Integer pageNo){
		logger.info("index media");
		
		//Map<String, Object> message = new HashMap(); 
		if(pageNo == null || pageNo == 0){
			pageNo = 1;
		}
		int contentCount = mediaService.count(new String[]{"isDelete","channelType"}, new Object[]{0,1});
		if(contentCount == 1){
			pageNo = 1;
		}
		Page page = new Page(pageNo, Page.DEFAULT_PAGE_ROW_COUNT, contentCount);
		List<Map<String, Object>> medias = mediaService.selectPageByMap(new String[]{"isDelete","channelType"}, new Object[]{0,1}, "createTime", "desc", Page.DEFAULT_PAGE_ROW_COUNT, pageNo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("medias", medias);
		mv.addObject("REALMEDIAURL",Constants.REALMEDIAURL);
		mv.addObject("pagestring", page.getPageStringForJokerBase());
		mv.setViewName("/media/index");
		return mv;
	}
	
	@RequestMapping("/indexdesc")
	public ModelAndView indexdescContent(
			HttpServletResponse response, 
			HttpServletRequest request,
			@RequestParam(value = "pageNo" ,required=false)Integer pageNo){
		logger.info("index media");
		
		//Map<String, Object> message = new HashMap(); 
		if(pageNo == null || pageNo == 0){
			pageNo = 1;
		}
		int contentCount = mediaService.count(new String[]{"isDelete","channelType"}, new Object[]{0,3});
		if(contentCount == 1){
			pageNo = 1;
		}
		Page page = new Page(pageNo, Page.DEFAULT_PAGE_ROW_COUNT, contentCount);
		List<Map<String, Object>> medias = mediaService.selectPageByMap(new String[]{"isDelete","channelType"}, new Object[]{0,3}, "createTime", "desc", Page.DEFAULT_PAGE_ROW_COUNT, pageNo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("medias", medias);
		mv.addObject("REALMEDIAURL",Constants.REALMEDIAURL);
		mv.addObject("pagestring", page.getPageStringForJokerBase());
		mv.setViewName("/media/indexdesc");
		return mv;
	}
	
	@RequestMapping("/createindex")
	public ModelAndView createMediaIndex(){
		ModelAndView mv = new ModelAndView();
		List<Channel> channels = channelService.findByMap(new String[]{"isDelete","channelType"}, new Object[]{0,1}, "create_time","desc");
		mv.addObject("channels", channels);
		return mv;
	}
	
	@RequestMapping("/createindexdesc")
	public ModelAndView createMediaIndexdesc(){
		ModelAndView mv = new ModelAndView();
		List<Channel> channels = channelService.findByMap(new String[]{"isDelete","channelType"}, new Object[]{0,3}, "create_time","desc");
		mv.addObject("channels", channels);
		return mv;
	}
	
	
	@RequestMapping("/upload")
	public ModelAndView uploadMedia(
			HttpServletRequest request,
			HttpServletResponse response, 
			@RequestParam(value = "imgFile") MultipartFile imgFile,
			@RequestParam(value="channelId")String channelId
			){
		
		String mediaName = imgFile.getOriginalFilename();
		logger.info(mediaName);
		try {
			String url = FileUpload.upLoadFile(Constants.MEDIA_PATH, imgFile.getOriginalFilename(), imgFile.getBytes());
			
			Media media = new Media();
			
			media.setMediaId(UuidFactory.getUuid());
			media.setMediaName(mediaName);
			media.setMediaPath(url);
			media.setChannelId(channelId);
			media.setChannelType(1);
			media.setCreateId(SystemUtil.getCurrentUser(request).getUserId());
			media.setCreateTime(DateUtils.getDateTime());
			media.setIsDelete(0);
			media.setMediaStatus(0);
			
			try {
				mediaService.insert(media);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return new ModelAndView("redirect:/media/indexdesc.shtml");
	}
	
	@RequestMapping("/uploaddesc")
	public ModelAndView uploadMediadesc(
			HttpServletRequest request,
			HttpServletResponse response, 
			@RequestParam(value = "imgFile") MultipartFile imgFile,
			@RequestParam(value="channelId")String channelId,
			@RequestParam(value="mediaDesc")String mediaDesc
			){
		
		String mediaName = imgFile.getOriginalFilename();
		logger.info(mediaName);
		
		try {
			String url = FileUpload.upLoadFile(Constants.MEDIA_PATH, imgFile.getOriginalFilename(), imgFile.getBytes());
			Media media = new Media();
			media.setMediaId(UuidFactory.getUuid());
			media.setMediaName(mediaName);
			media.setMediaPath(url);
			media.setMediaDesc(mediaDesc);
			media.setChannelId(channelId);
			media.setChannelType(3);
			media.setCreateId(SystemUtil.getCurrentUser(request).getUserId());
			media.setCreateTime(DateUtils.getDateTime());
			media.setIsDelete(0);
			media.setMediaStatus(0);
			
			try {
				mediaService.insert(media);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return new ModelAndView("redirect:/media/index.shtml");
	}
	
	@RequestMapping("/del")
	public void delMedia(
			HttpServletResponse response,
			@RequestParam(value="mediaId")String mediaId){
		
		try {
			int ret = mediaService.update(mediaId, new String[]{"deleteId","deleteTime","isDelete"}, new Object[]{UuidFactory.getUuid(),DateUtils.getDateTime(),1});
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			response.getWriter().write("{\"error\":1}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
