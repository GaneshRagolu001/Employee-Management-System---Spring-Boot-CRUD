package com.example.Springprojects.EmployeesSpring.rest.DAO;

import com.example.Springprojects.EmployeesSpring.rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // inbuild methods
}
