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
 * Created on 2016年7月17日
 *******************************************************************************/


package com.showmecoo.web.management.test;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class UserDao2TestCase {
	
	@Autowired
	UserDao2 dao;
	
	@Test
	public void testQuery(){
		String id = "402881e755e99c620155e99c68400000";
//		UserEntity2 user = dao.findOne(id );
//		
//		long c = dao.count();
		Pageable pageable = new PageRequest(1, 10);
		UserEntity2 user = dao.findByUserName("mac");
//		System.out.println(c);
		System.out.println(user);
		System.out.println(pageable.getPageNumber());
	}
}

/*
 * 修改历史
 * $Log$ 
 */