package com.jokerbase.business.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.jokerbase.business.bean.Comment;
import com.jokerbase.business.common.SystemUtil;
import com.jokerbase.business.dao.ICommentDao;
import com.jokerbase.business.service.ICommentService;
import com.jokerbase.core.persistence.IGenericDao;
import com.jokerbase.core.service.impl.GenericService;
import com.jokerbase.tools.DateUtils;
import com.jokerbase.tools.UuidFactory;

public class CommentService extends GenericService<Comment, String> implements ICommentService{

	@Autowired
	private ICommentDao commentDao;
	
	@Override
	protected IGenericDao getDao() {
		// TODO Auto-generated method stub
		return this.commentDao;
	}

	@Override
	public List<Map<String, Object>> selectPageByMap(
			String[] properties, Object[] propertyValues, String orderBy,
			String order, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return commentDao.selectPageByMap( properties, propertyValues, orderBy, order, pageSize, pageNo);
	}

	@Override
	public void createComment(HttpServletRequest request, Comment comment) {
		// TODO Auto-generated method stub
		try {
			comment.setCommentId(UuidFactory.getUuid());
			comment.setCreateId(SystemUtil.getCurrentUser(request).getUserId());
			comment.setCreateTime(DateUtils.getDateTime());
			comment.setIsDelete(0);
			comment.setCommentStatus(0);
			commentDao.insert(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert comment error");
		}
	}

	@Override
	public void deleteComment(HttpServletRequest request, String commentId) {
		// TODO Auto-generated method stub
		Comment comment = commentDao.findById(commentId);
		comment.setIsDelete(1);
		comment.setCommentStatus(1);
		comment.setDeleteTime(DateUtils.getDateTime());
		comment.setDeleteId(SystemUtil.getCurrentUser(request).getUserId());
		try {
			commentDao.update(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
