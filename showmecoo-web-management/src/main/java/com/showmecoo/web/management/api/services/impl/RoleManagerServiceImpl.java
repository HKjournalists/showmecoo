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


package com.showmecoo.web.management.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.showmecoo.web.commons.bo.RoleModel;
import com.showmecoo.web.commons.util.JsonablePageImpl;
import com.showmecoo.web.management.api.service.IRoleManagerService;
import com.showmecoo.web.management.entity.RoleEntity;
import com.showmecoo.web.management.spi.repository.RoleRepository;
import com.showmecoo.web.management.util.PoBoTransUtil;

/**
 * 角色管理对外接口实现类
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */
@Service
public class RoleManagerServiceImpl implements IRoleManagerService{

	private static Logger log = LoggerFactory.getLogger(RoleManagerServiceImpl.class);
	
	@Autowired
	private RoleRepository roleRepository;
	
	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IRoleManagerService#createRole(com.showmecoo.web.commons.bo.RoleModel)
	 */
	@Override
	public RoleModel createRole(RoleModel bo) throws Throwable {
		RoleEntity po = null;
		if(null == bo){
			throw new IllegalAccessException("roleModel can not be null, roleModel: " + bo);
		}
		po = PoBoTransUtil.roleB2P(bo);
		log.debug("call createRole restful api, bo:{}", bo);
		return PoBoTransUtil.roleP2B(roleRepository.save(po));
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IRoleManagerService#deleteRole(int)
	 */
	@Override
	public void deleteRole(int roleId) throws Throwable {
		log.debug("call deleteRole restful api, roleid:{}", roleId);
		roleRepository.delete(roleId);
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IRoleManagerService#updateRole(com.showmecoo.web.commons.bo.RoleModel)
	 */
	@Override
	public RoleModel updateRole(RoleModel bo) throws Throwable {
		if(null == bo){
			throw new IllegalAccessException("roleModel can not be null ");
		}
		RoleEntity po = PoBoTransUtil.roleB2P(bo);

		log.debug("call updateRole restful api, bo:{}", bo);
		
		return PoBoTransUtil.roleP2B(roleRepository.save(po));
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IRoleManagerService#findRoleById(java.lang.String)
	 */
	@Override
	public RoleModel findRoleById(int roleId) throws Throwable {
		log.debug("call findRoleById restful api, roleid:{}", roleId);
		
		return PoBoTransUtil.roleP2B(roleRepository.findOne(roleId));
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IRoleManagerService#findRoleByName(java.lang.String)
	 */
	@Override
	public RoleModel findRoleByName(String roleName) throws Throwable {
		if(null == roleName){
			throw new IllegalAccessException("role name can not be null");
		}
		log.debug("call findRoleByName restful api, roleName:{}", roleName);
		
		return PoBoTransUtil.roleP2B(roleRepository.findRoleByName(roleName));
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IRoleManagerService#findAllRoles()
	 */
	@Override
	public JsonablePageImpl<RoleModel> findAllRoles() throws Throwable {
		PageRequest pageable = new PageRequest(0, 10);
		Page<RoleEntity> poPage = roleRepository.findAll(pageable);
		
		JsonablePageImpl<RoleModel> jsonablePage = new JsonablePageImpl<>();
		jsonablePage.setContent(PoBoTransUtil.roleListP2B(poPage.getContent()));
		jsonablePage.setFirst(poPage.isFirst());
		jsonablePage.setLast(poPage.isLast());
		jsonablePage.setNumber(poPage.getNumber());
		jsonablePage.setNumberOfElements(poPage.getNumberOfElements());
		jsonablePage.setSize(poPage.getSize());
		jsonablePage.setTotalElements(poPage.getTotalElements());
		jsonablePage.setTotalPages(poPage.getTotalPages());
		
		return jsonablePage;
	}

	/* (non-Javadoc)
	 * @see com.showmecoo.web.management.api.IRoleManagerService#findRolesWithPageable(int, int)
	 */
	@Override
	public JsonablePageImpl<RoleModel> findRolesWithPageable(int page, int size) throws Throwable {
		PageRequest pageable = new PageRequest(page, size);
		Page<RoleEntity> poPage = roleRepository.findAll(pageable);
		
		JsonablePageImpl<RoleModel> jsonablePage = new JsonablePageImpl<>();
		jsonablePage.setContent(PoBoTransUtil.roleListP2B(poPage.getContent()));
		jsonablePage.setFirst(poPage.isFirst());
		jsonablePage.setLast(poPage.isLast());
		jsonablePage.setNumber(poPage.getNumber());
		jsonablePage.setNumberOfElements(poPage.getNumberOfElements());
		jsonablePage.setSize(poPage.getSize());
		jsonablePage.setTotalElements(poPage.getTotalElements());
		jsonablePage.setTotalPages(poPage.getTotalPages());
		
		return jsonablePage;
	}

}

/*
 * 修改历史
 * $Log$ 
 */