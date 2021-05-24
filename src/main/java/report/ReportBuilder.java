package report;

import entities.Employee;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.util.List;

public class ReportBuilder {

  public static void generateReport(List<Employee> list){
    InputStream data = ReportBuilder.class.getResourceAsStream("/employee_report.jrxml");
    try {
      JasperReport report = JasperCompileManager.compileReport(data);
      JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(list));
      JasperViewer.viewReport(print, true);
    } catch (JRException e) {
      e.printStackTrace();
    }
  }
}
