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


package com.showmecoo.web.management.user.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showmecoo.web.commons.bo.UserModel;
import com.showmecoo.web.management.user.api.IUserManagerService;
import com.showmecoo.web.management.user.entity.UserEntity;
import com.showmecoo.web.management.user.spi.UserRepository;
import com.showmecoo.web.management.user.util.UserUtil;

/**
 * 用户管理模块对外提供的rest service 实现类，返回json格式的返回值
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Service
public class UserManagerServiceImpl implements IUserManagerService{
	
	Logger log = LoggerFactory.getLogger(UserManagerServiceImpl.class);
	
//	@Resource
//	@Qualifier("userRepository")此类定义用于dao有多个实现类的情况
	@Autowired
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.spi.IUserManagerService#findUserByName(java.lang.String)
	 */
	@Override
	public UserEntity findUserByName(String userName) {
		log.debug("call findUserByName restful api, userName:{}", userName);
		UserEntity user = userRepository.findUserByName(userName);
		return user;
	}
	
	@Override
	public UserEntity createUserEntity(UserModel bo) {
		UserEntity po = null;
		if(null != bo){
			try {
				po = UserUtil.b2p(bo);
			} catch (IllegalAccessException e) {
				log.error("bo 2 po error, bo:{}", bo, e);
			}
		}
		log.debug("call create user restful api, user:{}", bo.toString());
		
		return userRepository.createUser(po);
	}
	
	@Override
	public UserEntity updateUserEntity(UserModel bo) {
		UserEntity po = null;
		if(null != bo){
			try {
				po = UserUtil.b2p(bo);
			} catch (IllegalAccessException e) {
				log.error("bo 2 po error, bo:{}", bo, e);
			}
		}
		log.debug("call update user restful api, user:{}", bo.toString());
		try {
			po = userRepository.updateUser(po);
		} catch (IllegalAccessException e) {
			log.error("update po failed, po:{}", po, e);
		}
		
		return po;
	}
	
	
	@Override
	public boolean deleteUserEntity(String userId) {
		log.debug("call delete user restful api, userid:{}", userId);
		boolean flag = false;
		try {
			 flag = userRepository.deleteUserEntity(userId);
		} catch (Throwable e) {
			log.error("delete user error, userid:{}", userId, e);
		}
		return flag;
	}
	
	
	@Override
	public UserEntity findUserById(String userId) {
		log.debug("call findUserById restful api, userid:{}", userId);
		return userRepository.findUserById(userId);
	}
	@Override
	public int countUsers() {
		log.debug("call countUsers restful api");
		return userRepository.countUsers();
	}


	
	

}

/*
 * 修改历史
 * $Log$ 
 */