package com.jokerbase.business.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.jokerbase.business.bean.Channel;
import com.jokerbase.business.common.SystemUtil;
import com.jokerbase.business.dao.IChannelDao;
import com.jokerbase.business.service.IChannelService;
import com.jokerbase.core.persistence.IGenericDao;
import com.jokerbase.core.service.impl.GenericService;
import com.jokerbase.tools.DateUtils;
import com.jokerbase.tools.UuidFactory;

public class ChannelService extends GenericService<Channel, String> implements IChannelService{

	@Autowired
	private IChannelDao channelDao;
	@Override
	protected IGenericDao getDao() {
		// TODO Auto-generated method stub
		return this.channelDao;
	}
	@Override
	public void createChannel(HttpServletRequest request, Channel channel) {
		// TODO Auto-generated method stub
		channel.setChannelId(UuidFactory.getUuid());
		channel.setChannelLevel(0);
		channel.setChannelParentId("");
		channel.setChannelStatus(0);
		channel.setCreateTime(DateUtils.getDateTime());
		channel.setCreateId(SystemUtil.getCurrentUser(request).getUserId());
		channel.setIsDelete(0);
		try {
			channelDao.insert(channel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert channel error");
		}
	}
	@Override
	public List<Map<String, Object>> selectPageByMap(String[] properties,
			Object[] propertyValues, String orderBy, String order,
			int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return channelDao.selectPageByMap(properties, propertyValues, orderBy, order, pageSize, pageNo);
	}
	@Override
	public void deleteChannel(HttpServletRequest request, String channelId) {
		// TODO Auto-generated method stub
		Channel channel = channelDao.findById(channelId);
		channel.setChannelStatus(1);
		channel.setIsDelete(1);
		channel.setDeleteId(SystemUtil.getCurrentUser(request).getUserId());
		channel.setDeleteTime(DateUtils.getDateTime());
		try {
			channelDao.update(channel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void updateChannel(HttpServletRequest request, Channel channel) {
		// TODO Auto-generated method stub
		channel.setUpdateId(SystemUtil.getCurrentUser(request).getUserId());
		channel.setUpdateTime(DateUtils.getDateTime());
		try {
			channelDao.update(channel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
