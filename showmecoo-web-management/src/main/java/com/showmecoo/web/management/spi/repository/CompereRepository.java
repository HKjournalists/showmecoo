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

import org.springframework.data.repository.PagingAndSortingRepository;

import com.showmecoo.web.management.entity.CompereEntity;

/**
 * 主持人 数据层接口
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public interface CompereRepository  extends PagingAndSortingRepository<CompereEntity, String>{
	
}

/*
 * 修改历史
 * $Log$ 
 */