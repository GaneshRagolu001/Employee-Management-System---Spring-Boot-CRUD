package com.example.Springprojects.EmployeesSpring.rest.Service;

import com.example.Springprojects.EmployeesSpring.rest.DAO.StudentDAO;
import com.example.Springprojects.EmployeesSpring.rest.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    @Override
    public List<Employee> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Employee findbyId(int id) {
        return studentDAO.findbyId(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return studentDAO.save(employee);
    }

    @Override
    @Transactional
    public void deletebyId(int id) {
        studentDAO.deletebyId(id);
    }
}
