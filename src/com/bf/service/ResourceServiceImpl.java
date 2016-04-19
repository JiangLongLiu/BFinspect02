package com.bf.service;

import org.springframework.stereotype.Service;

import com.bf.base.AbstractBaseDao;
import com.bf.entity.Resource;
@Service
public class ResourceServiceImpl extends AbstractBaseDao<Resource, Integer> implements ResourceService {
	//添加资源 
	public void addResource(Integer pid,Resource res) {
		 if(pid!=0) {
			 //说明存在父节点
			 res.setParent(findById(pid));
		 }
		 save(res);
	 }
	
	//修改资源
	public void updateResource(Integer pid,Resource res) {
		 if(pid!=0) {
			 //说明存在父节点
			 res.setParent(findById(pid));
		 }
		 update(res);
	}
}
