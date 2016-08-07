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


package com.showmecoo.web.management.util;

import java.util.ArrayList;
import java.util.List;

import com.showmecoo.web.commons.bo.PictureWorkModel;
import com.showmecoo.web.commons.bo.VideoWorkModel;
import com.showmecoo.web.management.entity.PictureWorkEntity;
import com.showmecoo.web.management.entity.VideoWorkEntity;

/**
 * 作品 业务层对象与数据层对象相互转换工具类
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class WorkPoBoTransUtil {
	
	/**
	 * 业务层对象转为数据层对象
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static PictureWorkEntity picB2P(PictureWorkModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("PictureWorkModel can not be null");
		}
		
		PictureWorkEntity po = new PictureWorkEntity();
		po.setActorId(bo.getActorId());
		po.setBriefIntroduction(bo.getBriefIntroduction());
		po.setCreateTime(bo.getCreateTime());
		po.setPictureId(bo.getPictureId());
		po.setPictureName(bo.getPictureName());
		po.setRecommendLevel(bo.getRecommendLevel());
		po.setUpdateTime(bo.getUpdateTime());
		po.setVisitNum(bo.getVisitNum());
		po.setWorkName(bo.getWorkName());
		
		return po;
	} 
	
	/**
	 * 数据层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException
	 */
	public static PictureWorkModel picP2B(PictureWorkEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("PictureWorkEntity can not be null");
		}
		
		PictureWorkModel bo = new PictureWorkModel();
		bo.setActorId(po.getActorId());
		bo.setBriefIntroduction(po.getBriefIntroduction());
		bo.setCreateTime(po.getCreateTime());
		bo.setPictureId(po.getPictureId());
		bo.setPictureName(po.getPictureName());
		bo.setRecommendLevel(po.getRecommendLevel());
		bo.setUpdateTime(po.getUpdateTime());
		bo.setVisitNum(po.getVisitNum());
		bo.setWorkName(po.getWorkName());
		
		return bo;
	} 
	
	/**
	 * 业务层对象批量转为数据层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<PictureWorkEntity> picListB2P(List<PictureWorkModel> boList) throws IllegalAccessException{
		if(null == boList){
			throw new IllegalAccessException("PictureWorkModel list can not be null");
		}
		
		List<PictureWorkEntity> poList = new ArrayList<>();
		for(PictureWorkModel bo:boList){
			poList.add(picB2P(bo));
		}
		
		return poList;
	}
	
	/**
	 * 数据层对象批量转为业务层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<PictureWorkModel> picListP2B(List<PictureWorkEntity> poList) throws IllegalAccessException{
		if(null == poList){
			throw new IllegalAccessException("PictureWorkEntity list can not be null");
		}
		
		List<PictureWorkModel> boList = new ArrayList<>();
		for(PictureWorkEntity po:poList){
			boList.add(picP2B(po));
		}
		
		return boList;
	}
	
	/**
	 * 视屏对象  业务层对象转为数据层对象
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static VideoWorkEntity videoB2P(VideoWorkModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("VideoModel can not be null");
		}
		
		VideoWorkEntity po = new VideoWorkEntity();
		
		po.setActorId(bo.getActorId());
		po.setBriefIntroduction(bo.getBriefIntroduction());
		po.setCreateTime(bo.getCreateTime());
		po.setRecommendLevel(bo.getRecommendLevel());
		po.setUpdateTime(bo.getUpdateTime());
		po.setVideoId(bo.getVideoId());
		po.setVideoName(bo.getVideoName());
		po.setVisitNum(bo.getVisitNum());
		po.setWorkName(bo.getWorkName());
		
		return po;
	}
	
	/**
	 * 视屏对象 数据层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException
	 */
	public static VideoWorkModel videoP2B(VideoWorkEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("VideoWorkEntity can not be null");
		}
		
		VideoWorkModel bo = new VideoWorkModel();
		
		bo.setActorId(po.getActorId());
		bo.setBriefIntroduction(po.getBriefIntroduction());
		bo.setCreateTime(po.getCreateTime());
		bo.setRecommendLevel(po.getRecommendLevel());
		bo.setUpdateTime(po.getUpdateTime());
		bo.setVideoId(po.getVideoId());
		bo.setVideoName(po.getVideoName());
		bo.setVisitNum(po.getVisitNum());
		bo.setWorkName(po.getWorkName());
		
		return bo;
	}
	
	/**
	 * 视屏对象 业务层对象批量转为数据层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<VideoWorkEntity> videoListB2P(List<VideoWorkModel> boList) throws IllegalAccessException{
		if(null == boList){
			throw new IllegalAccessException("PictureWorkModel list can not be null");
		}
		
		List<VideoWorkEntity> poList = new ArrayList<>();
		for(VideoWorkModel bo:boList){
			poList.add(videoB2P(bo));
		}
		
		return poList;
	}
	
	/**
	 * 视屏对象 数据层对象批量转为业务层对象
	 * @param poList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<VideoWorkModel> videoListP2B(List<VideoWorkEntity> poList) throws IllegalAccessException{
		if(null == poList){
			throw new IllegalAccessException("VideoWorkEntity list can not be null");
		}
		
		List<VideoWorkModel> boList = new ArrayList<>();
		for(VideoWorkEntity po:poList){
			boList.add(videoP2B(po));
		}
		
		return boList;
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */