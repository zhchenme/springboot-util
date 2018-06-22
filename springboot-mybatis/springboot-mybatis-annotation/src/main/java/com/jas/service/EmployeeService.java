package com.jas.service;

import com.jas.bean.Employee;
import com.jas.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jas
 * @create 2018-06-22 9:44
 **/
@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeMapper employeeMapper;
    
    public Employee getEmpById(Integer id) {
        return employeeMapper.getEmpById(id);
    }
}
