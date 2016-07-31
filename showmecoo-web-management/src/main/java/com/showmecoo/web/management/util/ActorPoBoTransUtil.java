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
import com.showmecoo.web.management.entity.ActorEntity;
import com.showmecoo.web.management.entity.CompereEntity;

/**
 * Actor 业务层对象实例与数据层对象实例转换工具类
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class ActorPoBoTransUtil {
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */