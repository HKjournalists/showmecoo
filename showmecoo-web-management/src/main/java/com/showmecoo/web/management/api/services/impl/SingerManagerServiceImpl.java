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
 * Created on 2016年8月1日
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

import com.showmecoo.web.commons.bo.SingerModel;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.api.service.ISingerManagerService;
import com.showmecoo.web.management.entity.ActorEntity;
import com.showmecoo.web.management.entity.SingerEntity;
import com.showmecoo.web.management.spi.repository.ActorRepository;
import com.showmecoo.web.management.spi.repository.SingerRepository;
import com.showmecoo.web.management.util.ActorPoBoTransUtil;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Service
public class SingerManagerServiceImpl implements ISingerManagerService{
	
	private static Logger log = LoggerFactory.getLogger(SingerManagerServiceImpl.class);
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private SingerRepository singerRepository;
	
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ISingerManagerService#createSingerModel(com.showmecoo.web.commons.bo.SingerModel)
	 */
	@Override
	public SingerModel createSingerModel(SingerModel bo) throws Throwable {
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
		ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
		SingerEntity po = singerRepository.save(ActorPoBoTransUtil.singerB2P(bo));
		
		return ActorPoBoTransUtil.singerP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ISingerManagerService#updateSingerModel(com.showmecoo.web.commons.bo.SingerModel)
	 */
	@Override
	public SingerModel updateSingerModel(SingerModel bo) throws Throwable {
		SingerEntity po = singerRepository.save(ActorPoBoTransUtil.singerB2P(bo));

		return ActorPoBoTransUtil.singerP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ISingerManagerService#deleteSingerModel(java.lang.String)
	 */
	@Override
	public void deleteSingerModel(String singerId) throws Throwable {
		
		singerRepository.delete(singerId);
		actorRepository.delete(singerId);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ISingerManagerService#findSingerById(java.lang.String)
	 */
	@Override
	public SingerModel findSingerById(String singerId) throws Throwable {
		ActorEntity actor = actorRepository.findOne(singerId);
		if(null == actor){
			log.error("can not find singer by id, singerid:{}", singerId);
			return null;
		}
		SingerEntity po = singerRepository.findOne(singerId);
		SingerModel bo = ActorPoBoTransUtil.singerP2B(po);
		ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
		
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ISingerManagerService#findSingerModelByName(java.lang.String)
	 */
	@Override
	public List<SingerModel> findSingerModelByName(String singerName) throws Throwable {
		List<ActorEntity> list = actorRepository.findActorEntityByName(singerName);
		if(null == list){
			log.error("can not find any singer by singerName, name:{}", singerName);
			return null;
		}
		List<SingerModel> boList = new ArrayList<>();
		for(ActorEntity actor:list){
			SingerEntity po = singerRepository.findOne(actor.getActorId());
			SingerModel bo = ActorPoBoTransUtil.singerP2B(po);
			ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
			boList.add(bo);
		}
		return boList;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ISingerManagerService#findSingerByNickName(java.lang.String)
	 */
	@Override
	public SingerModel findSingerByNickName(String nickName) throws Throwable {
		ActorEntity actor = actorRepository.findActorEntityByNickName(nickName);
		SingerEntity po = singerRepository.findOne(actor.getActorId());
		SingerModel bo = ActorPoBoTransUtil.singerP2B(po);
		ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
		
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ISingerManagerService#findAllSingers()
	 */
	@Override
	public JsonablePageImpl<SingerModel> findAllSingers() throws Throwable {
		
		PageRequest pageable = new PageRequest(0, 10);
		Page<SingerEntity> poPage = singerRepository.findAll(pageable);
		List<SingerEntity> poList = poPage.getContent();
		if(poList == null){
			log.info("can not find any actor");
			return null;
		}
		List<SingerModel> boList = new ArrayList<>();
		for(SingerEntity po:poList){
			ActorEntity actor = actorRepository.findOne(po.getActorId());
			SingerModel bo = ActorPoBoTransUtil.singerP2B(po);
			ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
			boList.add(bo);
			
		}
		JsonablePageImpl<SingerModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(boList);
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
	 * @see com.showmecoo.web.management.api.service.ISingerManagerService#findSingerWithPage(int, int)
	 */
	@Override
	public JsonablePageImpl<SingerModel> findSingerWithPage(int page, int size) throws Throwable {
		
		PageRequest pageable = new PageRequest(page, size);
		Page<SingerEntity> poPage = singerRepository.findAll(pageable);
		List<SingerEntity> poList = poPage.getContent();
		if(poList == null){
			log.info("can not find any actor");
			return null;
		}
		List<SingerModel> boList = new ArrayList<>();
		for(SingerEntity po:poList){
			ActorEntity actor = actorRepository.findOne(po.getActorId());
			SingerModel bo = ActorPoBoTransUtil.singerP2B(po);
			ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
			boList.add(bo);
			
		}
		JsonablePageImpl<SingerModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(boList);
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