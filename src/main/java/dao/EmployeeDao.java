package dao;

import entities.Employee;

import java.util.List;

public interface EmployeeDao {
  List<Employee> getEmployees();
}
