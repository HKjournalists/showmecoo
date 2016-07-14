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

import java.util.Date;

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
	private UserRepository userRepository;

	/**
	 * Test method for {@link com.showmecoo.web.management.user.impl.UserRepositoryImpl#findUserByName(java.lang.String)}.
	 */
	@Test
//	@Rollback(false)
	public void testFindUserByName() {
		UserEntity user = userRepository.findUserByName("mac");
		System.out.println(user);
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getUserName(), "mac");
	}

	/**
	 * Test method for {@link com.showmecoo.web.management.user.impl.UserRepositoryImpl#findUserById(java.lang.String)}.
	 */
	@Test
	public void testFindUserById() {
		UserEntity user = userRepository.findUserById("402881e755e99c620155e99c68400000");
		Assert.assertEquals(user.getUserName(), "mac");
		System.out.println(user);
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
		int count = userRepository.countUsers();
		Assert.assertEquals(2, count);
	}

	/**
	 * Test method for {@link com.showmecoo.web.commons.dao.BasicRepository#create(java.lang.Object)}.
	 */
	@Test
//	@Rollback(false)
	public void testCreate() {
		UserEntity user = new UserEntity();
//		user.setUserId("1");
		user.setUserName("mac");
		user.setPassword("1234");
		user.setPhone("123456789");
		user.setEmail("ss@aa.com");
		user.setRolename("admin");
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		user.setLastLoginDate(new Date());
		user.setOpenId("1234");
		userRepository.createUser(user);
	}

	/**
	 * Test method for {@link com.showmecoo.web.commons.dao.BasicRepository#update(java.lang.Object)}.
	 */
	@Test
	@Rollback(false)
	public void testUpdate() {
		UserEntity user = userRepository.findUserByName("mac");
		user.setEmail("update@gmail.com");
		userRepository.updateUser(user);
		UserEntity nuser = userRepository.findUserById(user.getUserId());
		Assert.assertEquals("update@gmail.com", nuser.getEmail());
	}

	/**
	 * Test method for {@link com.showmecoo.web.commons.dao.BasicRepository#delete(java.lang.Object)}.
	 */
	@Test
	@Rollback(false)
	public void testDelete() {
		UserEntity user = userRepository.findUserByName("mac1");
		userRepository.deleteUserEntity(user.getUserId());
		UserEntity nuser = userRepository.findUserByName("mac1");
		Assert.assertNull(nuser);
	}

}

/*
 * 修改历史
 * $Log$ 
 */