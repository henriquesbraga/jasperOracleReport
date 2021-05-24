package dao;

import dao.impl.EmployeeDaoJDBC;

public class DaoFactory {
  public static EmployeeDao createEmployeeDao(){
    return new EmployeeDaoJDBC();
  }
}
