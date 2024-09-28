package model;

import java.text.ParseException;

public class PartTimeEmployee extends Employee {

    private final float discount = 0.5f;

    public PartTimeEmployee(String id, String lastName, String firstName, String dob, int workingDay) throws ParseException {
        super(id, lastName, firstName, dob, workingDay);
    }

    @Override
    public float calSalary() {
        return this.workingDay * 1000000 * this.discount;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
