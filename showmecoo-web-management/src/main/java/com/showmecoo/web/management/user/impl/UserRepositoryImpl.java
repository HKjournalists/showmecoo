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
import com.showmecoo.web.management.user.spi.UserRepository;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
	
	private static Logger log = LoggerFactory.getLogger(UserRepositoryImpl.class);
	
	 @PersistenceContext
	 private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.spi.UserDao#findUserByName(java.lang.String)
	 */
	@Override
	public UserEntity findUserByName(String userName) {
		Query query = entityManager.createNativeQuery(UserSQLConstants.SQL_FIND_USER_BY_NAME, UserEntity.class);
		query.setParameter(1, userName);
		UserEntity user;
		try {
			user = (UserEntity) query.getSingleResult();
		} catch (NoResultException e) {
			log.error("can not find user by userName: {}", userName, e);
			return null;
		}
		
		return user;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.spi.UserDao#findUserById(java.lang.String)
	 */
	@Override
	public UserEntity findUserById(String userId) {
		Query query = entityManager.createNativeQuery(UserSQLConstants.SQL_FIND_USER_BY_ID, UserEntity.class);
		query.setParameter(1, userId);
		
		return (UserEntity) query.getSingleResult();
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
	@SuppressWarnings("unchecked")
	@Override
	public int countUsers() {
		Query query = entityManager.createNativeQuery(UserSQLConstants.SQL_COUNT_USER);
		List<Number> list = (List<Number>)query.getResultList();
		return list.get(0).intValue();
	}

	@Override
	public UserEntity createUser(UserEntity userInfo) {
		entityManager.persist(userInfo);
		return userInfo;
	}

	@Override
	public UserEntity updateUser(UserEntity user) throws IllegalAccessException {
		if(null == user || findUserById(user.getUserId()) == null){
			throw new IllegalAccessException("the update user is illegal, please check first");
		}
		
		return entityManager.merge(user);
	}

	@Override
	public boolean deleteUserEntity(String userid) {

		Query query = entityManager.createNativeQuery(UserSQLConstants.SQL_DELETE_USER_BY_ID);
		query.setParameter(1, userid);
		int i = query.executeUpdate();
		if(i==0){
			return false;
		}
		return true;
	}
	
}	

/*
 * 修改历史
 * $Log$ 
 */