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
 * Created on 2016年7月7日
 *******************************************************************************/


package com.showmecoo.web.management.constants;

/**
 * config all the native user SQLs
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class UserSQLConstants {
	
	/*
	 *   `userid` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `rolename` VARCHAR(45) NULL,
  `createdate` DATETIME NOT NULL,
  `modifydate` DATETIME NOT NULL,
  `lastlogindate` DATETIME NOT NULL,
  `openid` VARCHAR(45) NULL
	 */
	
	public static final String SQL_FIND_USER_BY_NAME = "select userid, username, password, phone, email, rolename, createdate, modifydate, lastlogindate, openid from user where username=?1"; 
	public static final String SQL_FIND_USER_BY_ID = "select userid, username, password, phone, email, rolename, createdate, modifydate, lastlogindate, openid from user where userid=?"; 
	public static final String SQL_COUNT_USER = "select count(userid) from user"; 
	
	public static final String SQL_DELETE_USER_BY_ID = "delete from user where userid=?"; 
	
}

/*
 * 修改历史
 * $Log$ 
 */