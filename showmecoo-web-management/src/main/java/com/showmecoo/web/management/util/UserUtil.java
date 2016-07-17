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
 * Created on 2016年7月16日
 *******************************************************************************/


package com.showmecoo.web.management.util;

import com.showmecoo.web.commons.bo.UserModel;
import com.showmecoo.web.management.user.entity.UserEntity;

/**
 * user common utils
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class UserUtil {
	
	public static UserEntity b2p(UserModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("user object can not be null");
		}
		
		UserEntity po = new UserEntity();
		po.setUserId(bo.getUserId());
		po.setUserName(bo.getUserName());
		po.setPassword(bo.getPassword());
		po.setPhone(bo.getPhone());
		po.setEmail(bo.getEmail());
		po.setRolename(bo.getRolename());
		po.setOpenId(bo.getOpenId());
		po.setCreateDate(bo.getCreateDate());
		po.setLastLoginDate(bo.getLastLoginDate());
		po.setModifyDate(bo.getModifyDate());
		
		return po;
	}
	
	
	public static UserModel p2b(UserEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("user object can not be null");
		}
		
		UserModel bo = new UserModel();
		bo.setUserId(po.getUserId());
		bo.setUserName(po.getUserName());
		bo.setPassword(po.getPassword());
		bo.setPhone(po.getPhone());
		bo.setEmail(po.getEmail());
		bo.setRolename(po.getRolename());
		bo.setOpenId(po.getOpenId());
		bo.setCreateDate(po.getCreateDate());
		bo.setLastLoginDate(po.getLastLoginDate());
		bo.setModifyDate(po.getModifyDate());
		
		return bo;
	}
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */