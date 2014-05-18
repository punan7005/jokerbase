package com.jokerbase.business.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jokerbase.business.bean.Media;
import com.jokerbase.business.dao.IMediaDao;
import com.jokerbase.business.service.IMediaService;
import com.jokerbase.core.persistence.IGenericDao;
import com.jokerbase.core.service.impl.GenericService;

public class MediaService extends GenericService<Media, String> implements IMediaService {

	@Autowired
	private IMediaDao mediaDao;
	
	@Override
	protected IGenericDao getDao() {
		return this.mediaDao;
	}
	
	@Override
	public List<Map<String, Object>> selectPageByMap(String[] properties,
			Object[] propertyValues, String orderBy, String order,
			int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return mediaDao.selectPageByMap(properties, propertyValues, orderBy, order, pageSize, pageNo);
	}


}
