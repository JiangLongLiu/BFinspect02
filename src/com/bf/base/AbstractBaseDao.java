package com.bf.base;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.bf.common.Pager;
import com.bf.dao.Idao;
import com.bf.util.GetEntityClassUtil;

public abstract class AbstractBaseDao<T, PK extends Serializable> implements
		BaseDao<T, PK> {

	@Resource
	private Idao<T, PK> iDao;
	
	@SuppressWarnings("unchecked")
	private Class<T> entityClass = GetEntityClassUtil
			.getEntityClass(getClass());

	public void save(T entity) {
		iDao.save(entity);
	}

	public void update(T entity) {
       iDao.update(entity);
	}

	public List<T> findAll() {
		return iDao.findAll(entityClass);
	}
	public void delete(PK... pks) {
		iDao.delete(entityClass, pks);
	}

	public Pager<T> findByPage(String xql, int pageNo, int pageSize) {
		return iDao.findByPage(entityClass, xql, pageNo, pageSize);
	}

	public Pager<T> findByPage(String xql, Object key, int pageNo, int pageSize) {
		return iDao.findByPage(entityClass, xql, key, pageNo, pageSize);
	}

	public Pager<T> findByPage(String xql, Object[] keys, int pageNo,
			int pageSize) {
		return iDao.findByPage(entityClass, xql, keys, pageNo, pageSize);
	}
	
	public T findById(PK pk) {
		return iDao.findById(entityClass, pk);
	}
	
	public List<T> findAll(String hql) {
		return iDao.findAll(entityClass, hql);
	}
	
	public void deleteByLogic(PK... pks) {
		iDao.deleteByLogic(entityClass, pks);
	}
	
	public T findByKeys(String xql,Object[] keys) {
		return iDao.findByKeys(entityClass, xql, keys);
	}
	
	public List<T> findKeys(String xql,Object[] keys) {
		return iDao.findKeys(entityClass, xql, keys);
	}

}
