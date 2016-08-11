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


package com.showmecoo.web.portal.wechat.controller;

import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;

import com.showmecoo.web.commons.util.EncryptUtil;
import com.showmecoo.web.portal.config.WechatConfigUtil;

/**
 * 与微信服务器作交互验证
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

@Controller
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/checkSignature")
public class WechatServerCheckController {
	
	/*
	 * 加密/校验流程如下：
1. 将token、timestamp、nonce三个参数进行字典序排序
2. 将三个参数字符串拼接成一个字符串进行sha1加密
3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 */
	public boolean checkSignature(@QueryParam("token")String token, @QueryParam("timestamp")String timestamp, @QueryParam("nonce")String nonce, @QueryParam("signature")String signature){
		String[] arr = new String[]{WechatConfigUtil.WECHAT_CHECK_SIGNATURE_TOKEN, timestamp, nonce};
		Arrays.sort(arr);
		StringBuffer sbf = new StringBuffer();
		for(String str:arr){
			sbf.append(str);
		}
		String encryptStr = EncryptUtil.encrypt(sbf.toString(), EncryptUtil.ENCRYPT_TYPE_SHA1);
		return signature == null ? false : encryptStr.equals(signature);
	} 
}

/*
 * 修改历史
 * $Log$ 
 */