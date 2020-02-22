package com.springboot.service;

import com.springboot.entity.Employee;
import com.springboot.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(Long id) {

    Optional<Employee> result = employeeRepository.findById(id);

    Employee theEmployee = null;

    if (result.isPresent()) {
      theEmployee = result.get();
    } else {
      throw new RuntimeException("Did not find employee id - " + id);
    }
    return theEmployee;
  }

  @Override
  public void save(Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  public void deleteById(Long id) {
    employeeRepository.deleteById(id);
  }
}
