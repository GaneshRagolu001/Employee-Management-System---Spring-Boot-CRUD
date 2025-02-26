package com.example.Springprojects.EmployeesSpring.rest.Rest;

import com.example.Springprojects.EmployeesSpring.rest.Service.EmployeeService;
import com.example.Springprojects.EmployeesSpring.rest.Service.EmployeeServiceImpl;
import com.example.Springprojects.EmployeesSpring.rest.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService studentService) {
        this.employeeService = studentService;
    }


    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeid}")
    public Employee findbyId(@PathVariable("employeeid") int myid){


        return employeeService.findbyId(myid);
    }

    @PostMapping("/employees")
    public Employee createNewEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.save(employee);
        return newEmployee;
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("employeeId") int empId){
        Employee updatedEmployee = employeeService.findbyId(empId);
        Employee newEmployee = null;
        if(updatedEmployee != null){
            updatedEmployee.setFirstName(employee.getFirstName());
            updatedEmployee.setLastName(employee.getLastName());
            updatedEmployee.setEmail(employee.getEmail());
             newEmployee = employeeService.save(updatedEmployee);

        }else{
            throw new RuntimeException("Employee not found by id - " + empId);
        }
        return newEmployee;
    }


    @DeleteMapping("/employees/{employeeid}")
    public void deletebyId(@PathVariable("employeeid") int myid){

        employeeService.deletebyId(myid);
    }


}
