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

import java.util.ArrayList;
import java.util.List;

import com.showmecoo.web.commons.bo.RoleModel;
import com.showmecoo.web.commons.bo.UserModel;
import com.showmecoo.web.commons.bo.WechatUserModel;
import com.showmecoo.web.management.entity.RoleEntity;
import com.showmecoo.web.management.entity.UserEntity;
import com.showmecoo.web.management.entity.WechatUserEntity;

/**
 * user common utils
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class PoBoTransUtil {
	
	/**
	 * 网页用户，业务层对象转为持久层对象
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static UserEntity userB2P(UserModel bo) throws IllegalAccessException{
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
	
	/**
	 * 网页用户，持久层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException
	 */
	public static UserModel userP2B(UserEntity po) throws IllegalAccessException{
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
	
	
	/**
	 * 微信用户,业务层对象转为持久层对象
	 * @param bo		微信用户业务层对象
	 * @return
	 * @throws IllegalAccessException 
	 */
	public static WechatUserEntity wechatB2P(WechatUserModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("wechat user object can not be null");
		}
		WechatUserEntity po = new WechatUserEntity();
		po.setCity(bo.getCity());
		po.setCountry(bo.getCountry());
		po.setGroupId(bo.getGroupId());
		po.setHeadimgurl(bo.getHeadimgurl());
		po.setLanguage(bo.getLanguage());
		po.setNickName(bo.getNickName());
		po.setOpenId(bo.getOpenId());
		po.setProvince(bo.getProvince());
		po.setRemark(bo.getRemark());
		po.setSex(bo.getSex());
		po.setSubscribeTime(bo.getSubscribeTime());
		po.setUnionid(bo.getUnionid());
		po.setUserId(bo.getUserId());
		
		return po;
		
	}
	
	
	/**
	 * 微信用户,持久层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException 
	 */
	public static WechatUserModel wechatP2B(WechatUserEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("wechat user object can not be null");
		}
		WechatUserModel bo = new WechatUserModel();
		po.setCity(bo.getCity());
		po.setCountry(bo.getCountry());
		po.setGroupId(bo.getGroupId());
		po.setHeadimgurl(bo.getHeadimgurl());
		po.setLanguage(bo.getLanguage());
		po.setNickName(bo.getNickName());
		po.setOpenId(bo.getOpenId());
		po.setProvince(bo.getProvince());
		po.setRemark(bo.getRemark());
		po.setSex(bo.getSex());
		po.setSubscribeTime(bo.getSubscribeTime());
		po.setUnionid(bo.getUnionid());
		po.setUserId(bo.getUserId());
		
		return bo;
	}
	
	/**
	 * 用户对象实例，业务层对象批量转为持久层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<UserEntity> userListB2P(List<UserModel> boList) throws IllegalAccessException{
		List<UserEntity> poList = new ArrayList<>();
		for(UserModel bo : boList){
			poList.add(userB2P(bo));
		}
		
		return poList;
	}
	
	/**
	 * 用户实例，持久层对象批量转为业务层对象
	 * @param poList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<UserModel> userListP2B(List<UserEntity> poList) throws IllegalAccessException{
		List<UserModel> boList = new ArrayList<>();
		for(UserEntity po : poList){
			boList.add(userP2B(po));
		}
		return boList;
	}
	
	/**
	 * 微信用户实例，持久层对象批量转为持久层对象
	 * @param poList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<WechatUserModel> wechatListP2B(List<WechatUserEntity> poList) throws IllegalAccessException{
		List<WechatUserModel> boList = new ArrayList<WechatUserModel>();
		for(WechatUserEntity po:poList){
			boList.add(wechatP2B(po));
		}
		return boList;
	}
	
	/**
	 * 微信用户实例，业务层对象批量转为持久层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<WechatUserEntity> wechatListB2P(List<WechatUserModel> boList) throws IllegalAccessException{
		List<WechatUserEntity> poList = new ArrayList<>();
		for(WechatUserModel bo:boList){
			poList.add(wechatB2P(bo));
		}
		return poList;
	}
	
	
	/**
	 * 角色业务层对象转为持久层对象
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static RoleEntity roleB2P(RoleModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("role model object can not be null");
		}
		RoleEntity po = new RoleEntity();
		po.setCreateDate(bo.getCreateDate());
		po.setCreateUserId(bo.getCreateUserId());
		po.setModifyDate(bo.getModifyDate());
		po.setModifyUserId(bo.getModifyUserId());
		po.setRoleDesc(bo.getRoleDesc());
		po.setRoleId(bo.getRoleId());
		po.setRoleName(bo.getRoleName());
		
		return po;
	}
	
	/**
	 * 角色实例持久层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException
	 */
	public static RoleModel roleP2B(RoleEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("role entity model object can not be null");
		}
		RoleModel bo = new RoleModel();
		bo.setCreateDate(po.getCreateDate());
		bo.setCreateUserId(po.getCreateUserId());
		bo.setModifyDate(po.getModifyDate());
		bo.setModifyUserId(po.getModifyUserId());
		bo.setRoleDesc(po.getRoleDesc());
		bo.setRoleId(po.getRoleId());
		bo.setRoleName(po.getRoleName());
		
		return bo;
	}
	
	/**
	 * 角色实例持久层对象批量转为业务层对象
	 * @param poList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<RoleModel> roleListP2B(List<RoleEntity> poList) throws IllegalAccessException{
		if(null == poList){
			throw new IllegalAccessException("role entity model list can not be null");
		}
		List<RoleModel> boList = new ArrayList<>();
		for(RoleEntity po:poList){
			boList.add(roleP2B(po));
		}
		return boList;
	}
	
	/**
	 * 角色实例，业务层对象批量转为持久层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<RoleEntity> roleListB2P(List<RoleModel> boList) throws IllegalAccessException{
		if(null == boList){
			throw new IllegalAccessException("role business model list can not be null");
		}
		List<RoleEntity> poList = new ArrayList<>();
		for(RoleModel bo:boList){
			poList.add(roleB2P(bo));
		}
		return poList;
	}
	
	
	
	
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */