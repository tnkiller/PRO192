package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

public class Employee {

    protected String id;
    protected String lastName;
    protected String firstName;
    protected Date dob;
    protected int workingDay;

    public Employee() {

    }

    public Employee(String id, String lastName, String firstName, String dob, int workingDay) throws ParseException {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = setDob(dob);
        this.workingDay = workingDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDob() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(dob);
    }

    public Date setDob(String dob) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.parse(dob);
    }

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    //calculate salary
    public float calSalary() {
        return 0;
    }

    //calculate age
    public int calAge() {
        String dobString = getDob();
        String[] splitted_dob = dobString.split("-");
        int yearBirth = Integer.parseInt(splitted_dob[splitted_dob.length - 1]);
        int curYear = Year.now().getValue();
        return curYear - yearBirth;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-10s | %-10s | %-5s | %-15s | %-15s | %-10s\n",
                this.id,
                this.lastName,
                this.firstName,
                calAge(),
                getDob(),
                this.workingDay,
                calSalary());
    }
}
