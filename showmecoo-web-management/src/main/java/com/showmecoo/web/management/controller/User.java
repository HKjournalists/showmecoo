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
 * Created on 2016年7月26日
 *******************************************************************************/


package com.showmecoo.web.management.controller;

import java.io.Serializable;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class User implements Serializable{

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2595124144431240669L;
	
	private String name;
	private int age;
	private boolean hasMoney;
	
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the age.
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age The age to set.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
	/**
	 * @return Returns the hasMoney.
	 */
	public boolean isHasMoney() {
		return hasMoney;
	}
	/**
	 * @param hasMoney The hasMoney to set.
	 */
	public void setHasMoney(boolean hasMoney) {
		this.hasMoney = hasMoney;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	

}

/*
 * 修改历史
 * $Log$ 
 */