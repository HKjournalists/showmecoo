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

import java.util.ArrayList;
import java.util.List;

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
public class ThymeleafSampleController {
	
	@RequestMapping(path={"/","/index"},method=RequestMethod.GET)
	public String index(ModelMap map){
		map.addAttribute("showmecoo", "showmecoo");
		List<User> users = new ArrayList<User>();
		for(int i=0; i<2; i++){
			User u = new User();
			u.setAge(i);
			u.setName("u"+i);
			u.setHasMoney(true);
			users.add(u);
		}
		map.addAttribute("users", users);
		return "view/thymeleafSample";
	}
}

/*
 * 修改历史
 * $Log$ 
 */