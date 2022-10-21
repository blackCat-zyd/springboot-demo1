package com.zyd.springbootdemo1.service;

import com.zyd.springbootdemo1.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee employee);

    public List<Employee> getEmployeeList();
}
