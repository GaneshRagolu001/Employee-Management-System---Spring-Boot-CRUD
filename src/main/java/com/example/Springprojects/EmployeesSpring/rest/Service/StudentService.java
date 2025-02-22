package com.example.Springprojects.EmployeesSpring.rest.Service;


import com.example.Springprojects.EmployeesSpring.rest.entity.Employee;

import java.util.List;

public interface StudentService {
    public List<Employee> findAll();

    public Employee findbyId(int id);

    public Employee save(Employee employee);

    public void deletebyId(int id);

}
