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
 * Created on 2016年7月24日
 *******************************************************************************/


package com.showmecoo.web.commons.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.showmecoo.web.commons.bo.RoleModel;

/**
 * 可以以Json格式序列化和反序列化的分页对象
 *
 *<br/>
	 * JsonablePageImpl 序列化和反序列化方式
	 * <pre>
	 * 序列化：<br/>
	 * JsonablePageImpl<RoleModel> p = new JsonablePageImpl<>();
		List<RoleModel> list = new ArrayList<>();
		RoleModel role = new RoleModel();
		role.setCreateDate(new Date());
		role.setCreateUserId("123");
		role.setModifyDate(new Date());
		role.setModifyUserId("23");
		role.setRoleDesc("user");
		role.setRoleId(231);
		role.setRoleName("role");
		list.add(role);
		p.setContent(list);
		String jstr = FastJsonUtil.Object2String(p);
	 * </pre>
	 * <pre>
	 * 反序列化：<br/>
	 * JsonablePageImpl<RoleModel> np = FastJsonUtil.string2Object(jstr, JsonablePageImpl.class);
	 * List nlist = np.getContent();
	 * 
	 * List<RoleModel> content = new ArrayList<>();
	 * for(int i=0; i &lt nlist.size(); i++){ 
	 *	JSONObject s = (JSONObject) nlist.get(i);
	 *	RoleModel r = FastJsonUtil.jsonObj2JavaObject(s, RoleModel.class);
	 *	content.add(r);
	 * }
	 * np.setContent(content);
	 * </pre>
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 * @param <T>
 */

public class JsonablePageImpl<T> implements Serializable{
	
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 5440938541803224976L;
	/*
	 * {
    "totalElements": 1,
    "totalPages": 1,
    "size": 10,
    "content": [
        {
            "roleId": 1,
            "roleName": "user",
            "roleDesc": "normal user",
            "createUserId": "123",
            "createDate": 1469341383000,
            "modifyUserId": "456",
            "modifyDate": 1469341383000
        }
    ],
    "number": 0,
   // "sort": null, 暂时不提供
    "numberOfElements": 1,
    "first": true,
    "last": true
}
	 */
	private long totalElements;
	private int totalPages;
	private int size;
	private int number;
	private int numberOfElements;
	private boolean first;
	private boolean last;
	private List<T> content;
	
	/**
	 * @return Returns the totalElements.
	 */
	public long getTotalElements() {
		return totalElements;
	}
	/**
	 * @param totalElements The totalElements to set.
	 */
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	/**
	 * @return Returns the totalPages.
	 */
	public int getTotalPages() {
		return totalPages;
	}
	/**
	 * @param totalPages The totalPages to set.
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	/**
	 * @return Returns the size.
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size The size to set.
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return Returns the number.
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number The number to set.
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return Returns the numberOfElements.
	 */
	public int getNumberOfElements() {
		return numberOfElements;
	}
	/**
	 * @param numberOfElements The numberOfElements to set.
	 */
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	/**
	 * @return Returns the first.
	 */
	public boolean isFirst() {
		return first;
	}
	/**
	 * @param first The first to set.
	 */
	public void setFirst(boolean first) {
		this.first = first;
	}
	/**
	 * @return Returns the last.
	 */
	public boolean isLast() {
		return last;
	}
	/**
	 * @param last The last to set.
	 */
	public void setLast(boolean last) {
		this.last = last;
	}
	/**
	 * @return Returns the content.
	 */
	public List<T> getContent() {
		return content;
	}
	/**
	 * @param content The content to set.
	 */
	public void setContent(List<T> content) {
		this.content = content;
	}
	
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonablePageImpl [totalElements=" + totalElements + ", totalPages=" + totalPages + ", size=" + size
				+ ", number=" + number + ", numberOfElements=" + numberOfElements + ", first=" + first + ", last="
				+ last + ", content=" + content + "]";
	}
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		JsonablePageImpl<RoleModel> p = new JsonablePageImpl<>();
		List<RoleModel> list = new ArrayList<>();
		RoleModel role = new RoleModel();
		role.setCreateDate(new Date());
		role.setCreateUserId("123");
		role.setModifyDate(new Date());
		role.setModifyUserId("23");
		role.setRoleDesc("user");
		role.setRoleId(231);
		role.setRoleName("role");
		list.add(role);
		p.setContent(list);
		String jstr = FastJsonUtil.Object2String(p);
		System.out.println(jstr);
		JsonablePageImpl<RoleModel> np = FastJsonUtil.string2Object(jstr, JsonablePageImpl.class);
		List nlist = np.getContent();
		List<RoleModel> content = new ArrayList<>();
		for(int i=0; i<nlist.size(); i++){
			JSONObject s = (JSONObject) nlist.get(i);
			RoleModel r = FastJsonUtil.jsonObj2JavaObject(s, RoleModel.class);
			content.add(r);
		}
		np.setContent(content);
	}
	
}

/*
 * 修改历史
 * $Log$ 
 */