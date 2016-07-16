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
 * Created on 2016年7月16日
 *******************************************************************************/


package com.showmecoo.web.commons.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 对外暴露的user对象
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class UserModel implements Serializable{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -9072051734900629705L;
	
	private String userId;
	
	private String userName;
	private String password;
	private String phone;
	private String email;
	private String rolename;
	
	private Date createDate;
	
	private Date modifyDate;
	
	private Date lastLoginDate;
	
	private String openId;

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
	 * @return Returns the userName.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName The userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Returns the phone.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone The phone to set.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Returns the rolename.
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename The rolename to set.
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * @return Returns the createDate.
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate The createDate to set.
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return Returns the modifyDate.
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate The modifyDate to set.
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * @return Returns the lastLoginDate.
	 */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * @param lastLoginDate The lastLoginDate to set.
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", rolename=" + rolename + ", createDate="
				+ createDate + ", modifyDate=" + modifyDate
				+ ", lastLoginDate=" + lastLoginDate + ", openId=" + openId
				+ "]";
	}
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */