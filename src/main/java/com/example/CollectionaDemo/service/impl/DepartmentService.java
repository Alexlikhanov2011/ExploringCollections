package com.example.CollectionaDemo.service.impl;

import com.example.CollectionaDemo.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public Employee getEmployeeWithsMaxSalary(Integer departmentId);
    public Employee getEmployeeWithsMinSalary(Integer departmentId);
    public List<Employee> getAllEmployeesGetDepartment(Integer departmentId);

    public Map<Integer, List<Employee>> getAllEmployee();
}

