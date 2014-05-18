package com.jokerbase.business.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.jokerbase.business.bean.User;
import com.jokerbase.business.common.SystemUtil;
import com.jokerbase.business.dao.IUserDao;
import com.jokerbase.business.service.IUserService;
import com.jokerbase.core.persistence.IGenericDao;
import com.jokerbase.core.service.impl.GenericService;
import com.jokerbase.tools.DateUtils;
import com.jokerbase.tools.MD5Util;
import com.jokerbase.tools.UuidFactory;

/** 
 * 类说明 :用户Service
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

	@Override
	public void createUser(HttpServletRequest request, User user) {
		// TODO Auto-generated method stub
		user.setCreateTime(DateUtils.getDateTime());
		user.setIsDelete(0);
		user.setUserId(UuidFactory.getUuid());
		String password = MD5Util.getMD5String(user.getUserPassword());
		user.setUserPassword(password);
		user.setUserIsVal(0);
		try {
			userDao.insert(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(HttpServletRequest request, User user) {
		// TODO Auto-generated method stub
		User olduser = userDao.findById(user.getUserId());
		user.setUserPassword(olduser.getUserPassword());
		user.setIsDelete(olduser.getIsDelete());
		user.setUpdateId(SystemUtil.getCurrentUser(request).getUserId());
		user.setUpdateTime(DateUtils.getDateTime());
		
		try {
			userDao.update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteUser(HttpServletRequest request, String userId) {
		// TODO Auto-generated method stub
		User user = userDao.findById(userId);
		user.setIsDelete(1);
		user.setDeleteId(SystemUtil.getCurrentUser(request).getUserId());
		user.setDeleteTime(DateUtils.getDateTime());
		try {
			userDao.update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public User loginByMap(User user) {
		// TODO Auto-generated method stub
		return userDao.loginByMap(user);
	}

}
