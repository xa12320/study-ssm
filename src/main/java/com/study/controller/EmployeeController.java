package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.pojo.Employee;
import com.study.service.EmployeeService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/1/31 14:43
 * @Description:
 * 查询所有员工----------->/emp---->get
 * 查询分页员工信息----------->/emp/page/number---->get
 * 根据id查询所有员工----------->/emp/id---->get
 * 跳转到添加页面----------->/to/add---->get
 * 添加员工----------->/emp---->post
 * 修改员工信息----------->/emp---->put
 * 删除员工----------->/emp---->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     *查询分页员工
     * @param pageNum 浏览器传输来的页码
     * @param model 共享数据
     * @return
     */
    @RequestMapping(value = "/emp/page/{pageNum}",method = RequestMethod.GET)
    public String getEmpPage(@PathVariable("pageNum") Integer pageNum,Model model){
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmpPage(pageNum);
        //将请求域共享到请求域中
        model.addAttribute("page", page);
        return "emp_page_all";
    }

    /**
     * 跳转到员工列表页面
     * @param model 获取数据库数据，前台显示
     * @return 返回员工列表页
     */
    @GetMapping("/emp")
    public String showAllEmp(Model model){
        List<Employee> lists = employeeService.getAllEmp();
        model.addAttribute("lists", lists);
        return "emp_all";
    }

    /**
     * 跳转到添加页面
     * @return 返回添加页面
     */
    @GetMapping("/to/add")
    public String showAddEmp(){
        return "emp_add";
    }

    /**
     *添加员工
     * @param employee 需要添加的员工
     * @return 重定向到员工列表页
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmp(Employee employee,Model model){
       int result = employeeService.addEmp(employee);
       if(result == 0){
           model.addAttribute("error", "错误");
           return "emp_add";
       }
        return "redirect:/emp";
    }

    /**
     * 跳转到修改页面
     * @param index 需要修改的员工id
     * @param model 共享数据
     * @return 返回修改页面
     */
    @RequestMapping(value = "/emp/{index}",method = RequestMethod.GET)
    public String showUpdate(@PathVariable("index") Integer index,Model model){
        Employee employee = employeeService.getEmpByid(index);
        model.addAttribute("employee", employee);
        return "emp_update";
    }

    //http://localhost:8080/ssm/emp/page/1
    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String updateEmpById(
            Employee employee
            //@RequestHeader("referer") String referer

    ){
        int result = employeeService.updateEmpByid(employee);

        //String num = referer.substring(referer.length() - 1, referer.length());
        //int index = Integer.parseInt(num);
        //System.out.println(index);
        return "redirect:/emp/page/1 ";
    }

}
