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
 * Created on 2016年8月2日
 *******************************************************************************/


package com.showmecoo.web.commons.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class OrderModel implements Serializable{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -6367047239137754693L;
	
	private String orderId;
	private String linkName;
	private String phone;
	private String showAdddr;
	private Date showDate;
	private int showFee;
	private String userId;
	private String openId;
	private Date createDate;
	private Date modifyDate;
	private String modifyUserId;
	private String requestMark;
	/**
	 * @return Returns the orderId.
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId The orderId to set.
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return Returns the linkName.
	 */
	public String getLinkName() {
		return linkName;
	}
	/**
	 * @param linkName The linkName to set.
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
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
	 * @return Returns the showAdddr.
	 */
	public String getShowAdddr() {
		return showAdddr;
	}
	/**
	 * @param showAdddr The showAdddr to set.
	 */
	public void setShowAdddr(String showAdddr) {
		this.showAdddr = showAdddr;
	}
	/**
	 * @return Returns the showDate.
	 */
	public Date getShowDate() {
		return showDate;
	}
	/**
	 * @param showDate The showDate to set.
	 */
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	/**
	 * @return Returns the showFee.
	 */
	public int getShowFee() {
		return showFee;
	}
	/**
	 * @param showFee The showFee to set.
	 */
	public void setShowFee(int showFee) {
		this.showFee = showFee;
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
	 * @return Returns the modifyUserId.
	 */
	public String getModifyUserId() {
		return modifyUserId;
	}
	/**
	 * @param modifyUserId The modifyUserId to set.
	 */
	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
	/**
	 * @return Returns the requestMark.
	 */
	public String getRequestMark() {
		return requestMark;
	}
	/**
	 * @param requestMark The requestMark to set.
	 */
	public void setRequestMark(String requestMark) {
		this.requestMark = requestMark;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderId + ", linkName=" + linkName + ", phone=" + phone + ", showAdddr="
				+ showAdddr + ", showDate=" + showDate + ", showFee=" + showFee + ", userId=" + userId + ", openId="
				+ openId + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", modifyUserId="
				+ modifyUserId + ", requestMark=" + requestMark + "]";
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */