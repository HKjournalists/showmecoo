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


package com.showmecoo.web.management.spi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.showmecoo.web.management.spi.dao.UserInternalDao;

/**
 * 用户管理模块自定义DAO接口实现类
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Repository
@Transactional
public class UserRepositoryImpl implements UserInternalDao{
	
	private static Logger log = LoggerFactory.getLogger(UserRepositoryImpl.class);
	
	 @PersistenceContext
	 private EntityManager entityManager;
	 
	
}	

/*
 * 修改历史
 * $Log$ 
 */