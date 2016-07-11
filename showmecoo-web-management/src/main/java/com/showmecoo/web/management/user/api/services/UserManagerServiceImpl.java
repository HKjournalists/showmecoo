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
 * Created on 2016年7月10日
 *******************************************************************************/


package com.showmecoo.web.management.user.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.showmecoo.web.management.user.api.IUserManagerService;
import com.showmecoo.web.management.user.entity.UserEntity;
import com.showmecoo.web.management.user.spi.UserDao;

/**
 * 用户管理模块对外提供的rest service，返回json格式的返回值
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Component
public class UserManagerServiceImpl implements IUserManagerService{
	
//	@Resource
//	@Qualifier("userRepository")此类定义用于dao有多个实现类的情况
	@Autowired
	private UserDao userDao;
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.spi.IUserManagerService#findUserByName(java.lang.String)
	 */
	@Override
	public UserEntity findUserByName(String userName) {
		UserEntity user = userDao.findUserByName(userName);
		
		return user;
	}
	
	

}

/*
 * 修改历史
 * $Log$ 
 */