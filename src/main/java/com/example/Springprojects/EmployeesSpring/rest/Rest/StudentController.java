package com.example.Springprojects.EmployeesSpring.rest.Rest;

import com.example.Springprojects.EmployeesSpring.rest.Service.StudentServiceImpl;
import com.example.Springprojects.EmployeesSpring.rest.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/employees")
    public List<Employee> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/employees/{employeeid}")
    public Employee findbyId(@PathVariable("employeeid") int myid){
        Employee emp = studentService.findbyId(myid);
        if(emp == null){
            throw new RuntimeException("Employee id not found - " + myid);
        }
        return studentService.findbyId(myid);
    }

    @PostMapping("/employees")
    public Employee createNewEmployee(@RequestBody Employee employee){
//        employee.setId(0);
        Employee newEmployee = studentService.save(employee);
        return newEmployee;
    }

    @DeleteMapping("/employees/{employeeid}")
    public void deletebyId(@PathVariable("employeeid") int myid){
        Employee emp = studentService.findbyId(myid);
        if(emp == null){
            throw new RuntimeException("Employee id not found - " + myid);
        }
        studentService.deletebyId(myid);
    }


}
