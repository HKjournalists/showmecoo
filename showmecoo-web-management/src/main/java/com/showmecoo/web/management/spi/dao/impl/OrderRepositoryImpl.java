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


package com.showmecoo.web.management.spi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.showmecoo.web.management.spi.dao.OrderInternalDao;

/**
 * 订单管理复杂查询内部接口实现类
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class OrderRepositoryImpl implements OrderInternalDao{
	
	private static Logger log = LoggerFactory.getLogger(OrderRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
}

/*
 * 修改历史
 * $Log$ 
 */