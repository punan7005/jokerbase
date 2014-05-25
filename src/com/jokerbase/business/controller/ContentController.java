package com.jokerbase.business.controller;

import java.io.IOException;
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
import com.jokerbase.business.bean.Content;
import com.jokerbase.business.common.Constants;
import com.jokerbase.business.common.SystemUtil;
import com.jokerbase.business.service.IChannelService;
import com.jokerbase.business.service.IContentService;
import com.jokerbase.tools.DateUtils;
import com.jokerbase.tools.FileUpload;
import com.jokerbase.tools.JsonUtil;
import com.jokerbase.tools.Logger;
import com.jokerbase.tools.Page;
import com.jokerbase.tools.UuidFactory;

/** 
 * 类说明 :内容控制器
 * @author  joker 
 * 创建时间：2013-2-21 下午1:57:41 
 */
@Controller
public class ContentController {
	
	@Autowired
	private IContentService contentService;
	
	@Autowired
	private IChannelService channelService;
	
	private Logger logger = new Logger();

	@RequestMapping("/content/tocratecontent")
	public ModelAndView indexContent(
			HttpServletResponse response, 
			HttpServletRequest request,
			@RequestParam(value="contentId",required=false)String contentId){
		Map<String, Object> message = new HashMap<String, Object>();
		List<Channel> channellist = channelService.findByMap(new String[]{"channelStatus", "isDelete"}, new Object[]{0, 0}, null, null);
		message.put("channellist", channellist);
		return new ModelAndView("/content/createcontent",message);
	}
	
	@RequestMapping("/content/tomoditycontent")
	public ModelAndView editContent(
			HttpServletResponse response, 
			HttpServletRequest request,
			@RequestParam(value="contentId",required=false)String contentId){
		logger.info("index Content");
		ModelAndView mv = new ModelAndView();
		
		List<Channel> channels = channelService.findByMap(new String[]{"isDelete","channelStatus"}, new Object[]{0,0}, null, null);
		mv.addObject("channels", channels);
		if(contentId!=null){
			Content content = contentService.findById(contentId);
			mv.addObject("content",content);
		}
		mv.setViewName("/content/modifycontent");
		return mv;
	}
	
	
	
	@RequestMapping("/content/create")
	public ModelAndView createContent(HttpServletResponse response, 
			HttpServletRequest request,
			@RequestParam(value="content")String content,
			@RequestParam(value="contentTitle")String contentTitle,
			@RequestParam(value="channelId")String channelId
			){
		ModelAndView mv = new ModelAndView();
		mv.addObject("content", content);
		System.out.println(content);
		
		Content contentObj = new Content();
		contentObj.setContentId(UuidFactory.getUuid());
		contentObj.setContentChannelId(channelId);
		contentObj.setContentTitle(contentTitle);
		contentObj.setContentMain(content);
		contentObj.setCreateId(SystemUtil.getCurrentUser(request).getUserId());
		contentObj.setCreateTime(DateUtils.getDateTime());
		contentObj.setIsDelete(0);
		contentObj.setContentStatus(0);
		try {
			logger.info("insert content:" + contentService.insert(contentObj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/content/tocontentlist.shtml");
	}
	
	@RequestMapping("/content/update")
	public ModelAndView updateContent(HttpServletResponse response, 
			HttpServletRequest request,
			@RequestParam(value="contentId")String contentId,
			@RequestParam(value="content")String content,
			@RequestParam(value="contentTitle")String contentTitle,
			@RequestParam(value="channelId")String channelId
			){
		ModelAndView mv = new ModelAndView();
		mv.addObject("content", content);
		logger.info(content);
		
		try {
			
			logger.info("insert content:" + contentService.update(contentId, new String[]{"contentMain", "contentTitle","contentChannelId"}, new Object[]{content,contentTitle,channelId}));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/content/tocontentlist.shtml");
	}
	
	/**
	 * 内容删除
	 * @return
	 */
	@RequestMapping("/del")
	public ModelAndView deleteContent(
			@RequestParam(value="contentId")String contentId){
		try {
			int ret = contentService.update(contentId, new String[]{"deleteId","deleteTime","isDelete"}, new Object[]{UuidFactory.getUuid(),DateUtils.getDateTime(),1});
			logger.info("delete content :" +  ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/content/list.shtml");
		return mv;
	}
	
	@RequestMapping("/sort")
	public ModelAndView sortContent(
			@RequestParam(value="contentId")String contentId,
			@RequestParam(value="contentSort")String contentSort
			){
		try {
			int ret = contentService.update(contentId, new String[]{"updateTime","contentSort"}, new Object[]{DateUtils.getDateTime(),contentSort});
			logger.info("sort content :" +  ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/content/list.shtml");
		return mv;
	}
	
	@RequestMapping("/upload")
	public void uploadPicture(HttpServletResponse response,@RequestParam(value = "imgFile") MultipartFile imgFile) throws IOException{
		logger.info(imgFile.getOriginalFilename());
		
		String url = FileUpload.upLoadFile(Constants.CONTENT_PATH, imgFile.getOriginalFilename(), imgFile.getBytes());
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", 0);
			map.put("url", Constants.REALCONTENTURL + "\\" + url);
			response.getWriter().print(JsonUtil.write(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/content/tocontentlist")
	public ModelAndView toContentList(
			HttpServletResponse response,
			@RequestParam(value = "pageNo" ,required=false)Integer pageNo
			){
		
		//Map<String, Object> message = new HashMap(); 
		if(pageNo == null || pageNo == 0){
			pageNo = 1;
		}
		int contentCount = contentService.count(new String[]{"isDelete"}, new Object[]{0});
		if(contentCount == 1){
			pageNo = 1;
		}
		Page page = new Page(pageNo, Page.DEFAULT_PAGE_ROW_COUNT, contentCount);
		List<Map<String, Object>> contents = contentService.selectPageByMap(new String[]{"isDelete"}, new Object[]{0}, "contentSort desc ,updateTime desc,createTime", "desc", Page.DEFAULT_PAGE_ROW_COUNT, pageNo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("contents", contents);
		mv.addObject("pagestring", page.getPageStringForJokerBase());
		mv.setViewName("/content/contentlist");
		return mv;
	}
	
//	去往内容更新页
	@RequestMapping("/toupdatecontent")
	public ModelAndView toUpdateContent(){
		Map<String, Object> message = new HashMap();
		return new ModelAndView();
	}
	
//	更新提交
	@RequestMapping("/updatecontent")
	public ModelAndView updateContent(){
		Map<String, Object> message = new HashMap();
		return new ModelAndView();
	}
	
}
