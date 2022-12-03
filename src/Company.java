import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.jar.Attributes;

public class Company {
    //    Attributes
    private String nameCompany;
    private String taxCode;
    private float monthlyRevenue;

    private float monthlyProfit;

    private ArrayList<Employee> listStandardEmployee;
    private ArrayList<Employee> listManager;
    private ArrayList<Employee> listDirector;

    //    Get and Set methods
    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public float getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(float monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    public float getMonthlyProfit() {
        return monthlyProfit;
    }

    public ArrayList<Employee> getListStandardEmployee() {
        return listStandardEmployee;
    }


    public ArrayList<Employee> getListManager() {
        return listManager;
    }


    public ArrayList<Employee> getListDirector() {
        return listDirector;
    }


    //    Constructor methods
    private void init() {
        this.listStandardEmployee = new ArrayList<Employee>();
        this.listManager = new ArrayList<Employee>();
        this.listDirector = new ArrayList<Employee>();
    }

    public Company() {
        this.init();
    }

    public Company(String nameCompany, String taxCode, float monthlyRevenue, ArrayList<Employee> listStandardEmployee, ArrayList<Employee> listManager, ArrayList<Employee> listDirector) {
        this.nameCompany = nameCompany;
        this.taxCode = taxCode;
        this.monthlyRevenue = monthlyRevenue;
        this.listStandardEmployee = listStandardEmployee;
        this.listManager = listManager;
        this.listDirector = listDirector;
    }

    // Input and print out company information
    public void inputInformation(Scanner sc) {
        System.out.println("=================== Provide Company Information =============");

        System.out.print("Company name: ");
        this.nameCompany = sc.nextLine();

        System.out.print("Tax code: ");
        this.taxCode = sc.nextLine();

        System.out.print("Monthly Revenue: ");
        this.monthlyRevenue = Float.parseFloat(sc.nextLine());
    }

    public void printOutCompanyInformation() {
        String text = "";
        text += "||" + this.formatForStringAttribute(this.nameCompany) + "|";
        text += this.formatForStringAttribute(this.taxCode) + "|";
        text += this.formatForFloatAttribute(this.monthlyRevenue) + "|";
        System.out.println(text);
    }

    //    Supporting methods for displaying company information
    private String formatForStringAttribute(String stringType) {
        String paddleLeft = "%5s";
        String paddleRight = "%-15s";
        return String.format(paddleLeft, " ") + String.format(paddleRight, stringType);
    }

    private String formatForFloatAttribute(Float floatType) {
        String paddleLeft = "%8s";
        String paddleRight = "%-12s";
        return String.format(paddleLeft, " ") + String.format(paddleRight, floatType);
    }


    // Add all types of employee by dummy data
    public void createDummyDataStandardEmployee() {
        try {
            FileReader reader = new FileReader("src/StandardEmployeeDummyData.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] listInfo = line.split(" # ");
                Employee em;
                em = new StandardEmployee(listInfo[0], listInfo[1], listInfo[2], Integer.parseInt(listInfo[3]));
                em.calSalary();
                // Thêm nhân sự vào list
                this.listStandardEmployee.add(em);
            }
            reader.close();// Đóng tập tin
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createDummyDataManager() {
        try {
            FileReader reader = new FileReader("src/ManagerDummyData.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] listInfo = line.split(" # ");
                Employee em;
                em = new Manager(listInfo[0], listInfo[1], listInfo[2], Integer.parseInt(listInfo[3]));
                em.calSalary();
                // Thêm nhân sự vào list
                this.listManager.add(em);
            }
            reader.close();// Đóng tập tin
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createDummyDataDirector() {
        try {
            FileReader reader = new FileReader("src/DirectorDummyData.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] listInfo = line.split(" # ");
                Employee em;
                em = new Director(listInfo[0], listInfo[1], listInfo[2], Integer.parseInt(listInfo[3]), Float.parseFloat(listInfo[3]));
                em.calSalary();
                // Thêm nhân sự vào list
                this.listDirector.add(em);
            }
            reader.close();// Đóng tập tin
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add type of employees to company manually
    private void showEmployeeMenu() {
        System.out.println("1. Standard Employee");
        System.out.println("2. Manager");
        System.out.println("3. Director");
        System.out.println("0. Exit");
    }

    public void addOneEmployeeToCompany(Scanner sc) {
        System.out.println("================ Add one employee to company ==============");
        int userInput;
        do {
            System.out.println();
            showEmployeeMenu();
            System.out.print("Select one option: ");
            userInput = Integer.parseInt(sc.nextLine());
            while (userInput > 3 || userInput < 0) {
                System.out.print("Choose again 0-3: ");
                userInput = Integer.parseInt(sc.nextLine());
            }
            switch (userInput) {
                case 1:
                    Employee newEm = new StandardEmployee();
                    newEm.inputEmployeeInfo(sc);
                    newEm.calSalary();
                    this.listStandardEmployee.add(newEm);
                    break;
                case 2:
                    Employee newMan = new Manager();
                    newMan.inputEmployeeInfo(sc);
                    newMan.calSalary();
                    this.listManager.add(newMan);
                    break;
                case 3:
                    Employee newDirec = new Director();
                    newDirec.inputEmployeeInfo(sc);
                    newDirec.calSalary();
                    this.listDirector.add(newDirec);
                    break;
                case 0:
                    break;
            }
        } while (userInput != 0);

    }

    //    print out all employees lists
    private void headerForStandardEmployee() {
        System.out.println("=================================================================================================================================");
    }

    private void headerForManager() {
        System.out.println("=================================================================================================================================");
    }

    private void headerForDirector() {
        System.out.println("=================================================================================================================================");
    }

    private void headlineForStandardEmployee() {
        String text = "";
        text += "||" + String.format("%9s", " ") + String.format("%-11s", "ID") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "Full name") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "Phone number") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "Working days") + "|";
        text += String.format("%6s", " ") + String.format("%-14s", "Salary") + "|";
        text += String.format("%2s", " ") + String.format("%-18s", "Manager In charge") + "||";
        System.out.println(text);
    }

    private void headlineForManager() {
        String text = "";
        text += "||" + String.format("%9s", " ") + String.format("%-11s", "ID") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "Full name") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "Phone number") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "Working days") + "|";
        text += String.format("%6s", " ") + String.format("%-14s", "Salary") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "No of Employees") + "||";
        System.out.println(text);
    }

    private void headlineForDirector() {
        String text = "";
        text += "||" + String.format("%9s", " ") + String.format("%-11s", "ID") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "Full name") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "Phone number") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "Working days") + "|";
        text += String.format("%6s", " ") + String.format("%-14s", "Salary") + "|";
        text += String.format("%4s", " ") + String.format("%-16s", "Holding Share") + "||";
        System.out.println(text);
    }

    public void printOutStandardEmployeeListFormat(ArrayList<Employee> listEm) {
        System.out.println("STANDARD EMPLOYEE LIST");
        this.headerForStandardEmployee();
        this.headlineForStandardEmployee();
        this.headerForStandardEmployee();
        for (Employee em : listEm) {
            em.outputInfoForEmployee();
        }
        this.headerForStandardEmployee();
    }

    public void printOutManagerListFormat(ArrayList<Employee> listEm) {
        System.out.println("MANAGER LIST");
        this.headerForManager();
        this.headlineForManager();
        this.headerForManager();
        for (Employee em : listEm) {
            em.outputInfoForEmployee();
        }
        this.headerForManager();
    }

    public void printOutDirectorListFormat(ArrayList<Employee> listEm) {
        System.out.println("DIRECTOR LIST");
        this.headerForDirector();
        this.headlineForDirector();
        this.headerForDirector();
        for (Employee em : listEm) {
            em.outputInfoForEmployee();
        }
        this.headerForDirector();
    }

    public void printOutAllEmployeeInCompany() {
        this.printOutDirectorListFormat(this.listDirector);
        this.printOutManagerListFormat(this.listManager);
        this.printOutStandardEmployeeListFormat(this.listStandardEmployee);
    }

    // Allocate Employee To Manager:
    private Employee findEmployeeById(String Id, ArrayList<Employee> listEm) {
        Employee em = null;
        for (Employee em1 : listEm) {
            if (em1.employeeId.equals(Id)) {
                em = em1;
                return em;
            }
        }
        return em;
    }

    public void allocateEmployeeToManager(Scanner sc) {
        this.printOutStandardEmployeeListFormat(this.listStandardEmployee);
        System.out.print("Select one employee to be allocated by ID: ");
        String idInput = sc.nextLine();
        Employee em = this.findEmployeeById(idInput, this.listStandardEmployee);
        while (em == null) {
            System.out.print("Please input correct ID: ");
            idInput = sc.nextLine();
            em = this.findEmployeeById(idInput, this.listStandardEmployee);
        }
        em = (StandardEmployee) em;

        this.printOutManagerListFormat(this.listManager);
        System.out.print("Select one manager to be allocate employee " + em.employeeId + ": ");
        idInput = sc.nextLine();
        Employee em1 = this.findEmployeeById(idInput, this.listManager);
        while (em1 == null) {
            System.out.print("Please input correct ID: ");
            idInput = sc.nextLine();
            em1 = this.findEmployeeById(idInput, this.listManager);
        }
        System.out.println("Allocation request is being process......");
        em1 = (Manager) em1;
        ((StandardEmployee) em).setManagerIncharge(em1);
        ((Manager) em1).increaseNumberOfEmployeeManage();
        System.out.println();
        System.out.println("================= New List after updated ===============");
        this.printOutAllEmployeeInCompany();
    }

    //    Calculate the salary of all employee in the company
    public float calTotalSalaryOfCompany() {
        float totalSalary = 0;
        for (Employee em : this.listStandardEmployee) {
            totalSalary += em.salary;
        }

        for (Employee em : this.listManager) {
            totalSalary += em.salary;
        }

        for (Employee em : this.listDirector) {
            totalSalary += em.salary;
        }

        return totalSalary;
    }

    //    List of standard employee with the highest salary
    public ArrayList<Employee> findListStandardEmployeeWithHigestSalary() {
        ArrayList<Employee> listEm = new ArrayList<Employee>();
        int maxIndex = 0;
        Employee maxEm = this.listStandardEmployee.get(0);
        for (int i = 0; i < this.listStandardEmployee.size(); i++) {
            Employee em1 = this.listStandardEmployee.get(i);
            if (em1.salary > maxEm.salary) {
                maxIndex = i;
                maxEm = em1;
            }
        }

        float maxSalary = maxEm.salary;

        for (int i = maxIndex; i < this.listStandardEmployee.size(); i++) {
            Employee em1 = this.listStandardEmployee.get(i);
            if (em1.salary == maxSalary) {
                listEm.add(em1);
            }
        }

        return listEm;
    }

    // List of Managers with the highest number of employee under his supervision
    public ArrayList<Employee> findListManagerWithHighestEmployee() {
        ArrayList<Employee> listMan = new ArrayList<Employee>();
        Employee maxManager = this.listManager.get(0);
        int index = 0;
        for (int i = 0; i < this.listManager.size(); i++) {
            if (((Manager) this.listManager.get(i)).getNumberOfEmployeeBeingManaged() > ((Manager) maxManager).getNumberOfEmployeeBeingManaged()) {
                maxManager = this.listManager.get(i);
                index = i;
            }
        }

        int maxEmployee = ((Manager) maxManager).getNumberOfEmployeeBeingManaged();

        for (int i = index; i < this.listManager.size(); i++) {
            Employee em = this.listManager.get(i);
            if (((Manager) em).getNumberOfEmployeeBeingManaged() == maxEmployee) {
                listMan.add(em);
            }
        }
        return listMan;
    }

    // Sorting all employes by name
    private ArrayList<Employee> combineThreeList() {
        ArrayList<Employee> listBig = new ArrayList<Employee>();
        for (Employee em : this.listStandardEmployee) {
            listBig.add(em);
        }
        for (Employee em : this.listManager) {
            listBig.add(em);
        }
        for (Employee em : this.listDirector) {
            listBig.add(em);
        }
        return listBig;
    }

    public ArrayList<Employee> sortListByName() {
        ArrayList<Employee> listBig = this.combineThreeList();
        int n = listBig.size();
        for (int i = 1; i < n; i++) {
            Employee temp = listBig.get(i);
            while ((i > 0) && (temp.getFullName().compareTo(listBig.get(i - 1).getFullName()) < 0)) {
                Collections.swap(listBig, i - 1, i);
                i--;
            }
            listBig.set(i, temp);
        }
        return listBig;
    }

    // Sorting all employes by Id
    public ArrayList<Employee> sortListBySalary() {
        ArrayList<Employee> listBig = this.combineThreeList();
        int n = listBig.size();
        for (int i = 1; i < n; i++) {
            Employee temp = listBig.get(i);
            while ((i > 0) && (temp.getSalary() > listBig.get(i - 1).getSalary())) {
                Collections.swap(listBig, i - 1, i);
                i--;
            }
            listBig.set(i, temp);
        }
        return listBig;
    }

    // Find director with the highest share holding in the company
    public ArrayList<Employee> findListDirectorWithLargestShareHolding() {
        ArrayList<Employee> listResult = new ArrayList<Employee>();
        if (this.listDirector.size() == 0) {
            return null;
        }

        Employee maxDirector = this.listDirector.get(0);
        int maxIndex = 0;
        for (int i = 0; i < this.listDirector.size(); i++) {
            if (((Director) (this.listDirector.get(i))).getShareHolding() > ((Director) maxDirector).getShareHolding()) {
                maxDirector = this.listDirector.get(i);
                maxIndex = i;
            }
        }

        float maxSalary = ((Director) maxDirector).getShareHolding();

        for (int i = maxIndex; i < this.listDirector.size(); i++) {
            Employee d1 = this.listDirector.get(i);
            if (((Director) (d1)).getShareHolding() == maxSalary) {
                listResult.add(d1);
            }
        }

        return listResult;
    }

    // Find and print out total income for each director
    private float calTotalSalaryCompany() {
        float totalSalary = 0;
        for (Employee em1 : this.listStandardEmployee) {
            totalSalary += em1.getSalary();
        }
        for (Employee em1 : this.listManager) {
            totalSalary += em1.getSalary();
        }
        for (Employee em1 : this.listDirector) {
            totalSalary += em1.getSalary();
        }
        return totalSalary;
    }

    private void calCompanyProfit() {
        this.monthlyProfit = this.monthlyRevenue - this.calTotalSalaryCompany();
    }

    public void printOutDirectorWithTotalIncome() {
        this.calCompanyProfit();
        for (Employee em1 : this.listDirector) {
            ((Director) em1).setTotalIncome(((Director) em1).getSalary() + (((Director) em1).getShareHolding() / 100) * this.monthlyProfit);
        }

        for (Employee em1 : this.listDirector) {
            ((Director) em1).outputDirectorWithTotalIncome();
        }
    }

    //    Remove one employee from the list
    private Employee findEmployeeById1(String id) {
        Employee e1 = null;
        for (Employee e2 : this.listManager) {
            if (e2.getEmployeeId().equals(id)) {
                e1 = e2;
                return e1;
            }
        }
        for (Employee e2 : this.listStandardEmployee) {
            if (e2.getEmployeeId().equals(id)) {
                e1 = e2;
                return e1;
            }
        }
        for (Employee e2 : this.listDirector) {
            if (e2.getEmployeeId().equals(id)) {
                e1 = e2;
                return e1;
            }
        }
        return e1;
    }

    public void removeOneEmployeeById(Scanner sc) {
        this.printOutDirectorListFormat(this.listDirector);
        this.printOutManagerListFormat(this.listManager);
        this.printOutStandardEmployeeListFormat(this.listStandardEmployee);
        System.out.println();
        System.out.print("Please input the ID that you want to remove from the list: ");
        String id = sc.nextLine();
        Employee e1 = this.findEmployeeById1(id);
        while (e1 == null) {
            System.out.print("Can not find " + id + " in the list, please input valid id: ");
            id = sc.nextLine();
            e1 = this.findEmployeeById1(id);
        }

        if (e1 instanceof Director) {
            for (int i = 0; i < this.listDirector.size(); i++) {
                if (this.listDirector.get(i).getEmployeeId().equals(e1.getEmployeeId())) {
                    this.listDirector.remove(i);
                    return;
                }
            }
        } else if (e1 instanceof StandardEmployee) {
            this.removeStandardEmployee(e1);
        } else {
            this.removeManager(e1);
        }
    }

    private void removeStandardEmployee(Employee e1) {
        if (((StandardEmployee) e1).getManagerIncharge() == null) {
            this.listStandardEmployee.remove(e1);
        } else {
            ((Manager) ((StandardEmployee) e1).getManagerIncharge()).decreaseNumberOfEmployeeManage();
            for (int i = 0; i < this.listStandardEmployee.size(); i++) {
                if (this.listStandardEmployee.get(i).getEmployeeId().equals(e1.getEmployeeId())) {
                    this.listStandardEmployee.remove(i);
                    return;
                }
            }
        }
    }

    private void removeManager(Employee e1) {
        if (((Manager) e1).getNumberOfEmployeeBeingManaged() == 0) {
            for (int i = 0; i < this.listManager.size(); i++) {
                if (this.listManager.get(i).getEmployeeId().equals(e1.getEmployeeId())) {
                    this.listManager.remove(i);
                    return;
                }
            }
        } else {
            for (Employee e2 : this.listStandardEmployee) {
                if (((StandardEmployee) e2).getManagerIncharge() == e1)
                    ((StandardEmployee) e2).setManagerIncharge(null);
            }
            for (int i = 0; i < this.listManager.size(); i++) {
                if (this.listManager.get(i).getEmployeeId().equals(e1.getEmployeeId())) {
                    this.listManager.remove(i);
                    return;
                }
            }
        }
    }
}



