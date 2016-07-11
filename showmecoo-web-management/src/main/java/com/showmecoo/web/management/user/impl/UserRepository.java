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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.showmecoo.web.management.user.constants.UserSQLConstants;
import com.showmecoo.web.management.user.entity.UserEntity;
import com.showmecoo.web.management.user.spi.UserDao;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Repository
@Transactional
public class UserRepository implements UserDao{
	
	 @PersistenceContext
	 private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.spi.UserDao#findUserByName(java.lang.String)
	 */
	@Override
	public UserEntity findUserByName(String userName) {
		Query query = entityManager.createNativeQuery(UserSQLConstants.SQL_FIND_USER_BY_NAME, UserEntity.class);
		query.setParameter(1, userName);
//		Object r = query.getSingleResult();
//		UserEntity user = (UserEntity) query.getSingleResult();
		return (UserEntity) query.getSingleResult();
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.spi.UserDao#findUserById(java.lang.String)
	 */
	@Override
	public UserEntity findUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.spi.UserDao#findAllUsers()
	 */
	@Override
	public List<UserEntity> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.spi.UserDao#findUsersWithPage()
	 */
	@Override
	public List<UserEntity> findUsersWithPage() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.spi.UserDao#countUsers()
	 */
	@Override
	public long countUsers() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}	

/*
 * 修改历史
 * $Log$ 
 */