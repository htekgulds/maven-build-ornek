package com.example.mavenbuildornek;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> employees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{name}")
    public Employee employee(@PathVariable String name) {
        return employeeService.getEmployee(name);
    }
}
