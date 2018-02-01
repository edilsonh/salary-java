public class Salesman extends Employee {
  private int annualSales;

  public Salesman(String name, int monthlySalary, int annualSales){
    super(name, monthlySalary);
    this.annualSales = annualSales;
  }

  public int annualSalary(){
    int commission = (int) Math.round(annualSales * .02);
    /*
    * Annual sales is multiplied by 2% and the rounded
    * to the next dollar and converted to a integer
    */
    int baseSalary = super.annualSalary();
    if (commission < 20000) {
      return commission + baseSalary;
    } else {
      return 20000 + baseSalary;
    }
  }

  public String toString(){
    return super.toString() + ", Annual Sales: " + annualSales;
  }
}
