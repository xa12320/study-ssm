package com.study.mapper;

import com.study.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/1/31 17:12
 * @Description:
 */
public interface EmployeeMapper {
    /**
     * 获取到所有员工
     * @return 返回员工list
     */
    List<Employee> getAllEmp();

    /**
     * 添加员工
     * @param employee
     * @return 返回添加结果：成功：1，失败：0
     */
    int addEmp(Employee employee);

    /**
     * 通过id获取员工
     * @param index 员工的id
     * @return 返回员工
     */
    Employee getEmpById(Integer index);

    /**
     * 根据id修改员工
     * @param employee
     * @param
     * @return
     */
    int updateEmpById(Employee employee);
}
