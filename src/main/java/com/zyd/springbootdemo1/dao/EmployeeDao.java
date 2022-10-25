package com.zyd.springbootdemo1.dao;

import com.zyd.springbootdemo1.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class EmployeeDao {

    private List<Employee> employeeList = new ArrayList<>();

    public int addEmployee(Employee employee) {
        int id = employee.getEmployeeId();
        for (Employee e : employeeList) {
            int id2 = e.getEmployeeId();
            if (id2 == id) {
                return -1;
            }
        }
        employeeList.add(employee);
        return 0;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public int update(Employee employee) {
        int id = employee.getEmployeeId();
        for (Employee e : employeeList) {
            int id2 = e.getEmployeeId();
            if (id2 == id) {
                Integer departmentId = employee.getDepartmentId();
                String lastName = employee.getLastName();
                if (departmentId != null && departmentId >= 0) {
                    e.setDepartmentId(departmentId);
                }
                if (lastName != null && !lastName.isEmpty()) {
                    e.setLastName(lastName);
                }
                return 0;
            }
        }
        return -1;
    }

    public Employee queryById(Long id) {
        for (Employee e : employeeList) {
            int id2 = e.getEmployeeId();
            if (id2 == id) {
                return e;
            }
        }
        return null;
    }

    public int deleteById(Long id) {
        Iterator<Employee> iterator = employeeList.listIterator();
        while (iterator.hasNext()) {
            int id2 = iterator.next().getEmployeeId();
            if (id2 == id) {
                iterator.remove();
                return 0;
            }
        }
        return 0;
    }

}
