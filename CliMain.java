package com.hexaware.MLP156.util;

import java.util.Scanner;

import com.hexaware.MLP156.factory.EmployeeFactory;
import com.hexaware.MLP156.factory.VendorFactory;
import com.hexaware.MLP156.factory.MenuFactory;
import com.hexaware.MLP156.factory.OrdersFactory;
import com.hexaware.MLP156.model.Employee;
import com.hexaware.MLP156.model.Menu;
import com.hexaware.MLP156.model.Orders;
import com.hexaware.MLP156.model.Vendor;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("  Canteen Management System  ");
    System.out.println("-----------------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Employee Login");
    System.out.println("3. Vendor Login");
    System.out.println("4. Exit");
    mainMenuDetails();
  }
/**
 * mainMenuDetails method  process the option selected from main menu.
 */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice: ");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullMenu();
          break;
        case 2:
          empLogin();
          break;
        case 3:
          venLogin();
          break;
        // case 4:
        //   empWltBal();
        //   break;
        // //
        case 4:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose appropriate option.");
      }
    }   catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }
/**
 * showFullMenu method  display the menu item stored in database.
 */
  private void showFullMenu() {
    Menu[] menu = MenuFactory.showMenu();
    System.out.println("FOOD_ID " + "FOOD_NAME " + "VENDOR_ID " + "FOOD_TYPE " + "CALORIES " + "FOOD_AMT ");
    for (Menu m : menu) {
      System.out.println(m.getFoodId() + " " + m.getFoodName() + " " + m.getVenId() + " "
                         + m.getFoodType() + " " + m.getFoodType() + " " + m.getCalories() + " " + m.getFoodAmt());
    }
  }

  private void empLogin() {
    System.out.println("Enter Employee UserName: ");
    String eName = option.next();
    System.out.println("Enter Password: ");
    String ePassword = option.next();
    Employee emp = EmployeeFactory.validateLogin(eName, ePassword);
    int emp1 = emp.getEmpId();

    if (emp == null) {
      System.out.println("Please enter valid details.");
      return;
    } else {
      empMenu(eName, emp1);
      System.out.println(emp);
    }
  }

  private void empMenu(final String eName, final int emp1) {
    System.out.println("      Employee Page      ");
    System.out.println("-------------------------");
    System.out.println("1. Check Wallet Balanace");
    System.out.println("2. Order History");
    System.out.println("3. Place Order");
    System.out.println("4. Exit");
    empMenuDetails(eName, emp1);
  }
/**
 *
 * @param eName gets the employee username.
 */
  public void empMenuDetails(final String eName, final int emp1) {
    try {
      System.out.println("Enter your choice: ");
      int empOption = option.nextInt();
      switch (empOption) {
        case 1:
          empWltBal(emp1);
          empMenu(eName, emp1);
          break;
        case 2:
          showOrdersForEmployee(emp1);
          empMenu(eName, emp1);
          break;
        case 3:
          placeOrder();
          empMenu(eName, emp1);
          break;
        case 4:
          mainMenu();
        default:
          System.out.println("Choose an appropriate option.");
      }
    }   catch (Exception e) {
      e.printStackTrace();
      System.out.println("Enter a valid value.");
    }
    option.nextLine();
    mainMenuDetails();
  }

  private void empWltBal(final int emp1) {
    double ebal = EmployeeFactory.empwalletbal(emp1);
    System.out.println("Your Wallet Balance is " + ebal);  
  }

  public void showOrdersForEmployee(final int emp1) {
    // System.out.println("Enter your Employee Id: ");
    // int eId = option.nextInt();
    Orders ord = OrdersFactory.employeeorderhistory(emp1);
    System.out.println(ord);
  }




  private void venLogin() {
    System.out.println("Enter Vendor UserName: ");
    String vName = option.next();
    System.out.println("Enter Password: ");
    String vPassword = option.next();
    Vendor ven = VendorFactory.validateVLogin(vName, vPassword);
    int ven1 = ven.getVendoorId();

    if (ven == null) {
      System.out.println("Please enter valid details");
      return;
    } else {
      venMenu(vName, ven1);
      System.out.println(ven);
    }
  }

  private void venMenu(final String vName, final int ven1) {
    System.out.println("      Vendor Page      ");
    System.out.println("-----------------------");
    System.out.println("1. Check Wallet Balance");
    System.out.println("2. Order History");
    System.out.println("3. Order Status");
    System.out.println("4. Exit");
    venMenuDetails(vName, ven1);
  }
/**
 * venMenuDetails method  process the option selected from main menu.
 */
  private void venMenuDetails(final String vName, final int ven1) {
    try {
      System.out.println("Enter your choice: ");
      int venOption = option.nextInt();
      switch (venOption) {
        case 1:
          venWltBal(ven1);
          venMenu(vName, ven1);
          break;
        case 2:
          showOrdersForVendors(ven1);
          venMenu(vName, ven1);
          break;
        case 3:
          placeOrder();
          break;
        case 4:
          mainMenu();
        default:
          System.out.println("Choose an appropriate option.");
      }
    }   catch (Exception e) {
      e.printStackTrace();
      System.out.println("Enter a valid value");
    }
    option.nextLine();
    mainMenuDetails();
  }

  private void placeOrder() {
  }

  /**
   */
  public void venWltBal(final int ven1) {
    // System.out.println("Enter your Vendor Id: ");
    // int vid = option.nextInt();

    double vbal = VendorFactory.venwalletbal(ven1);
    System.out.println("Your Wallet Balance is " + vbal);
  }

  public void showOrdersForVendors(int ven1) {
    // System.out.println("Enter your vendor ID:");
    // int venId = option.nextInt();
    Orders ven = OrdersFactory.vendororderhistory(ven1);
    System.out.println(ven);
  }
/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
