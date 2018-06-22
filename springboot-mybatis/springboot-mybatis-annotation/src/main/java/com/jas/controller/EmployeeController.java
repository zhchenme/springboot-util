package com.jas.controller;

import com.jas.bean.Employee;
import com.jas.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jas
 * @create 2018-06-22 9:46
 **/
@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping("emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmpById(id);
        return employee;
    }
}
