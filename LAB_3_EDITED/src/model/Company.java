package model;

import java.text.ParseException;
import java.util.ArrayList;

public class Company {

    private ArrayList<Employee> empList;

    public Company() throws ParseException {
        this.empList = new ArrayList<>();
        this.empList.add(new FullTimeEmployee("F101", "Nguyen", "A", "11-01-2000", 1, 3));
        this.empList.add(new FullTimeEmployee("F102", "Tran", "B", "11-02-2000", 2, 2));
        this.empList.add(new FullTimeEmployee("F103", "Le", "C", "11-03-2000", 3, 1));
        this.empList.add(new PartTimeEmployee("P101", "Nguyen", "A", "11-01-1999", 1));
        this.empList.add(new PartTimeEmployee("P102", "Tran", "B", "11-02-1999", 2));
        this.empList.add(new PartTimeEmployee("P103", "Le", "C", "11-03-1999", 3));
    }

    public ArrayList<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(ArrayList<Employee> empList) {
        this.empList = empList;
    }

}
