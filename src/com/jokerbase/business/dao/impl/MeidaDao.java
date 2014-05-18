package com.jokerbase.business.dao.impl;

import java.util.List;
import java.util.Map;

import com.jokerbase.business.bean.Media;
import com.jokerbase.business.dao.IMediaDao;
import com.jokerbase.core.persistence.impl.IbatisGenericDao;

public class MeidaDao extends IbatisGenericDao<Media, String> implements IMediaDao {

	@Override
	public List<Map<String, Object>> selectPageByMap(String[] properties,
			Object[] propertyValues, String orderBy, String order,
			int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = this.findByStatementPostfix(".selectPageByMap", properties, propertyValues, orderBy, order, pageSize, pageNo);
		return list;
	}

}
