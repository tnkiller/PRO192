package controller;

import java.text.ParseException;

public class Run {

    //MAIN
    public static void main(String[] args) throws ParseException {
        Management mgn = new Management();
        int choice = 0;
        try {
            mgn.execute(choice);
        } catch (ParseException e) {
        }
    }

}
