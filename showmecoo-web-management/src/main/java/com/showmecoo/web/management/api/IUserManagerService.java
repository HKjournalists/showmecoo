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


package com.showmecoo.web.management.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.showmecoo.web.commons.bo.UserModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;
import com.showmecoo.web.management.entity.UserEntity;

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
	@Path(RestAPIConstants.OPERATION_TYPE_CREATE)
	UserEntity createUserEntity(UserModel bo);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@PUT
	@Path(RestAPIConstants.OPERATION_TYPE_UPDATE)
	UserEntity updateUserEntity(UserModel bo);
	
	/**
	 * 根据userId删除用户
	 * @param userId
	 * @return
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
	@Path(RestAPIConstants.OPERATION_TYPE_QUERY + "/{userName}")
	UserEntity findUserByName(@PathParam("userName")String userName);
	
	/**
	 * 根据userId查询用户信息
	 * @param userId
	 * @return
	 */
	@GET
	@Path(RestAPIConstants.OPERATION_TYPE_QUERY + "/id/{userid}")
	UserEntity findUserById(@PathParam("{userid}")String userId);
	
	/**
	 * 统计总用户数
	 * @return
	 */
	@GET
	@Path(RestAPIConstants.OPERATION_TYPE_QUERY + "/count")
	long countUsers();
	
	/**
	 * 指定分页页码和每页大小的查询
	 * @param page						页码，从第几页开始
	 * @param size						每页结果集大小
	 * @return							返回带分页信息的Page对象，通过page.getContent获取结果集<br/>
	 * page json示例
	 * <pre/>
	 *  {
    "content": [
        {
            "createDate": 1468503190000,
            "email": "update1@gmail.com",
            "lastLoginDate": 1468503190000,
            "modifyDate": 1468503190000,
            "openId": "1234",
            "password": "1234",
            "phone": "123456789",
            "rolename": "admin",
            "userId": "402881e755e99c620155e99c68400000",
            "userName": "mac"
        },
        {
            "createDate": 1468844905000,
            "email": "ss@aa.com",
            "lastLoginDate": 1468844905000,
            "modifyDate": 1468844905000,
            "openId": "1234",
            "password": "1234",
            "phone": "123456789",
            "rolename": "admin",
            "userId": "402881e755fdfa890155fdfa90510000",
            "userName": "mac1"
        }
    ],
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 2,
    "size": 10,
    "totalElements": 2,
    "totalPages": 1
}
	 * </pre>
	 */
	@GET
	@Path(RestAPIConstants.OPERATION_TYPE_QUERY + "/list/page/{page}/{size}")
	Page<UserEntity> findUsersWithPageParam(@PathParam("page")int page, @PathParam("size")int size);
	
	/**
	 * 查找所有的用户，返回
	 * @param pageable
	 * @return Page<UserEntity>			返回带分页信息的Page对象，通过page.getContent获取结果集<br/>
	 * page json示例
	 * <pre/>
	 *  {
    "content": [
        {
            "createDate": 1468503190000,
            "email": "update1@gmail.com",
            "lastLoginDate": 1468503190000,
            "modifyDate": 1468503190000,
            "openId": "1234",
            "password": "1234",
            "phone": "123456789",
            "rolename": "admin",
            "userId": "402881e755e99c620155e99c68400000",
            "userName": "mac"
        },
        {
            "createDate": 1468844905000,
            "email": "ss@aa.com",
            "lastLoginDate": 1468844905000,
            "modifyDate": 1468844905000,
            "openId": "1234",
            "password": "1234",
            "phone": "123456789",
            "rolename": "admin",
            "userId": "402881e755fdfa890155fdfa90510000",
            "userName": "mac1"
        }
    ],
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 2,
    "size": 10,
    "totalElements": 2,
    "totalPages": 1
}
	 * </pre>
	 */
	@GET
	@Path(RestAPIConstants.OPERATION_TYPE_QUERY + "/list/all")
	Page<UserEntity> findAllUsers();
	
	
}

/*
 * 修改历史
 * $Log$ 
 */