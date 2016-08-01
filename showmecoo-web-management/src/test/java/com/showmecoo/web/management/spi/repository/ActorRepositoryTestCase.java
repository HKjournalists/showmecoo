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
 * Created on 2016年8月1日
 *******************************************************************************/


package com.showmecoo.web.management.spi.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.showmecoo.web.management.Application;
import com.showmecoo.web.management.entity.ActorEntity;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
public class ActorRepositoryTestCase {
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Test
	@Rollback(false)
	public void testCreate(){
		ActorEntity actor = new ActorEntity();
		actor.setAge(10);
		actor.setCreateTime(new Date());
		actor.setDisplayedNum(10);
		actor.setFansNum(100);
		actor.setHeight(170);
		actor.setImageName("image_singer_mac");
		actor.setName("lili");
		actor.setNickName("macly3");
		actor.setSex(1);
		actor.setType(1);
		actor.setVisitNum(10);
		actorRepository.save(actor);
	
	}
	
	@Test
	public void testFindActorEntityByName(){
		String name = "lili";
		List<ActorEntity> list = actorRepository.findActorEntityByName(name);
		Assert.assertNotNull(list);
		for(ActorEntity po:list){
			System.out.println(po);
		}
	}
	
	@Test
	public void testFindActorByNickName(){
		String nickName = "macly3";
		ActorEntity actor = actorRepository.findActorEntityByNickName(nickName);
		Assert.assertNotNull(actor);
		System.out.println(actor);
	}
}

/*
 * 修改历史
 * $Log$ 
 */