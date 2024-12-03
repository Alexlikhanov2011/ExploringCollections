package com.example.CollectionaDemo.service.impl;

import com.example.CollectionaDemo.exceptions.EmployeeAllreadeAddedException;
import com.example.CollectionaDemo.exceptions.EmployeeNotFoundException;
import com.example.CollectionaDemo.exceptions.EmployeeStorageFullException;
import com.example.CollectionaDemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int SIZE = 10;
    private final List<Employee> employees = new ArrayList<>();
@Override
    public Employee add(String firstName, String lastName) {

        if (employees.size() == SIZE) {
            throw new EmployeeStorageFullException("Не можем создать хранилище уже переполнено");
        }
        var employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAllreadeAddedException("Сотрудник с именем " + firstName + " и фаилией"+
                    lastName+" уже есть такой");
        }
        employees.add(employee);
return employee;
    }
    @Override
    public Employee find(String firstName, String lastName) {
        var employee = new Employee(firstName, lastName);
        for (Employee empl : employees) {
            if (empl.equals(employee)) {
                return empl;
            }
        }

        throw new EmployeeNotFoundException("Сотрудник с именем " +
                firstName + " и фамилией " + lastName + " не существует");
    }
    @Override
    public Employee remove(String firstName, String lastName) {
        var employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник с именем " +
                    firstName + " и фамилией " + lastName + " не существует");
        }
        employees.remove(employee);
        return employee;
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableList(employees);
    }
}
