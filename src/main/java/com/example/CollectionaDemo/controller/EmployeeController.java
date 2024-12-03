package com.example.CollectionaDemo.controller;

import com.example.CollectionaDemo.model.Employee;
import com.example.CollectionaDemo.service.impl.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @GetMapping("/add")
    public void add(@RequestParam String firstName,
                    @RequestParam String lastName) {
        service.add(firstName, lastName);
    }

    @GetMapping("/find")

    public Employee get(@RequestParam String firstName,
                        @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping("/remove")
    public void remove(@RequestParam String firstName,
                          @RequestParam String lastName) {
        service.remove(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> getall() {
        return service.getAll();
    }
}
