import java.util.Scanner;

public class Employee_DelRosario {

  public static void main(String[] args) {
    // For scanner
    Scanner input = new Scanner(System.in);

    // set variables
    System.out.print("Input the name:");
    String name = input.nextLine();
    System.out.print("Input the basic salary:");
    int salary = input.nextInt();
    System.out.print("Input the over time hours:");
    int overtime = input.nextInt();

    PaySlip_DelRosario a = new PaySlip_DelRosario();
    a.setName(name);
    a.setBasicSalary(salary);
    a.setOverTime(overtime);

    a.getOutput();
  }
}
