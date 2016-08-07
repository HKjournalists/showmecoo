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
	 * 用户－user相关操作前缀
	 */
	public static final String OPTION_USER_USER = "/user";
	/**
	 * 用户－wechat微信相关操作前缀
	 */
	public static final String OPTION_USER_WECHAT = "/wechat";
	
	/**
	 * 根据user表字段的查询前缀，用于区分URI
	 */
	public static final String OPERATION_FIND_USER = "/1";
	/**
	 * 根据wechat_user_info表字段查询前缀，用于区分URI
	 */
	public static final String OPERATION_FIND_WECHAT = "/2";
	
	/**
	 * 查询参数为name
	 */
	public static final String QUERY_PARAM_NAME = "/n";//查询参数为name
	/**
	 * 查询参数为id
	 */
	public static final String QUERY_PARAM_ID = "/i";//查询参数为id
	/**
	 * 查询所有
	 */
	public static final String QUERY_PARAM_ALL = "/all";//查询所有
	public static final String QUERY_PARAM_LIST = "/list";//查询部分

	
	
//-----------------------------------------------------------艺人相关操作前缀-------------------------------------------------
	/**
	 * 艺人－actor相关操作前缀
	 */
	public static final String OPTION_ACTOR_ACTOR = "/actor";
	/**
	 * 艺人－dancer相关操作前缀
	 */
	public static final String OPTION_ACTOR_DANCER = "/dancer";
	/**
	 * 艺人－singer相关操作前缀
	 */
	public static final String OPTION_ACTOR_SINGER = "/singer";
	/**
	 * 艺人－model相关操作前缀
	 */
	public static final String OPTION_ACTOR_MODEL = "/model";
	/**
	 * 艺人－compere相关操作前缀
	 */
	public static final String OPTION_ACTOR_COMPERE = "/compere";
	
//-----------------------------------------------------------作品相关操作前缀-------------------------------------------------
	/**
	 * 作品－图片相关操作前缀
	 */
	public static final String OPTION_WORK_PICTURE = "/picture";
	
	/**
	 * 作品－视频相关操作前缀
	 */
	public static final String OPTION_WORK_VIDEO = "/video";
	
}
