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


package com.showmecoo.web.management.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 演员主表 数据对象实例
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Entity
@Table(name="actor")
public class ActorEntity implements Serializable{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -5091083412451971871L;
	
	@Id
	@GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name="system-uuid",strategy="uuid") 
	private String actorId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(unique=true, name="nick_name", nullable=false)
	private String nickName;
	
	private int height;
	
	private int age;
	
	private int sex;//male=1, female=2
	
	private int type;//艺人类型：舞者(1)，歌手(2)，模特(3)，主持人(4)
	
	@Column(name="displayed_num")
	private int displayedNum;
	
	@Column(name="visit_num")
	private int visitNum;
	
	@Column(name="fans_num")
	private int fansNum;
	
	@Column(name = "create_time", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	
	@Column(name="image_name")
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
		return "ActorEntity [actorId=" + actorId + ", name=" + name + ", nickName=" + nickName + ", height=" + height
				+ ", age=" + age + ", sex=" + sex + ", type=" + type + ", displayedNum=" + displayedNum + ", visitNum="
				+ visitNum + ", fansNum=" + fansNum + ", createTime=" + createTime + ", imageName=" + imageName + "]";
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */