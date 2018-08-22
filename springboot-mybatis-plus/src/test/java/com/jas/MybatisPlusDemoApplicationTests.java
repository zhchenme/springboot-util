package com.jas;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jas.entity.Employee;
import com.jas.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusDemoApplicationTests {

	@Autowired
	private DruidDataSource dataSource;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void dataSourceTest() {
        System.out.println(dataSource .getClass());
    }

    @Test
    public void sqlTest() {
        EntityWrapper<Employee> ew = new EntityWrapper<>();
        
        ew.eq("last_name", "张三");
        
        List<Employee> employeeList = employeeService.selectList(ew);

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
