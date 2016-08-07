/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2012 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月4日
 *******************************************************************************/


package com.showmecoo.web.commons.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class PictureWorkModel implements Serializable{
	
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -8514356738700138517L;
	
	private String pictureId;
	private String actorId;
	private String workName;
	private int recommendLevel;
	private String pictureName;
	private int visitNum;
	private Date createTime;
	private Date updateTime;
	private String briefIntroduction;
	/**
	 * @return Returns the pictureId.
	 */
	public String getPictureId() {
		return pictureId;
	}
	/**
	 * @param pictureId The pictureId to set.
	 */
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	/**
	 * @return Returns the actorId.
	 */
	public String getActorId() {
		return actorId;
	}
	/**
	 * @param actorId The actorId to set.
	 */
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	/**
	 * @return Returns the workName.
	 */
	public String getWorkName() {
		return workName;
	}
	/**
	 * @param workName The workName to set.
	 */
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	/**
	 * @return Returns the recommendLevel.
	 */
	public int getRecommendLevel() {
		return recommendLevel;
	}
	/**
	 * @param recommendLevel The recommendLevel to set.
	 */
	public void setRecommendLevel(int recommendLevel) {
		this.recommendLevel = recommendLevel;
	}
	/**
	 * @return Returns the pictureName.
	 */
	public String getPictureName() {
		return pictureName;
	}
	/**
	 * @param pictureName The pictureName to set.
	 */
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	/**
	 * @return Returns the visitNum.
	 */
	public int getVisitNum() {
		return visitNum;
	}
	/**
	 * @param visitNum The visitNum to set.
	 */
	public void setVisitNum(int visitNum) {
		this.visitNum = visitNum;
	}
	/**
	 * @return Returns the createTime.
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime The createTime to set.
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return Returns the updateTime.
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime The updateTime to set.
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return Returns the briefIntroduction.
	 */
	public String getBriefIntroduction() {
		return briefIntroduction;
	}
	/**
	 * @param briefIntroduction The briefIntroduction to set.
	 */
	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PictureWorkModel [pictureId=" + pictureId + ", actorId=" + actorId + ", workName=" + workName
				+ ", recommendLevel=" + recommendLevel + ", pictureName=" + pictureName + ", visitNum=" + visitNum
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", briefIntroduction="
				+ briefIntroduction + "]";
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */