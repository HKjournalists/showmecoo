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

import com.showmecoo.web.commons.bo.UserModel;
import com.showmecoo.web.commons.bo.WechatUserModel;
import com.showmecoo.web.management.entity.UserEntity;
import com.showmecoo.web.management.entity.WechatUserEntity;

/**
 * user common utils
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class UserUtil {
	
	/**
	 * 网页用户，业务层对象转为持久层对象
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
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
	
	/**
	 * 网页用户，持久层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException
	 */
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
	
	public static List<UserEntity> userListB2P(List<UserModel> boList) throws IllegalAccessException{
		List<UserEntity> poList = new ArrayList<>();
		for(UserModel bo : boList){
			poList.add(b2p(bo));
		}
		
		return poList;
	}
	
	public static List<UserModel> userListP2B(List<UserEntity> poList) throws IllegalAccessException{
		List<UserModel> boList = new ArrayList<>();
		for(UserEntity po : poList){
			boList.add(p2b(po));
		}
		return boList;
	}
	
	public static List<WechatUserModel> wecahtListP2B(List<WechatUserEntity> poList) throws IllegalAccessException{
		List<WechatUserModel> boList = new ArrayList<WechatUserModel>();
		for(WechatUserEntity po:poList){
			boList.add(wechatP2B(po));
		}
		return boList;
	}
	
	public static List<WechatUserEntity> wechatListB2P(List<WechatUserModel> boList) throws IllegalAccessException{
		List<WechatUserEntity> poList = new ArrayList<>();
		for(WechatUserModel bo:boList){
			poList.add(wechatB2P(bo));
		}
		return poList;
	}
	
}

/*
 * 修改历史
 * $Log$ 
 */