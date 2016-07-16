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

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class SimpleDateFormateHolder {

	public static final String DEFAULT_PATTER = "yyyy-MM-dd HH:MM:SS";
	
	private static final String NULL_PATTERN = "_null";
	
	private static ThreadLocal<HashMap<String, SimpleDateFormat>>  mapTable = new ThreadLocal<HashMap<String, SimpleDateFormat>>(){

		@Override
		protected HashMap<String, SimpleDateFormat> initialValue() {
			return new HashMap<String,SimpleDateFormat>();
		}
		
	};

	public static SimpleDateFormat getThreadLocalSimpleDateFormat(String pattern) {
		if (pattern==null){
			pattern = NULL_PATTERN;
		}
		
		HashMap<String, SimpleDateFormat> map = mapTable.get();
		SimpleDateFormat obj = map.get(pattern);
		if (obj!=null)
			return obj;
		
		//make pattern
		if (pattern.equals(NULL_PATTERN)){
			obj = new SimpleDateFormat();
		}else{
			obj = new SimpleDateFormat(pattern);
		}
		
		map.put(pattern, obj);
		return obj;
	}
	
	public static void main(String[] args) {
		getThreadLocalSimpleDateFormat("yyyyMMdd");
		getThreadLocalSimpleDateFormat("yyyyMMdd");
		getThreadLocalSimpleDateFormat("yyyyMMdd");
		
		getThreadLocalSimpleDateFormat(null);
		getThreadLocalSimpleDateFormat(null);
	}

}

/*
 * 修改历史
 * $Log$ 
 */