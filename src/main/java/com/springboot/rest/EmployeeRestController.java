package com.springboot.rest;

import com.springboot.service.EmployeeService;
import com.springboot.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

  private EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("")
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping("/{employeeId}")
  public Employee findById(@PathVariable Long employeeId) {
    Employee employee = employeeService.findById(employeeId);

    if (employee == null) {
      throw new RuntimeException("Employee id not found - " + employeeId);
    }
    return employee;
  }

  @PostMapping("")
  public Employee addEmployee(@RequestBody Employee employee) {
    employeeService.save(employee);

    return employee;
  }

  @PutMapping("")
  public Employee updateEmployee(@RequestBody Employee employee){
    employeeService.save(employee);

    return employee;
  }

  @DeleteMapping("/{employeeId}")
  public String deleteEmployee(@PathVariable Long employeeId){
    Employee employee = employeeService.findById(employeeId);

    if (employee == null){
      throw  new  RuntimeException("Employee id not found - " + employeeId);
    }
    employeeService.deleteById(employeeId);

    return "Deleted employee with id - " + employeeId;
  }

}
