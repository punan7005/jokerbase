package com.jokerbase.business.bean;

public class Media {
	/**
	 * 媒体id
	 */
	private String mediaId;
	/**
	 * 媒体名称
	 */
	private String mediaName;
	/**
	 * 媒体路径
	 */
	private String mediaPath;
	/**
	 * 图片描述
	 */
	private String mediaDesc;
	/**
	 * 频道id
	 */
	private String channelId;
	/**
	 * 分类类型（0：图文；1：媒体；2:内容型栏目 ；3:图片带描述)
	 */
	private Integer channelType;
	/**
	 * 创建人id
	 */
	private String createId;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 是否删除
	 */
	private int isDelete;
	/**
	 * 删除人id
	 */
	private String deleteId;
	/**
	 * 删除时间
	 */
	private String deleteTime;
	/**
	 * 媒体状态
	 */
	private int mediaStatus;
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getMediaName() {
		return mediaName;
	}
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	public String getMediaPath() {
		return mediaPath;
	}
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}
	public String getMediaDesc() {
		return mediaDesc;
	}
	public void setMediaDesc(String mediaDesc) {
		this.mediaDesc = mediaDesc;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public Integer getChannelType() {
		return channelType;
	}
	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
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
	public int getMediaStatus() {
		return mediaStatus;
	}
	public void setMediaStatus(int mediaStatus) {
		this.mediaStatus = mediaStatus;
	}
	
		
}
