package com.zyd.springbootdemo1.service;

import com.zyd.springbootdemo1.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public int addEmployee(Employee employee);

    public List<Employee> getEmployeeList();

    public int update(Employee employee);

    public Employee queryById(Long id);

    public int deleteById(Long id);
}
