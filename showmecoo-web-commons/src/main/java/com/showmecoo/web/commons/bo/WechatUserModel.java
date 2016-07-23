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
 * Created on 2016年7月22日
 *******************************************************************************/


package com.showmecoo.web.commons.bo;

import java.io.Serializable;

/**
 * 微信用户对象业务层实体
 * 所有属性由微信接口提供
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class WechatUserModel implements Serializable{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -1706644737716765253L;

	private String openId;
	
	private String userId;
	
	private String nickName;//微信别名
	
	private String sex;//1为男，2为女
	
	private String city;
	
	private String country;
	
	private String province;
	
	private String language;
	
	private String headimgurl;//用户头像链接地址
	
	private String subscribeTime;//用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间"subscribe_time": 1382694957
	
	private String unionid;//只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
	
	private String remark;//公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	
	private String groupId;//用户所在的分组ID

	/**
	 * @return Returns the openId.
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId The openId to set.
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * @return Returns the userId.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @return Returns the sex.
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex The sex to set.
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return Returns the city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return Returns the country.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country The country to set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return Returns the province.
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province The province to set.
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return Returns the language.
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language The language to set.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return Returns the headimgurl.
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}

	/**
	 * @param headimgurl The headimgurl to set.
	 */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	/**
	 * @return Returns the subscribeTime.
	 */
	public String getSubscribeTime() {
		return subscribeTime;
	}

	/**
	 * @param subscribeTime The subscribeTime to set.
	 */
	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	/**
	 * @return Returns the unionid.
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * @param unionid The unionid to set.
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * @return Returns the remark.
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark The remark to set.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return Returns the groupId.
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId The groupId to set.
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WechatUserEntity [openId=" + openId + ", userId=" + userId + ", nickName=" + nickName + ", sex=" + sex
				+ ", city=" + city + ", country=" + country + ", province=" + province + ", language=" + language
				+ ", headimgurl=" + headimgurl + ", subscribeTime=" + subscribeTime + ", unionid=" + unionid
				+ ", remark=" + remark + ", groupId=" + groupId + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */