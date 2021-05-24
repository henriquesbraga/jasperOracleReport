package dao.impl;

import connection.DataSource;
import dao.EmployeeDao;
import entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoJDBC implements EmployeeDao {
  @Override
  public List<Employee> getEmployees() {
    String SQL = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, SALARY from EMPLOYEES ";
    List<Employee> list = new ArrayList<>();
    try(Connection conn = DataSource.getConnection()){
      try(PreparedStatement st = conn.prepareStatement(SQL)){
        try(ResultSet rs = st.executeQuery()){
          while (rs.next()){
            Employee employee = new Employee();
            employee.setId(rs.getLong("EMPLOYEE_ID"));
            employee.setFirstName(rs.getString("FIRST_NAME"));
            employee.setLastName(rs.getString("LAST_NAME"));
            employee.setEmail(rs.getString("EMAIL"));
            employee.setPhoneNumber(rs.getString("PHONE_NUMBER"));
            employee.setHireDate(rs.getDate("HIRE_DATE"));
            employee.setSalary(rs.getDouble("SALARY"));
            list.add(employee);
          }
          return list;
        }
      }

    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return null;
  }
}
