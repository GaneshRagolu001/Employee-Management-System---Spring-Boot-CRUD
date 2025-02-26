package com.example.Springprojects.EmployeesSpring.rest.Service;


import com.example.Springprojects.EmployeesSpring.rest.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findbyId(int id);

    public Employee save(Employee employee);

    public void deletebyId(int id);


}
