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
 * Created on 2016年7月7日
 *******************************************************************************/


package com.showmecoo.web.management.user.spi;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.PathParam;

import com.showmecoo.web.management.user.entity.UserEntity;

/**
 * 用户管理DAO接口
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Transactional
public interface UserRepository{
	
	/**
	 * 新增用户，返回带useId信息的UserEntity对象
	 * @param user
	 * @return
	 */
	public UserEntity createUser(UserEntity user);
	
	
	/**
	 * 更新用户，返回跟新后的UserEntity对象
	 * @param user
	 * @return
	 */
	public UserEntity updateUser(UserEntity user) throws IllegalAccessException;
	
	/**
	 * 根据userid删除UserEntity
	 * @param userId
	 * @return
	 * @throws Throwable
	 */
	public boolean deleteUserEntity(String userId) throws Throwable;
	
	
	/**
	 * 根据用户名查找用户，适用于用户注册场景，页面搜索艺人场景
	 * @param userName		用户名
	 * @return	UserEntity	用户对象		
	 */
	public UserEntity findUserByName(@PathParam("userName")String userName);
	
	
	
	
	/**
	 * 根据用户ID查找用户，适用于修改用户场景
	 * @param userId
	 * @return		返回userEntity 的json串
	 */
	public UserEntity findUserById(String userId);
	
	/**
	 * 查找所有的用户对象
	 * @return		返回userEntity list 的json串
	 */
	public List<UserEntity> findAllUsers();
	
	public List<UserEntity> findUsersWithPage();
	
	/**
	 * 统计总用户数
	 * @return	
	 */
	public int countUsers();
	
	
}

/*
 * 修改历史
 * $Log$ 
 */