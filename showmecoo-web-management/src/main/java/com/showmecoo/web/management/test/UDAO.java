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
 * Created on 2016年7月11日
 *******************************************************************************/


package com.showmecoo.web.management.test;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public interface UDAO{
	
	UserEntity2 findUserByName(String name);
	
	UserEntity2 createUser(UserEntity2 user);
}

/*
 * 修改历史
 * $Log$ 
 */