import dao.DaoFactory;
import dao.EmployeeDao;
import entities.Employee;
import report.ReportBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Employee> list = new ArrayList<>();
    EmployeeDao dao = DaoFactory.createEmployeeDao();
    list = dao.getEmployees();
    ReportBuilder.generateReport(list);
  }
}
