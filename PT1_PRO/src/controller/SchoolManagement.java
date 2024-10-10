package controller;

import java.text.ParseException;
import model.*;
import view.*;

public class SchoolManagement extends Menu1 {

    School school;
    static String[] stringMenu = {
        "Show information of student",
        "Search student",
        "Add new student",
        "Sorting",
        "Show students born before 2000",
        "Exit"
    };

    public SchoolManagement() throws ParseException {
        super("|-Student management tool-|", stringMenu);
        school = new School();
    }

    @Override
    public void execute(int n) throws ParseException {
        switch (n) {
            case 1 ->
                showStudent();
            case 2 ->
                school.searchList();
            case 3 ->
                addStudent();
            case 4 -> {
                school.sorting();
                showStudent();
            }
            case 5 ->
                school.stat();
            case 6 -> {
                sortStudent();
                showStudent();
            }
        }
    }

    //cua anh Minh
    private void sortStudent() throws ParseException {
        String[] subMn = {
            "by ID",
            "by date of birth",
            "by name",
            "by average",
            "Back"
        };
        Menu1 subMenu = new Menu1("Sort by...", subMn) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 -> {
                        school.sort((p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
                    }
                    case 2 -> {
                        school.sort((p1, p2) -> p1.getDobDate().compareTo(p2.getDobDate()));
                    }
                    case 3 -> {
                        school.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
                    }
                    case 4 -> {
                        school.sort((p1, p2) -> Double.compare(p1.getAverage(), p2.getAverage()));
                    }
                }
            }
        };
        subMenu.run();
    }

    //SHOW ALL
    public void showStudent() {
        System.out.format("%-5s | %-15s | %-15s | %-5s | %-5s | %-5s\n",
                "ID",
                "Name",
                "Date of birth",
                "Java",
                "HTML",
                "Average"
        );
        for (Student iStudent : school.getStudentList()) {
            System.out.println(iStudent.toString());

        }
    }

    //ADD NEW
    private void addStudent() throws ParseException {
        int id = (Integer.parseInt(Utils.getValue("Enter id: ")));
        String name = Utils.getValue("Enter name: ");
        String dob = Utils.getValue("Enter date of birth: ");
        float java = Float.parseFloat(Utils.getValue("Enter Java score: "));
        float html = Float.parseFloat(Utils.getValue("Enter HTML score: "));
        Student s1 = new Student(id, name, dob, java, html);
        school.getStudentList().add(s1);
    }

    public static void main(String[] args) throws ParseException {
        SchoolManagement obj = new SchoolManagement();
        obj.run();
    }

}
