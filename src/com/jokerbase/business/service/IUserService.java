package com.jokerbase.business.service;

import javax.servlet.http.HttpServletRequest;

import com.jokerbase.business.bean.Channel;
import com.jokerbase.business.bean.User;
import com.jokerbase.core.service.IGenericService;

/** 
 * 类说明 :用户Service接口
 * @author  joker 
 * 创建时间：2013-2-19 上午11:10:21 
 */
public interface IUserService extends IGenericService<User, String>{
	/** 
	 * 方法说明 :新增用户
	 * @author  joker 
	 * 创建时间：2013-08-05
	 * <p>@param request</p>
	 * <p>@param channel</p>
	 */
	public void createUser(HttpServletRequest request, User	user);
	/** 
	 * 方法说明 :修改用户
	 * @author  joker 
	 * 创建时间：2013-08-05
	 * <p>@param request</p>
	 * <p>@param channel</p>
	 */
	public void updateUser(HttpServletRequest request, User	user);
	/** 
	 * 方法说明 :删除用户
	 * @author  joker 
	 * 创建时间：2013-08-05
	 * <p>@param request</p>
	 * <p>@param comment</p>
	 */
	public void deleteUser(HttpServletRequest request, String userId);
	/** 
	 * 方法说明 :用户登录
	 * @author  joker 
	 * 创建时间：2013-10-31
	 * <p>@param user</p>
	 */
	public User loginByMap(User user);
}
