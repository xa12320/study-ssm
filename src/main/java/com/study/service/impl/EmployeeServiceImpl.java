package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.mapper.EmployeeMapper;
import com.study.pojo.Employee;
import com.study.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/1/31 16:21
 * @Description:
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmp() {
        List<Employee> list = employeeMapper.getAllEmp();
        return list;
    }

    @Override
    public int addEmp(Employee employee) {
        int result = employeeMapper.addEmp(employee);
        return result;
    }

    @Override
    public PageInfo<Employee> getEmpPage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,4);
        //查询所有员工信息
        List<Employee> list = employeeMapper.getAllEmp();
        //获取分页相关数据
        PageInfo<Employee> page = new PageInfo<>(list,5);
        return page;
    }

    @Override
    public Employee getEmpByid(Integer index) {
        Employee employee = employeeMapper.getEmpById(index);
        return employee;
    }

    @Override
    public int updateEmpByid(Employee employee) {
        int result = employeeMapper.updateEmpById(employee);
        return result;
    }


}
