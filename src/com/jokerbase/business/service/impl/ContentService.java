package com.jokerbase.business.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jokerbase.business.bean.Content;
import com.jokerbase.business.dao.IContentDao;
import com.jokerbase.business.service.IContentService;
import com.jokerbase.core.persistence.IGenericDao;
import com.jokerbase.core.service.impl.GenericService;

public class ContentService extends GenericService<Content, String> implements
		IContentService {

	@Autowired
	private IContentDao contentDao;
	
	@Override
	protected IGenericDao getDao() {
		return this.contentDao;
	}
	
	@Override
	public List<Map<String, Object>> selectPageByMap(String[] properties,
			Object[] propertyValues, String orderBy, String order,
			int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return contentDao.selectPageByMap(properties, propertyValues, orderBy, order, pageSize, pageNo);
	}

}
