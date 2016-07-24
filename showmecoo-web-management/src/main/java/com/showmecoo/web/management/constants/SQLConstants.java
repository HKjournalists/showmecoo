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

public class SQLConstants {

	/*
	 * `userid` VARCHAR(45) NOT NULL, `username` VARCHAR(45) NOT NULL,
	 * `password` VARCHAR(45) NOT NULL, `phone` VARCHAR(45) NULL, `email`
	 * VARCHAR(45) NULL, `rolename` VARCHAR(45) NULL, `createdate` DATETIME NOT
	 * NULL, `modifydate` DATETIME NOT NULL, `lastlogindate` DATETIME NOT NULL,
	 * `openid` VARCHAR(45) NULL
	 */

	
	//user table
	public static final String USER_SQL_FIND_USER_BY_NAME = "select userid, username, password, phone, email, rolename, createdate, modifydate, lastlogindate, openid "
									+ "from user "
									+ "where username=?1";
	
	public static final String USER_SQL_FIND_USER_BY_ID = "select userid, username, password, phone, email, rolename, createdate, modifydate, lastlogindate, openid "
														+ "from user "
														+ "where userid=?";
	
	public static final String USER_SQL_COUNT_USER = "select count(userid) from user";

	public static final String USER_SQL_DELETE_USER_BY_ID = "delete from user where userid=?";

	/*
	 * 
	 * --user_wechat_info 微信用户信息表 CREATE TABLE `showmecoo`.`user_wechat_info` (
	 * `openid` VARCHAR(45) NOT NULL, `userid` VARCHAR(45) NULL, `nickname`
	 * VARCHAR(45) NULL, `sex` CHAR(1) NULL, `city` VARCHAR(45) NULL, `country`
	 * VARCHAR(45) NULL, `province` VARCHAR(45) NULL, `language` VARCHAR(45)
	 * NULL, `headimgurl` VARCHAR(45) NULL, `subscribe_time` DATETIME NULL,
	 * `unionid` VARCHAR(45) NULL, `remark` VARCHAR(45) NULL, `groupid`
	 * VARCHAR(45) NULL, PRIMARY KEY (`openid`));
	 */

	public static final String USER_SQL_FIND_WECHAT_USER_BY_USERID = "select openid, userid, nickname, sex, city, country, province, language, headimgurl, subscribe_time, unionid, remark, groupid "
																+ "	from wechat_user_info "
																+ "	where userid=?1";
	
	/*
	 * CREATE TABLE `showmecoo`.`role` (
  `roleid` INT NOT NULL AUTO_INCREMENT,
  `rolename` VARCHAR(45) NOT NULL,
  `roledesc` VARCHAR(45) NULL,
  `createuserid` VARCHAR(45) NOT NULL,
  `createdate` DATETIME NOT NULL,
  `modifyuserid` VARCHAR(45) NOT NULL,
  `modifydate` DATETIME NOT NULL,
  PRIMARY KEY (`roleid`));

	 */
	
	//role table
	public static final String ROLE_SQL_FIND_ROLE_BY_NAME = "select roleid, rolename, roledesc, createuserid, createdate, modifyuserid, modifydate "
															+ " from role"
															+ " where rolename=?1";
}

/*
 * 修改历史 $Log$
 */