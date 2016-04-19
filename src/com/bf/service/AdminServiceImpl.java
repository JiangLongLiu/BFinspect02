package com.bf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bf.base.AbstractBaseDao;
import com.bf.entity.Admin;
@Service
public class AdminServiceImpl extends AbstractBaseDao<Admin, Integer> implements AdminService {
	//登陆
	public Admin login(String account,String password) {
		String xql = "from Admin adm where adm.flag=? and adm.account=? and adm.password=?";
		List<Object> params = new ArrayList<Object>();
		params.add(1);
		params.add(account);
		params.add(password);
		return findByKeys(xql,params.toArray());
	}
}
