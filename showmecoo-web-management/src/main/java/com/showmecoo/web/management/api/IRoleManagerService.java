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

import com.showmecoo.web.commons.bo.RoleModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;
import com.showmecoo.web.commons.util.JsonablePageImpl;

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
	RoleModel findRoleById(@PathParam("roleid") int roleId) throws Throwable;
	
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
	 * 
	 * @return					返回JsonablePageImpl，该对象可以方便的以json格式序列化和反序列化
	 * @throws Throwable
	 * <br/>
	 * JsonablePageImpl 序列化和反序列化方式
	 * <pre>
	 * 序列化：<br/>
	 * JsonablePageImpl<RoleModel> p = new JsonablePageImpl<>();
		List<RoleModel> list = new ArrayList<>();
		RoleModel role = new RoleModel();
		role.setCreateDate(new Date());
		role.setCreateUserId("123");
		role.setModifyDate(new Date());
		role.setModifyUserId("23");
		role.setRoleDesc("user");
		role.setRoleId(231);
		role.setRoleName("role");
		list.add(role);
		p.setContent(list);
		String jstr = FastJsonUtil.Object2String(p);
	 * </pre>
	 * <pre>
	 * 反序列化：<br/>
	 * JsonablePageImpl<RoleModel> np = FastJsonUtil.string2Object(jstr, JsonablePageImpl.class);
	 * List nlist = np.getContent();
	 * 
	 * List<RoleModel> content = new ArrayList<>();
	 * for(int i=0; i &lt nlist.size(); i++){ 
	 *	JSONObject s = (JSONObject) nlist.get(i);
	 *	RoleModel r = FastJsonUtil.jsonObj2JavaObject(s, RoleModel.class);
	 *	content.add(r);
	 * }
	 * np.setContent(content);
	 * </pre>
	 * 
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.PARAM_QUERY_ALL)
	JsonablePageImpl<RoleModel> findAllRoles() throws Throwable;
	
	/**
	 * 带分页查询角色纪录信息，可以指定从第几页查询，每页纪录条数， 返回带分页信息的Page对象
	 * @param page				从第几页查询
	 * @param size				每页条数
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.PARAM_QUERY_ALL + "/{page}/{size}")
	JsonablePageImpl<RoleModel> findRolesWithPageable(@PathParam("page") int page, @PathParam("size") int size) throws Throwable;
}

/*
 * 修改历史
 * $Log$ 
 */