package com.example.Springprojects.EmployeesSpring.rest.DAO;

import com.example.Springprojects.EmployeesSpring.rest.entity.Employee;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface StudentDAO  {

    public List<Employee> findAll();

    public Employee findbyId(int id);

    public Employee save(Employee employee);

    public void deletebyId(int id);

}
