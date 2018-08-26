package com.jas.common.shiro;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author zchen
 * @description 授权过滤器
 * @create 2018-08-24 17:009
 */
public class ShiroPermsFilter extends PermissionsAuthorizationFilter {

	/**
	 * shiro 认证 perms 资源失败后回调方法
	 * 
	 * @param request
	 * @param response
	 * @param mappedValue
	 * @return
	 * @throws Exception
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		return super.onAccessDenied(request, response);
	}

}
