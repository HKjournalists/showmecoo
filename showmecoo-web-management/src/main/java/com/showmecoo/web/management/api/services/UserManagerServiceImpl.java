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


package com.showmecoo.web.management.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.showmecoo.web.commons.bo.UserModel;
import com.showmecoo.web.management.api.IUserManagerService;
import com.showmecoo.web.management.entity.UserEntity;
import com.showmecoo.web.management.spi.dao.UserRepository;
import com.showmecoo.web.management.util.UserUtil;

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
		return userRepository.save(po);
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
		po = userRepository.save(po);
		return po;
	}
	
	
	@Override
	public void deleteUserEntity(String userId) {
		log.debug("call delete user restful api, userid:{}", userId);
		try {
			 userRepository.delete(userId);
		} catch (Throwable e) {
			log.error("delete user error, userid:{}", userId, e);
		}
	}
	
	
	@Override
	public UserEntity findUserById(String userId) {
		log.debug("call findUserById restful api, userid:{}", userId);
		return userRepository.findOne(userId);
	}
	@Override
	public long countUsers() {
		log.debug("call countUsers restful api");
		return userRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.api.IUserManagerService#findUsersWithPageParam(int, int)
	 */
	@Override
	public Page<UserEntity> findUsersWithPageParam(int page, int size) {
		log.debug("call findUsersWithPageParam restful api, page:{}, size:{}", page, size);
		PageRequest pageable = new PageRequest(page, size);
		
		return userRepository.findAll(pageable);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.api.IUserManagerService#findAllUsers(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<UserEntity> findAllUsers() {
		log.debug("call findAllUsers restful api");
		Pageable pageable = new PageRequest(0, 10);
		return userRepository.findAll(pageable);
	}


	
	
	

}

/*
 * 修改历史
 * $Log$ 
 */