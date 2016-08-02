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

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
@ComponentScan("com.showmecoo.web.management.test")
public class UDAOImplTestCase {
	
	@Autowired
	UDAO dao;

	/**
	 * Test method for {@link com.showmecoo.web.management.test.UDAOImpl#findUserByName(java.lang.String)}.
	 */
	@Test
	public void testFindUserByName() {
		UserEntity2 user = dao.findUserByName("mac");
		System.out.println(user);
	}
	
	@Test
	public void testCreateUser(){
		UserEntity2 user = new UserEntity2();
		user.setUserName("mac1");
		user.setPassword("1234");
		user.setPhone("123456789");
		user.setEmail("ss@aa.com");
		user.setRolename("admin");
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		user.setLastLoginDate(new Date());
		user.setOpenId("1234");
		dao.createUser(user);
	}
}

/*
 * 修改历史
 * $Log$ 
 */