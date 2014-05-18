package com.jokerbase.business.service;

import java.util.List;
import java.util.Map;

import com.jokerbase.business.bean.Media;
import com.jokerbase.core.service.IGenericService;

public interface IMediaService extends IGenericService<Media, String> {
	public List<Map<String, Object>> selectPageByMap(
			String[] properties, Object[] propertyValues, String orderBy,
			String order, int pageSize, int pageNo);
}
