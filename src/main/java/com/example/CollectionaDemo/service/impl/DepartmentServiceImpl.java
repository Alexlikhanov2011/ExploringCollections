package com.example.CollectionaDemo.service.impl;

import com.example.CollectionaDemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithsMaxSalary(Integer departmentId) {
       return employeeService.getAll().values()
                .stream()
                .filter(employee -> departmentId.equals(employee.getDepartment()))
                .max(Comparator.comparingInt(Employee::getSalary))
               .orElse(null);

    }

    @Override
    public Employee getEmployeeWithsMinSalary(Integer departmentId) {
        return employeeService.getAll().values()
                .stream()
                .filter(employee -> departmentId.equals(employee.getDepartment()))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployeesGetDepartment(Integer departmentId) {
        return employeeService.getAll().values().stream()
                .filter(employee -> departmentId.equals(employee.getDepartment()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployee() {
        return employeeService.getAll().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
