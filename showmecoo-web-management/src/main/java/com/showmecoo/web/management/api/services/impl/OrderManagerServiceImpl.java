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
 * Created on 2016年8月3日
 *******************************************************************************/


package com.showmecoo.web.management.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.showmecoo.web.commons.bo.OrderModel;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.api.service.IOrderManagerService;
import com.showmecoo.web.management.entity.OrderEntity;
import com.showmecoo.web.management.spi.repository.OrderRepsitory;
import com.showmecoo.web.management.util.OrderPoBoTransUtil;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Service
public class OrderManagerServiceImpl implements IOrderManagerService{
	
	private Logger log = LoggerFactory.getLogger(OrderManagerServiceImpl.class);
	
	@Autowired
	private OrderRepsitory orderRepository;

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IOrderManagerService#createOrderModel(com.showmecoo.web.commons.bo.OrderModel)
	 */
	@Override
	public OrderModel createOrderModel(OrderModel bo) throws Throwable {
		log.debug("call createOrderModel rest api");
		OrderEntity po = orderRepository.save(OrderPoBoTransUtil.orderB2P(bo));
		return OrderPoBoTransUtil.orderP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IOrderManagerService#updateOrderModel(com.showmecoo.web.commons.bo.OrderModel)
	 */
	@Override
	public OrderModel updateOrderModel(OrderModel bo) throws Throwable {
		log.debug("call updateOrderModel rest api");
		OrderEntity po = orderRepository.save(OrderPoBoTransUtil.orderB2P(bo));
		return OrderPoBoTransUtil.orderP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IOrderManagerService#deleteOrderModel(java.lang.String)
	 */
	@Override
	public void deleteOrderModel(String orderId) throws Throwable {
		log.debug("call deleteOrderModel rest api");
		orderRepository.delete(orderId);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IOrderManagerService#findOrderById(java.lang.String)
	 */
	@Override
	public OrderModel findOrderById(String orderId) throws Throwable {
		log.debug("call findOrderById rest api");
		OrderEntity po = orderRepository.findOne(orderId);
		return OrderPoBoTransUtil.orderP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IOrderManagerService#findAllOrders()
	 */
	@Override
	public JsonablePageImpl<OrderModel> findAllOrders() throws Throwable {
		log.debug("call findAllOrders rest api");
		PageRequest pageable = new PageRequest(0, 10);
		Page<OrderEntity> poPage = orderRepository.findAll(pageable);
		JsonablePageImpl<OrderModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(OrderPoBoTransUtil.orderListP2B(poPage.getContent()));
		jsonAble.setFirst(poPage.isFirst());
		jsonAble.setLast(poPage.isLast());
		jsonAble.setNumber(poPage.getNumber());
		jsonAble.setNumberOfElements(poPage.getNumberOfElements());
		jsonAble.setSize(poPage.getSize());
		jsonAble.setTotalElements(poPage.getTotalElements());
		return jsonAble;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IOrderManagerService#findOrdersWithPage(int, int)
	 */
	@Override
	public JsonablePageImpl<OrderModel> findOrdersWithPage(int page, int size) throws Throwable {
		
		log.debug("call findOrdersWithPage rest api");
		PageRequest pageable = new PageRequest(page, size);
		Page<OrderEntity> poPage = orderRepository.findAll(pageable);
		JsonablePageImpl<OrderModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(OrderPoBoTransUtil.orderListP2B(poPage.getContent()));
		jsonAble.setFirst(poPage.isFirst());
		jsonAble.setLast(poPage.isLast());
		jsonAble.setNumber(poPage.getNumber());
		jsonAble.setNumberOfElements(poPage.getNumberOfElements());
		jsonAble.setSize(poPage.getSize());
		jsonAble.setTotalElements(poPage.getTotalElements());
		return jsonAble;
	}

}

/*
 * 修改历史
 * $Log$ 
 */