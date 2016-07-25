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
 * Created on 2016年7月24日
 *******************************************************************************/


package com.showmecoo.web.management.spi.dao.impl;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.PageImpl;

import com.alibaba.fastjson.JSONObject;
import com.showmecoo.web.commons.http.HttpClientUtil;
import com.showmecoo.web.commons.util.FastJsonUtil;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class RoleManagerServiceImplTestCase {
	
	@Test
	public void testFileRoleById() throws IllegalAccessException, IOException{
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/roles/q/i/1";
		CloseableHttpResponse response = HttpClientUtil.syncSendGetRequest(client, uri);
		Assert.assertNotNull(response);
		System.out.println(FastJsonUtil.Object2String(response));
		System.out.println(HttpClientUtil.getResponseContent(response));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll(){
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/roles/q/list";
		try {
			CloseableHttpResponse response = HttpClientUtil.syncSendGetRequest(client, uri);
			Assert.assertNotNull(response);
			System.out.println(FastJsonUtil.Object2String(response));
			String responseContent = HttpClientUtil.getResponseContent(response);
			System.out.println(responseContent);
//			PageImpl boPage = FastJsonUtil.string2Object(responseContent, PageImpl.class);
			
//			FastJsonUtil.
//			Assert.assertNotNull(boPage);
//			List<RoleModel> boList = boPage.getContent();
//			System.out.println(boPage.getTotalElements());
			
		} catch (IllegalAccessException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*
 * 修改历史
 * $Log$ 
 */