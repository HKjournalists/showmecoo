package com.showmecoo.web.commons.constants;

public class RestAPIConstants {
	
	/*
	 * restful api standard
	 * http://ip:port/api_version/module/operation(create/update/delete/query)/options...(list/id/name...)/parameter
	 * uri:http://ip:port//一级模块/操作/可选标识/参数	
	 */
	
	public static final String URI_SEPERATOR = "/";
	
	public static final String API_VERSION = URI_SEPERATOR + "1";
	
	//uri modules define
	public static final String URI_MODULE_USERS = URI_SEPERATOR + "users";
	public static final String URI_MODULE_ORDERS = URI_SEPERATOR + "orders";
	public static final String URI_MODULE_ACTORS = URI_SEPERATOR + "actors";
	public static final String URI_MODULE_WORKS = URI_SEPERATOR + "works";
	
	
	public static final String OPERATION_TYPE_GET = "/query";
	public static final String OPERATION_TYPE_POST = "/create";
	public static final String OPERATION_TYPE_PUT = "/update";
	public static final String OPERATION_TYPE_DELETE = "/delete";
}
