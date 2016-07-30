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

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.showmecoo.web.commons.bo.ActorModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;

/**
 * 演员管理 对外提供REST 接口，主要为演员一级页面提供服务
 * 
 * restful api standard
 * http://ip:port/api_version/module/operation(create/update/delete/query)/options...(list/id/name...)/parameter
 * uri:http://ip:port//一级模块/操作/可选标识/参数
 *
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(value=RestAPIConstants.API_VERSION + RestAPIConstants.URI_MODULE_ACTORS)
public interface IActorManagerService {
	
	/**
	 * 新增Actor，在对应的actor表新增一条纪录
	 * @param bo
	 * @return
	 */
	@POST
	@Path(value=RestAPIConstants.OPERATION_TYPE_CREATE + RestAPIConstants.OPTION_ACTOR_ACTOR )
	ActorModel createActorModel(ActorModel bo) throws Throwable;
	
	/**
	 * 更新Actor， 只更新Actor一张主表的纪录
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@PUT
	@Path(value=RestAPIConstants.OPERATION_TYPE_UPDATE + RestAPIConstants.OPTION_ACTOR_ACTOR)
	ActorModel updateActorModel(ActorModel bo) throws Throwable;
	
	/**
	 * 删除艺人，同时删除actor表以及dancer, singer, model, compere子表中的形同id的纪录
	 * @param bo
	 * @throws Throwable
	 */
	@DELETE
	@Path(value=RestAPIConstants.OPERATION_TYPE_UPDATE + RestAPIConstants.OPTION_ACTOR_ACTOR)
	void deleteActor(ActorModel bo) throws Throwable;
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */