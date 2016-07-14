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
 * Created on 2016年7月8日
 *******************************************************************************/


package com.showmecoo.web.commons.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * 所有模块dao repository的基础父类
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 * @param <T>
 */
@Deprecated
@Repository
@Transactional
@NoRepositoryBean
public class BasicRepository<T, ID extends Serializable> implements BasicDao<T, ID>{
	
	 @PersistenceContext
	  private EntityManager entityManager;
	

	/* (non-Javadoc)
	 * @see com.showmecoo.web.commons.dao.BaseDao#create(java.lang.Object)
	 */
	@Override
	public <S extends T> S create(S entity) {
		if(null == entity){
			entityManager.persist(entity);
		}else{
			//TODO log
		}
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.commons.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public <S extends T> S update(S entity) {
		if(entity != null){
			entityManager.merge(entity);
		}
		return entity;
	}


	/* (non-Javadoc)
	 * @see com.showmecoo.web.commons.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(T entity) {
		if(null != entity){
			entityManager.remove(entity);
		}
	}



}

/*
 * 修改历史
 * $Log$ 
 */