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
 * Created on 2016年7月29日
 *******************************************************************************/


package com.showmecoo.web.management.spi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.showmecoo.web.management.constants.SQLConstants;
import com.showmecoo.web.management.entity.ActorEntity;

/**
 * 演员管理数据层接口
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public interface ActorRepository extends PagingAndSortingRepository<ActorEntity, String>{
	
	@Query(value=SQLConstants.ACTOR_SQL_FIND_ACTOR_BY_NAME, nativeQuery=true)
	List<ActorEntity> findActorEntityByName(String actorName);
	
	@Query(value=SQLConstants.ACTOR_SQL_FIND_ACTOR_BY_NICK_NAME, nativeQuery=true)
	ActorEntity findActorEntityByNickName(String nickName);
}

/*
 * 修改历史
 * $Log$ 
 */