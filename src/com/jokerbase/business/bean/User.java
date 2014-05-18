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
	private String userEmail;
//	用户注册时间
	private String createTime;
//	用户验证状态(0：未验证；1：通过验证)
	private Integer userIsVal;
//	修改时间
	private String updateTime;
//	修改人id
	private String updateId;
//	是否删除（0：否；1：是）
	private Integer isDelete;
//	删除人
	private String deleteId;
//	删除时间
	private String deleteTime;
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	public String getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}
	public Integer getUserIsVal() {
		return userIsVal;
	}
	public void setUserIsVal(Integer userIsVal) {
		this.userIsVal = userIsVal;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
