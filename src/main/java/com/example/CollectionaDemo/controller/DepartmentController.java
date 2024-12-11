package com.example.CollectionaDemo.controller;

import com.example.CollectionaDemo.model.Employee;
import com.example.CollectionaDemo.service.impl.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public Employee getEmployeeWithsMaxSalary(@RequestParam ("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithsMaxSalary(departmentId);
    }
    @GetMapping("min-salary")
    public Employee getEmployeeWithsMinSalary(@RequestParam ("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithsMinSalary(departmentId);
    }
    @GetMapping(value = "all", params = "departmentId")
    public List<Employee> getAllEmployeesGetDepartment(@RequestParam ("departmentId") Integer departmentId) {
        return departmentService.getAllEmployeesGetDepartment(departmentId);
    }
    @GetMapping("all")
    public Map<Integer, List<Employee>> getAllEmployee() {
        return departmentService.getAllEmployee();
    }
}
