package com.jokerbase.business.dao;

import com.jokerbase.business.bean.User;
import com.jokerbase.core.persistence.IGenericDao;

/** 
 * 类说明 :用户Dao接口
 * @author  joker 
 * 创建时间：2013-2-1 下午4:31:18 
 */
public interface IUserDao extends IGenericDao<User, String>{
	public User loginByMap(User user);
}
