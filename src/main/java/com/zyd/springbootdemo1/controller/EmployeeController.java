package com.zyd.springbootdemo1.controller;

import com.zyd.springbootdemo1.entity.Employee;
import com.zyd.springbootdemo1.result.ResponseResult;
import com.zyd.springbootdemo1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 列表
    @GetMapping
    public ResponseResult<List<Employee>> list() {

        return ResponseResult.success(employeeService.getEmployeeList());
    }


    //增
    @PostMapping
    public ResponseResult add(Employee employee) {
        if (employee == null) {
            return ResponseResult.fail( "参数错误");
        }
        int rt = employeeService.addEmployee(employee);
        if (rt != 0) {
            return ResponseResult.fail("添加失败");
        }
        return ResponseResult.success(employee);
    }

    //删
    @DeleteMapping("{employeeId}")
    public ResponseResult delete(@PathVariable("employeeId") Long employeeId) {
        //若id为空或者小于1返回400
        if (employeeId == null || employeeId < 1) {
            return ResponseResult.fail("参数错误");
        }
        Integer count = employeeService.deleteById(employeeId);
        if (count == null || count != 0) {
            //插入失败，返回404
            return ResponseResult.fail("删除失败");
        }//删除成功，返回204
        return ResponseResult.success();
    }

    //改
    @PutMapping
    public ResponseResult update(Employee employee) {
        //若User对象为空则返回400
        if (employee == null) {
            return ResponseResult.fail("参数错误");
        }
        long id = employee.getEmployeeId();
        Integer count = employeeService.update(employee);
        if (count == null || count != 0) {
            //插入失败，返回400
            return ResponseResult.fail("修改失败");
        }
        //创建对象成功，返回204
        return  ResponseResult.success(employeeService.queryById(id));
    }

    //@RequestMapping(value = "{id}", method = RequestMethod.GET)//   /employee/{employeeId}
    //查
    @GetMapping("{employeeId}")
    //@PathVariable可以将URL中占位符参数{employeeId}绑定到处理器类的方法形参中@PathVariable(“employeeId“)
    public ResponseResult<Employee> queryById(@PathVariable("employeeId") Long employeeId) {
        //若ID小于1则返回400
        if (employeeId == null || employeeId < 1) {
            return ResponseResult.fail(null, "参数错误");
        }
        Employee employee = employeeService.queryById(employeeId);
        //若ID为空则返回404
        if (employee == null) {
            return ResponseResult.fail(null, "没找到");
        }
        return ResponseResult.success(employee);
    }
}
