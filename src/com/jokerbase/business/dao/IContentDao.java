package com.jokerbase.business.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jokerbase.business.bean.Content;
import com.jokerbase.core.persistence.IGenericDao;

public interface IContentDao extends IGenericDao<Content, String>{
	@Override
	public Content findById(String id);
	
	@Override
	public Serializable insert(Content o) throws Exception;
	
	@Override
	public int update(String id, String[] properties, Object[] propertyValues)
			throws Exception;
	
	public List<Map<String, Object>> selectPageByMap(
			String[] properties, Object[] propertyValues, String orderBy,
			String order, int pageSize, int pageNo);
}
