public class Executive extends Employee {
  private int stockPrice;

  public Executive(String name, int monthlySalary, int stockPrice){
    super(name, monthlySalary);
    this.stockPrice = stockPrice;
  }

  public int annualSalary(){
    if (stockPrice > 50) {
      return super.annualSalary() + 30000;
    } else {
      return super.annualSalary();
    }
  }

  public String toString(){
    return super.toString() + ", Stock Price: " + stockPrice;
  }
}
