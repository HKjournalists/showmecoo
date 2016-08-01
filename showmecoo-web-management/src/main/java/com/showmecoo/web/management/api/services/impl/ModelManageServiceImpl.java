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

import com.showmecoo.web.commons.bo.ModelModel;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.api.service.IModelManagerService;
import com.showmecoo.web.management.entity.ActorEntity;
import com.showmecoo.web.management.entity.ModelEntity;
import com.showmecoo.web.management.spi.repository.ActorRepository;
import com.showmecoo.web.management.spi.repository.ModelRepository;
import com.showmecoo.web.management.util.ActorPoBoTransUtil;

/**
 * model管理 rest 接口实现类
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Service
public class ModelManageServiceImpl implements IModelManagerService{
	
	private static Logger log = LoggerFactory.getLogger(ModelManageServiceImpl.class);
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private ModelRepository modelRepository;

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IModelManagerService#createModel(com.showmecoo.web.commons.bo.ModelModel)
	 */
	@Override
	public ModelModel createModel(ModelModel bo) throws Throwable {
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
		ModelEntity po = modelRepository.save(ActorPoBoTransUtil.modelB2P(bo));
		return ActorPoBoTransUtil.modelP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IModelManagerService#updateModel(com.showmecoo.web.commons.bo.ModelModel)
	 */
	@Override
	public ModelModel updateModel(ModelModel bo) throws Throwable {
		ModelEntity po = modelRepository.save(ActorPoBoTransUtil.modelB2P(bo));
		return ActorPoBoTransUtil.modelP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IModelManagerService#deleteModel(java.lang.String)
	 */
	@Override
	public void deleteModel(String modelId) throws Throwable {
		modelRepository.delete(modelId);
		actorRepository.delete(modelId);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IModelManagerService#findModelById(java.lang.String)
	 */
	@Override
	public ModelModel findModelById(String modelId) throws Throwable {
		ActorEntity actor = actorRepository.findOne(modelId);
		ModelEntity po = modelRepository.findOne(modelId);
		if(null == po){
			log.error("can not find model by id:{}", modelId);
			return null;
		}
		ModelModel bo = ActorPoBoTransUtil.modelP2B(po);
		ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
		
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IModelManagerService#findModelByName(java.lang.String)
	 */
	@Override
	public List<ModelModel> findModelByName(String modelName) throws Throwable {
		List<ActorEntity> list = actorRepository.findActorEntityByName(modelName);
		if(null == list){
			log.error("can not find any model by name, name:{}", modelName);
		}
		List<ModelModel> boList = new ArrayList<>();
		for(ActorEntity po : list){
			ModelEntity model = modelRepository.findOne(po.getActorId());
			ModelModel bo = ActorPoBoTransUtil.modelP2B(model);
			ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(po), bo);
			boList.add(bo);
		}
		return boList;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IModelManagerService#findModelByNickName(java.lang.String)
	 */
	@Override
	public ModelModel findModelByNickName(String nickName) throws Throwable {
		ActorEntity actor = actorRepository.findActorEntityByNickName(nickName);
		if(null == actor){
			log.error("can not find model by nickName, nickName:{}", nickName);
		}
		ModelEntity po = modelRepository.findOne(actor.getActorId());
		ModelModel bo = ActorPoBoTransUtil.modelP2B(po);
		ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IModelManagerService#findAllModels()
	 */
	@Override
	public JsonablePageImpl<ModelModel> findAllModels() throws Throwable {
		
		PageRequest pageable = new PageRequest(0, 10);
		Page<ModelEntity> poPage = modelRepository.findAll(pageable);
		List<ModelEntity> poList = poPage.getContent();
		if(poList == null){
			log.info("can not find any actor");
			return null;
		}
		List<ModelModel> boList = new ArrayList<>();
		for(ModelEntity po:poList){
			ActorEntity actor = actorRepository.findOne(po.getActorId());
			ModelModel bo = ActorPoBoTransUtil.modelP2B(po);
			ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
			boList.add(bo);
			
		}
		JsonablePageImpl<ModelModel> jsonAble = new JsonablePageImpl<>();
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
	 * @see com.showmecoo.web.management.api.service.IModelManagerService#findModelsWithPage(int, int)
	 */
	@Override
	public JsonablePageImpl<ModelModel> findModelsWithPage(int page, int size) throws Throwable {
		
		PageRequest pageable = new PageRequest(page, size);
		Page<ModelEntity> poPage = modelRepository.findAll(pageable);
		List<ModelEntity> poList = poPage.getContent();
		if(poList == null){
			log.info("can not find any actor");
			return null;
		}
		List<ModelModel> boList = new ArrayList<>();
		for(ModelEntity po:poList){
			ActorEntity actor = actorRepository.findOne(po.getActorId());
			ModelModel bo = ActorPoBoTransUtil.modelP2B(po);
			ActorPoBoTransUtil.addCommonAttr4Bo(ActorPoBoTransUtil.actorP2B(actor), bo);
			boList.add(bo);
			
		}
		JsonablePageImpl<ModelModel> jsonAble = new JsonablePageImpl<>();
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