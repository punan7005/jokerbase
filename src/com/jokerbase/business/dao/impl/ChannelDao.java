package com.jokerbase.business.dao.impl;

import java.util.List;
import java.util.Map;

import com.jokerbase.business.bean.Channel;
import com.jokerbase.business.dao.IChannelDao;
import com.jokerbase.core.persistence.impl.IbatisGenericDao;

public class ChannelDao extends IbatisGenericDao<Channel, String> implements IChannelDao{

	@Override
	public List<Map<String, Object>> selectPageByMap(String[] properties,
			Object[] propertyValues, String orderBy, String order,
			int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = this.findByStatementPostfix(".selectPageByMap", properties, propertyValues, orderBy, order, pageSize, pageNo);
		return list;
	}

}
