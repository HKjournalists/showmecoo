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
 * Created on 2016年7月6日
 *******************************************************************************/


package com.showmecoo.web.commons.dao;

import java.io.Serializable;

import org.springframework.data.repository.Repository;

/**
 * DAO层的基础接口，用于抽象各个dao的公共方法
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 * 
 * @param <T> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */

@Deprecated
public interface BasicDao<T, ID extends Serializable> extends Repository<T, ID> {
	
	/**
	 * create a record by given entity. Use the returned instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 * @param entity
	 */
	<S extends T> S create(S entity);
	
	/**
	 * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
	 * entity instance completely.
	 * 
	 * @param entity
	 * @return the saved entity
	 */
	<S extends T> S update(S entity);

	
//	/**
//	 * Deletes the entity with the given id.
//	 * 
//	 * @param id must not be {@literal null}.
//	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
//	 */
//	void delete(ID id);

	/**
	 * Deletes a given entity.
	 * 
	 * @param entity
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	void delete(T entity);

//	/**
//	 * Deletes the given entities.
//	 * 
//	 * @param entities
//	 * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
//	 */
//	void delete(Iterable<? extends T> entities);

//	/**
//	 * Deletes all entities managed by the repository.
//	 */
//	void deleteAll();
	
//	/**
//	 * 根据表指定字段查询一条纪录
//	 * @param attrName		字段名
//	 * @param value			字段值
//	 * @return
//	 */
//	T findEntityByAttr(String attrName, String value);
}

/*
 * 修改历史
 * $Log$ 
 */