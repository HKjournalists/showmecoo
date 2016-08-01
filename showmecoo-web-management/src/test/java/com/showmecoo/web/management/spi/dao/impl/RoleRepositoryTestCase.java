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
 * Created on 2016年7月24日
 *******************************************************************************/


package com.showmecoo.web.management.spi.dao.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.showmecoo.web.commons.util.FastJsonUtil;
import com.showmecoo.web.management.Application;
import com.showmecoo.web.management.entity.RoleEntity;
import com.showmecoo.web.management.spi.repository.RoleRepository;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
public class RoleRepositoryTestCase {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Test
	@Rollback(false)
	public void testCreateRole(){
		RoleEntity role = new RoleEntity();
		role.setCreateDate(new Date());
		role.setCreateUserId("123");
		role.setModifyDate(new Date());
		role.setModifyUserId("456");
		role.setRoleDesc("normal user");
		role.setRoleName("user");
		roleRepo.save(role);
	}
	
	@Test
//	@Rollback(false)
	public void testUpdateRole() throws Throwable{
		RoleEntity role = roleRepo.findRoleByName("user");
		Assert.assertNotNull(role);
		role.setRoleDesc("admin user");
		roleRepo.save(role);
		RoleEntity nRole = roleRepo.findOne(role.getRoleId());
		System.out.println(nRole);
		Assert.assertEquals("admin user", nRole.getRoleDesc());
	}
	
	@Test
	public void testFindAll(){
		PageRequest pageable = new PageRequest(0, 10);
		Page<RoleEntity> poPage = roleRepo.findAll(pageable);
		System.out.println(FastJsonUtil.Object2String(poPage));
	}
	
	
	
	
	
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */