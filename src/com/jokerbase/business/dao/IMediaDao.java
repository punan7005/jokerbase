package com.jokerbase.business.dao;

import java.util.List;
import java.util.Map;

import com.jokerbase.business.bean.Media;
import com.jokerbase.core.persistence.IGenericDao;

public interface IMediaDao  extends IGenericDao<Media, String> {

	
	public List<Map<String, Object>> selectPageByMap(
			String[] properties, Object[] propertyValues, String orderBy,
			String order, int pageSize, int pageNo);
}
