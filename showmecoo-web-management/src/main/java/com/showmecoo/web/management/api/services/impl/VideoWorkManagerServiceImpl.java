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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.showmecoo.web.commons.bo.VideoWorkModel;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.api.service.IVideoWorkManagerService;
import com.showmecoo.web.management.entity.VideoWorkEntity;
import com.showmecoo.web.management.spi.repository.VideoWorkRepository;
import com.showmecoo.web.management.util.WorkPoBoTransUtil;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Service
public class VideoWorkManagerServiceImpl implements IVideoWorkManagerService{
	
	private Logger log = LoggerFactory.getLogger(VideoWorkManagerServiceImpl.class);
	
	@Autowired
	private VideoWorkRepository videoRepository;
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IVideoWorkManagerService#createVideoWorkModel(com.showmecoo.web.commons.bo.VideoWorkModel)
	 */
	@Override
	public VideoWorkModel createVideoWorkModel(VideoWorkModel bo) throws Throwable {
		log.debug("call createVideoWorkModel rest api, VideoWorkModel:{}", bo);
		VideoWorkEntity po = videoRepository.save(WorkPoBoTransUtil.videoB2P(bo));
		return WorkPoBoTransUtil.videoP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IVideoWorkManagerService#updateVideoWorkModel(com.showmecoo.web.commons.bo.VideoWorkModel)
	 */
	@Override
	public VideoWorkModel updateVideoWorkModel(VideoWorkModel bo) throws Throwable {
		log.debug("call updateVideoWorkModel rest api, VideoWorkModel:{}", bo);
		VideoWorkEntity po = videoRepository.save(WorkPoBoTransUtil.videoB2P(bo));
		return WorkPoBoTransUtil.videoP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IVideoWorkManagerService#deleteVideoWorkModelById(java.lang.String)
	 */
	@Override
	public void deleteVideoWorkModelById(String videoId) throws Throwable {
		log.debug("call deleteVideoWorkModelById rest api, videoId:{}", videoId);
		videoRepository.delete(videoId);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IVideoWorkManagerService#findPictureWorkById(java.lang.String)
	 */
	@Override
	public VideoWorkModel findPictureWorkById(String videoId) throws Throwable {
		log.debug("call findPictureWorkById rest api, videoId:{}", videoId);
		VideoWorkEntity po = videoRepository.findOne(videoId);
		if(null == po){
			log.error("can not find VideoWorkModel by videoId:" + videoId);
			return null;
		}
		return WorkPoBoTransUtil.videoP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IVideoWorkManagerService#findPictureWorkByName(java.lang.String)
	 */
	@Override
	public VideoWorkModel findPictureWorkByName(String workName) throws Throwable {
		
		log.debug("call findPictureWorkByName rest api, workName:{}", workName);
		VideoWorkEntity po = videoRepository.findVideoWorkByWorkName(workName);
		if(null == po){
			log.error("can not find VideoWorkModel by workName:" + workName);
			return null;
		}
		return WorkPoBoTransUtil.videoP2B(po);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IVideoWorkManagerService#findAllPictureWorks()
	 */
	@Override
	public JsonablePageImpl<VideoWorkModel> findAllPictureWorks() throws Throwable {
		
		log.debug("call findAllPictureWorks rest api");
		PageRequest pageable = new PageRequest(0, 10);
		Page<VideoWorkEntity> poPage = videoRepository.findAll(pageable);
		JsonablePageImpl<VideoWorkModel> jsonAble = new JsonablePageImpl<>();
		jsonAble.setContent(WorkPoBoTransUtil.videoListP2B(poPage.getContent()));
		jsonAble.setFirst(poPage.isFirst());
		jsonAble.setLast(poPage.isLast());
		jsonAble.setNumber(poPage.getNumber());
		jsonAble.setNumberOfElements(poPage.getNumberOfElements());
		jsonAble.setSize(poPage.getSize());
		jsonAble.setTotalElements(poPage.getTotalElements());
		return jsonAble;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.service.IVideoWorkManagerService#findPictureWorksWithPage(int, int)
	 */
	@Override
	public JsonablePageImpl<VideoWorkModel> findPictureWorksWithPage(int page, int size) throws Throwable {
		
		log.debug("call findPictureWorksWithPage rest api, page:{}, size:{}", page, size);
		PageRequest pageable = new PageRequest(page, size);
		Page<VideoWorkEntity> poPage = videoRepository.findAll(pageable);
		JsonablePageImpl<VideoWorkModel> jsonAble = new JsonablePageImpl<>();
		List<VideoWorkEntity> poList = poPage.getContent();
		jsonAble.setContent(WorkPoBoTransUtil.videoListP2B(poList));
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