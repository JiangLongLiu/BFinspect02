package com.bf.base;

import java.io.Serializable;
import java.util.List;

import com.bf.common.Pager;

/**
 * 
 * 基础接口
 * ============================================================================
 * 版权所有 2010-2013 北方网有限公司，并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：在未取得北方网授权之前，您不能将本软件应用于商业用途，否则北方网将保留追究的权力。
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.ibeifeng.com/
 * ----------------------------------------------------------------------------
 * ============================================================================
 */
public interface BaseDao<T, PK extends Serializable> {
	/**
	 * 添加
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * 查询全部
	 * @return
	 */
	public List<T> findAll();
	/**
	 * 删除
	 * @param pks
	 */
	public void delete(PK... pks);
	/**
	 * 不带条件分页
	 * @param xql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager<T> findByPage(String xql,int pageNo,int pageSize);
	/**
	 * 带一个条件的分页
	 * @param xql
	 * @param key
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager<T> findByPage(String xql,Object key,int pageNo,int pageSize);
	/**
	 * 带多个条件的分页
	 * @param xql
	 * @param keys
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager<T> findByPage(String xql,Object[] keys,int pageNo,int pageSize);
	/**
	 * 根据主键获取对象
	 * @param pk
	 * @return
	 */
	public T findById(PK pk);
	/**
	 * 查询
	 * @param hql
	 * @return
	 */
	public List<T> findAll(String hql);
	/**
	 * 
	 * @param pks
	 */
	public void deleteByLogic(PK... pks);
	/**
	 * 根据条件得对象
	 * @param xql
	 * @param keys
	 * @return
	 */
	public T findByKeys(String xql,Object[] keys);
	/**
	 * 根据条件得集合
	 * @param xql
	 * @param keys
	 * @return
	 */
	public List<T> findKeys(String xql,Object[] keys);
}
