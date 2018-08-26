package com.jas.common.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author zc
 * @description 认证过滤器
 * @create 2018-08-24 17:10
 */
public class ShiroLoginFilter extends FormAuthenticationFilter {

	/**
	 * 前置--认证前
	 * 
	 * @param request
	 * @param response
	 * @param mappedValue
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		// TODO Auto-generated method stub
		return super.onPreHandle(request, response, mappedValue);
	}

    /**
     * 是否允许通过--认证时
     * 
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		// TODO Auto-generated method stub
		return super.isAccessAllowed(request, response, mappedValue);
	}

    /**
     * 认证不通过--不通过
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return super.onAccessDenied(request, response);
	}
}
