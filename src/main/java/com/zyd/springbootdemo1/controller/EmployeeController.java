package com.zyd.springbootdemo1.controller;

import com.zyd.springbootdemo1.entity.Employee;
import com.zyd.springbootdemo1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("add")
    public Employee add(Employee user) {
        employeeService.addEmployee(user);
        return user;
    }

    @GetMapping("list")
    public List<Employee> list() {
        return employeeService.getEmployeeList();
    }

}
