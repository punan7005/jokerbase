package com.jokerbase.business.dao.impl;

import com.jokerbase.business.bean.User;
import com.jokerbase.business.dao.IUserDao;
import com.jokerbase.core.persistence.impl.IbatisGenericDao;

/** 
 * 类说明 :
 * @author  joker 
 * 创建时间：2013-2-1 下午4:32:23 
 */
public class UserDao extends IbatisGenericDao<User, String> implements IUserDao{

}
