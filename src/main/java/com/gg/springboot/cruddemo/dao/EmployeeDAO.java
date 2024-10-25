package com.gg.springboot.cruddemo.dao;

import com.gg.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee>findAll();

    Employee findById(int theId);

    Employee save(Employee employee);

    void deleteById(int id);


}
