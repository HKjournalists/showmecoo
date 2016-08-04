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

import com.showmecoo.web.commons.bo.CompereModel;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.api.service.ICompereManagerService;
import com.showmecoo.web.management.entity.ActorEntity;
import com.showmecoo.web.management.entity.CompereEntity;
import com.showmecoo.web.management.spi.repository.ActorRepository;
import com.showmecoo.web.management.spi.repository.CompereRepository;
import com.showmecoo.web.management.util.ActorPoBoTransUtil;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Service
public class CompereManagerServiceImpl implements ICompereManagerService{
	
	private Logger log = LoggerFactory.getLogger(CompereManagerServiceImpl.class);
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private CompereRepository compereRepository;

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ICompereManagerService#createCompereModel(com.showmecoo.web.commons.bo.CompereModel)
	 */
	@Override
	public CompereModel createCompereModel(CompereModel bo) throws Throwable {
		String nickName = bo.getNickName();
		ActorEntity po = actorRepository.findActorEntityByNickName(nickName);
		if(null == po){
			po = new ActorEntity();
			po.setAge(bo.getAge());
			po.setCreateTime(bo.getCreateTime());
			po.setDisplayedNum(bo.getDisplayedNum());
			po.setFansNum(bo.getFansNum());
			po.setHeight(bo.getHeight());
			po.setImageName(bo.getImageName());
			po.setName(bo.getName());
			po.setNickName(nickName);
			po.setSex(bo.getSex());
			po.setType(bo.getType());
			po.setVisitNum(bo.getVisitNum());
			po = actorRepository.save(po);
		}
		bo.setActorId(po.getActorId());
		ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(po), bo);
		CompereEntity ret = compereRepository.save(ActorPoBoTransUtil.compereB2P(bo));
		
		return ActorPoBoTransUtil.compereP2B(ret);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ICompereManagerService#updateCompereModel(com.showmecoo.web.commons.bo.CompereModel)
	 */
	@Override
	public CompereModel updateCompereModel(CompereModel bo) throws Throwable {
		CompereEntity po = compereRepository.save(ActorPoBoTransUtil.compereB2P(bo));
		return ActorPoBoTransUtil.compereP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ICompereManagerService#deleteCompereModel(java.lang.String)
	 */
	@Override
	public void deleteCompereModel(String compereId) throws Throwable {
		compereRepository.delete(compereId);
		actorRepository.delete(compereId);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ICompereManagerService#findCompereById(java.lang.String)
	 */
	@Override
	public CompereModel findCompereById(String compereId) throws Throwable {
		
		ActorEntity actor = actorRepository.findOne(compereId);
		if(null == actor){
			log.error("can not find compere by compereId:{}, please check again", compereId);
			return null;
		}
		
		CompereEntity po = compereRepository.findOne(compereId);
		CompereModel bo = ActorPoBoTransUtil.compereP2B(po);
		ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ICompereManagerService#findCompereByName(java.lang.String)
	 */
	@Override
	public List<CompereModel> findCompereByName(String compereName) throws Throwable {
		List<ActorEntity> list = actorRepository.findActorEntityByName(compereName);
		if(null == list){
			log.error("can not find compere by name:{}", compereName);
			return null;
		}
		List<CompereModel> boList = new ArrayList<>();
		for(ActorEntity actor:list){
			
			CompereEntity po = compereRepository.findOne(actor.getActorId());
			CompereModel bo = ActorPoBoTransUtil.compereP2B(po);
			ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
			boList.add(bo);
			
		}
		return boList;
	}

	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ICompereManagerService#findCompereByNickName(java.lang.String)
	 */
	@Override
	public CompereModel findCompereByNickName(String nickName) throws Throwable {
		ActorEntity actor = actorRepository.findActorEntityByNickName(nickName);
		if(null == actor){
			log.error("can not find compere by nickName:{}", nickName);
			return null;
		}
		CompereEntity po = compereRepository.findOne(actor.getActorId());
		CompereModel bo = ActorPoBoTransUtil.compereP2B(po);
		ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.ICompereManagerService#findAllComperes()
	 */
	@Override
	public JsonablePageImpl<CompereModel> findAllComperes() throws Throwable {
		PageRequest pageable = new PageRequest(0, 10);
		Page<CompereEntity> poPage = compereRepository.findAll(pageable);
		List<CompereEntity> poList = poPage.getContent();
		if(null == poList){
			log.error("can not find any compere");
			return null;
		}
		List<CompereModel> boList = new ArrayList<>();
		for(CompereEntity po:poList){
			ActorEntity actor = actorRepository.findOne(po.getActorId());
			CompereModel bo = ActorPoBoTransUtil.compereP2B(po);
			ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
			boList.add(bo);
		}
		
		JsonablePageImpl<CompereModel> jsonAble = new JsonablePageImpl<>();
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
	 * @see com.showmecoo.web.management.api.service.ICompereManagerService#findComperesWithPage(int, int)
	 */
	@Override
	public JsonablePageImpl<CompereModel> findComperesWithPage(int page, int size) throws Throwable {
		
		PageRequest pageable = new PageRequest(page, size);
		Page<CompereEntity> poPage = compereRepository.findAll(pageable);
		List<CompereEntity> poList = poPage.getContent();
		if(null == poList){
			log.error("can not find any compere");
			return null;
		}
		List<CompereModel> boList = new ArrayList<>();
		for(CompereEntity po:poList){
			ActorEntity actor = actorRepository.findOne(po.getActorId());
			CompereModel bo = ActorPoBoTransUtil.compereP2B(po);
			ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
			boList.add(bo);
		}
		JsonablePageImpl<CompereModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(ActorPoBoTransUtil.compereListP2B(poList));
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