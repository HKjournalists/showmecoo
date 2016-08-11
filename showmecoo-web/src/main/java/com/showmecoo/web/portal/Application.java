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
 * Created on 2016年8月11日
 *******************************************************************************/

package com.showmecoo.web.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@SpringBootApplication
@ComponentScan(value = {"com.showmecoo.web", "com.showmecoo.web.commons"} )
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/*
 * 修改历史 $Log$
 */