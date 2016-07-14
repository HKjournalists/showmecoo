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

import static org.junit.Assert.fail;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.showmecoo.web.management.Application;
import com.showmecoo.web.management.user.entity.UserEntity;
import com.showmecoo.web.management.user.spi.UserRepository;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
public class UserRepositoryTestCase {
	
	@Autowired
	private UserRepository userDao;

	/**
	 * Test method for {@link com.showmecoo.web.management.user.impl.UserRepositoryImpl#findUserByName(java.lang.String)}.
	 */
	@Test
//	@Rollback(false)
	public void testFindUserByName() {
		UserEntity user = userDao.findUserByName("mac");
		System.out.println(user);
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getUserName(), "mac");
	}

	/**
	 * Test method for {@link com.showmecoo.web.management.user.impl.UserRepositoryImpl#findUserById(java.lang.String)}.
	 */
	@Test
	public void testFindUserById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.showmecoo.web.management.user.impl.UserRepositoryImpl#findAllUsers()}.
	 */
	@Test
	public void testFindAllUsers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.showmecoo.web.management.user.impl.UserRepositoryImpl#findUsersWithPage()}.
	 */
	@Test
	public void testFindUsersWithPage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.showmecoo.web.management.user.impl.UserRepositoryImpl#countUsers()}.
	 */
	@Test
	public void testCountUsers() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.showmecoo.web.commons.dao.BasicRepository#create(java.lang.Object)}.
	 */
	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.showmecoo.web.commons.dao.BasicRepository#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.showmecoo.web.commons.dao.BasicRepository#delete(java.lang.Object)}.
	 */
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}

/*
 * 修改历史
 * $Log$ 
 */