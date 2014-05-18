package com.jokerbase.business.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.jokerbase.business.bean.Comment;
import com.jokerbase.core.service.IGenericService;

/** 
 * 类说明 :评论service接口
 * @author  joker 
 * 创建时间：2013-7-22 下午23:57:00 
 */
public interface ICommentService extends IGenericService<Comment, String>{
	/** 
	 * 方法说明 :按照参数返回评论分页信息
	 * @author  joker 
	 * 创建时间：2013-07-28
	 * <p>@param statementPostfix</p>
	 * <p>@param properties</p>
	 * <p>@param propertyValues</p>
	 * <p>@param orderBy</p>
	 * <p>@param order</p>
	 * <p>@param pageSize</p>
	 * <p>@param pageNo</p>
	 */
	public List<Map<String, Object>> selectPageByMap(
			String[] properties, Object[] propertyValues, String orderBy,
			String order, int pageSize, int pageNo);
	/** 
	 * 方法说明 :评论新增
	 * @author  joker 
	 * 创建时间：2013-07-28
	 * <p>@param request</p>
	 * <p>@param comment</p>
	 */
	public void createComment(HttpServletRequest request, Comment comment);
	/** 
	 * 方法说明 :评论删除
	 * @author  joker 
	 * 创建时间：2013-07-28
	 * <p>@param request</p>
	 * <p>@param comment</p>
	 */
	public void deleteComment(HttpServletRequest request, String commentId);
}
