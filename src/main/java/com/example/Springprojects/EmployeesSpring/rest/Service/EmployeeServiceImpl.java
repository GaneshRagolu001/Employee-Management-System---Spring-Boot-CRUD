package com.example.Springprojects.EmployeesSpring.rest.Service;

import com.example.Springprojects.EmployeesSpring.rest.DAO.EmployeeRepository;
import com.example.Springprojects.EmployeesSpring.rest.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findbyId(int id) {

        Optional<Employee> myemployee = employeeRepository.findById(id);
        Employee myemployee1 = null;
        if(myemployee.isPresent()){
            myemployee1 = myemployee.get();
        }else{
            throw new RuntimeException("Did not find employee with - " + id);
        }
        return myemployee1;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deletebyId(int id) {

        employeeRepository.deleteById(id);
    }
}
