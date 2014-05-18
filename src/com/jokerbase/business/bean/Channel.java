package com.jokerbase.business.bean;

public class Channel {
//	分类id
	private String channelId;
//	分类名称
	private String channelName;
//	分类级别
	private Integer channelLevel;
//	父分类id
	private String channelParentId;
//	分类状态（0：正常；1:删除；）
	private Integer channelStatus;
//	是否删除（0：否；1：是）
	private Integer isDelete;
//	创建时间
	private String createTime;
//	创建人id
	private String createId;
//	更新时间
	private String updateTime;
//	更新人id
	private String updateId;
//	删除时间
	private String deleteTime;
//	删除人id
	private String deleteId;
//	分类类型（0：图文；1：媒体；2:内容型栏目 ；3:图片带描述)
	private Integer channelType;
//	分类样式
	private String channelCss;
	
	public String getChannelCss() {
		return channelCss;
	}
	public void setChannelCss(String channelCss) {
		this.channelCss = channelCss;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public Integer getChannelLevel() {
		return channelLevel;
	}
	public void setChannelLevel(Integer channelLevel) {
		this.channelLevel = channelLevel;
	}
	public String getChannelParentId() {
		return channelParentId;
	}
	public void setChannelParentId(String channelParentId) {
		this.channelParentId = channelParentId;
	}
	public Integer getChannelStatus() {
		return channelStatus;
	}
	public void setChannelStatus(Integer channelStatus) {
		this.channelStatus = channelStatus;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
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
	public String getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	public Integer getChannelType() {
		return channelType;
	}
	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}
	
}
