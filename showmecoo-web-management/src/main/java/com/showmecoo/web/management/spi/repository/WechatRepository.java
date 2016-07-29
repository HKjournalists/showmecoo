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


package com.showmecoo.web.management.spi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.showmecoo.web.management.constants.SQLConstants;
import com.showmecoo.web.management.entity.WechatUserEntity;
import com.showmecoo.web.management.spi.dao.UserInternalDao;

/**
 * 微信用户对象实例持久层接口
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public interface WechatRepository extends PagingAndSortingRepository<WechatUserEntity, String>, UserInternalDao{
	
	/**
	 * 根据用户ID查找微信公众号关注用户
	 * @param userId		userEntity ID
	 * @return
	 */
	@Query(value=SQLConstants.USER_SQL_FIND_WECHAT_USER_BY_USERID, nativeQuery=true)
	WechatUserEntity findWechatUserByUserId(String userId);
}

/*
 * 修改历史
 * $Log$ 
 */