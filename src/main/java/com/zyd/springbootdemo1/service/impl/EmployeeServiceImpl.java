package com.zyd.springbootdemo1.service.impl;

import com.zyd.springbootdemo1.dao.EmployeeDao;
import com.zyd.springbootdemo1.entity.Employee;
import com.zyd.springbootdemo1.service.EmployeeService;
import com.zyd.springbootdemo1.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> list = employeeDao.getEmployeeList();
        CommonUtil.removeDuplicate(list);
        return list;
    }
}
