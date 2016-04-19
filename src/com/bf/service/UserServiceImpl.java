package com.bf.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bf.base.AbstractBaseDao;
import com.bf.entity.User;
@Service
public class UserServiceImpl extends AbstractBaseDao<User, Integer> implements UserService {

}
