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
    public int addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> list = employeeDao.getEmployeeList();
        CommonUtil.removeDuplicate(list);
        return list;
    }

    @Override
    public int update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public Employee queryById(Long id) {
        return employeeDao.queryById(id);
    }

    @Override
    public int deleteById(Long id) {
        return employeeDao.deleteById(id);
    }
}
