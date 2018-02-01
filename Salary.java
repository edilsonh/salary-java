/*
* File: Salary.java
* Author: Edilson Hernandez
* Date: January 21, 2018
* Purpose: The purpose of this program is to read from a text file and
*  create objects of employees depending on the position. Furthermore, each
*  employee is stored in the corresponding year. The information of each
*  employee is displayed by year and average per year is displayed.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Salary {
  public static void main (String[] args){
    BufferedReader inputStream = null;
    Employee[] year2014 = new Employee[10];
    Employee[] year2015 = new Employee[10];
    // Employee[] creates an array that will consist of the object Employee
    int count2014 = 0;
    int count2015 = 0;
    // The 'count' variables is to determine the index where the Employee object will be stored
    int total2014 = 0;
    int total2015 = 0;
    // The 'total' variable is used to store the total for each to later find the average

    String fileLine;
    try {
      inputStream = new BufferedReader(new FileReader("Employees.txt"));
      while ((fileLine = inputStream.readLine()) != null) {
        String[] emp = fileLine.split(" ");
        /*
        * 'emp' is used to store an array of each element for each line from Employee.txt
        * Interger.parseInt is used to convert the a number string to an integer
        */
        switch (Integer.parseInt(emp[0])) {
          case 2014:
          if (emp[1].equals("Employee")) {
            Employee e = new Employee(emp[2], Integer.parseInt(emp[3]));
            year2014[count2014] = e;
          } else if (emp[1].equals("Salesman")) {
            Salesman s = new Salesman(emp[2], Integer.parseInt(emp[3]), Integer.parseInt(emp[4]));
            year2014[count2014] = s;
          } else if (emp[1].equals("Executive")) {
            Executive exec = new Executive(emp[2], Integer.parseInt(emp[3]), Integer.parseInt(emp[4]));
            year2014[count2014] = exec;
          }
            count2014++;
            break;

          case 2015:
          if (emp[1].equals("Employee")) {
            Employee e = new Employee(emp[2], Integer.parseInt(emp[3]));
            year2015[count2015] = e;
          } else if (emp[1].equals("Salesman")) {
            Salesman s = new Salesman(emp[2], Integer.parseInt(emp[3]), Integer.parseInt(emp[4]));
            year2015[count2015] = s;
          } else if (emp[1].equals("Executive")) {
            Executive exec = new Executive(emp[2], Integer.parseInt(emp[3]), Integer.parseInt(emp[4]));
            year2015[count2015] = exec;
          }
            count2015++;
            break;
        }
      }
    } catch(IOException io) {
      System.out.println("Issue closing the files " + io.getMessage());
    }
    System.out.println("2014 Employees:");
    for (int i=0; i<10; i++) {
      if (year2014 != null) {
        System.out.println(year2014[i] + ", Annual Salary: " + year2014[i].annualSalary()+ "\n");
        total2014 += year2014[i].annualSalary();
      }
    }
    System.out.println("\n2015 Employees:");
    for (int i=0; i<10; i++) {
      if (year2015 != null) {
        System.out.println(year2015[i] + ", Annual Salary: " + year2015[i].annualSalary()+ "\n");
        total2015 += year2015[i].annualSalary();
      }
    }
    System.out.println("The average salary for 2014 was $" + total2014/10);
    System.out.println("The average salary for 2015 was $" + total2015/10);
  }
}
