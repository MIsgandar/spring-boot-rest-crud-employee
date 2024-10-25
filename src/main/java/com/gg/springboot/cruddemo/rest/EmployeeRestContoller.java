package com.gg.springboot.cruddemo.rest;


import com.gg.springboot.cruddemo.dao.EmployeeDAO;
import com.gg.springboot.cruddemo.entity.Employee;
import com.gg.springboot.cruddemo.service.EmployeeService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestContoller {

    private EmployeeService employeeService;

    // quick and dirty: inject employee dao
    public EmployeeRestContoller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for Get /emyployee(employeeId
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null) {
          throw new RuntimeException("Employee id not found: " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        Employee addedEmployee = employeeService.save(employee);
        return addedEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee updEmployee = employeeService.save(employee);
        return updEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null)
            throw new RuntimeException("Employee id is not found: " + employeeId);

        employeeService.deleteById(employeeId);
        return "Employee with id: " + employeeId + " has been deleeted";

    }











}
