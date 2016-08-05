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
 * Created on 2016年8月4日
 *******************************************************************************/


package com.showmecoo.web.management.spi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.showmecoo.web.management.constants.SQLConstants;
import com.showmecoo.web.management.entity.PictureWorkEntity;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public interface PictureWorkRepository extends PagingAndSortingRepository<PictureWorkEntity, String>{
	
	@Query(value=SQLConstants.WORK_SQL_FIND_PICTURE_BY_WORK_NAME, nativeQuery=true)
	PictureWorkEntity findPictureByWorkName(String workName) throws Throwable;
}

/*
 * 修改历史
 * $Log$ 
 */