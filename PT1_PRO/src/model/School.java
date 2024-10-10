package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Predicate;
import view.Menu1;
import view.Utils;

public class School {

    private ArrayList<Student> studentList;

    public School() throws ParseException {
        this.studentList = new ArrayList<>();
        this.studentList.add(new Student(1, "Nguyen Van A", "15/01/2000", 8.5f, 9.0f));
        this.studentList.add(new Student(10, "Bui Van P", "12/06/2000", 7.5f, 7.8f));
        this.studentList.add(new Student(2, "Tran Thi B", "23/11/1999", 7.8f, 8.2f));
        this.studentList.add(new Student(4, "Pham Thi D", "22/07/1998", 7.4f, 7.7f));
        this.studentList.add(new Student(3, "Le Van C", "10/03/2001", 9.2f, 8.8f));
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Student> search(Predicate<Student> p) {
        ArrayList<Student> rs = new ArrayList<>();
        for (Student i : studentList) {
            if (p.test(i)) {
                rs.add(i);
            }
        }
        return rs;
    }

    //SEARCH
    public void searchList() throws ParseException {
        String[] subMn = {
            "by average",
            "by date of birth",
            "Back"
        };
        Menu1 subMenu = new Menu1("Search by...", subMn) {
            @Override
            public void execute(int n) throws ParseException {
                ArrayList<Student> rs = null;
                switch (n) {
                    case 1 -> {
                        float avr = Float.parseFloat(Utils.getValue("Enter average: "));
                        rs = search(p -> p.getAverage() == avr);
                    }
                    case 2 -> {
                        Student temp = new Student();
                        String dob = Utils.getValue("Enter date of birth: ");
                        Date dobDate = temp.setDob(dob);
                        rs = search(p -> p.getDobDate().equals(dobDate));
                    }
                }
                System.out.println(rs);
            }
        };
        subMenu.run();
    }

    public void sort(Comparator<Student> compare) throws ParseException {
        Collections.sort(studentList, compare);
    }

    //SORT
    public void sorting() throws ParseException {
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
                        Collections.sort(studentList, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
                    }
                    case 2 -> {
                        Collections.sort(studentList, (p1, p2) -> p1.getDobDate().compareTo(p2.getDobDate()));
                    }
                    case 3 -> {
                        Collections.sort(studentList, (p1, p2) -> p1.getName().compareTo(p2.getName()));
                    }
                    case 4 -> {
                        Collections.sort(studentList, (p1, p2) -> Double.compare(p1.getAverage(), p2.getAverage()));
                    }
                }
            }
        };
        subMenu.run();
    }

    //STATISTIC
    public void stat() {
        int numOfStudent = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        Date year2000 = calendar.getTime();
        for (Student st : studentList) {
            if (st.getDobDate().before(year2000)) {
                System.out.println(st);
                numOfStudent++;
            }
        }
        System.out.println("Number of student born before 2000: " + numOfStudent);
    }

}
