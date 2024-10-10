package view;

import java.util.Scanner;

public class Utils {

    public static String getValue(String msg) {
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
