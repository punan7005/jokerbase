package com.jokerbase.business.bean;
/** 
 * 类说明 :用户实体
 * @author  joker 
 * 创建时间：2013-2-1 上午9:56:15 
 */
public class User {
	
//	用户id
	private String userId;
//	用户名
	private String userName;
//	用户密码
	private String userPassword;
//	用户邮箱
	private String userEMail;
	
	public String getUserEMail() {
		return userEMail;
	}
	public void setUserEMail(String userEMail) {
		this.userEMail = userEMail;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
