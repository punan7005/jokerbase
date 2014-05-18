package com.jokerbase.business.bean;

public class Comment {
//	评论id
	private String commentId;
//	评论标题
	private String commentTitle;
//	评论主体
	private String commentContent;
//	被评论内容id
	private String commentContentId;
//	创建人id
	private String createId;
//	创建时间
	private String createTime;
//	更新时间
	private String updateTime;
//	更新人id
	private String updateId;
//	是否删除（0：否；1：是）
	private Integer isDelete;
//	评论状态(0：正常；1：删除；)
	private Integer commentStatus;
//	删除人时间
	private String deleteTime;
//	删除人id
	private String deleteId;
	
	
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getCommentTitle() {
		return commentTitle;
	}
	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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
	public Integer getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(Integer commentStauts) {
		this.commentStatus = commentStauts;
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
	public String getCommentContentId() {
		return commentContentId;
	}
	public void setCommentContentId(String commentContentId) {
		this.commentContentId = commentContentId;
	}
	
	
}
