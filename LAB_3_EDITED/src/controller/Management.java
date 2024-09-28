package controller;

import java.text.ParseException;
import model.*;
import view.Menu;
import view.Utils;

public class Management {

    Company comp;

    public Management() throws ParseException {
        comp = new Company();
    }

    //execute
    public void execute(int choice) throws ParseException {
        do {
            Menu.showMainMenu();
            choice = Integer.parseInt(Utils.getValue("Enter your choice: "));
            switch (choice) {
                case 1 ->
                    inputEmp();
                case 2 ->
                    displayEmp();
                case 3 ->
                    sortingSalary();
                case 4 ->
                    delEmp();
                case 5 ->
                    exportAvrSal();
                case 0 ->
                    System.out.println("See you again...");
                default ->
                    System.out.println("Invalid choice!...");
            }
        } while (choice <= 5 && choice != 0);
    }

    //input
    private void inputEmp() throws ParseException {
        int numEmp = Integer.parseInt(Utils.getValue("Enter number of employee you want to add: "));
        for (int i = 0; i < numEmp; i++) {
            System.out.println("Employee[" + i + "]: ");
            String id = Utils.getValue("Enter id: ");
            String lastName = Utils.getValue("Enter last name: ");
            String firstName = Utils.getValue("Enter first name: ");
            String dob = Utils.getValue("Enter date of birth: ");
            int workingDay = Integer.parseInt(Utils.getValue("Enter working day in a month: "));
            int empType = 0;
            Menu.showSubMenu();
            empType = Integer.parseInt(Utils.getValue("Enter type of employee: "));
            if (empType == 1) {
                int otTime = Integer.parseInt(Utils.getValue("Enter OT time: "));
                FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(id, lastName, firstName, dob, workingDay, otTime);
                comp.getEmpList().add(fullTimeEmployee);
            } else if (empType == 2) {
                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(id, lastName, firstName, dob, workingDay);
                comp.getEmpList().add(partTimeEmployee);
            }
        }
    }

    //display
    public void displayEmp() {
        if (comp.getEmpList() != null) {
            int choice;
            do {
                Menu.showDetailMenu();
                choice = Integer.parseInt(Utils.getValue("You choose: "));
                switch (choice) {
                    case 1 -> {
                        System.out.println("\t\t\t~~~~~~~~~~All employees in company~~~~~~~~~~");
                        System.out.format("%-5s | %-10s | %-10s | %-5s | %-10s | %-15s | %-10s\n",
                                "ID",
                                "Last Name",
                                "First Name",
                                "Age",
                                "Date of birthay",
                                "Woking day",
                                "Salary"
                        );
                        for (Employee i : comp.getEmpList()) {
                            System.out.print(i.toString());
                        }
                    }
                    case 2 -> {
                        System.out.println("\t\t\t~~~~~~~~~~Full-time employees in company~~~~~~~~~~");
                        System.out.format("%-5s | %-10s | %-10s | %-5s | %-10s | %-15s | %-10s | %-5s\n",
                                "ID",
                                "Last Name",
                                "First Name",
                                "Age",
                                "Date of birthay",
                                "Woking day",
                                "Salary",
                                "OT time"
                        );
                        for (Employee i : comp.getEmpList()) {
                            if (i instanceof FullTimeEmployee) {
                                System.out.print(((FullTimeEmployee) i).toStringFull());
                            }
                        }
                        System.out.println("\n");
                        System.out.println("\t\t\t~~~~~~~~~~Part-time employees in company~~~~~~~~~~");
                        System.out.format("%-5s | %-10s | %-10s | %-5s | %-10s | %-15s | %-10s\n",
                                "ID",
                                "Last Name",
                                "First Name",
                                "Age",
                                "Date of birthay",
                                "Woking day",
                                "Salary"
                        );
                        for (Employee i : comp.getEmpList()) {
                            if (i instanceof PartTimeEmployee) {
                                System.out.println(i.toString());
                            }
                        }

                    }
                    default ->
                        System.out.println("Invalid! Choose again");
                }
            } while (choice > 3);

        } else {
            System.out.println("Empty list...");
        }
    }

    //sort according salary
    public void sortingSalary() {
        for (int i = 1; i < comp.getEmpList().size(); i++) {
            float key = comp.getEmpList().get(i).calSalary();
            Employee keyEmp = comp.getEmpList().get(i);
            int j = i - 1;
            while (j >= 0 && key > comp.getEmpList().get(j).calSalary()) {
                comp.getEmpList().set(j + 1, comp.getEmpList().get(j));
                j--;
            }
            comp.getEmpList().set(j + 1, keyEmp);
        }
        System.out.println("\t\t\t~~~~~~~~~~List after sorted~~~~~~~~~~");
        System.out.format("%-5s | %-10s | %-10s | %-5s | %-10s | %-15s | %-10s\n",
                "ID",
                "Last Name",
                "First Name",
                "Age",
                "Date of birthay",
                "Woking day",
                "Salary"
        );
        for (Employee i : comp.getEmpList()) {
            System.out.print(i.toString());
        }
    }

    //search and delete according to name
    public void delEmp() {
        if (!comp.getEmpList().isEmpty()) {
            String searchName = Utils.getValue("Enter name employee need deleted: ");
            boolean isExist = false;
            for (int i = 0; i < comp.getEmpList().size(); i++) {
                if (comp.getEmpList().get(i).getFirstName().equalsIgnoreCase(searchName)) {
                    isExist = true;
                    comp.getEmpList().remove(i);
                    break;
                }
            }
            if (!isExist) {
                System.out.println("Can't find name in list...");
            } else {
                System.out.println("Deleted successfully!");
            }
        } else {
            System.out.println("Empty list...");
        }

    }

    //export average salary according to each type of emp
    public void exportAvrSal() {
        float resFull = 0.0f;
        float resPart = 0.0f;
        int countFull = 0;
        int countPart = 0;
        for (Employee i : comp.getEmpList()) {
            if (i instanceof FullTimeEmployee) {
                countFull++;
                resFull += i.calSalary();
            } else if (i instanceof PartTimeEmployee) {
                countPart++;
                resPart += i.calSalary();
            }
        }
        System.out.println("---> Average salary of Full-time employee: " + (resFull / countFull));
        System.out.println("<----------------------------------------------------->");
        System.out.println("---> Average salary of Part-time employee: " + (resPart / countPart));
    }
}
