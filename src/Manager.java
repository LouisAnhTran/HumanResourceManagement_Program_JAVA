import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Manager extends Employee {
    //    attributes
    private final float salaryOneDay = 200;
    private int numberOfEmployeeBeingManaged;

    //    Get and set methods
    public int getNumberOfEmployeeBeingManaged() {
        return numberOfEmployeeBeingManaged;
    }

    //    Constructor methods
    public Manager() {
        super();
        this.numberOfEmployeeBeingManaged = 0;
    }

    public Manager(String employeeId, String fullName, String phoneNumber, int numberOfWorkingDays) {
        super(employeeId, fullName, phoneNumber, numberOfWorkingDays);
        this.numberOfEmployeeBeingManaged = 0;
    }

    //    Input and print out information methods
    @Override
    public void inputEmployeeInfo(Scanner sc) {
        super.inputEmployeeInfo(sc);
    }

    @Override
    public void outputInfoForEmployee() {
        super.outputInfoForEmployee();
        String text = "";
        text += this.formatForFloatAttribute((float) (this.numberOfEmployeeBeingManaged)) + "||";
        System.out.println(text);
    }

    @Override
    protected void outputInfoForEmployeeThreeFields() {
        super.outputInfoForEmployeeThreeFields();
        String text = "";
        text += formatForStringAttribute("Manager") + "||";
        System.out.println(text);
    }

    @Override
    protected void outputInfoForEmployeeFourFields() {
        super.outputInfoForEmployeeThreeFields();
        String text = "";
        text += formatForStringAttribute("Manager") + "|";
        text += formatForStringAttribute(String.valueOf(this.salary)) + "||";
        System.out.println(text);
    }

    //    Business methods
    @Override
    protected void calSalary() {
        this.salary = this.numberOfEmployeeBeingManaged * 100 + this.numberOfWorkingDays * this.salaryOneDay;
    }

    public void increaseNumberOfEmployeeManage() {
        this.numberOfEmployeeBeingManaged++;
    }

    public void decreaseNumberOfEmployeeManage() {
        this.numberOfEmployeeBeingManaged--;
    }



}
