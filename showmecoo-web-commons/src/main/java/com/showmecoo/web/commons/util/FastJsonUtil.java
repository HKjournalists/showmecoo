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
 * Created on 2016年7月16日
 *******************************************************************************/


package com.showmecoo.web.commons.util;

import com.alibaba.fastjson.JSON;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class FastJsonUtil {

	
	/**
	 * parse object to string
	 * @param obj
	 * @return
	 */
	public static String Object2String(Object obj){
		return JSON.toJSONString(obj);
	}
	
	/**
	 * parse string to object
	 * @param data
	 * @param clazz
	 * @return
	 */
	public static <T> T string2Object(String data,Class<T> clazz){
		return JSON.parseObject(data, clazz);
	}
	
	
	/**
	 * parse json object to java object
	 * @param jsonObj
	 * @param clazz
	 * @return
	 */
	public static <T> T jsonObj2JavaObject(JSON jsonObj,Class<T> clazz){
		return JSON.toJavaObject(jsonObj, clazz);
	}
	
//	public static WFUserObject parseJsonObj2WFUserObject(Object obj){
//		WFUserObject userObject = null;
//		if(obj instanceof JSON){
//			JSONObject jsonObj = (JSONObject) obj;
//			WFWorkItem witem = JSON.toJavaObject(jsonObj, WFWorkItem.class);
//			System.out.println(witem);
//		}
//	}

}

/*
 * 修改历史
 * $Log$ 
 */