package com.jas.service;

import com.jas.common.MyBasePageRequest;
import com.jas.common.MyBasePageResponse;
import com.jas.entity.Employee;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jas
 * @since 2018-08-21
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 分页获取员工信息
     * 
     * @param request
     * @return
     */
    MyBasePageResponse<Employee> getEmpPage(MyBasePageRequest<Employee> request);
}
