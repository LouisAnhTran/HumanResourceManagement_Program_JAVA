import java.lang.reflect.Constructor;
import java.util.Scanner;
import java.util.jar.Attributes;

public abstract class Employee {
    //    Attributes
    protected String employeeId;
    protected String fullName;
    protected String phoneNumber;
    protected int numberOfWorkingDays;
    protected float salary;

    //    Get and Set methos
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberOfWorkingDays() {
        return numberOfWorkingDays;
    }

    public void setNumberOfWorkingDays(int numberOfWorkingDays) {
        this.numberOfWorkingDays = numberOfWorkingDays;
    }

    public float getSalary() {
        return salary;
    }

    //    Constructor
    protected Employee() {

    }

    public Employee(String employeeId, String fullName, String phoneNumber, int numberOfWorkingDays) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.numberOfWorkingDays = numberOfWorkingDays;
    }

    //    Input and print out employee information
    protected void inputEmployeeInfo(Scanner sc) {
        System.out.println("****** Please input information for these fields of employee");
        System.out.print("Employee ID: ");
        this.employeeId = sc.nextLine();

        System.out.print("Full name: ");
        this.fullName = sc.nextLine();

        System.out.print("Mobile Phone: ");
        this.phoneNumber = sc.nextLine();

        System.out.print("Number of workings day: ");
        this.numberOfWorkingDays = Integer.parseInt(sc.nextLine());
    }


    protected void outputInfoForEmployee() {
        String text = "";
        text += "||" + formatForStringAttribute(this.employeeId) + "|";
        text += formatForStringAttribute(this.fullName) + "|";
        text += formatForStringAttribute(this.phoneNumber) + "|";
        text += formatForFloatAttribute((float) this.numberOfWorkingDays) + "|";
        text += formatForFloatAttribute(this.salary) + "|";
        System.out.print(text);
    }

    protected void outputInfoForEmployeeThreeFields() {
        String text = "";
        text += "||" + formatForStringAttribute(this.employeeId) + "|";
        text += formatForStringAttribute(this.fullName) + "|";
        System.out.print(text);
    }

    protected void outputInfoForEmployeeFourFields() {
        String text = "";
        text += "||" + formatForStringAttribute(this.employeeId) + "|";
        text += formatForStringAttribute(this.fullName) + "|";
        System.out.print(text);
    }

    //    Helper for output information
    protected String formatForStringAttribute(String stringType) {
        String paddleLeft = "%5s";
        String paddleRight = "%-15s";
        return String.format(paddleLeft, " ") + String.format(paddleRight, stringType);
    }

    protected String formatForFloatAttribute(Float floatType) {
        String paddleLeft = "%8s";
        String paddleRight = "%-12s";
        return String.format(paddleLeft, " ") + String.format(paddleRight, floatType);
    }

    //    Business Methods
    protected abstract void calSalary();
}
