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
 * Created on 2016年8月5日
 *******************************************************************************/


package com.showmecoo.web.management.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.showmecoo.web.commons.bo.PictureWorkModel;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.api.service.IPictureWorkManagerService;
import com.showmecoo.web.management.entity.PictureWorkEntity;
import com.showmecoo.web.management.spi.repository.PictureWorkRepository;
import com.showmecoo.web.management.util.WorkPoBoTransUtil;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Service
public class PictureWorkManagerServiceImpl implements IPictureWorkManagerService{
	
	private Logger log = LoggerFactory.getLogger(PictureWorkManagerServiceImpl.class);
	
	@Autowired
	private PictureWorkRepository pictureRepository;
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IPictureWorkManagerService#createPictureWorkModel(com.showmecoo.web.commons.bo.PictureWorkModel)
	 */
	@Override
	public PictureWorkModel createPictureWorkModel(PictureWorkModel bo) throws Throwable {
		log.debug("call createPictureWorkModel rest api");
		PictureWorkEntity po = pictureRepository.save(WorkPoBoTransUtil.picB2P(bo));
		return WorkPoBoTransUtil.picP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IPictureWorkManagerService#updatePictureWorkModel(com.showmecoo.web.commons.bo.PictureWorkModel)
	 */
	@Override
	public PictureWorkModel updatePictureWorkModel(PictureWorkModel bo) throws Throwable {
		log.debug("call updatePictureWorkModel rest api");
		PictureWorkEntity po = pictureRepository.save(WorkPoBoTransUtil.picB2P(bo));
		return WorkPoBoTransUtil.picP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IPictureWorkManagerService#deletePictureWorkModelById(java.lang.String)
	 */
	@Override
	public void deletePictureWorkModelById(String workId) throws Throwable {
		log.debug("call deletePictureWorkModelById rest api");
		pictureRepository.delete(workId);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IPictureWorkManagerService#findPictureWorkById(java.lang.String)
	 */
	@Override
	public PictureWorkModel findPictureWorkById(String pictureId) throws Throwable {
		log.debug("call findPictureWorkById rest api");
		PictureWorkEntity po = pictureRepository.findOne(pictureId);
		return WorkPoBoTransUtil.picP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IPictureWorkManagerService#findPictureWorkByName(java.lang.String)
	 */
	@Override
	public PictureWorkModel findPictureWorkByName(String workName) throws Throwable {
		log.debug("call findPictureWorkByName rest api");
		PictureWorkEntity po = pictureRepository.findPictureByWorkName(workName);
		return WorkPoBoTransUtil.picP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IPictureWorkManagerService#findAllPictureWorks()
	 */
	@Override
	public JsonablePageImpl<PictureWorkModel> findAllPictureWorks() throws Throwable {
		log.debug("call findAllPictureWorks rest api");
		
		PageRequest pageable = new PageRequest(0, 10);
		Page<PictureWorkEntity> poPage = pictureRepository.findAll(pageable);
		JsonablePageImpl<PictureWorkModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(WorkPoBoTransUtil.picListP2B(poPage.getContent()));
		jsonAble.setFirst(poPage.isFirst());
		jsonAble.setLast(poPage.isLast());
		jsonAble.setNumber(poPage.getNumber());
		jsonAble.setNumberOfElements(poPage.getNumberOfElements());
		jsonAble.setSize(poPage.getSize());
		jsonAble.setTotalElements(poPage.getTotalElements());
		
		return jsonAble;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IPictureWorkManagerService#findPictureWorksWithPage(int, int)
	 */
	@Override
	public JsonablePageImpl<PictureWorkModel> findPictureWorksWithPage(int page, int size) throws Throwable {

		log.debug("call findPictureWorksWithPage rest api, page:{}, size:{}", page, size);
		PageRequest pageable = new PageRequest(page, size);
		Page<PictureWorkEntity> poPage = pictureRepository.findAll(pageable);
		JsonablePageImpl<PictureWorkModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(WorkPoBoTransUtil.picListP2B(poPage.getContent()));
		jsonAble.setFirst(poPage.isFirst());
		jsonAble.setLast(poPage.isLast());
		jsonAble.setNumber(poPage.getNumber());
		jsonAble.setNumberOfElements(poPage.getNumberOfElements());
		jsonAble.setSize(poPage.getSize());
		jsonAble.setTotalElements(poPage.getTotalElements());
		return jsonAble;
	}
	
}

/*
 * 修改历史
 * $Log$ 
 */