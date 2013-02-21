package com.jokerbase.business.bean;
/** 
 * 类说明 :内容实体
 * @author  joker 
 * 创建时间：2013-2-20 下午3:16:30 
 */
public class Content {

//	内容id
	private String contentId;
//	内容所属栏目id
	private String contentChannelId;
//	内容标题
	private String contentTitle;
//	内容主体
	private String contentMain;
//	内容创建人id
	private String contentCreateId;
//	内容创建时间
	private String contentCreateTime;
//	内容是否删除
	private int contentIsDelete;
//	内容状态
	private int contentStatus;
//	内容修改人id
	private String contentModifyId;
//	内容修改时间
	private String contentModifyTime;
	
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
	public String getContentCreateId() {
		return contentCreateId;
	}
	public void setContentCreateId(String contentCreateId) {
		this.contentCreateId = contentCreateId;
	}
	public String getContentCreateTime() {
		return contentCreateTime;
	}
	public void setContentCreateTime(String contentCreateTime) {
		this.contentCreateTime = contentCreateTime;
	}
	public int getContentIsDelete() {
		return contentIsDelete;
	}
	public void setContentIsDelete(int contentIsDelete) {
		this.contentIsDelete = contentIsDelete;
	}
	public int getContentStatus() {
		return contentStatus;
	}
	public void setContentStatus(int contentStatus) {
		this.contentStatus = contentStatus;
	}
	public String getContentModifyId() {
		return contentModifyId;
	}
	public void setContentModifyId(String contentModifyId) {
		this.contentModifyId = contentModifyId;
	}
	public String getContentModifyTime() {
		return contentModifyTime;
	}
	public void setContentModifyTime(String contentModifyTime) {
		this.contentModifyTime = contentModifyTime;
	}
	
}
