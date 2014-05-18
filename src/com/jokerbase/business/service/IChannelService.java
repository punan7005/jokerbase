package com.jokerbase.business.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.jokerbase.business.bean.Channel;
import com.jokerbase.core.service.IGenericService;

public interface IChannelService extends IGenericService<Channel, String>{
	/** 
	 * 方法说明 :按照参数返回分类分页信息
	 * @author  joker 
	 * 创建时间：2013-07-28
	 * <p>@param statementPostfix</p>
	 * <p>@param properties</p>
	 * <p>@param propertyValues</p>
	 * <p>@param orderBy</p>
	 * <p>@param order</p>
	 * <p>@param pageSize</p>
	 * <p>@param pageNo</p>
	 */
	public List<Map<String, Object>> selectPageByMap(
			String[] properties, Object[] propertyValues, String orderBy,
			String order, int pageSize, int pageNo);
	/** 
	 * 方法说明 :新增分类
	 * @author  joker 
	 * 创建时间：2013-07-29
	 * <p>@param request</p>
	 * <p>@param channel</p>
	 */
	public void createChannel(HttpServletRequest request, Channel channel);
	/** 
	 * 方法说明 :修改分类
	 * @author  joker 
	 * 创建时间：2013-07-29
	 * <p>@param request</p>
	 * <p>@param channel</p>
	 */
	public void updateChannel(HttpServletRequest request, Channel channel);
	/** 
	 * 方法说明 :分类删除\
	 * @author  joker 
	 * 创建时间：2013-07-28
	 * <p>@param request</p>
	 * <p>@param comment</p>
	 */
	public void deleteChannel(HttpServletRequest request, String channelId);
}
