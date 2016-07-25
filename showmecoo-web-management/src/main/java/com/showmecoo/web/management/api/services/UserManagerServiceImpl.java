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
import com.showmecoo.web.commons.bo.WechatUserModel;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.api.IUserManagerService;
import com.showmecoo.web.management.entity.UserEntity;
import com.showmecoo.web.management.entity.WechatUserEntity;
import com.showmecoo.web.management.spi.dao.UserRepository;
import com.showmecoo.web.management.spi.dao.WechatRepository;
import com.showmecoo.web.management.util.PoBoTransUtil;

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
	
	@Autowired
	private WechatRepository wechatUserRepository;
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.spi.IUserManagerService#findUserByName(java.lang.String)
	 */
	@Override
	public UserModel findUserByName(String userName) throws Throwable {
		log.debug("call findUserByName restful api, userName:{}", userName);
		UserEntity po = userRepository.findUserByName(userName);
		return PoBoTransUtil.userP2B(po);
	}
	
	@Override
	public UserModel createUserModel(UserModel bo) throws Throwable {
		UserEntity po = null;
		if(null != bo){
				po = PoBoTransUtil.userB2P(bo);
		}
		log.debug("call create user restful api, user:{}", bo.toString());
		return PoBoTransUtil.userP2B(userRepository.save(po));
	}
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IUserManagerService#createWechatUserModel(com.showmecoo.web.commons.bo.WechatUserModel)
	 */
	@Override
	public WechatUserModel createWechatUserModel(WechatUserModel wechatBo) throws Throwable {
		WechatUserEntity po = null;
		if(null != wechatBo){
			po = PoBoTransUtil.wechatB2P(wechatBo);
		}
		log.debug("cal create wechat user restful api, wechatUser:{}", wechatBo);
		return PoBoTransUtil.wechatP2B(wechatUserRepository.save(po));
	}
	
	@Override
	public UserModel updateUserModel(UserModel bo) throws Throwable {
		UserEntity po = null;
		if(null != bo){
			po = PoBoTransUtil.userB2P(bo);
		}
		log.debug("call update user restful api, user:{}", bo.toString());
		
		return PoBoTransUtil.userP2B(userRepository.save(po));
	}
	
	

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IUserManagerService#updateWechatUserModel(com.showmecoo.web.commons.bo.WechatUserModel)
	 */
	@Override
	public WechatUserModel updateWechatUserModel(WechatUserModel wechatBo) throws Throwable {
		WechatUserEntity po = new WechatUserEntity();
		if(null != wechatBo){
			po = PoBoTransUtil.wechatB2P(wechatBo);
		}
		
		return PoBoTransUtil.wechatP2B(wechatUserRepository.save(po));
	}

	
	@Override
	public void deleteUserModel(String userId) throws Throwable {
		log.debug("call delete user restful api, userid:{}", userId);
		userRepository.delete(userId);
	}
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IUserManagerService#deleteWechatUserModel(java.lang.String)
	 */
	@Override
	public void deleteWechatUserModel(String openid) throws Throwable {
		log.debug("call delete wechat user restful api, openid:{}" , openid);
		wechatUserRepository.delete(openid);
	}
	
	
	@Override
	public UserModel findUserById(String userId) throws Throwable {
		log.debug("call findUserById restful api, userid:{}", userId);
		return PoBoTransUtil.userP2B(userRepository.findOne(userId));
	}
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IUserManagerService#findWechatUserModelByOpenid(java.lang.String)
	 */
	@Override
	public WechatUserModel findWechatUserModelByOpenid(String openid) throws Throwable {
		log.debug("call findWechatUserModelByOpenid restful api, openid:{}", openid);
		return PoBoTransUtil.wechatP2B(wechatUserRepository.findOne(openid));
	}
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IUserManagerService#findWechatUserModelByUserid(java.lang.String)
	 */
	@Override
	public WechatUserModel findWechatUserModelByUserid(String userId) throws Throwable {
		log.debug("call findWechatUserModelByUserid restful api, userid:{}", userId);
		return PoBoTransUtil.wechatP2B(wechatUserRepository.findWechatUserByUserId(userId));
	}
	
	
	@Override
	public long countUsers() {
		log.debug("call countUsers restful api");
		return userRepository.count();
	}
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IUserManagerService#countWechatUsers()
	 */
	@Override
	public long countWechatUsers() {
		log.debug("call countWechatUsers restful api");
		return wechatUserRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.api.IUserManagerService#findUsersWithPageParam(int, int)
	 */
	@Override
	public JsonablePageImpl<UserModel> findUsersWithPageParam(int page, int size) throws Throwable {
		log.debug("call findUsersWithPageParam restful api, page:{}, size:{}", page, size);
		PageRequest pageable = new PageRequest(page, size);
		Page<UserEntity> poPage = userRepository.findAll(pageable);
		
		JsonablePageImpl<UserModel> jsonablePage = new JsonablePageImpl<>();
		jsonablePage.setContent(PoBoTransUtil.userListP2B(poPage.getContent()));
		jsonablePage.setFirst(poPage.isFirst());
		jsonablePage.setLast(poPage.isLast());
		jsonablePage.setNumber(poPage.getNumber());
		jsonablePage.setNumberOfElements(poPage.getNumberOfElements());
		jsonablePage.setSize(poPage.getSize());
		jsonablePage.setTotalElements(poPage.getTotalElements());
		jsonablePage.setTotalPages(poPage.getTotalPages());
		
		return jsonablePage;
	}
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IUserManagerService#findWechatUsersWithPageParam(int, int)
	 */
	@Override
	public JsonablePageImpl<WechatUserModel> findWechatUsersWithPageParam(int page, int size) throws Throwable {
		log.debug("call findWechatUsersWithPageParam restful api, page:{}, size:{}", page, size);
		PageRequest pageable = new PageRequest(page, size);
		Page<WechatUserEntity> poPage = wechatUserRepository.findAll(pageable);
		
		JsonablePageImpl<WechatUserModel> jsonablePage = new JsonablePageImpl<>();
		jsonablePage.setContent(PoBoTransUtil.wechatListP2B(poPage.getContent()));
		jsonablePage.setFirst(poPage.isFirst());
		jsonablePage.setLast(poPage.isLast());
		jsonablePage.setNumber(poPage.getNumber());
		jsonablePage.setNumberOfElements(poPage.getNumberOfElements());
		jsonablePage.setSize(poPage.getSize());
		jsonablePage.setTotalElements(poPage.getTotalElements());
		jsonablePage.setTotalPages(poPage.getTotalPages());
		
		return jsonablePage;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.user.api.IUserManagerService#findAllUsers(org.springframework.data.domain.Pageable)
	 */
	@Override
	public JsonablePageImpl<UserModel> findAllUsers() throws Throwable{
		log.debug("call findAllUsers restful api");
		Pageable pageable = new PageRequest(0, 10);
		Page<UserEntity> poPage = userRepository.findAll(pageable);
		
		JsonablePageImpl<UserModel> jsonablePage = new JsonablePageImpl<>();
		jsonablePage.setContent(PoBoTransUtil.userListP2B(poPage.getContent()));
		jsonablePage.setFirst(poPage.isFirst());
		jsonablePage.setLast(poPage.isLast());
		jsonablePage.setNumber(poPage.getNumber());
		jsonablePage.setNumberOfElements(poPage.getNumberOfElements());
		jsonablePage.setSize(poPage.getSize());
		jsonablePage.setTotalElements(poPage.getTotalElements());
		jsonablePage.setTotalPages(poPage.getTotalPages());
		
		return jsonablePage;
	}

	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IUserManagerService#findAllWechatUsers()
	 */
	@Override
	public JsonablePageImpl<WechatUserModel> findAllWechatUsers() throws Throwable {
		log.debug("call findAllWechatUsers restful api");
		PageRequest pageable = new PageRequest(0, 10);
		Page<WechatUserEntity> poPage = wechatUserRepository.findAll(pageable);
//		PageImpl<WechatUserModel> boPage = new PageImpl<>(PoBoTransUtil.wechatListP2B(poPage.getContent()), pageable, poPage.getTotalElements());
		
		JsonablePageImpl<WechatUserModel> jsonablePage = new JsonablePageImpl<>();
		jsonablePage.setContent(PoBoTransUtil.wechatListP2B(poPage.getContent()));
		jsonablePage.setFirst(poPage.isFirst());
		jsonablePage.setLast(poPage.isLast());
		jsonablePage.setNumber(poPage.getNumber());
		jsonablePage.setNumberOfElements(poPage.getNumberOfElements());
		jsonablePage.setSize(poPage.getSize());
		jsonablePage.setTotalElements(poPage.getTotalElements());
		jsonablePage.setTotalPages(poPage.getTotalPages());
		
		return jsonablePage;
	}


	
	
	

}

/*
 * 修改历史
 * $Log$ 
 */