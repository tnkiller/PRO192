package view;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu1 {

    protected String title;// tiêu de cua menu
    protected ArrayList<String> mulChoice;// danh sach cac chuc nang

    public Menu1() {
    }

    public Menu1(String title, String[] mulChoice) {
        this.title = title;
        this.mulChoice = new ArrayList<>();
        for (String s : mulChoice) {
            this.mulChoice.add(s);
        }
    }

    public void display() {// hien thi danh sach cac chuc nang cua Menu
        System.out.println("\t" + title);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < this.mulChoice.size(); i++) {
            System.out.println((i + 1) + "." + this.mulChoice.get(i));
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public int getSelected() {// doc lua chon nguoi dung
        display();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice:   ");
        return sc.nextInt();
    }

    public abstract void execute(int n) throws ParseException;

    public void run() throws ParseException {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n >= this.mulChoice.size()) {
                break;
            }
        }
    }

}
