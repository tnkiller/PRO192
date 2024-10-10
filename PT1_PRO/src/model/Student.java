package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private int id;
    private String name;
    private Date dob;
    private float java;
    private float html;
    private float average;

    public Student() {

    }

    public Student(int id, String name, String dob, float java, float html) throws ParseException {
        this.id = id;
        this.name = name;
        this.dob = setDob(dob);
        this.java = java;
        this.html = html;
        this.average = average;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        return sdf.format(dob);
    }

    public Date getDobDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        return this.dob;

    }

    public Date setDob(String dob) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        return sdf.parse(dob);
    }

    public float getJava() {
        return java;
    }

    public void setJava(float java) {
        this.java = java;
    }

    public float getHtml() {
        return html;
    }

    public void setHtml(float html) {
        this.html = html;
    }

    public float getAverage() {
        return calAverage();
    }

    public float calAverage() {
        return (float) Math.round(((this.java + this.html) / 2) * 10) / 10;
    }

    @Override
    public String toString() {
        return String.format("%-5d | %-15s | %-15s | %-5.1f | %-5.1f | %-5.1f",
                this.id,
                this.name,
                getDob(),
                this.java,
                this.html,
                calAverage());
    }

}
