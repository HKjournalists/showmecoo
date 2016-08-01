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
 * Created on 2016年7月7日
 *******************************************************************************/


package com.showmecoo.web.management.spi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.showmecoo.web.management.constants.SQLConstants;
import com.showmecoo.web.management.entity.UserEntity;
import com.showmecoo.web.management.spi.dao.UserInternalDao;

/**
 * 用户管理DAO接口
 * 
 * 可以定义一些简单的自定义查询，因为可以借助spring data自动实现命名sql查询
 * 不需要手动实现，但是对于复杂查询还是需要使用自己实现，那时就需要定义在UserInternalDao里
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Transactional
public interface UserRepository extends PagingAndSortingRepository<UserEntity, String>, UserInternalDao{
	
	/**
	 * 根据用户名查找userEntity，
	 * @param userName
	 * @return
	 */
	@Query(value=SQLConstants.USER_SQL_FIND_USER_BY_NAME, nativeQuery=true)
	UserEntity findUserByName(String userName);
	
}

/*
 * 修改历史
 * $Log$ 
 */