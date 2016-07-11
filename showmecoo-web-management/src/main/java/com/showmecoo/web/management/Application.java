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
 * Created on 2016年7月10日
 *******************************************************************************/


package com.showmecoo.web.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@SpringBootApplication
@ComponentScan("com.showmecoo.web")
//@EnableJpaRepositories(basePackages = "com.showmecoo.web.management.user.app")
//@EntityScan(basePackages = "com.showmecoo.web.management.user.app")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/*
 * 修改历史
 * $Log$ 
 */