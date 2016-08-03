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


package com.showmecoo.web.management.util;

import java.util.ArrayList;
import java.util.List;

import com.showmecoo.web.commons.bo.OrderModel;
import com.showmecoo.web.management.entity.OrderEntity;

/**
 * order 数据层对象与业务层对象转换工具类
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class OrderPoBoTransUtil {
	
	public static OrderEntity orderB2P(OrderModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("OrderModel can not be null");
		}
		
		OrderEntity po = new OrderEntity();
		po.setCreateDate(bo.getCreateDate());
		po.setLinkName(bo.getLinkName());
		po.setModifyDate(bo.getModifyDate());
		po.setOpenId(bo.getOpenId());
		po.setOrderId(bo.getOrderId());
		po.setPhone(bo.getPhone());
		po.setRequestMark(bo.getRequestMark());
		po.setShowAdddr(bo.getShowAdddr());
		po.setShowDate(bo.getShowDate());
		po.setShowFee(bo.getShowFee());
		po.setUserId(bo.getUserId());
		
		return po;
	}
	
	public static OrderModel orderP2B(OrderEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("OrderEntity can not be null");
		}
		
		OrderModel bo = new OrderModel();
		bo.setCreateDate(po.getCreateDate());
		bo.setLinkName(po.getLinkName());
		bo.setModifyDate(po.getModifyDate());
		bo.setOpenId(po.getOpenId());
		bo.setOrderId(po.getOrderId());
		bo.setPhone(po.getPhone());
		bo.setRequestMark(po.getRequestMark());
		bo.setShowAdddr(po.getShowAdddr());
		bo.setShowDate(po.getShowDate());
		bo.setShowFee(po.getShowFee());
		bo.setUserId(po.getUserId());
		
		return bo;
	}
	
	public static List<OrderModel> orderListP2B(List<OrderEntity> poList) throws IllegalAccessException{
		if(null == poList){
			throw new IllegalAccessException("OrderEntity list can not be null");
		}
		
		List<OrderModel> boList = new ArrayList<>();
		for(OrderEntity po:poList){
			boList.add(orderP2B(po));
		}
		return boList;
	}
	
	public static List<OrderEntity> orderListB2P(List<OrderModel> boList) throws IllegalAccessException{
		if(null == boList){
			throw new IllegalAccessException("OrderModel list can not be null");
		}
		
		List<OrderEntity> poList = new ArrayList<>();
		for(OrderModel bo:boList){
			poList.add(orderB2P(bo));
		}
		return poList;
	}
}

/*
 * 修改历史
 * $Log$ 
 */