package com.jokerbase.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jokerbase.business.bean.User;
import com.jokerbase.business.dao.IUserDao;
import com.jokerbase.business.service.IUserService;
import com.jokerbase.core.persistence.IGenericDao;
import com.jokerbase.core.service.impl.GenericService;

/** 
 * 类说明 :
 * @author  joker 
 * 创建时间：2013-2-19 上午11:12:41 
 */
public class UserService extends GenericService<User, String> implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	protected IGenericDao getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

}
