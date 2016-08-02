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
 * Created on 2016年8月2日
 *******************************************************************************/


package com.showmecoo.web.management.api.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.showmecoo.web.commons.bo.OrderModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;
import com.showmecoo.web.commons.util.JsonablePageImpl;

/**
 * 订单管理 对外提供REST API 接口
 *
 *restful api standard
 * http://ip:port/api_version/module/operation(create/update/delete/query)/options...(list/id/name...)/parameter
 * uri:http://ip:port//一级模块/操作/可选标识/参数
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(value=RestAPIConstants.API_VERSION + RestAPIConstants.URI_MODULE_ORDERS)
public interface IOrderManagerService {
	
	/**
	 * 创建订单<br/>
	 * e.g uri: http://host:port/1/orders/c
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@POST
	@Path(value=RestAPIConstants.OPERATION_TYPE_CREATE)
	OrderModel createOrderModel(OrderModel bo) throws Throwable;
	
	/**
	 * 更新订单<br/>
	 * e.g uri: http://host:port/1/orders/u
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@PUT
	@Path(value=RestAPIConstants.OPERATION_TYPE_UPDATE)
	OrderModel updateOrderModel(OrderModel bo) throws Throwable;
	
	
	/**
	 * 根据订单ID删除订单信息<br/>
	 * e.g uri: http://host:port/1/orders/d/123
	 * @param orderId
	 * @throws Throwable
	 */
	@DELETE
	@Path(value=RestAPIConstants.OPERATION_TYPE_DELETE + "/{orderId}")
	void deleteOrderModel(@PathParam("orderId")String orderId) throws Throwable;
	
	/**
	 * 根据订单ID查询订单信息<br/>
	 * e.g uri: http://host:port/1/orders/q/123
	 * @param orderId
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.QUERY_PARAM_ID + "/{orderId}")
	OrderModel findOrderById(@PathParam("orderId") String orderId) throws Throwable;
	
	/**
	 * 查询所有的订单信息，返回分页对象JsonablePageImpl的json串，默认从0页开始，每页10条
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.QUERY_PARAM_ALL)
	JsonablePageImpl<OrderModel> findAllOrders() throws Throwable;
	
	/**
	 * 查询部分订单信息，指定页数和每页条数，返回分页对象JsonablePageImpl的json串
	 * @param page				从第几页开始
	 * @param size				每页条数
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.QUERY_PARAM_LIST + "/{page}/{size}")
	JsonablePageImpl<OrderModel> findOrdersWithPage(@PathParam("page")int page, @PathParam("size")int size) throws Throwable;
	
}

/*
 * 修改历史
 * $Log$ 
 */