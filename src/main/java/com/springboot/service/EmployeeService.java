package com.springboot.service;

import com.springboot.entity.Employee;
import java.util.List;

public interface EmployeeService {

  public List<Employee> findAll();

  public Employee findById(Long id);

  public void save(Employee employee);

  public void deleteById(Long id);
}
