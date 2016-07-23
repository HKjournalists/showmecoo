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
 * Created on 2016年7月23日
 *******************************************************************************/


package com.showmecoo.web.management.spi.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.showmecoo.web.management.constants.UserSQLConstants;
import com.showmecoo.web.management.entity.WechatUserEntity;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public interface WechatRepository extends PagingAndSortingRepository<WechatUserEntity, String>, UserInternalDao{
	
	/**
	 * 根据用户ID查找微信公众号关注用户
	 * @param userId		userEntity ID
	 * @return
	 */
	@Query(value=UserSQLConstants.SQL_FIND_WECHAT_USER_BY_USERID, nativeQuery=true)
	WechatUserEntity findWechatUserByUserId(String userId);
}

/*
 * 修改历史
 * $Log$ 
 */