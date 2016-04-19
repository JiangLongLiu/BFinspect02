package com.bf.service;

import com.bf.base.BaseDao;
import com.bf.entity.Admin;

public interface AdminService extends BaseDao<Admin, Integer> {
	/**
	 * 登陆
	 * @param account
	 * @param password
	 * @return
	 */
   public Admin login(String account,String password);
}
