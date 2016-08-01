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
 * Created on 2016年7月28日
 *******************************************************************************/


package com.showmecoo.web.commons.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * actor表的业务层对象， 不对应具体的页面
 * 
 * 新增舞者，歌手，模特，主持人的时候创建ActorEntity，由actorEntity生成actorid
 * 然后赋值给DancerEntity，SingerEntity，ModelEntity，CompereEntity
 * 
 * 
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class ActorModel implements Serializable{
	
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 6902049561519971085L;

	private String actorId;
	private String name;
	private String nickName;
	private int height;
	private int age;
	private int sex;//male=1, female=2
	private int type;//艺人类型：舞者(1)，歌手(2)，模特(3)，主持人(4)
	private int displayedNum;
	private int visitNum;
	private int fansNum;
	private Date createTime;
	private String imageName;
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
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the nickName.
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName The nickName to set.
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return Returns the height.
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height The height to set.
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return Returns the age.
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age The age to set.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return Returns the sex.
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex The sex to set.
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	/**
	 * @return Returns the type.
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type The type to set.
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return Returns the displayedNum.
	 */
	public int getDisplayedNum() {
		return displayedNum;
	}
	/**
	 * @param displayedNum The displayedNum to set.
	 */
	public void setDisplayedNum(int displayedNum) {
		this.displayedNum = displayedNum;
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
	 * @return Returns the fansNum.
	 */
	public int getFansNum() {
		return fansNum;
	}
	/**
	 * @param fansNum The fansNum to set.
	 */
	public void setFansNum(int fansNum) {
		this.fansNum = fansNum;
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
	 * @return Returns the imageName.
	 */
	public String getImageName() {
		return imageName;
	}
	/**
	 * @param imageName The imageName to set.
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActorModel [actorId=" + actorId + ", name=" + name + ", nickName=" + nickName + ", height=" + height
				+ ", age=" + age + ", sex=" + sex + ", type=" + type + ", displayedNum=" + displayedNum + ", visitNum="
				+ visitNum + ", fansNum=" + fansNum + ", createTime=" + createTime + ", imageName=" + imageName + "]";
	}
	
	
}	

/*
 * 修改历史
 * $Log$ 
 */