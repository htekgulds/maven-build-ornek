package com.example.mavenbuildornek;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(String name);

    List<Employee> getAllEmployees();
}
