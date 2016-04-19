package com.bf.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
/**
 * 
 * 批准授权过滤器
 * ============================================================================
 * 版权所有 2010-2013 北方网有限公司，并保留所有权利。
 * ----------------------------------------------------------------------------
 * 提示：在未取得北方网授权之前，您不能将本软件应用于商业用途，否则北方网将保留追究的权力。
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.ibeifeng.com/
 * ----------------------------------------------------------------------------
 * ============================================================================
 */
public class MyAuthorizationFilter extends AbstractSecurityInterceptor implements Filter {
	//与资源对应
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

	@Override
	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		//完成2个步骤 1：调用判断的方法 获取资源权限
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {
	}

}
