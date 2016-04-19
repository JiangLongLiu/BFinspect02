package com.bf.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 
 * 获取当前类父类的泛型的第一个参数
 * ============================================================================
 * 版权所有 2010-2013 北方网有限公司，并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：在未取得北方网授权之前，您不能将本软件应用于商业用途，否则北方网将保留追究的权力。
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.ibeifeng.com/
 * ----------------------------------------------------------------------------
 * ============================================================================
 */
public class GetEntityClassUtil {
	public static Class getEntityClass(Class c) {
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] param = ((ParameterizedType) type).getActualTypeArguments();
			return (Class) param[0];
		} else {
			return Object.class;
		}
	}
}
