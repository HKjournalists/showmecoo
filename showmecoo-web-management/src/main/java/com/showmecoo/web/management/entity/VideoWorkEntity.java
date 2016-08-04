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


package com.showmecoo.web.management.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Entity
@Table(name="work_video")
public class VideoWorkEntity implements Serializable{
	
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 6442001036828227264L;

	@Id
	@GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name="system-uuid",strategy="uuid") 
	private String videoId;
	
	private String actorId;
	
	@Column(name="work_name")
	private String workName;
	
	@Column(name="recommend_level")
	private int recommendLevel;
	
	@Column(name="video_name")
	private String videoName;
	
	@Column(name="visit_num")
	private int visitNum;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="update_time")
	private Date updateTime;
	
	@Column(name="brief_introduction")
	private String briefIntroduction;

	/**
	 * @return Returns the videoId.
	 */
	public String getVideoId() {
		return videoId;
	}

	/**
	 * @param videoId The videoId to set.
	 */
	public void setVideoId(String videoId) {
		this.videoId = videoId;
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
	 * @return Returns the videoName.
	 */
	public String getVideoName() {
		return videoName;
	}

	/**
	 * @param videoName The videoName to set.
	 */
	public void setVideoName(String videoName) {
		this.videoName = videoName;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkVideoEntity [videoId=" + videoId + ", actorId=" + actorId + ", workName=" + workName
				+ ", recommendLevel=" + recommendLevel + ", videoName=" + videoName + ", visitNum=" + visitNum
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", briefIntroduction="
				+ briefIntroduction + "]";
	}
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */