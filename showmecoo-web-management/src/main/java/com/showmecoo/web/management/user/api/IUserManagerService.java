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

import com.showmecoo.web.commons.constants.RestAPIConstants;
import com.showmecoo.web.management.user.entity.UserEntity;

/**
 * 
 * userManager 模块对外提供的user相关的restful服务接口
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
@Path(RestAPIConstants.API_VERSION + RestAPIConstants.URI_MODULE_USERS)
public interface IUserManagerService {
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@POST
	@Path(RestAPIConstants.OPERATION_TYPE_POST)
	UserEntity createUserEntity(UserEntity user);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@PUT
	@Path(RestAPIConstants.OPERATION_TYPE_PUT)
	UserEntity updateUserEntity(UserEntity user);
	
	/**
	 * 根据userId删除用户
	 * @param userId
	 */
	@DELETE
	@Path(RestAPIConstants.OPERATION_TYPE_DELETE + "/{userid}")
	void deleteUserEntity(@PathParam("userid")String userId);
	
	/**
	 * 根据userName查询用户信息
	 * @param userName
	 * @return
	 */
	@GET
	@Path(RestAPIConstants.OPERATION_TYPE_GET + "/{userName}")
	UserEntity findUserByName(@PathParam("userName")String userName);
	
	/**
	 * 根据userId查询用户信息
	 * @param userId
	 * @return
	 */
	@GET
	@Path(RestAPIConstants.OPERATION_TYPE_GET + "/id/{userid}")
	UserEntity findUserById(@PathParam("{userid}")String userId);
	
	/**
	 * 统计总用户数
	 * @return
	 */
	@GET
	@Path(RestAPIConstants.OPERATION_TYPE_GET + "/count")
	int countUsers();
	
//	List<UserEntity> findUsers();
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */