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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.showmecoo.web.commons.bo.ActorModel;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.api.service.IActorManagerService;
import com.showmecoo.web.management.entity.ActorEntity;
import com.showmecoo.web.management.spi.repository.ActorRepository;
import com.showmecoo.web.management.spi.repository.CompereRepository;
import com.showmecoo.web.management.spi.repository.DancerRepository;
import com.showmecoo.web.management.spi.repository.ModelRepository;
import com.showmecoo.web.management.spi.repository.SingerRepository;
import com.showmecoo.web.management.util.ActorPoBoTransUtil;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Service
public class ActorManagerServiceImpl implements IActorManagerService{
	
	private static Logger log = LoggerFactory.getLogger(ActorManagerServiceImpl.class);
	
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private DancerRepository dancerRepository;
	@Autowired
	private SingerRepository singerRepository;
	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private CompereRepository compereRepository;
	
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IActorManagerService#createActorModel(com.showmecoo.web.commons.bo.ActorModel)
	 */
	@Override
	public ActorModel createActorModel(ActorModel bo) throws Throwable {
		log.debug("call createActorModel rest api, bo:{}", bo);
		ActorEntity po = ActorPoBoTransUtil.actorB2P(bo);
		
		return ActorPoBoTransUtil.actorP2B(actorRepository.save(po));
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IActorManagerService#updateActorModel(com.showmecoo.web.commons.bo.ActorModel)
	 */
	@Override
	public ActorModel updateActorModel(ActorModel bo) throws Throwable {
		log.debug("call updateActorModel rest api, bo:{}", bo);
		ActorEntity po = ActorPoBoTransUtil.actorB2P(bo);
		
		return ActorPoBoTransUtil.actorP2B(actorRepository.save(po));
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IActorManagerService#deleteActor(com.showmecoo.web.commons.bo.ActorModel)
	 */
	@Override
	public void deleteActor(String actorId) throws Throwable {
		log.debug("call deleteActor rest api,");
		actorRepository.delete(actorId);
		compereRepository.delete(actorId);
		dancerRepository.delete(actorId);
		singerRepository.delete(actorId);
		dancerRepository.delete(actorId);
		modelRepository.delete(actorId);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IActorManagerService#findActorModelById(java.lang.String)
	 */
	@Override
	public ActorModel findActorModelById(String actorId) throws Throwable {
		ActorEntity po = actorRepository.findOne(actorId);
		if(null == po){
			log.error("can not find ActorModel by id:{}", actorId);
			return null;
		}
		return ActorPoBoTransUtil.actorP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IActorManagerService#findActorModelByName(java.lang.String)
	 */
	@Override
	public List<ActorModel> findActorModelByName(String actorName) throws Throwable {
		List<ActorEntity> poList = actorRepository.findActorEntityByName(actorName);
		return ActorPoBoTransUtil.actorListP2B(poList);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IActorManagerService#findActorModelByNickName(java.lang.String)
	 */
	@Override
	public ActorModel findActorModelByNickName(String actorNickName) throws Throwable {
		ActorEntity po = actorRepository.findActorEntityByNickName(actorNickName);
		return ActorPoBoTransUtil.actorP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IActorManagerService#findAllActors()
	 */
	@Override
	public JsonablePageImpl<ActorModel> findAllActors() throws Throwable {
		PageRequest pageable = new PageRequest(0, 10);
		Page<ActorEntity> poPage = actorRepository.findAll(pageable);
		if(poPage.getContent() == null){
			log.info("can not find any actor");
			return null;
		}
		JsonablePageImpl<ActorModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(ActorPoBoTransUtil.actorListP2B(poPage.getContent()));
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