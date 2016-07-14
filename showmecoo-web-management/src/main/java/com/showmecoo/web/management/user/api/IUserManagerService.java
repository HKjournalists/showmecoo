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
 * Created on 2016年7月10日
 *******************************************************************************/


package com.showmecoo.web.management.user.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.showmecoo.web.management.user.entity.UserEntity;
import com.showmecoo.web.management.user.spi.Consumes;

/**
 * restful api standard
 * http://ip:port/api_version/module/operation(create/update/delete/query)/options...(list/id/name...)/parameter
 * uri:http://ip:port//一级模块/操作/可选标识/参数
 *
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Component
@Path(RestAPIConstants.API_VERSION + RestAPIConstants.URI_MODULE_USERS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IUserManagerService {
	
	@POST
	@Path("/create")
	UserEntity createUserEntity(UserEntity user);
	
	@PUT
	@Path("/update")
	UserEntity updateUserEntity(UserEntity user);
	
	@DELETE
	@Path("/delete/{userid}")
	void deleteUserEntity(@pathParm("userid")String userId);
	
	@GET
	@Path("/query/{userName}")
	UserEntity findUserByName(@PathParam("userName")String userName);
	
	@GET
	@Path("/query/id/{userid}")
	UserEntity findUserById(@PathParam("{userid}")String userId);
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */