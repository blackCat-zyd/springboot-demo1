package com.zyd.springbootdemo1.controller;

import com.zyd.springbootdemo1.entity.Employee;
import com.zyd.springbootdemo1.result.ResponseResult;
import com.zyd.springbootdemo1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //增
    @PostMapping
    public Employee add(Employee user) {
        employeeService.addEmployee(user);
        return user;
    }

    // 列表
    @GetMapping
    public List<Employee> list() {
        return employeeService.getEmployeeList();
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
        Employee user = userService.queryById(id);
        //若ID为空则返回404
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user);
    }

    //删
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        //若id为空或者小于1返回400
        if (id == null || id < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Integer count = userService.deleteById(id);
        if (count == null || count == 0) {
            //插入失败，返回404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }//删除成功，返回204
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    //改
    @PutMapping
    public ResponseEntity<Void> update(User user) {
        //若User对象为空则返回400
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Integer count = userService.update(user);
        if (count == null || count == 0) {
            //插入失败，返回400
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }//创建对象成功，返回204
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
