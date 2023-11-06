// import for date
import java.time.LocalDate;

public class PaySlip_DelRosario {
  private String name;
  private double basicSalary;
  private int overTime;
  private LocalDate currentDate;
  private double overTimePay;
  private double grossIncome;
  private double withholdingTax;
  private double sssDeduction;
  private double pagIbigDeduction;
  private double philHealthDeduction;
  private double netPay;

  // Set the input
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setBasicSalary(int basicSalary) {
    this.basicSalary = basicSalary;
  }

  public double getBasicSalary() {
    return basicSalary;
  }

  public void setOverTime(int overTime) {
    this.overTime = overTime;
  }

  public int getOverTime() {
    return overTime;
  }

  public LocalDate getCurrentDate() {
    currentDate = java.time.LocalDate.now();
    return currentDate;
  }

  public double getOverTimePay() {
    overTimePay = overTime * (0.01 * basicSalary);
    return overTimePay;
  }

  public double getGrossIncome() {
    grossIncome = basicSalary + overTimePay;
    return grossIncome;
  }

  public double getWithholdingTax(double grossIncome) {
    if (grossIncome < 20000) {
      return grossIncome * 0;
    }  
    if (grossIncome > 20000 && grossIncome < 31000) {
      return ((grossIncome - 20000) * 0.2);
    }  
    if (grossIncome > 31000 && grossIncome < 61000) {
      return ((grossIncome - 31000) * 0.25) + 2300;
    }  
    if (grossIncome > 61000 && grossIncome < 154000) {
      return ((grossIncome - 61000) * 0.3) + 10000;
    }  
    if (grossIncome > 154000 && grossIncome < 615000) {
      return ((grossIncome - 154000) * 0.32) + 38000;
    }  

    return ((grossIncome - 615000) * 0.35) + 185000;

  }

  public double getSssDeduction() {
    sssDeduction = basicSalary * 0.13;
    return sssDeduction;
  }

  public double getPagIbigDeduction() {
    pagIbigDeduction = basicSalary * 0.02;
    return pagIbigDeduction;
  }

  public double getPhilheatlDeduction() {
    philHealthDeduction = basicSalary * 0.35;
    if (philHealthDeduction > 2450) {
      philHealthDeduction = 2450;
    }
    return philHealthDeduction;
  }

  public double getNetPay() {
    netPay = grossIncome - withholdingTax - (sssDeduction + pagIbigDeduction + philHealthDeduction);
    return netPay;
  }

  public void getOutput() {
    System.out.println("");
    System.out.println("*********************");
    System.out.println("******Payslip*******");
    System.out.println("*********************");
    System.out.println("Date Generated:" + getCurrentDate());
    System.out.println("Employee Name:" + getName());
    System.out.printf("Basic Salary " +"₱: %.2f %n" , getBasicSalary());
    System.out.println("No. of OT hours:" + getOverTime());
    System.out.printf("OT Pay " + "₱: %.2f %n" , getOverTimePay());
    System.out.printf("Gross Income" +"₱: %.2f %n" , getGrossIncome());
    System.out.printf("Witholding Tax" +"₱: %.2f %n" ,  getWithholdingTax());
    System.out.println("OtherDeductions:");
    System.out.printf("    SSS " +"₱:%.2f %n" , getSssDeduction());
    System.out.printf("    Pag-ibig " + "₱:%.2f %n" , getPagIbigDeduction());
    System.out.printf("    PhilHealth " +"₱:%.2f %n", getPhilheatlDeduction());
    System.out.printf("Net Pay " +"₱:%.2f %n" , getNetPay());
  }

}
