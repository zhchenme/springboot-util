package com.jas.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jas.common.MyBasePageRequest;
import com.jas.common.MyBasePageResponse;
import com.jas.common.ResponseEntity;
import com.jas.entity.Employee;
import com.jas.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jas
 * @since 2018-08-21
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    /**
     * 获取所有员工信息
     * 
     * @return
     */
    @GetMapping("/emps")
    public ResponseEntity<List<Employee>> getAllEmps() {
        ResponseEntity<List<Employee>> res = new ResponseEntity<>();
        List<Employee> employeeList = employeeService.selectList(new EntityWrapper<>());
        res.setData(employeeList);
        return res;
    }

    /**
     * 根据 id 获取员工信息
     * 
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") Integer id) {
        ResponseEntity<Employee> res = new ResponseEntity<>();
        Employee employee = employeeService.selectById(id);
        res.setData(employee);
        return res;
    }

    /**
     * 分页获取员工信息
     * 
     * @param request
     * @return
     */
    @GetMapping("/emps/page")
    public ResponseEntity<MyBasePageResponse<Employee>> getEmpPage(MyBasePageRequest<Employee> request) {
        ResponseEntity<MyBasePageResponse<Employee>> res = new ResponseEntity<>();
        MyBasePageResponse<Employee> employeeList = employeeService.getEmpPage(request);
        res.setData(employeeList);
        return res;
    }
}

