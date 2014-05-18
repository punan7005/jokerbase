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

import com.jokerbase.business.bean.Comment;
import com.jokerbase.business.common.SystemUtil;
import com.jokerbase.business.service.ICommentService;
import com.jokerbase.tools.DateUtils;
import com.jokerbase.tools.Page;
import com.jokerbase.tools.UuidFactory;

/** 
 * 类说明 :评论控制器
 * @author  joker 
 * 创建时间：2013-2-21 下午1:59:06 
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@RequestMapping("/tocommentlist")
	public ModelAndView toCommentList(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="pageNo",required=false) Integer pageNo){
		Map<String, Object> message = new HashMap(); 
		if(pageNo == null || pageNo == 0){
			pageNo = 1;
		}
		int commentCount = commentService.count(new String[]{"isDelete"}, new Object[]{0});
		if(commentCount == 1){
			pageNo = 1;
		}
		Page page = new Page(pageNo, Page.DEFAULT_PAGE_ROW_COUNT, commentCount);
		List<Map<String, Object>> commentList = commentService.selectPageByMap(new String[]{"isDelete"}, new Object[]{0}, "createTime", "desc", Page.DEFAULT_PAGE_ROW_COUNT, pageNo);
		message.put("commentList", commentList);
		message.put("pagestring", page.getPageStringForJokerBase());
		return new ModelAndView("comment/commentlist",message);
	}
	
	@RequestMapping("/tocreatecomment")
	public ModelAndView toCreateComment(HttpServletRequest request, HttpServletResponse response, Comment comment){
		Map<String, Object> message = new HashMap();
		
		return new ModelAndView("comment/createcomment");
	}
	
	@RequestMapping("createcomment")
	public ModelAndView createComment(HttpServletRequest request, HttpServletResponse response, Comment comment){
		Map<String, Object> message = new HashMap();
		if(comment == null){
			return null;
		}
		commentService.createComment(request, comment);
		return new ModelAndView("redirect:/comment/tocommentlist.shtml");
	}
	
	@RequestMapping("deletecomment")
	public ModelAndView deleteComment(HttpServletRequest request, HttpServletResponse response, String commentId){
		Map<String, Object> message = new HashMap();
		if(commentId == null){
			return null;
		}
		commentService.deleteComment(request, commentId);
		return new ModelAndView("redirect:/comment/tocommentlist.shtml");
	}
	
	@RequestMapping("toupdatecomment")
	public ModelAndView toUpdateComment(HttpServletRequest request, HttpServletResponse response, String commentId){
		Map<String, Object> message = new HashMap();
		return new ModelAndView();
	}
	
	@RequestMapping("updatecomment")
	public ModelAndView updateComment(HttpServletRequest request, HttpServletResponse response, Comment comment){
		Map<String, Object> message = new HashMap();
		return new ModelAndView();
	}
}
