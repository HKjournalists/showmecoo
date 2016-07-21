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
 * Created on 2016年7月22日
 *******************************************************************************/


package com.showmecoo.web.management.spi.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.showmecoo.web.management.entity.OrderEntity;

/**
 * 订单管理DAO类，提供基础的CRUD方法
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public interface OrderRepsitory extends PagingAndSortingRepository<OrderEntity, String>{

}

/*
 * 修改历史
 * $Log$ 
 */