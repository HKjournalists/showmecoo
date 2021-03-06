package com.showmecoo.web.commons.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Map;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * http restful api 调用客户端工具类
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class HttpClientUtil {

	private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

	private static PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

	static {
		connectionManager.setMaxTotal(100);
	}

	/**
	 * 
	 * @return
	 */
	public static CloseableHttpClient getCloseableHttpClient() {
		return HttpClients.custom().setConnectionManager(connectionManager).build();
	}

	/**
	 * close http client
	 * 
	 * @param client
	 */
	public static void closeClient(CloseableHttpClient client) {
		try {
			client.close();
		} catch (IOException e) {
			log.error("http client close failed", e);
		}
	}

	/**
	 * 
	 * 同步发送http get请求
	 * 
	 * @param client
	 * @param uri
	 *            带参数的请求uri e.g http://localhost:8080/1/users/query/mac
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws ClientProtocolException
	 */
	public static CloseableHttpResponse syncSendGetRequest(CloseableHttpClient client, String uri)
			throws IOException, IllegalAccessException {

		CloseableHttpResponse response = null;

		HttpGet getRequest = new HttpGet(uri);
		getRequest.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		getRequest.setHeader(HttpHeaders.ACCEPT_CHARSET, "UTF-8");

		response = client.execute(getRequest);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			log.error("failed : HTTP error code : {}", statusCode);
			throw new IllegalAccessException("failed : HTTP error code : " + statusCode);
		}

		return response;
	}


	/**
	 * 同步发送http get请求, 并使用http://path:port/uri?param=vlue方式请求
	 * 
	 * @param client
	 *            HttpClient
	 * @param uri
	 *            不带参数的请求uri e.g http://localhost:8080/1/users/query
	 * @param params
	 *            请求参数map
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws IllegalAccessException
	 */
	public static CloseableHttpResponse syncSendGetRequestWithParams(CloseableHttpClient client, String uri,
			Map<String, String> params) throws URISyntaxException, IOException, IllegalAccessException {

		CloseableHttpResponse response = null;
		URIBuilder uriBuilder = new URIBuilder(uri);
		if (null != params) {
			for (String key : params.keySet()) {
				uriBuilder.setParameter(key, params.get(key));
			}
		}

		HttpGet getRequest = new HttpGet(uriBuilder.build());
		getRequest.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		getRequest.setHeader(HttpHeaders.ACCEPT_CHARSET, "UTF-8");

		System.out.println(getRequest.getURI());
		response = client.execute(getRequest);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			log.error("failed : HTTP error code : {}", statusCode);
			throw new IllegalAccessException("failed : HTTP error code : " + statusCode);
		}

		return response;
	}

	/**
	 * 根据response获取返回的json串
	 * 
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws UnsupportedOperationException
	 */
	public static String getResponseContent(CloseableHttpResponse response)
			throws UnsupportedOperationException, IOException {
		StringBuffer sbf = new StringBuffer();
		BufferedReader br = null;
		if (null != response) {

			try {
				InputStream in = response.getEntity().getContent();
				br = new BufferedReader(new InputStreamReader(in, "UTF-8"));

				String content = null;
				while ((content = br.readLine()) != null) {
					sbf.append(content);
				}
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return sbf.toString();
	}

	/**
	 * 根据httpClient uri和post请求参数 发送post 请求
	 * 
	 * @param client
	 *            HttpClient连接客户端
	 * @param uri
	 *            post请求uri e.g http://localhost:8080/1/users/create/
	 * @param params
	 *            请求参数，Map类型
	 * @return
	 */
	// public static CloseableHttpResponse
	// syncSendPostRequest(CloseableHttpClient client, String uri, Map<String,
	// String> params){
	// CloseableHttpResponse response = null;
	// HttpPost postReq = new HttpPost(uri);
	// postReq.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
	// postReq.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
	// postReq.setHeader(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
	//// postReq.setHeader(HttpHeaders.);
	// List<NameValuePair> list = new ArrayList<NameValuePair>();
	// if(null != params){
	// for(String key:params.keySet()){
	// BasicNameValuePair valuePair = new BasicNameValuePair(key,
	// params.get(key));
	// list.add(valuePair);
	// }
	//
	// if(list.size() > 0){
	// try {
	// UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
	// postReq.setEntity(entity);
	// entity.setContentEncoding(new BasicHeader(HttpHeaders.CONTENT_TYPE,
	// MediaType.APPLICATION_JSON));
	// } catch (UnsupportedEncodingException e) {
	// log.error("construct urlEncodedFromEntity failed", e);
	// }
	// }
	// }
	//
	// try {
	// response = client.execute(postReq);
	// int statusCode = response.getStatusLine().getStatusCode();
	// if (statusCode != HttpStatus.SC_OK) {
	// log.error("failed : HTTP error code : {}", statusCode);
	// return null;
	// }
	// } catch (IOException e) {
	// log.error("send post request failed", e);
	// }
	//
	// return response;
	//
	// }

	/**
	 * 同步发送post请求
	 * @param client					HttpClient连接客户端
	 * @param uri						post请求uri e.g http://localhost:8080/1/users/create/ 	
	 * @param jsonStr					json参数，复杂对象的json串
	 * @return
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static CloseableHttpResponse syncSendPostRequest(CloseableHttpClient client, String uri, String jsonStr)
			throws IllegalAccessException, IOException {
		CloseableHttpResponse response = null;
		HttpPost postReq = new HttpPost(uri);
		postReq.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		postReq.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
		postReq.setHeader(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
		StringEntity se = new StringEntity(jsonStr, "UTF-8");
		postReq.setEntity(se);
		response = client.execute(postReq);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			log.error("failed : HTTP error code : {}", statusCode);
			throw new IllegalAccessException("failed : HTTP error code : " + statusCode);
		}

		return response;

	}

	/**
	 * 同步发送PUT请求
	 * 
	 * @param client
	 * @param uri
	 *            不带参数的PUT请求URI
	 * @param jsonStr
	 *            PUT请求参数的json串
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws IllegalAccessException
	 */
	public static CloseableHttpResponse syncSendPutRequest(CloseableHttpClient client, String uri, String jsonStr)
			throws ClientProtocolException, IOException, IllegalAccessException {
		CloseableHttpResponse response = null;
		HttpPut putReq = new HttpPut(uri);
		putReq.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		putReq.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
		putReq.setHeader(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
		StringEntity se = new StringEntity(jsonStr, "UTF-8");
		putReq.setEntity(se);
		response = client.execute(putReq);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			log.error("failed : HTTP error code : {}", statusCode);
			throw new IllegalAccessException("failed : HTTP error code : " + statusCode);
		}

		return response;
	}

	/**
	 * 根据userid删除用户
	 * 
	 * @param client
	 * @param uri
	 *            带参数的请求uri e.g http://localhost:8080/1/users/delete/123455
	 * @return
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static CloseableHttpResponse syncSendDeleteRequest(CloseableHttpClient client, String uri)
			throws IllegalAccessException, ClientProtocolException, IOException {
		CloseableHttpResponse response = null;
		HttpDelete getRequest = new HttpDelete(uri);
		getRequest.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		getRequest.setHeader(HttpHeaders.ACCEPT_CHARSET, "UTF-8");

		response = client.execute(getRequest);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != HttpStatus.SC_OK) {
			log.error("failed : HTTP error code : {}", statusCode);
			throw new IllegalAccessException("failed : HTTP error code : " + statusCode);
		}

		return response;
	}

}
