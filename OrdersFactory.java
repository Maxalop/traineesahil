package com.hexaware.MLP156.factory;

import com.hexaware.MLP156.persistence.OrdersDAO;
import com.hexaware.MLP156.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP156.model.Orders;
/**
 * OrdersFactory class used to fetch orders data from database.
 * @author hexware
 */
public class OrdersFactory {
  /**
   *  Protected constructor.
   */
  protected OrdersFactory() {
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   */
  public static Orders[] showOrdersForCustomers() {
    List<Orders> ord = dao().show();
    return ord.toArray(new Orders[ord.size()]);
  }
    /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param ab the array of orders object
   */
  // public static Orders showOrdersForVendorss(final int ab) {
  //   OrdersDAO eDAO = dao();
  //   Orders emp = eDAO.showOrdersForVendorss(ab);
  //   return emp;
  // }
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   */
  public static Orders[] showOrdersForVendors() {
    List<Orders> ord = dao().show();
    return ord.toArray(new Orders[ord.size()]);
  }
    /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param a the array of orders object
   */
  public static  Orders employeeorderhistory(final int a) {
    OrdersDAO oDAO = dao();
    Orders  odr = oDAO.employeeorderhistory(a);
    return odr;
  }
   /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param a the array of orders object
   */
  public static  Orders vendororderhistory(final int a) {
    OrdersDAO oDAO = dao();
    Orders odr = oDAO.vendororderhistory(a);
    return odr;
  }
}