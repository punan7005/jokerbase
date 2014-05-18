package com.jokerbase.business.bean;

public class Content {
	/**
	 * 内容id
	 */
	private String contentId;
	/**
	 * 内容所属栏目id
	 */
	private String contentChannelId;
	/**
	 * 内容标题
	 */
	private String contentTitle;
	/**
	 * 内容主体
	 */
	private String contentMain;
	/**
	 * 创建人id
	 */
	private String createId;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 是否删除（0：否；1：是）
	 */
	private int isDelete;
	/**
	 * 内容状态
	 */
	private int contentStatus;
	/**
	 * 删除时间
	 */
	private String deleteTime;
	/**
	 * 删除id
	 */
	private String deleteId;
	/**
	 * 更新id
	 */
	private String updateId;
	/**
	 * 更新时间
	 */
	private String updateTime;
	/**
	 * 排序(采用权重)
	 */
	private int contentSort;
	

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentChannelId() {
		return contentChannelId;
	}

	public void setContentChannelId(String contentChannelId) {
		this.contentChannelId = contentChannelId;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentMain() {
		return contentMain;
	}

	public void setContentMain(String contentMain) {
		this.contentMain = contentMain;
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

	public int getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(int contentStatus) {
		this.contentStatus = contentStatus;
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

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public int getContentSort() {
		return contentSort;
	}

	public void setContentSort(int contentSort) {
		this.contentSort = contentSort;
	}
	
}
