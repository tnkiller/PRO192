package model;

import java.text.ParseException;
import java.util.ArrayList;

public class Company {

    private ArrayList<Employee> empList;

    public Company() throws ParseException {
        this.empList = new ArrayList<>();
        this.empList.add(new FullTimeEmployee("1", "Hoang", "Nguyen", "11-01-2000", 5, 6));
        this.empList.add(new FullTimeEmployee("10", "thuy", "thuy", "11-01-2000", 5, 10));
        this.empList.add(new PartTimeEmployee("2", "Truong", "Nguyen", "22-12-2000", 10));
    }

    public ArrayList<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(ArrayList<Employee> empList) {
        this.empList = empList;
    }

}
