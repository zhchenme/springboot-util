package com.jas.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jas.common.MyBasePageRequest;
import com.jas.common.MyBasePageResponse;
import com.jas.entity.Employee;
import com.jas.mapper.EmployeeDao;
import com.jas.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jas
 * @since 2018-08-21
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements EmployeeService {
    
    @Override
    public MyBasePageResponse<Employee> getEmpPage(MyBasePageRequest<Employee> request) {
        // 设置倒排序字段
        request.setDescs(Arrays.asList("id"));

        // 获取所有员工信息
        List<Employee> employeeList = super.baseMapper.selectPage(request.getPagePlus(), new EntityWrapper<>());

        request.getPagePlus().setRecords(employeeList);

        return new MyBasePageResponse<>(request.getPagePlus());
    }
}
