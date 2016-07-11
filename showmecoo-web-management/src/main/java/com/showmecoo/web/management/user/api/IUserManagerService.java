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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.showmecoo.web.management.user.entity.UserEntity;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Component
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public interface IUserManagerService {
	
	@GET
	@Path("/{userName}")
	UserEntity findUserByName(@PathParam("userName")String userName);
	
}

/*
 * 修改历史
 * $Log$ 
 */