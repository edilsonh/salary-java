public class Employee {
  private String name;
  private int monthlySalary;

  public Employee(String name, int monthlySalary){
    this.name = name;
    this.monthlySalary = monthlySalary;
  }

  public int annualSalary(){
    return monthlySalary * 12;
  }

  public String toString(){
    return "Name: " + name + ", Monthly Salary: " + monthlySalary;
  }
}
