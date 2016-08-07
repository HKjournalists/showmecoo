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
 * Created on 2016年8月4日
 *******************************************************************************/


package com.showmecoo.web.management.api.service;

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

import com.showmecoo.web.commons.bo.VideoWorkModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;
import com.showmecoo.web.commons.util.JsonablePageImpl;

/**
 * 艺人视频作品对外提供rest api 接口
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
@Path(value=RestAPIConstants.API_VERSION + RestAPIConstants.URI_MODULE_WORKS)
public interface IVideoWorkManagerService {
	
	/**
	 * 新增艺人作品<br/>
	 * e.g uri: http://host:port/1/works/c/video
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@POST
	@Path(value=RestAPIConstants.OPERATION_TYPE_CREATE + RestAPIConstants.OPTION_WORK_VIDEO)
	VideoWorkModel createVideoWorkModel(VideoWorkModel bo) throws Throwable;
	
	/**
	 * 更新艺人作品<br/>
	 * e.g uri: http://host:port/1/works/video
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@PUT
	@Path(value=RestAPIConstants.OPERATION_TYPE_UPDATE + RestAPIConstants.OPTION_WORK_VIDEO)
	VideoWorkModel updateVideoWorkModel(VideoWorkModel bo) throws Throwable;
	
	
	/**
	 * 根据ID删除图片作品<br/>
	 * e.g uri: http://host:port/1/works/d/video/123
	 * @param videoId
	 * @throws Throwable
	 */
	@DELETE
	@Path(value=RestAPIConstants.OPERATION_TYPE_DELETE + RestAPIConstants.OPTION_WORK_VIDEO + "/{videoId}")
	void deleteVideoWorkModelById(@PathParam("videoId")String videoId) throws Throwable;
	
	/**
	 * 根据ID查询图片作品信息<br/>
	 * e.g uri: http://host:port/1/works/q/video/i/123
	 * @param videoId
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_WORK_VIDEO + RestAPIConstants.QUERY_PARAM_ID + "/{videoId}")
	VideoWorkModel findPictureWorkById(@PathParam("videoId")String videoId) throws Throwable;
	
	/**
	 * 根据图片作品名称查询作品信息<br/>
	 * e.g uri: http://host:port/1/works/q/video/n/世纪年会
	 * @param workName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_WORK_VIDEO + RestAPIConstants.QUERY_PARAM_NAME + "/{workName}")
	VideoWorkModel findPictureWorkByName(@PathParam("workName")String workName) throws Throwable;
	
	/**
	 * 查询所有的图片作品信息, 返回带分页信息的JsonablePageImpl的json串，默认每页10条纪录<br/>
	 * e.g uri: http://host:port/1/works/q/video/all
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_WORK_VIDEO + RestAPIConstants.QUERY_PARAM_ALL)
	JsonablePageImpl<VideoWorkModel> findAllPictureWorks() throws Throwable;
	
	/**
	 * 查询部分图片作品信息，根据指定的分页信息查询<br/>
	 * e.g uri: http://host:port/1/works/q/video/list/10/20
	 * @param page
	 * @param size
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_WORK_VIDEO + RestAPIConstants.QUERY_PARAM_LIST + "/{page}/{size}")
	JsonablePageImpl<VideoWorkModel> findPictureWorksWithPage(@PathParam("page")int page, @PathParam("size")int size) throws Throwable;
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */