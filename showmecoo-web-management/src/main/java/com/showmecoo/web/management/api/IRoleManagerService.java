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


package com.showmecoo.web.management.api;

import java.util.List;

import javax.persistence.GeneratedValue;
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

import com.showmecoo.web.commons.bo.RoleModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;

/**
 * 角色管理对外接口
 *
 *restful api standard
 * http://ip:port/api_version/module/operation(create/update/delete/query)/options...(list/id/name...)/parameter
 * uri:http://ip:port//一级模块/操作/可选标识/参数
 * 
 * 
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(RestAPIConstants.API_VERSION + RestAPIConstants.URI_MODULE_ROLES)
public interface IRoleManagerService {
	
	/**
	 * 新增角色
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@POST
	@Path(value=RestAPIConstants.OPERATION_TYPE_CREATE)
	RoleModel createRole(RoleModel bo) throws Throwable;
	
	/**
	 * 根据角色ID删除角色
	 * @param roleId
	 * @throws Throwable
	 */
	@DELETE
	@Path(value=RestAPIConstants.OPERATION_TYPE_DELETE + "/{roleid}")
	void deleteRole(@PathParam("roleid") int roleId) throws Throwable;
	
	/**
	 * 更新角色信息
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@PUT
	@Path(value=RestAPIConstants.OPERATION_TYPE_UPDATE)
	RoleModel updateRole(RoleModel bo) throws Throwable;
	
	/**
	 * 根据角色ID查询角色信息
	 * @param roleId
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.PARAM_QUERY_ID +"/{roleid}" )
	RoleModel findRoleById(@PathParam("{roleid}") String roleId) throws Throwable;
	
	/**
	 * 根据角色名字查询角色信息
	 * @param roleName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.PARAM_QUERY_NAME + "/{rolename}")
	RoleModel findRoleByName(@PathParam("rolename") String roleName) throws Throwable;
	
	/**
	 * 查询所有的角色信息纪录，返回带分页信息的Page对象，默认是每页10条纪录，从第0叶开始
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.PARAM_QUERY_ALL)
	Page<RoleModel> findAllRoles() throws Throwable;
	
	/**
	 * 带分页查询角色纪录信息，可以指定从第几页查询，每页纪录条数， 返回带分页信息的Page对象
	 * @param page				从第几页查询
	 * @param size				每页条数
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.PARAM_QUERY_ALL + "/{page}/{size}")
	Page<RoleModel> findRolesWithPageable(@PathParam("page") int page, @PathParam("size") int size) throws Throwable;
}

/*
 * 修改历史
 * $Log$ 
 */