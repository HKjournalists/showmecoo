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
 * Created on 2016年7月20日
 *******************************************************************************/


package com.showmecoo.web.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 管理应用的首页控制器
 * 
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Controller
//@Path("/")
public class IndexController {
	
	@RequestMapping(path={"/","/index"},method=RequestMethod.GET)
	public String index(ModelMap map){
		map.addAttribute("showmecoo", "showmecoo");
		return "view/index";
	}
}

/*
 * 修改历史
 * $Log$ 
 */