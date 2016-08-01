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


package com.showmecoo.web.management.spi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.showmecoo.web.management.constants.SQLConstants;
import com.showmecoo.web.management.entity.RoleEntity;

/**
 * 角色管理数据层对外接口
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public interface RoleRepository extends PagingAndSortingRepository<RoleEntity, Integer>{
	
	@Query(value=SQLConstants.ROLE_SQL_FIND_ROLE_BY_NAME, nativeQuery=true)
	RoleEntity findRoleByName(String roleName) throws Throwable;

}

/*
 * 修改历史
 * $Log$ 
 */