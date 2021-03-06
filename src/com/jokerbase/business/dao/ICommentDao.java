package com.jokerbase.business.dao;

import java.util.List;
import java.util.Map;

import com.jokerbase.business.bean.Comment;
import com.jokerbase.core.persistence.IGenericDao;
/** 
 * 类说明 :评论dao接口
 * @author  joker 
 * 创建时间：2013-7-22 下午23:55:00 
 */
public interface ICommentDao extends IGenericDao<Comment, String>{
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
}
