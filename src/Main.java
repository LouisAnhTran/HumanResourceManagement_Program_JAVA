import javax.xml.parsers.SAXParser;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Company c1 = new Company();
        c1.createDummyDataStandardEmployee();
        c1.createDummyDataManager();
        c1.createDummyDataDirector();
        runProgram(sc, c1);
    }

    private static void showMenu() {
        System.out.println("========================================== MENU ==============================================");
        System.out.println("1.  Add information for company");
        System.out.println("2.  Allocation standard employee to manager");
        System.out.println("3.  Add one new employee to the company (can be types of employees)");
        System.out.println("4.  Remove one employee from the company");
        System.out.println("5.  Print out list of all employees with their corresponding salary");
        System.out.println("6.  Find a list of standard employee with highest salary");
        System.out.println("7.  Find a list of manager with the most number of employees under his supervision");
        System.out.println("8.  Sort the list of all employees of the company according to ABC");
        System.out.println("9.  Sort the list of all employees of the company in the descending order of their salary");
        System.out.println("10. Find a list of director with greatest amount of share holding");
        System.out.println("11. Print out total income for all directors");
        System.out.println("0. Exit the program");
        System.out.println("==============================================================================================");
        System.out.println();
    }

    private static void runProgram(Scanner sc, Company companyRun) {
        int userSelection;
        do {
            showMenu();
            System.out.print("Please select one option you'd like to proceed: ");
            userSelection = Integer.parseInt(sc.nextLine());

            while (userSelection > 11 || userSelection < 0) {
                System.out.print("Please kindly choose again (only 0-10 valid): ");
                userSelection = Integer.parseInt(sc.nextLine());
            }

            switch (userSelection) {
                case 1:
                    companyRun.inputInformation(sc);
                    System.out.println();
                    break;
                case 2:
                    companyRun.allocateEmployeeToManager(sc);
                    System.out.println();
                    break;
                case 3:
                    companyRun.addOneEmployeeToCompany(sc);
                    System.out.println();
                    break;
                case 4:
                    companyRun.removeOneEmployeeById(sc);
                    break;
                case 5:
                    companyRun.printOutDirectorListFormat(companyRun.getListDirector());
                    companyRun.printOutManagerListFormat(companyRun.getListManager());
                    companyRun.printOutStandardEmployeeListFormat(companyRun.getListStandardEmployee());
                    System.out.println();
                    break;
                case 6:
                    ArrayList<Employee> l1 = companyRun.findListStandardEmployeeWithHigestSalary();
                    companyRun.printOutStandardEmployeeListFormat(l1);
                    System.out.println();
                    break;
                case 7:
                    ArrayList<Employee> l2 = companyRun.findListManagerWithHighestEmployee();
                    companyRun.printOutManagerListFormat(l2);
                    System.out.println();
                    break;
                case 8:
                    ArrayList<Employee> l3 = companyRun.sortListByName();
                    for (Employee e1 : l3) {
                        e1.outputInfoForEmployeeThreeFields();
                    }
                    System.out.println();
                    break;
                case 9:
                    ArrayList<Employee> l4 = companyRun.sortListBySalary();
                    for (Employee e1 : l4) {
                        e1.outputInfoForEmployeeFourFields();
                    }
                    System.out.println();
                    break;
                case 10:
                    ArrayList<Employee> l5 = companyRun.findListDirectorWithLargestShareHolding();
                    companyRun.printOutDirectorListFormat(l5);
                    System.out.println();
                    break;
                case 11:
                    companyRun.printOutDirectorWithTotalIncome();
                    break;
                case 0:
                    break;
            }

        } while (userSelection != 0);
    }


}