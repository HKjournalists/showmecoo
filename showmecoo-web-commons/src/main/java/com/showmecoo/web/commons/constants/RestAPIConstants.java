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
	public static final String URI_MODULE_USERS = URI_SEPERATOR + "users";//用户，包括微信用户和网页用户
	public static final String URI_MODULE_ROLES = URI_SEPERATOR + "roles";//角色
	public static final String URI_MODULE_ORDERS = URI_SEPERATOR + "orders";//订单
	public static final String URI_MODULE_ACTORS = URI_SEPERATOR + "actors";//艺人
	public static final String URI_MODULE_WORKS = URI_SEPERATOR + "works";//作品
	
	
	public static final String OPERATION_TYPE_QUERY = "/q";
	public static final String OPERATION_TYPE_CREATE = "/c";
	public static final String OPERATION_TYPE_UPDATE = "/u";
	public static final String OPERATION_TYPE_DELETE = "/d";
	
	/**
	 * 微信端操作
	 */
	public static final String OPERATION_USER_WECHAT = "/wechat";
	
	/**
	 * 根据user表字段的查询前缀，用于区分URI
	 */
	public static final String OPERATION_FIND_USER = "/1";
	/**
	 * 根据wechat_user_info表字段查询前缀，用于区分URI
	 */
	public static final String OPERATION_FIND_WECHAT = "/2";
	
	
	public static final String PARAM_QUERY_NAME = "/n";//查询参数为name
	public static final String PARAM_QUERY_ID = "/i";//查询参数为id
	public static final String PARAM_QUERY_ALL = "/list";//查询所有
	
	/**
	 * 艺人相关操作前缀
	 */
	public static final String OPTION_ACTOR_ACTOR = "/actor";
	public static final String OPTION_ACTOR_DANCER = "/dancer";
	public static final String OPTION_ACTOR_SINGER = "/singer";
	public static final String OPTION_ACTOR_MODEL = "/model";
	public static final String OPTION_ACTOR_COMPERE = "/compere";
}
