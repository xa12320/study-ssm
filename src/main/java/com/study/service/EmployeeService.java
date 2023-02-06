package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.pojo.Employee;

import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/1/31 16:08
 * @Description:
 */
public interface EmployeeService {
    List<Employee> getAllEmp();


    int addEmp(Employee employee);

    /**
     * 获取员工分页信息
     * @param pageNum
     * @return
     */
    PageInfo<Employee> getEmpPage(Integer pageNum);

    /**
     * 通过员工id获取员工
     * @param index 员工的id
     * @return 返回员工
     */
    Employee getEmpByid(Integer index);

    /**
     * 通过id修改员工
     * @param employee
     * @param
     * @return
     */
    int updateEmpByid(Employee employee);
}
