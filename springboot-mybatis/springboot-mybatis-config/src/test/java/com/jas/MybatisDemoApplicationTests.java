package com.jas;

import com.jas.bean.Employee;
import com.jas.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testMapper() {
		Employee employee = employeeMapper.getEmpById(617);
		System.out.println(employee);
	}

}
