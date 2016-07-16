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
 * Created on 2016年7月15日
 *******************************************************************************/


package com.showmecoo.web.commons.http;

import static org.junit.Assert.fail;

import java.util.Date;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Assert;
import org.junit.Test;

import com.showmecoo.web.commons.bo.UserModel;
import com.showmecoo.web.commons.util.FastJsonUtil;

public class HttpClientUtilTestCase {

	@Test
	public void testGetCloseableHttpClient() {
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		Assert.assertNotNull(client);
		System.out.println(client);
	}

	@Test
	public void testCloseClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testSyncSendGetRequest() {
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/users/query/mac";
//		Map<String, String> params = new HashMap<>();
//		params.put("userName", "mac");
		CloseableHttpResponse response = HttpClientUtil.syncSendGetRequest(client, uri);
		Assert.assertNotNull(response);
		String content = HttpClientUtil.getResponseContent(response);
		System.out.println(content);
	}

	@Test
	public void testGetResponseContent() {
		fail("Not yet implemented");
	}

	@Test
	public void testSyncSendPostRequest() {
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/users/create/";
		
		UserModel user = new UserModel();
		user.setUserName("mac1");
		user.setPassword("1234");
		user.setPhone("123456789");
		user.setEmail("ss@aa.com");
		user.setRolename("admin");
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		user.setLastLoginDate(new Date());
		user.setOpenId("1234");
		
		String jsonStr = FastJsonUtil.Object2String(user);
		 
		CloseableHttpResponse response = HttpClientUtil.syncSendPostRequest(client, uri, jsonStr);
		Assert.assertNotNull(response);
		String content = HttpClientUtil.getResponseContent(response);
		System.out.println(content);
		
	}

	@Test
	public void testSyncSendPutRequest() {
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/users/update/";
		
		UserModel user = new UserModel();
		user.setUserId("402881e755f44e5b0155f44e7a1a0000");
		user.setUserName("mac1");
		user.setPassword("1234");
		user.setPhone("123456789");
		user.setEmail("ss@aa.com");
		user.setRolename("normal");
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		user.setLastLoginDate(new Date());
		user.setOpenId("1234");
		
		String jsonStr = FastJsonUtil.Object2String(user);
		 
		CloseableHttpResponse response = HttpClientUtil.syncSendPutRequest(client, uri, jsonStr);
		Assert.assertNotNull(response);
		String content = HttpClientUtil.getResponseContent(response);
		System.out.println(content);
	}

	@Test
	public void testSyncSendDeleteRequest() {
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/users/delete/402881e755f44e5b0155f44e7a1a0000";
//		Map<String, String> params = new HashMap<>();
//		params.put("userName", "mac");
		CloseableHttpResponse response = HttpClientUtil.syncSendDeleteRequest(client, uri);
		Assert.assertNotNull(response);
		String content = HttpClientUtil.getResponseContent(response);
		System.out.println(content);
	}

}

/*
 * 修改历史
 * $Log$ 
 */