package com.jas.mapper;

import com.jas.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author Jas
 * @create 2018-06-22 9:37
 **/
public interface EmployeeMapper {

    @Select("SELECT * FROM t_emp WHERE emp_id = #{id}")
    Employee getEmpById(Integer id);
}
