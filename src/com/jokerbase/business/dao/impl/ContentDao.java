package com.jokerbase.business.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jokerbase.business.bean.Content;
import com.jokerbase.business.dao.IContentDao;
import com.jokerbase.core.persistence.impl.IbatisGenericDao;


public class ContentDao extends IbatisGenericDao<Content, String> implements IContentDao {

	@Override
	public Content findById(String id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	
	@Override
	public Serializable insert(Content o) throws Exception {
		// TODO Auto-generated method stub
		return super.insert(o);
	}
	
	@Override
	public int update(String id, String[] properties, Object[] propertyValues)
			throws Exception {
		// TODO Auto-generated method stub
		return super.update(id, properties, propertyValues);
	}
	
	@Override
	public List<Map<String, Object>> selectPageByMap(String[] properties,
			Object[] propertyValues, String orderBy, String order,
			int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = this.findByStatementPostfix(".selectPageByMap", properties, propertyValues, orderBy, order, pageSize, pageNo);
		return list;
	}
	
	public static void main(String[] args){
		ContentDao contenDao = new ContentDao();
		contenDao.findById("123");
	}
}
