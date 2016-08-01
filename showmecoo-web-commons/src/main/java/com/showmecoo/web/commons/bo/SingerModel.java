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

/**
 * 歌手 业务层对象, 对应新增歌手页面的参数
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class SingerModel extends ActorModel {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -6492020268009147060L;
	
	private String skilledStyle;//擅长的曲目风格，以逗号分割的字符串，eg：摇滚，流行，民俗
	private String displayAddr;//演出地点，艺人接受的演出地点，以城市为单位，以逗号分割的字符串
	private int displayPrice;//演出费用，不明确标出，作为以后的预留字段，如果为0则在页面写上“面议（总有惊喜）”
	private String represantiveWork;//代表作品，唱的比较好的曲目
	private String standardDisplay;//代表演出，以逗号分割的字符串
	private String mainImageName;//主形象照名，大图，上传到服务器后的名字，用于默认的大图展示
	private String secondImageName;//副形象照名，在大图下方显示的小图，点击小图后在主图区域显示该图的大图，数据库中存放 以逗号分割的名字字符串，最多4个名字
	private String briefIntroduction;//简介，艺人自我简短介绍，不超过140个字
	private int levelScore;//艺人等级评分，80－100的为高级，40-79的为中级，0-39的为低级，前期评分为主观评定，录入艺人的时候给打的分数，
	/**
	 * @return Returns the skilledStyle.
	 */
	public String getSkilledStyle() {
		return skilledStyle;
	}
	/**
	 * @param skilledStyle The skilledStyle to set.
	 */
	public void setSkilledStyle(String skilledStyle) {
		this.skilledStyle = skilledStyle;
	}
	/**
	 * @return Returns the displayAddr.
	 */
	public String getDisplayAddr() {
		return displayAddr;
	}
	/**
	 * @param displayAddr The displayAddr to set.
	 */
	public void setDisplayAddr(String displayAddr) {
		this.displayAddr = displayAddr;
	}
	/**
	 * @return Returns the displayPrice.
	 */
	public int getDisplayPrice() {
		return displayPrice;
	}
	/**
	 * @param displayPrice The displayPrice to set.
	 */
	public void setDisplayPrice(int displayPrice) {
		this.displayPrice = displayPrice;
	}
	/**
	 * @return Returns the represantiveWork.
	 */
	public String getRepresantiveWork() {
		return represantiveWork;
	}
	/**
	 * @param represantiveWork The represantiveWork to set.
	 */
	public void setRepresantiveWork(String represantiveWork) {
		this.represantiveWork = represantiveWork;
	}
	/**
	 * @return Returns the standardDisplay.
	 */
	public String getStandardDisplay() {
		return standardDisplay;
	}
	/**
	 * @param standardDisplay The standardDisplay to set.
	 */
	public void setStandardDisplay(String standardDisplay) {
		this.standardDisplay = standardDisplay;
	}
	/**
	 * @return Returns the mainImageName.
	 */
	public String getMainImageName() {
		return mainImageName;
	}
	/**
	 * @param mainImageName The mainImageName to set.
	 */
	public void setMainImageName(String mainImageName) {
		this.mainImageName = mainImageName;
	}
	/**
	 * @return Returns the secondImageName.
	 */
	public String getSecondImageName() {
		return secondImageName;
	}
	/**
	 * @param secondImageName The secondImageName to set.
	 */
	public void setSecondImageName(String secondImageName) {
		this.secondImageName = secondImageName;
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
	 * @return Returns the levelScore.
	 */
	public int getLevelScore() {
		return levelScore;
	}
	/**
	 * @param levelScore The levelScore to set.
	 */
	public void setLevelScore(int levelScore) {
		this.levelScore = levelScore;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SingerModel [skilledStyle=" + skilledStyle + ", displayAddr=" + displayAddr + ", displayPrice="
				+ displayPrice + ", represantiveWork=" + represantiveWork + ", standardDisplay=" + standardDisplay
				+ ", mainImageName=" + mainImageName + ", secondImageName=" + secondImageName + ", briefIntroduction="
				+ briefIntroduction + ", levelScore=" + levelScore + "]";
	}

	
}

/*
 * 修改历史
 * $Log$ 
 */