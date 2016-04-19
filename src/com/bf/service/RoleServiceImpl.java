package com.bf.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bf.base.AbstractBaseDao;
import com.bf.entity.Role;
@Service
@Transactional
public class RoleServiceImpl extends AbstractBaseDao<Role, Integer> implements RoleService {

}
