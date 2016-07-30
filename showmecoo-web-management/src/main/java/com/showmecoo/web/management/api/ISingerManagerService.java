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

import com.showmecoo.web.commons.bo.SingerModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;
import com.showmecoo.web.commons.util.JsonablePageImpl;

/**
 * 歌手管理，对外REST 接口
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(value=RestAPIConstants.API_VERSION + RestAPIConstants.URI_MODULE_ACTORS)
public interface ISingerManagerService {
	
	/**
	 * 新增歌手，如果actor表没有纪录，则先新增actor表，生成actorid后再insert actor_singer表<br/>
	 * e.g uri: http://host:port/1/actors/c/singer
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@POST
	@Path(value=RestAPIConstants.OPERATION_TYPE_CREATE + RestAPIConstants.OPTION_ACTOR_SINGER)
	SingerModel createSingerModel(SingerModel bo) throws Throwable;
	
	/**
	 * 更新歌手信息<br/>
	 * e.g uri: http://host:port/1/actors/u/singer
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@PUT
	@Path(value=RestAPIConstants.OPERATION_TYPE_UPDATE + RestAPIConstants.OPTION_ACTOR_SINGER)
	SingerModel updateSingerModel(SingerModel bo) throws Throwable;
	
	/**
	 * 根据ID删除歌手信息<br/>
	 * e.g uri: http://host:port/1/actors/d/singer/123
	 * @param singerId
	 * @throws Throwable
	 */
	@DELETE
	@Path(value=RestAPIConstants.OPERATION_TYPE_DELETE + RestAPIConstants.OPTION_ACTOR_SINGER + "/{singerId}")
	void deleteSingerModel(@PathParam("singerId")String singerId) throws Throwable;
	
	/**
	 * 根据歌手Id查询歌手信息<br/>
	 * e.g uri: http://host:port/1/actors/q/singer/i/123
	 * @param singerId
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_SINGER + RestAPIConstants.QUERY_PARAM_ID + "/{singerId}")
	SingerModel findSingerById(@PathParam("singerId")String singerId) throws Throwable;
	
	/**
	 * 根据名字查询歌手，返回相同名字的歌手集合, 如果想查询唯一的歌手，请使用根据艺名（nickName）或Id的方式查询<br/>
	 * e.g uri: http://host:port/1/actors/q/singer/n/marry
	 * @param singerName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_SINGER + RestAPIConstants.QUERY_PARAM_NAME + "/{singerName}")
	List<SingerModel> findSingerModelByName(@PathParam("singerName")String singerName) throws Throwable;
	
	/**
	 * 根据艺名查询歌手信息<br/>
	 * e.g  uri: http://host:port/1/actors/q/singer/n/nick/小明
	 * @param nickName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_SINGER + RestAPIConstants.QUERY_PARAM_NAME + "/nick/{nickName}")
	SingerModel findSingerByNickName(String nickName) throws Throwable;
	
	
	/**
	 * 查询所有的歌手信息，返回带分页信息的JsonablePageImpl对象的json串, 默认是每页10条纪录<br/>
	 * e.g uri: http://host:port/1/actors/q/singer/all
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_SINGER + RestAPIConstants.QUERY_PARAM_ALL)
	JsonablePageImpl<SingerModel> findAllSingers() throws Throwable;
	
	/**
	 * 查询部分歌手信息，返回指定页的歌手信息<br/>
	 * e.g http://host:port/1/actors/q/singer/list/2/15
	 * @param page
	 * @param size
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_ACTOR_SINGER + RestAPIConstants.QUERY_PARAM_LIST + "/{page}/{size}")
	JsonablePageImpl<SingerModel> findSingerWithPage(int page, int size) throws Throwable;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */