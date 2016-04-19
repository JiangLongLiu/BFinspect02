package com.bf.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.bf.common.Pager;

/**
 * 
 * 基于Hibernate实现
 * ============================================================================
 * 版权所有 2010-2013 北方网有限公司，并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：在未取得北方网授权之前，您不能将本软件应用于商业用途，否则北方网将保留追究的权力。
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.ibeifeng.com/
 * ----------------------------------------------------------------------------
 * ============================================================================
 */
@Service
public class IdaoImpl<T, PK extends Serializable> extends HibernateDaoSupport
		implements Idao<T, PK> {
	/**
	 * 添加
	 */
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	/**
	 * 更新
	 */
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * 查询全部
	 */
	public List<T> findAll(Class<T> entityClass) {
		String hql = "from " + entityClass.getName();
		return getHibernateTemplate().find(hql);
	}

	/**
	 * 删除操作 (先查询再删除)
	 */
	public void delete(Class<T> entityClass, PK... pks) {
		for (PK pk : pks) {
			getHibernateTemplate().delete(
					getHibernateTemplate().get(entityClass, pk));
		}
	}

	public Pager<T> findByPage(Class<T> entityClass, String xql, int pageNo,
			int pageSize) {
		return findByPage(entityClass, xql, null, pageNo, pageSize);
	}

	public Pager<T> findByPage(Class<T> entityClass, String xql, Object key,
			int pageNo, int pageSize) {
		return findByPage(entityClass, xql, new Object[] { key }, pageNo,
				pageSize);
	}

	public Pager<T> findByPage(Class<T> entityClass, String xql, Object[] keys,
			int pageNo, int pageSize) {
		Pager<T> pager = new Pager<T>();
		List<T> pageList;
		Query query = getSession().createQuery(xql);
		if (keys != null && keys.length > 0) {
			for (int i = 0; i < keys.length; i++) {
				query.setParameter(i, keys[i]);
			}
		}
		query.setFirstResult(pageNo).setMaxResults(pageSize);
		pageList = query.list();
		int totalNum = getTotalNum(xql, keys);
		pager.setPageList(pageList);
		pager.setTotalNum(totalNum);
		return pager;
	}

	/**
	 * 用于查询总数
	 * 
	 * @param xql
	 * @param keys
	 * @return
	 */
	private int getTotalNum(String xql, Object[] keys) {
		int totalNum = 0;
		int index = xql.indexOf("from");
		String from = xql.substring(index).trim();
		String hql = "select count(*) " + from;
		Query query = getSession().createQuery(hql);
		if (keys != null && keys.length > 0) {
			for (int i = 0; i < keys.length; i++) {
				query.setParameter(i, keys[i]);
			}
		}
		totalNum = ((Long) query.uniqueResult()).intValue();
		return totalNum;
	}

	// 注入sessionFactory
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public T findById(Class<T> entityClass, PK pk) {
		return getHibernateTemplate().get(entityClass, pk);
	}

	public List<T> findAll(Class<T> entityClass, String hql) {
		return getHibernateTemplate().find(hql);
	}

	// 逻辑删除
	public void deleteByLogic(Class<T> entityClass, PK... pks) {
		// hql = "update User u set u.flag=0 where u.id in (?,?)"
		StringBuffer str = new StringBuffer();
		for (PK pk : pks) {
			str.append("?").append(",");
		}
		// 删除最后多余的,号
		str.deleteCharAt(str.length() - 1);
		String hql = "update " + entityClass.getName()
				+ " o set o.flag=0 where o.id in (" + str.toString() + ")";
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < pks.length; i++) {
			query.setParameter(i, pks[i]);
		}
		query.executeUpdate();
	}

	public T findByKeys(Class<T> entityClass, String xql, Object[] keys) {
		boolean flag = checkByKeys(xql, keys);
		if (flag) {
			Query query = getSession().createQuery(xql);
			if (keys != null && keys.length > 0) {
				for (int i = 0; i < keys.length; i++) {
					query.setParameter(i, keys[i]);
				}
			}
			return (T) query.uniqueResult();
		} else {
			return null;
		}
	}

	public List<T> findKeys(Class<T> entityClass, String xql, Object[] keys) {
		boolean flag = checkByKeys(xql, keys);
		if (flag) {
			Query query = getSession().createQuery(xql);
			if (keys != null && keys.length > 0) {
				for (int i = 0; i < keys.length; i++) {
					query.setParameter(i, keys[i]);
				}
			}
			return query.list();
		} else {
			return new ArrayList<T>();
		}
	}

	private boolean checkByKeys(String xql, Object[] keys) {
		int index = xql.indexOf("from");
		String from = xql.substring(index).trim();
		String hql = "select count(*) " + from;
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		if (keys != null && keys.length > 0) {
			for (int i = 0; i < keys.length; i++) {
				query.setParameter(i, keys[i]);
			}
		}
		int flag = ((Long) query.uniqueResult()).intValue();
		return flag > 0;
	}
}
