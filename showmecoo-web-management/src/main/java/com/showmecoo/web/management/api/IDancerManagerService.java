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


package com.showmecoo.web.management.api;

import java.util.List;

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

import com.showmecoo.web.commons.bo.DancerModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;
import com.showmecoo.web.commons.util.JsonablePageImpl;

/**
 * 舞者管理 对外REST 接口
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(value=RestAPIConstants.API_VERSION + RestAPIConstants.URI_MODULE_ACTORS)
public interface IDancerManagerService {
	
	/**
	 * 新增舞者，如果actor表没有纪录，则先新增actor表，生成actorid后再insert actor_dancer表<br/>
	 * e.g uri: http://host:port/1/actors/c/dancer
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@POST
	@Path(value=RestAPIConstants.OPERATION_TYPE_CREATE + RestAPIConstants.OPTION_ACTOR_DANCER)
	DancerModel createDancerModel(DancerModel bo) throws Throwable;
	
	/**
	 * 更新舞者<br/>
	 * e.g uri: http://host:port/1/actors/u/dancer
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@PUT
	@Path(value=RestAPIConstants.OPERATION_TYPE_UPDATE + RestAPIConstants.OPTION_ACTOR_DANCER)
	DancerModel updateDancerModel(DancerModel bo) throws Throwable;
	
	/**
	 * 删除舞者，根据id同时删除actor表和actor_dancer表纪录<br/>
	 * e.g uri: http://host:port/1/actors/d/dancer/123
	 * @param dancerId
	 * @throws Throwable
	 */
	@DELETE
	@Path(value=RestAPIConstants.OPERATION_TYPE_DELETE + RestAPIConstants.OPTION_ACTOR_DANCER + "/{dancerid}")
	void deleteDancerModel(@PathParam("dancerid")String dancerId) throws Throwable;
	
	
	/**
	 * 根据ID查询舞者<br/>
	 * e.g uri：http://host:port/1/actors/q/dancer/i/123
	 * @param dancerid
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_DANCER + RestAPIConstants.QUERY_PARAM_ID + "/{dancerid}")
	DancerModel findDancerById(@PathParam("dancerid")String dancerid) throws Throwable;
	
	/**
	 * 根据名字查询舞者，可能查出一堆重名的舞者，如果想查询唯一的舞者则使用nickName，或者使用ID<br/>
	 * e.g uri: http://host:port/1/actors/q/dancer/n/macky
	 * @param dancerName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_DANCER + RestAPIConstants.QUERY_PARAM_NAME + "/{dancerName}")
	List<DancerModel> findDancerByName(@PathParam("dancerName")String dancerName) throws Throwable;
	
	/**
	 * 根据别名（艺名）查询舞者，查出的结果唯一<br/>
	 * e.g uri: http://host:port/1/actors/q/dacner/n/nick/花花
	 * @param nickName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_DANCER + RestAPIConstants.QUERY_PARAM_NAME + "/nick/{nickName}")
	DancerModel findDancerByNickName(@PathParam("nickName") String nickName) throws Throwable;
	
	/**
	 * 查询所有的舞者, 返回带分页的JsonablePageImpl对象json串<br/>
	 * e.g uri: http://host:port/1/actors/q/dancer/list
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_DANCER + RestAPIConstants.QUERY_PARAM_ALL)
	JsonablePageImpl<DancerModel> findAllDancers() throws Throwable;
	
	/**
	 * 查询部分舞者，根据指定的页数和每页大小 返回JsonablePageImpl对象json串<br/>
	 * e.g uri: http://host:port/1/actors/q/dancer/list/2/10
	 * @param page
	 * @param size
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_DANCER + RestAPIConstants.QUERY_PARAM_LIST + "/{page}/{size}")
	JsonablePageImpl<DancerModel> findDancersWithPage(@PathParam("page")int page, @PathParam("size")int size) throws Throwable;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */