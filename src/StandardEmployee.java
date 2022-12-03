import org.w3c.dom.Attr;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class StandardEmployee extends Employee {
    //    Attributes
    private final float salaryOneDay = 100;
    private Employee managerIncharge;

    //    Get and Set methods
    public Employee getManagerIncharge() {
        return managerIncharge;
    }

    public void setManagerIncharge(Employee managerIncharge) {

        this.managerIncharge = managerIncharge;
    }

    //    Constructor methods
    public void init() {
        this.managerIncharge = null;
    }

    public StandardEmployee() {
        super();
        init();
    }

    public StandardEmployee(String employeeId, String fullName, String phoneNumber, int numberOfWorkingDays) {
        super(employeeId, fullName, phoneNumber, numberOfWorkingDays);
        this.managerIncharge = null;
    }

    //    Input and Output methods
    @Override
    public void inputEmployeeInfo(Scanner sc) {
        super.inputEmployeeInfo(sc);
    }

    @Override
    public void outputInfoForEmployee() {
        super.outputInfoForEmployee();
        String text = "";
        if (this.managerIncharge == null) {
            text += this.formatForStringAttribute("Not managed") + "||";

        } else {
            text += this.formatForStringAttribute(this.managerIncharge.fullName) + "||";
        }
        System.out.println(text);
    }

    @Override
    protected void outputInfoForEmployeeThreeFields() {
        super.outputInfoForEmployeeThreeFields();
        String text = "";
        text += formatForStringAttribute("Standard") + "||";
        System.out.println(text);
    }

    @Override
    protected void outputInfoForEmployeeFourFields() {
        super.outputInfoForEmployeeThreeFields();
        String text = "";
        text += formatForStringAttribute("Standard") + "|";
        text += formatForStringAttribute(String.valueOf(this.salary)) + "||";
        System.out.println(text);
    }

    @Override
    protected void calSalary() {
        this.salary = this.salaryOneDay * this.numberOfWorkingDays;
    }
}
