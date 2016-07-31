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


package com.showmecoo.web.management.api.service;

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

import com.showmecoo.web.commons.bo.CompereModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;
import com.showmecoo.web.commons.util.JsonablePageImpl;

/**
 * 主持人管理 对外REST接口
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(value=RestAPIConstants.API_VERSION + RestAPIConstants.URI_MODULE_ACTORS)
public interface ICompereManagerService {
	
	/**
	 * 新增主持人, 如果actor表没有纪录，则先新增actor表，生成actorid后再insert actor_compere表<br/>
	 * e.g uri: http://host:port/1/actors/c/compere
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@POST
	@Path(value=RestAPIConstants.OPERATION_TYPE_CREATE + RestAPIConstants.OPTION_ACTOR_COMPERE)
	CompereModel createCompereModel(CompereModel bo) throws Throwable;
	
	/**
	 * 更新主持人信息<br/>
	 * e.g uri: http://host:port/1/actors/u/compere
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@PUT
	@Path(value=RestAPIConstants.OPERATION_TYPE_UPDATE + RestAPIConstants.OPTION_ACTOR_COMPERE)
	CompereModel updateCompereModel(CompereModel bo) throws Throwable;
	
	/**
	 * 删除主持人，根据ID删除，同时删除actor表和actor_compere表中相同ID的纪录<br/>
	 * @param compereId
	 * @throws Throwable
	 */
	@DELETE
	@Path(value=RestAPIConstants.OPERATION_TYPE_DELETE + RestAPIConstants.OPTION_ACTOR_COMPERE)
	void deleteCompereModel(String compereId) throws Throwable;
	
	
	/**
	 * 根据ID查询主持人信息<br/>
	 * e.g uri: http://host:port/1/actors/q/compere/i/123
	 * @param compereId
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_COMPERE + RestAPIConstants.QUERY_PARAM_ID + "/{compereId}")
	CompereModel findCompereById(@PathParam("compereId")String compereId) throws Throwable;
	
	
	/**
	 * 根据名字查询主持人信息，返回相同名字的主持人集合, 如果想查询唯一的主持人，请使用根据艺名（nickName）或Id的方式查询<br/>
	 * e.g uri: http://host:port/1/actors/q/compere/n/lilly
	 * 
	 * @param CompereName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_COMPERE + RestAPIConstants.QUERY_PARAM_NAME + "/{compereName}")
	List<CompereModel> findCompereByName(@PathParam("compereName")String CompereName) throws Throwable;
	
	/**
	 * 根据艺名查询主持人信息<br/>
	 * e.g uri: http://host:port/1/actors/q/compere/n/nick/花花
	 * 
	 * @param nickName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_COMPERE + RestAPIConstants.QUERY_PARAM_NAME + "/nick/{nickName}")
	CompereModel findCompereByNickName(@PathParam("nickName")String nickName) throws Throwable;
	
	/**
	 * 查询所有的主持人信息，返回带分页信息的JsonablePageImpl对象的json串<br/>
	 * e.g uri: http://host:port/1/actors/q/compere/all
	 * 
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_COMPERE + RestAPIConstants.QUERY_PARAM_ALL)
	JsonablePageImpl<CompereModel> findAllComperes() throws Throwable;
	
	
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_COMPERE + RestAPIConstants.QUERY_PARAM_LIST + "/{page}/{size}")
	JsonablePageImpl<CompereModel> findComperesWithPage(@PathParam("page")int page, @PathParam("size")int size) throws Throwable;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */