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


package com.showmecoo.web.management.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户角色对象实体
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Entity
@Table(name="role")
public class RoleEntity implements Serializable{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -7024413524230876947L;

	/*
	 * --role 角色表
CREATE TABLE `showmecoo`.`role` (
  `roleid` INT NOT NULL AUTO_INCREMENT,
  `rolename` VARCHAR(45) NOT NULL,
  `roledesc` VARCHAR(45) NULL,
  `createuserid` VARCHAR(45) NOT NULL,
  `createdate` DATETIME NOT NULL,
  `modifyuserid` VARCHAR(45) NOT NULL,
  `modifydate` DATETIME NOT NULL,
  PRIMARY KEY (`roleid`));
	 */
	
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	private int roleId;
	
	private String roleName;
	private String roleDesc;//角色描述
	private String createUserId;//对应user表的userid
	private Date createDate;
	private String modifyUserId;//对应user表的userid
	private Date modifyDate;
	/**
	 * @return Returns the roleId.
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId The roleId to set.
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return Returns the roleName.
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName The roleName to set.
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return Returns the roleDesc.
	 */
	public String getRoleDesc() {
		return roleDesc;
	}
	/**
	 * @param roleDesc The roleDesc to set.
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	/**
	 * @return Returns the createUserId.
	 */
	public String getCreateUserId() {
		return createUserId;
	}
	/**
	 * @param createUserId The createUserId to set.
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleEntity [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", createUserId="
				+ createUserId + ", createDate=" + createDate + ", modifyUserId=" + modifyUserId + ", modifyDate="
				+ modifyDate + "]";
	}
	
	
	
	
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */