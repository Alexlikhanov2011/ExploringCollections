package com.example.CollectionaDemo.service.impl;

import com.example.CollectionaDemo.exceptions.EmployeeAllreadeAddedException;
import com.example.CollectionaDemo.exceptions.EmployeeNotFoundException;
import com.example.CollectionaDemo.exceptions.EmployeeStorageFullException;
import com.example.CollectionaDemo.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int SIZE = 10;

    @PostConstruct
    public void initEmployee() {
        add("sasha1", "likhanov", 100_000, 1);
        add("sasha2", "likhanov", 200_000, 1);
        add("sasha3", "likhanov", 300_000, 1);

        add("sasha4", "likhanov", 300_000, 2);
        add("sasha5", "likhanov", 500_000, 2);

        add("sasha6", "likhanov", 1_000_000, 3);
    }
    private final Map<String, Employee> employees = new HashMap<>();
@Override
    public Employee add(String firstName, String lastName, Integer salary, Integer department) {

        if (employees.size() == SIZE) {
            throw new EmployeeStorageFullException("Не можем создать хранилище уже переполнено");
        }
        if (employees.containsKey(getKey(firstName,lastName))) {
            throw new EmployeeAllreadeAddedException("Сотрудник с именем " + firstName + " и фаилией"+
                    lastName+" уже есть такой");
        }
    Employee employee = new Employee(firstName, lastName,salary,department);
        employees.put(getKey(employee),employee);
return employee;
    }
    @Override
    public Employee find(String firstName, String lastName) {

        Employee employee = employees.get(getKey(firstName,lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException("Сотрудник с именем " +
                    firstName + " и фамилией " + lastName + " не существует");
        }
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastName) {
        if (!employees.containsKey(getKey(firstName,lastName))) {
            throw new EmployeeNotFoundException("Сотрудник с именем " +
                    firstName + " и фамилией " + lastName + " не существует");
        }
        return employees.remove(getKey(firstName,lastName));

    }

    public Map<String,Employee> getAll() {
        return Collections.unmodifiableMap(employees);
    }

    private static String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }
    private static String getKey(Employee employee) {
        return employee.getFirstName() + employee.getLastName();
    }
}
