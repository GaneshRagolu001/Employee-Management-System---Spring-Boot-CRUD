package com.example.Springprojects.EmployeesSpring.rest.DAO;

import com.example.Springprojects.EmployeesSpring.rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO{

    EntityManager entityManager;

    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> thequery = entityManager.createQuery("from Employee",Employee.class);

        //execute the query and get result list
        List<Employee> myemployees = thequery.getResultList();
        //return the list
        return myemployees;
    }

    @Override
    public Employee findbyId(int theId) {
        Employee myemployee = entityManager.find(Employee.class,theId);
        return myemployee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee newEmployee = entityManager.merge(employee);
        return newEmployee;
    }

    @Override
    public void deletebyId(int theId) {
        Employee theemployee = entityManager.find(Employee.class,theId);
        entityManager.remove(theemployee);
    }
}
