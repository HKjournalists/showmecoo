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


package com.showmecoo.web.commons.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class EncryptUtil {
	
	public static final String encrypt_type_md5 = "MD5";
	public static final String ENCRYPT_TYPE_SHA1 = "SHA-1";
	public static final String ENCRYPT_TYPE_SHA256 = "SHA-256";
	/** 
     * @param str 需要加密的字符串 
     * @param encName 加密种类  MD5 SHA-1 SHA-256 
     * @return 
     * @Description: 实现对字符串的加密 
     */  
    public static String encrypt(String str, String encName){  
        String reStr = null;  
        try {  
            MessageDigest md5 = MessageDigest.getInstance(encName);  
            byte[] bytes = md5.digest(str.getBytes());  
            StringBuffer stringBuffer = new StringBuffer();  
            for (byte b : bytes){  
                int bt = b&0xff;  
                if (bt < 16){  
                    stringBuffer.append(0);  
                }   
                stringBuffer.append(Integer.toHexString(bt));  
            }  
            reStr = stringBuffer.toString();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return reStr;  
    }  
    
    public static void main(String[] args) {
		String str = EncryptUtil.encrypt("main", "SHA-1");
		System.out.println(str);
	}
}

/*
 * 修改历史
 * $Log$ 
 */