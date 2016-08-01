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


package com.showmecoo.web.management.util;

import java.util.ArrayList;
import java.util.List;

import com.showmecoo.web.commons.bo.ActorModel;
import com.showmecoo.web.commons.bo.CompereModel;
import com.showmecoo.web.commons.bo.DancerModel;
import com.showmecoo.web.commons.bo.ModelModel;
import com.showmecoo.web.commons.bo.SingerModel;
import com.showmecoo.web.management.entity.ActorEntity;
import com.showmecoo.web.management.entity.CompereEntity;
import com.showmecoo.web.management.entity.DancerEntity;
import com.showmecoo.web.management.entity.ModelEntity;
import com.showmecoo.web.management.entity.SingerEntity;

/**
 * Actor 业务层对象实例与数据层对象实例转换工具类
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class ActorPoBoTransUtil {
	
	/**
	 * actor 业务层对象转为数据层对象
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static ActorEntity actorB2P(ActorModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("actorModel object can not be null");
		}
		
		ActorEntity po = new ActorEntity();
		po.setActorId(bo.getActorId());
		po.setAge(bo.getAge());
		po.setCreateTime(bo.getCreateTime());
		po.setDisplayedNum(bo.getDisplayedNum());
		po.setFansNum(bo.getFansNum());
		po.setName(bo.getName());
		po.setHeight(bo.getHeight());
		po.setImageName(bo.getImageName());
		po.setNickName(bo.getNickName());
		po.setSex(bo.getSex());
		po.setType(bo.getType());
		po.setVisitNum(bo.getVisitNum());

		return po;
		
	}
	
	/**
	 * actor 数据层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException
	 */
	public static ActorModel actorP2B(ActorEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("actorEntity object can not be null");
		}
		
		ActorModel bo = new ActorModel();
		bo.setActorId(po.getActorId());
		bo.setAge(po.getAge());
		bo.setCreateTime(po.getCreateTime());
		bo.setDisplayedNum(po.getDisplayedNum());
		bo.setFansNum(po.getFansNum());
		bo.setName(po.getName());
		bo.setHeight(po.getHeight());
		bo.setImageName(po.getImageName());
		bo.setNickName(po.getNickName());
		bo.setSex(po.getSex());
		bo.setType(po.getType());
		bo.setVisitNum(po.getVisitNum());
		
		return bo;
	}
	
	
	/**
	 * actor 数据层对象批量转为业务层对象
	 * @param poList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<ActorModel> actorListP2B(List<ActorEntity> poList) throws IllegalAccessException{
		if(null == poList){
			throw new IllegalAccessException("actor entity list can not be null");
		}
		
		List<ActorModel> boList = new ArrayList<>();
		for(ActorEntity po:poList){
			boList.add(actorP2B(po));
		}
		return boList;
	}
	
	/**
	 * actor 业务层对象批量转为数据层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<ActorEntity> actorListB2P(List<ActorModel> boList) throws IllegalAccessException{
		if(null == boList){
			throw new IllegalAccessException("actorModel list can not be null");
		}
		
		List<ActorEntity> poList = new ArrayList<>();
		for(ActorModel bo:boList){
			poList.add(actorB2P(bo));
		}
		return poList;
	}
	
	
	/**
	 * Compere 数据层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException
	 */
	public static CompereModel compereP2B(CompereEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("CompereEntity can not be null");
		}
		
		CompereModel bo = new CompereModel();
		bo.setActorId(po.getActorId());
		bo.setSkilledStyle(po.getSkilledStyle());
		bo.setDisplayAddr(po.getDisplayAddr());
		bo.setDisplayPrice(po.getDisplayPrice());
		bo.setStandardDisplay(po.getStandardDisplay());
		bo.setMainImageName(po.getMainImageName());
		bo.setSecondImageName(po.getSecondImageName());
		bo.setBriefIntroduction(po.getBriefIntroduction());
		bo.setLevelScore(po.getLevelScore());
		
		return bo;
	}
	
	/**
	 * Compere 业务层对象转为数据层对象
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static CompereEntity compereB2P(CompereModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("CompereModel can not be null");
		}
		
		CompereEntity po = new CompereEntity();
		po.setActorId(bo.getActorId());
		po.setSkilledStyle(bo.getSkilledStyle());
		po.setDisplayAddr(bo.getDisplayAddr());
		po.setDisplayPrice(bo.getDisplayPrice());
		po.setStandardDisplay(bo.getStandardDisplay());
		po.setMainImageName(bo.getMainImageName());
		po.setSecondImageName(bo.getSecondImageName());
		po.setBriefIntroduction(bo.getBriefIntroduction());
		po.setLevelScore(bo.getLevelScore());
		
		return po;
	}
	
	/**
	 * Compere 数据层对象批量转为业务层对象
	 * @param poList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<CompereModel> compereListP2B(List<CompereEntity> poList) throws IllegalAccessException{
		if(null == poList){
			throw new IllegalAccessException("CompereEntity list can not be null");
		}
		
		List<CompereModel> boList = new ArrayList<>();
		for(CompereEntity po:poList){
			boList.add(compereP2B(po));
		}
		
		return boList;
	}
	
	/**
	 * Compere 业务层对象批量转为数据层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<CompereEntity> compereListB2P(List<CompereModel> boList) throws IllegalAccessException{
		if(null == boList){
			throw new IllegalAccessException("CompereModel list can not be null");
		}
		
		List<CompereEntity> poList = new ArrayList<>();
		for(CompereModel bo:boList){
			poList.add(compereB2P(bo));
		}
		
		return poList;
	}
	
	/**
	 * Dancer 业务层对象转为数据层对象
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static DancerEntity dancerB2P(DancerModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("DancerModel can not be null");
		}
		
		DancerEntity po = new DancerEntity();
		po.setActorId(bo.getActorId());
		po.setBriefIntroduction(bo.getBriefIntroduction());
		po.setDisplayAddr(bo.getDisplayAddr());
		po.setDisplayPrice(bo.getDisplayPrice());
		po.setLevelScore(bo.getLevelScore());
		po.setMainImageName(bo.getMainImageName());
		po.setSecondImageName(bo.getSecondImageName());
		po.setSkilledStyle(bo.getSkilledStyle());
		po.setStandardDisplay(bo.getStandardDisplay());
		
		return po;
	}
	
	/**
	 * Dancer 数据层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException
	 */
	public static DancerModel dancerP2B(DancerEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("DancerEntity can not be null");
		}
		
		DancerModel bo = new DancerModel();
		bo.setActorId(po.getActorId());
		bo.setBriefIntroduction(po.getBriefIntroduction());
		bo.setDisplayAddr(po.getDisplayAddr());
		bo.setDisplayPrice(po.getDisplayPrice());
		bo.setLevelScore(po.getLevelScore());
		bo.setMainImageName(po.getMainImageName());
		bo.setSecondImageName(po.getSecondImageName());
		bo.setSkilledStyle(po.getSkilledStyle());
		bo.setStandardDisplay(po.getStandardDisplay());
		
		return bo;
	}
	
	/**
	 * Dancer 业务层对象批量转为数据层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<DancerEntity> dancerListB2P(List<DancerModel> boList) throws IllegalAccessException{
		if(null == boList){
			throw new IllegalAccessException("DancerModel list can not be null");
		}
		List<DancerEntity> poList = new ArrayList<>();
		for(DancerModel bo:boList){
			poList.add(dancerB2P(bo));
		}
		return poList;
	}
	
	/**
	 * Dancer 数据层对象批量转为业务层对象
	 * @param poList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<DancerModel> dancerListP2B(List<DancerEntity> poList) throws IllegalAccessException{
		if(null == poList){
			throw new IllegalAccessException("DancerModel list can not be null");
		}
		List<DancerModel> boList = new ArrayList<>();
		for(DancerEntity po:poList){
			boList.add(dancerP2B(po));
		}
		return boList;
	}
	

	

	
	
	
	
	
	
	/**
	 * model 业务层对象转为数据层对象
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static ModelEntity modelB2P(ModelModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("ModelModel can not be null");
		}
		ModelEntity po = new ModelEntity();
		po.setActorId(bo.getActorId());
		po.setBriefIntroduction(bo.getBriefIntroduction());
		po.setDisplayAddr(bo.getDisplayAddr());
		po.setDisplayPrice(bo.getDisplayPrice());
		po.setLevelScore(bo.getLevelScore());
		po.setMainImageName(bo.getMainImageName());
		po.setSecondImageName(bo.getSecondImageName());
		po.setSkilledStyle(bo.getSkilledStyle());
		po.setStandardDisplay(bo.getStandardDisplay());
		
		return po;
	}
	
	/**
	 * model 数据层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException
	 */
	public static ModelModel modelP2B(ModelEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("ModelEntity can not be null");
		}
		ModelModel bo = new ModelModel();
		bo.setActorId(po.getActorId());
		bo.setBriefIntroduction(po.getBriefIntroduction());
		bo.setDisplayAddr(po.getDisplayAddr());
		bo.setDisplayPrice(po.getDisplayPrice());
		bo.setLevelScore(po.getLevelScore());
		bo.setMainImageName(po.getMainImageName());
		bo.setSecondImageName(po.getSecondImageName());
		bo.setSkilledStyle(po.getSkilledStyle());
		bo.setStandardDisplay(po.getStandardDisplay());
		
		return bo;
	}
	
	/**
	 * model 业务层对象批量转为数据层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<ModelEntity> modelListB2P(List<ModelModel> boList) throws IllegalAccessException{
		if(null == boList){
			throw new IllegalAccessException("boList can not be null");
		}
		
		List<ModelEntity> poList = new ArrayList<>();
		for(ModelModel bo:boList){
			poList.add(modelB2P(bo));
		}
		
		return poList;
	}
	
	/**
	 * model 数据层对象批量转为业务层对象
	 * @param poList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<ModelModel> modelListP2B(List<ModelEntity> poList) throws IllegalAccessException{
		if(null == poList){
			throw new IllegalAccessException("boList can not be null");
		}
		
		List<ModelModel> boList = new ArrayList<>();
		for(ModelEntity po:poList){
			boList.add(modelP2B(po));
		}
		
		return boList;
	}
	
	
	/**
	 * 直接从子表查出来的model对象不包含一些通用信息，这时需要通过主表查询出然后赋值给业务层对象
	 * @param actorModel
	 * @param bo
	 * @return
	 */
	public static ActorModel addCommonAttr4Bo(ActorModel actorModel, ActorModel bo){
		
		bo.setName(actorModel.getName());
		bo.setNickName(actorModel.getNickName());
		bo.setHeight(actorModel.getHeight());
		bo.setAge(actorModel.getAge());
		bo.setSex(actorModel.getSex());
		bo.setType(actorModel.getType());
		bo.setDisplayedNum(actorModel.getDisplayedNum());
		bo.setVisitNum(actorModel.getVisitNum());
		bo.setFansNum(actorModel.getFansNum());
		bo.setCreateTime(actorModel.getCreateTime());
		bo.setImageName(actorModel.getImageName());
		
		return bo;
	}
	
	
	/**
	 * singer 业务层对象转为数据层对象
	 * @param bo
	 * @return
	 * @throws IllegalAccessException
	 */
	public static SingerEntity singerB2P(SingerModel bo) throws IllegalAccessException{
		if(null == bo){
			throw new IllegalAccessException("SingerModel can not be null");
		}
		
		SingerEntity po = new SingerEntity();
		po.setActorId(bo.getActorId());
		po.setBriefIntroduction(bo.getBriefIntroduction());
		po.setDisplayAddr(bo.getDisplayAddr());
		po.setDisplayPrice(bo.getDisplayPrice());
		po.setLevelScore(bo.getLevelScore());
		po.setMainImageName(bo.getMainImageName());
		po.setRepresantiveWork(bo.getRepresantiveWork());
		po.setSecondImageName(bo.getSecondImageName());
		po.setSkilledStyle(bo.getSkilledStyle());
		po.setStandardDisplay(bo.getStandardDisplay());
		
		return po;
	}
	
	/**
	 * singer 数据层对象转为业务层对象
	 * @param po
	 * @return
	 * @throws IllegalAccessException
	 */
	public static SingerModel singerP2B(SingerEntity po) throws IllegalAccessException{
		if(null == po){
			throw new IllegalAccessException("SingerEntity can not be null");
		}
		
		SingerModel bo = new SingerModel();
		bo.setActorId(po.getActorId());
		bo.setBriefIntroduction(po.getBriefIntroduction());
		bo.setDisplayAddr(po.getDisplayAddr());
		bo.setDisplayPrice(po.getDisplayPrice());
		bo.setLevelScore(po.getLevelScore());
		bo.setMainImageName(po.getMainImageName());
		bo.setRepresantiveWork(po.getRepresantiveWork());
		bo.setSecondImageName(po.getSecondImageName());
		bo.setSkilledStyle(po.getSkilledStyle());
		bo.setStandardDisplay(po.getStandardDisplay());
		
		return bo;
	}
	
	
	/**
	 * singer 数据层对象批量转为业务层对象
	 * @param poList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<SingerModel> singerListP2B(List<SingerEntity> poList) throws IllegalAccessException{
		if(null == poList){
			throw new IllegalAccessException("poList can not be null");
		}
		
		List<SingerModel> boList = new ArrayList<>();
		for(SingerEntity po:poList){
			boList.add(singerP2B(po));
		}
		
		return boList;
	}
	
	
	/**
	 * singer 业务层对象批量转为数据层对象
	 * @param boList
	 * @return
	 * @throws IllegalAccessException
	 */
	public static List<SingerEntity> singerListB2P(List<SingerModel> boList) throws IllegalAccessException{
		if(null == boList){
			throw new IllegalAccessException("boList can not be null");
		}
		
		List<SingerEntity> poList = new ArrayList<>();
		for(SingerModel bo:boList){
			poList.add(singerB2P(bo));
		}
		
		return poList;
	}
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */