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
 * Created on 2016年7月30日
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

import com.showmecoo.web.commons.bo.ModelModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;
import com.showmecoo.web.commons.util.JsonablePageImpl;

/**
 * 模特管理 对外REST接口
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(value=RestAPIConstants.API_VERSION + RestAPIConstants.URI_MODULE_ACTORS)
public interface IModelManagerService {
	
	/**
	 * 新增模特，如果actor表没有纪录，则先新增actor表，生成actorid后再insert actor_model表<br/>
	 * e.g uri: http://host:port/1/actors/c/model
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@POST
	@Path(value=RestAPIConstants.OPERATION_TYPE_CREATE + RestAPIConstants.OPTION_ACTOR_MODEL)
	ModelModel createModel(ModelModel bo) throws Throwable;
	
	/**
	 * 更新模特信息<br/>
	 * e.g uri: http://host:port/1/actors/u/model
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@PUT
	@Path(value=RestAPIConstants.OPERATION_TYPE_UPDATE + RestAPIConstants.OPTION_ACTOR_MODEL)
	ModelModel updateModel(ModelModel bo) throws Throwable;
	
	/**
	 * 删除模特信息，同时删除actor表和actor_model表中相同ID的纪录<br/>
	 * e.g uri: http://host:port/1/actors/d/model/123
	 * @param modelId
	 * @throws Throwable
	 */
	@DELETE
	@Path(value=RestAPIConstants.OPERATION_TYPE_DELETE + RestAPIConstants.OPTION_ACTOR_MODEL + "/{modelId}")
	void deleteModel(@PathParam("modelId")String modelId) throws Throwable;
	
	/**
	 * 根据ID查询模特信息<br/>
	 * e.g uri: http://host:port/1/actors/q/model/i/123
	 * @param modelId
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_MODEL + RestAPIConstants.QUERY_PARAM_ID + "/{modelId}")
	ModelModel findModelById(@PathParam("modelId") String modelId) throws Throwable;
	
	/**
	 * 根据名字查询模特信息，返回相同名字的模特集合, 如果想查询唯一的模特，请使用根据艺名（nickName）或Id的方式查询<br/>
	 * e.g uri: http://host:port/1/actors/q/model/n/lilly
	 * @param modelName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_MODEL + RestAPIConstants.QUERY_PARAM_NAME + "/{modelName}")
	List<ModelModel> findModelByName(@PathParam("modelName")String modelName) throws Throwable;
	
	/**
	 * 根据艺名查询模特信息<br/>
	 * e.g uri: http://host:port/1/actors/q/model/n/nick/花花
	 * 
	 * @param nickName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_MODEL + RestAPIConstants.QUERY_PARAM_NAME + "/nick/{nickName}")
	ModelModel findModelByNickName(@PathParam("nickName")String nickName) throws Throwable;
	
	
	/**
	 * 查询所有的模特信息，返回带分页信息的JsonablePageImpl对象的json串，默认每页10条纪录<br/>
	 * e.g uri: http://host:port/1/actors/q/model/all
	 * 
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_MODEL + RestAPIConstants.QUERY_PARAM_ALL)
	JsonablePageImpl<ModelModel> findAllModels() throws Throwable;
	
	
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_MODEL + RestAPIConstants.QUERY_PARAM_LIST + "/{page}/{size}")
	JsonablePageImpl<ModelModel> findModelsWithPage(@PathParam("page")int page, @PathParam("size")int size) throws Throwable;
	
	
	
	
	
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */