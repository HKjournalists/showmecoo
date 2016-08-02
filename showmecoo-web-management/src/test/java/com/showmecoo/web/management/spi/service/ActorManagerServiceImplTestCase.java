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
 * Created on 2016年8月2日
 *******************************************************************************/


package com.showmecoo.web.management.spi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.showmecoo.web.commons.bo.ActorModel;
import com.showmecoo.web.commons.http.HttpClientUtil;
import com.showmecoo.web.commons.util.FastJsonUtil;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.entity.ActorEntity;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class ActorManagerServiceImplTestCase {
	
	@Test
	public void testCreateActorModel(){
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/actors/c/actor";
		ActorEntity actor = new ActorEntity();
		actor.setAge(10);
		actor.setCreateTime(new Date());
		actor.setDisplayedNum(10);
		actor.setFansNum(100);
		actor.setHeight(170);
		actor.setImageName("image_singer_mac");
		actor.setName("lili");
		actor.setNickName("macly4");
		actor.setSex(1);
		actor.setType(1);
		actor.setVisitNum(10);
		String jsonStr = FastJsonUtil.Object2String(actor);
		try {
			CloseableHttpResponse response = HttpClientUtil.syncSendPostRequest(client, uri, jsonStr);
			String content = HttpClientUtil.getResponseContent(response);
			System.out.println(content);
			ActorModel nactor = FastJsonUtil.string2Object(content, ActorModel.class);
			System.out.println(nactor);
		} catch (IllegalAccessException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testFindAllActors(){
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/actors/q/actor/all";
		try {
			CloseableHttpResponse response = HttpClientUtil.syncSendGetRequest(client, uri);
			Assert.assertNotNull(response);
			String content = HttpClientUtil.getResponseContent(response);
			System.out.println(content);
			JsonablePageImpl<ActorModel> jsonable = FastJsonUtil.string2Object(content, JsonablePageImpl.class);
			List list = jsonable.getContent();
			List<ActorModel> nlist = new ArrayList<>();
			for(int i=0; i<list.size(); i++){
				JSONObject jo = (JSONObject) list.get(i);
				ActorModel actor = FastJsonUtil.jsonObj2JavaObject(jo, ActorModel.class);
				nlist.add(actor);
			}
			jsonable.setContent(nlist);
			System.out.println(jsonable);
		} catch (IllegalAccessException | IOException e) {
			e.printStackTrace();
		}
	}
}

/*
 * 修改历史
 * $Log$ 
 */