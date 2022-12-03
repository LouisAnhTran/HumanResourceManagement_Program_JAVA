import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Director extends Employee {
    //    attributes
    private final float salaryOneDay = 300;
    private float shareHolding;

    private float totalIncome;

    //    Get and Set methods


    public float getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(float totalIncome) {
        this.totalIncome = totalIncome;
    }

    public float getShareHolding() {
        return shareHolding;
    }

    public void setShareHolding(float shareHolding) {
        if (shareHolding <= 100 & shareHolding >= 0) {
            this.shareHolding = shareHolding;
        }
    }

    //    Constructor
    public Director() {
        super();
    }

    public Director(String employeeId, String fullName, String phoneNumber, int numberOfWorkingDays, float shareHolding) {
        super(employeeId, fullName, phoneNumber, numberOfWorkingDays);
        this.setShareHolding(shareHolding);
    }

    //    Input and print out information
    @Override
    public void inputEmployeeInfo(Scanner sc) {
        super.inputEmployeeInfo(sc);
        System.out.print("Share holding: ");
        int input = Integer.parseInt(sc.nextLine());
        while (input < 0 || input > 100) {
            System.out.print("Input share 0-100 only: ");
            input = Integer.parseInt(sc.nextLine());
        }
        this.shareHolding = input;

    }

    @Override
    public void outputInfoForEmployee() {
        super.outputInfoForEmployee();
        String text = "";
        text += this.formatForFloatAttribute(this.shareHolding) + "||";
        System.out.println(text);
    }

    @Override
    public void outputInfoForEmployeeThreeFields() {
        super.outputInfoForEmployeeThreeFields();
        String text = "";
        text += formatForStringAttribute("Director") + "||";
        System.out.println(text);
    }

    @Override
    public void outputInfoForEmployeeFourFields() {
        super.outputInfoForEmployeeThreeFields();
        String text = "";
        text += formatForStringAttribute("Director") + "|";
        text += formatForStringAttribute(String.valueOf(this.salary)) + "||";
        System.out.println(text);
    }

    public void outputDirectorWithTotalIncome() {
        String text = "";
        text += "||" + formatForStringAttribute(this.employeeId) + "|";
        text += formatForStringAttribute(this.fullName) + "|";
        text += formatForStringAttribute(this.phoneNumber) + "|";
        text += formatForFloatAttribute((float) this.numberOfWorkingDays) + "|";
        text += formatForFloatAttribute(this.salary) + "|";
        text += formatForFloatAttribute(this.shareHolding) + "|";
        text += formatForFloatAttribute(this.totalIncome);
        System.out.println(text);
    }

    //    Business Methods
    @Override
    protected void calSalary() {
        this.salary = this.salaryOneDay * this.numberOfWorkingDays;
    }
}
