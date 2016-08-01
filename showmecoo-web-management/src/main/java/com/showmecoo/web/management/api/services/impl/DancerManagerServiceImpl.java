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
 * Created on 2016年7月31日
 *******************************************************************************/


package com.showmecoo.web.management.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.showmecoo.web.commons.bo.DancerModel;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.api.service.IDancerManagerService;
import com.showmecoo.web.management.entity.ActorEntity;
import com.showmecoo.web.management.entity.DancerEntity;
import com.showmecoo.web.management.spi.repository.ActorRepository;
import com.showmecoo.web.management.spi.repository.DancerRepository;
import com.showmecoo.web.management.util.ActorPoBoTransUtil;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Service
public class DancerManagerServiceImpl implements IDancerManagerService{
	
	private static Logger log = LoggerFactory.getLogger(DancerManagerServiceImpl.class);
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private DancerRepository dancerRepository;
	
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IDancerManagerService#createDancerModel(com.showmecoo.web.commons.bo.DancerModel)
	 */
	@Override
	public DancerModel createDancerModel(DancerModel bo) throws Throwable {

		ActorEntity actor = actorRepository.findActorEntityByNickName(bo.getNickName());
		if(null == actor){
			actor = new ActorEntity();
			actor.setAge(bo.getAge());
			actor.setCreateTime(bo.getCreateTime());
			actor.setDisplayedNum(bo.getDisplayedNum());
			actor.setFansNum(bo.getFansNum());
			actor.setHeight(bo.getHeight());
			actor.setImageName(bo.getImageName());
			actor.setName(bo.getName());
			actor.setNickName(bo.getNickName());
			actor.setSex(bo.getSex());
			actor.setType(bo.getType());
			actor.setVisitNum(bo.getVisitNum());
			actor = actorRepository.save(actor);
		}
		
		bo.setActorId(actor.getActorId());
		DancerEntity ret = dancerRepository.save(ActorPoBoTransUtil.dancerB2P(bo));
		return ActorPoBoTransUtil.dancerP2B(ret);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IDancerManagerService#updateDancerModel(com.showmecoo.web.commons.bo.DancerModel)
	 */
	@Override
	public DancerModel updateDancerModel(DancerModel bo) throws Throwable {
		DancerEntity po = dancerRepository.save(ActorPoBoTransUtil.dancerB2P(bo));
		return ActorPoBoTransUtil.dancerP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IDancerManagerService#deleteDancerModel(java.lang.String)
	 */
	@Override
	public void deleteDancerModel(String dancerId) throws Throwable {
		dancerRepository.delete(dancerId);
		actorRepository.delete(dancerId);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IDancerManagerService#findDancerById(java.lang.String)
	 */
	@Override
	public DancerModel findDancerById(String dancerid) throws Throwable {
		ActorEntity actor = actorRepository.findOne(dancerid);
		DancerEntity po = dancerRepository.findOne(dancerid);
		if(null == po){
			log.error("can not find dancer by id:{}", dancerid);
			return null;
		}
		
		DancerModel bo = ActorPoBoTransUtil.dancerP2B(po);
		ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IDancerManagerService#findDancerByName(java.lang.String)
	 */
	@Override
	public List<DancerModel> findDancerByName(String dancerName) throws Throwable {
		List<ActorEntity> list = actorRepository.findActorEntityByName(dancerName);
		if(null == list){
			log.error("can not find any dancer by name:{}", dancerName);
			return null;
		}
		List<DancerModel> boList = new ArrayList<>();
		for(ActorEntity actor:list){
			DancerEntity po = dancerRepository.findOne(actor.getActorId());
			boList.add(ActorPoBoTransUtil.dancerP2B(po));
		}
		return boList;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IDancerManagerService#findDancerByNickName(java.lang.String)
	 */
	@Override
	public DancerModel findDancerByNickName(String nickName) throws Throwable {
		ActorEntity actor = actorRepository.findActorEntityByNickName(nickName);
		if(null == actor){
			log.error("can not find dancer by nickName:{}", nickName);
			return null;
		}
		DancerEntity po = dancerRepository.findOne(actor.getActorId());
		
		return ActorPoBoTransUtil.dancerP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IDancerManagerService#findAllDancers()
	 */
	@Override
	public JsonablePageImpl<DancerModel> findAllDancers() throws Throwable {
		PageRequest pageable = new PageRequest(0, 10);
		Page<DancerEntity> poPage = dancerRepository.findAll(pageable);
		if(poPage.getContent() == null){
			log.info("can not find any actor");
			return null;
		}
		JsonablePageImpl<DancerModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(ActorPoBoTransUtil.dancerListP2B(poPage.getContent()));
		jsonAble.setFirst(poPage.isFirst());
		jsonAble.setLast(poPage.isLast());
		jsonAble.setNumber(poPage.getNumber());
		jsonAble.setNumberOfElements(poPage.getNumberOfElements());
		jsonAble.setSize(poPage.getSize());
		jsonAble.setTotalElements(poPage.getTotalElements());
		jsonAble.setTotalPages(poPage.getTotalPages());
		return jsonAble;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IDancerManagerService#findDancersWithPage(int, int)
	 */
	@Override
	public JsonablePageImpl<DancerModel> findDancersWithPage(int page, int size) throws Throwable {
		log.debug("call findDancersWithPage rest api ");
		PageRequest pageable = new PageRequest(page, size);
		Page<DancerEntity> poPage = dancerRepository.findAll(pageable);
		if(poPage.getContent() == null){
			log.info("can not find any actor");
			return null;
		}
		JsonablePageImpl<DancerModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(ActorPoBoTransUtil.dancerListP2B(poPage.getContent()));
		jsonAble.setFirst(poPage.isFirst());
		jsonAble.setLast(poPage.isLast());
		jsonAble.setNumber(poPage.getNumber());
		jsonAble.setNumberOfElements(poPage.getNumberOfElements());
		jsonAble.setSize(poPage.getSize());
		jsonAble.setTotalElements(poPage.getTotalElements());
		jsonAble.setTotalPages(poPage.getTotalPages());
		return jsonAble;
	}

}

/*
 * 修改历史
 * $Log$ 
 */