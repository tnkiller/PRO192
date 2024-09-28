package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FullTimeEmployee extends Employee {

    private int otTime;

    public FullTimeEmployee(String id, String lastName, String firstName, String dob, int workingDay, int otTime) throws ParseException {
        super(id, lastName, firstName, dob, workingDay);
        this.otTime = otTime;
    }

    public int getOtTime() {
        return otTime;
    }

    public void setOtTime(int otTime) {
        this.otTime = otTime;
    }

    @Override
    public float calSalary() {
        return this.workingDay * 1000000 + this.otTime * 100000;
    }

    public String toStringFull() {
        return String.format("%-5s | %-10s | %-10s | %-5s | %-15s | %-15s | %-10s | %-10s\n",
                this.id,
                this.lastName,
                this.firstName,
                calAge(),
                getDob(),
                this.workingDay,
                calSalary(),
                this.otTime);
    }

}
