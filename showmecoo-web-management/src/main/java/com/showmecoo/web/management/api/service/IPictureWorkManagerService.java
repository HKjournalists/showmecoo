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

import com.showmecoo.web.commons.bo.PictureWorkModel;
import com.showmecoo.web.commons.constants.RestAPIConstants;
import com.showmecoo.web.commons.util.JsonablePageImpl;

/**
 * 
 *  艺人图片作品对外提供rest api 接口
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
public interface IPictureWorkManagerService {
	
	/**
	 * 新增艺人作品<br/>
	 * e.g uri: http://host:port/1/works/c/picture
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@POST
	@Path(value=RestAPIConstants.OPERATION_TYPE_CREATE + RestAPIConstants.OPTION_WORK_PICTURE)
	PictureWorkModel createPictureWorkModel(PictureWorkModel bo) throws Throwable;
	
	/**
	 * 更新艺人作品<br/>
	 * e.g uri: http://host:port/1/works/picture
	 * @param bo
	 * @return
	 * @throws Throwable
	 */
	@PUT
	@Path(value=RestAPIConstants.OPERATION_TYPE_UPDATE + RestAPIConstants.OPTION_WORK_PICTURE)
	PictureWorkModel updatePictureWorkModel(PictureWorkModel bo) throws Throwable;
	
	
	/**
	 * 根据ID删除图片作品<br/>
	 * e.g uri: http://host:port/1/works/d/picture/123
	 * @param workId
	 * @throws Throwable
	 */
	@DELETE
	@Path(value=RestAPIConstants.OPERATION_TYPE_DELETE + RestAPIConstants.OPTION_WORK_PICTURE + "/{workId}")
	void deletePictureWorkModelById(@PathParam("workId")String workId) throws Throwable;
	
	/**
	 * 根据ID查询图片作品信息<br/>
	 * e.g uri: http://host:port/1/works/q/picture/i/123
	 * @param pictureId
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_WORK_PICTURE + RestAPIConstants.QUERY_PARAM_ID + "/{pictureId}")
	PictureWorkModel findPictureWorkById(@PathParam("pictureId")String pictureId) throws Throwable;
	
	/**
	 * 根据图片作品名称查询作品信息<br/>
	 * e.g uri: http://host:port/1/works/q/picture/n/世纪年会
	 * @param workName
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_WORK_PICTURE + RestAPIConstants.QUERY_PARAM_NAME + "/{workName}")
	PictureWorkModel findPictureWorkByName(@PathParam("workName")String workName) throws Throwable;
	
	/**
	 * 查询所有的图片作品信息, 返回带分页信息的JsonablePageImpl的json串，默认每页10条纪录<br/>
	 * e.g uri: http://host:port/1/works/q/picture/all
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_WORK_PICTURE + RestAPIConstants.QUERY_PARAM_ALL)
	JsonablePageImpl<PictureWorkModel> findAllPictureWorks() throws Throwable;
	
	/**
	 * 查询部分图片作品信息，根据指定的分页信息查询<br/>
	 * e.g uri: http://host:port/1/works/q/picture/list/10/20
	 * @param page
	 * @param size
	 * @return
	 * @throws Throwable
	 */
	@GET
	@Path(value=RestAPIConstants.OPERATION_TYPE_QUERY + RestAPIConstants.OPTION_WORK_PICTURE + RestAPIConstants.QUERY_PARAM_LIST + "/{page}/{size}")
	JsonablePageImpl<PictureWorkModel> findPictureWorksWithPage(@PathParam("page")int page, @PathParam("size")int size) throws Throwable;
	
	
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */