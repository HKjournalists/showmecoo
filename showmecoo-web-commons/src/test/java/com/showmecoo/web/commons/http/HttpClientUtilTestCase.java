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

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
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
	public void testSyncSendGetRequest() throws IllegalAccessException, IOException {
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
	public void testSyncSendGetRequestWithParam() throws URISyntaxException, IllegalAccessException, IOException{
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/hello/say";
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "mac");
		CloseableHttpResponse response = HttpClientUtil.syncSendGetRequestWithParams(client, uri, params);
		System.out.println(HttpClientUtil.getResponseContent(response));
		
	}

	@Test
	public void testGetResponseContent() {
		fail("Not yet implemented");
	}

	@Test
	public void testSyncSendPostRequest() throws IllegalAccessException, IOException {
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/users/create/";
		
		UserModel user = new UserModel();
		user.setUserName("mac2");
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
	public void testSyncSendPutRequest() throws ClientProtocolException, IllegalAccessException, IOException {
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/users/update/";
		
		UserModel user = new UserModel();
		user.setUserId("402881e755fdfa890155fdfa90510000");
		user.setUserName("mac1");
		user.setPassword("1234");
		user.setPhone("123456789");
		user.setEmail("ss2@aa.com");
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
	public void testSyncSendDeleteRequest() throws IllegalAccessException, ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/users/delete/402881e755fdfa890155fdfa90510000";
//		Map<String, String> params = new HashMap<>();
//		params.put("userName", "mac");
		CloseableHttpResponse response = HttpClientUtil.syncSendDeleteRequest(client, uri);
		Assert.assertNull(response);
		String content = HttpClientUtil.getResponseContent(response);
		System.out.println(content);
	}

	
	@Test
	public void testFindUsersWithPageParam() throws IllegalAccessException, IOException{
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
		String uri = "http://localhost:8080/1/users/query/pageList/0/10";
		CloseableHttpResponse response = HttpClientUtil.syncSendGetRequest(client, uri);
		Assert.assertNotNull(response);
		System.out.println(HttpClientUtil.getResponseContent(response));
	}
	
	@Test
	public void testFindAll() throws IllegalAccessException, IOException{
		CloseableHttpClient client = HttpClientUtil.getCloseableHttpClient();
//		PageRequest pageable = new PageRequest(0, 10);
		String uri = "http://localhost:8080/1/users/query/list/all";
		CloseableHttpResponse response = HttpClientUtil.syncSendGetRequest(client, uri);
		Assert.assertNotNull(response);
		System.out.println(response);
	}
}

/*
 * 修改历史
 * $Log$ 
 */