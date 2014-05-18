package com.jokerbase.business.dao.impl;

import java.util.List;
import java.util.Map;

import com.jokerbase.business.bean.Comment;
import com.jokerbase.business.dao.ICommentDao;
import com.jokerbase.core.persistence.impl.IbatisGenericDao;

/** 
 * 类说明 :评论dao
 * @author  joker 
 * 创建时间：2013-7-22 下午23:55:00 
 */
public class CommentDao extends IbatisGenericDao<Comment, String> implements ICommentDao{
	
	public List<Map<String, Object>> selectPageByMap(
			String[] properties, Object[] propertyValues, String orderBy,
			String order, int pageSize, int pageNo){
		List<Map<String, Object>> list = this.findByStatementPostfix(".selectPageByMap", properties, propertyValues, orderBy, order, pageSize, pageNo);
		return list;
	}
}
