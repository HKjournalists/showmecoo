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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Repository
@Transactional
public class UDAOImpl implements UDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.test.UDAO#findUserByName(java.lang.String)
	 */
	@Override
	public UserEntity2 findUserByName(String name) {
		Query query = entityManager.createNativeQuery("select userid, username, password, phone, email, rolename, createdate, modifydate, lastlogindate, openid from user where username=?", UserEntity2.class);
		query.setParameter(1, name);
//		Query query = entityManager.createQuery("from userEntity");
		return (UserEntity2) query.getSingleResult();
	}

}

/*
 * 修改历史
 * $Log$ 
 */