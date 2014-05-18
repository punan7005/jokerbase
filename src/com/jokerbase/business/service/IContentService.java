package com.jokerbase.business.service;

import java.util.List;
import java.util.Map;

import com.jokerbase.business.bean.Content;
import com.jokerbase.core.service.IGenericService;

public interface IContentService extends IGenericService<Content, String> {
	public List<Map<String, Object>> selectPageByMap(
			String[] properties, Object[] propertyValues, String orderBy,
			String order, int pageSize, int pageNo);
}
