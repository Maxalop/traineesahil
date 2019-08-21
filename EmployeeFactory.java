package com.hexaware.MLP156.factory;

import com.hexaware.MLP156.persistence.EmployeeDAO;
import com.hexaware.MLP156.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP156.model.Employee;
/**
 * EmployeeFactory class used to fetch employee data from database.
 * @author hexware
 */
public class EmployeeFactory {
  /**
   *  Protected constructor.
   */
  protected EmployeeFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Employee object.
   */
  public static Employee[] showEmployee() {
    List<Employee> employee = dao().show();
    return employee.toArray(new Employee[employee.size()]);
  }

  /**
   *
   * @param eN gets the employee username.
   * @param eP gets the employee password.
   * @return the validation.
   */
  public static Employee validateLogin(final String eN, final String eP) {
    EmployeeDAO eDAO = dao();
    Employee emp = eDAO.validateLogin(eN, eP);
    return emp;
  }
/**
 *
 * @param eid to get employee id.
 * @return the employee wallet balance.
 */
  public static double empwalletbal(final int eid) {
    EmployeeDAO eDAO1 = dao();
    double ewlt = eDAO1.empwalletbal(eid);
    return ewlt;
  }
}
