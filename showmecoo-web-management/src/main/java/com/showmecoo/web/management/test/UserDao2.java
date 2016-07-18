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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public interface UserDao2 extends PagingAndSortingRepository<UserEntity2, String>{
//	from UserEntity2 where username= :username
	@Query(value="from UserEntity2 where username= :username")
	UserEntity2 findByUserName(@Param("username") String username);
}

/*
 * 修改历史
 * $Log$ 
 */