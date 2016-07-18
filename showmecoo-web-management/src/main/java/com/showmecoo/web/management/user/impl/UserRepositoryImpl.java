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


package com.showmecoo.web.management.user.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.showmecoo.web.management.constants.UserSQLConstants;
import com.showmecoo.web.management.user.entity.UserEntity;
import com.showmecoo.web.management.user.spi.UserInternalDao;
import com.showmecoo.web.management.user.spi.UserRepository;

/**
 * TODO 此处填写 class 信息
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