package LAB1;

import java.util.Scanner;

public class Lesson2 {

    /*
    Write a program to input monthly electricity usage and calculate
electricity bill by progressive method
     If the number of electricity used is from 0 to 50, the price for each number
is 1000
     If the amount of electricity used is over 50, the price for each excess
number of electricity is 1200
     */


    static void ElectricBill(float e) {
        float bill;
        if (e > 0) {
            if (e < 50) bill = e * 1000;
            else bill = 50 * 1000 + (e - 50) * 1200;
        } else bill = -1;
        if (bill == -1) System.out.print("Invalid!");
        else System.out.println("Your electricity bill: " + bill + "VND");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number of electricity: ");
        float eNum = sc.nextFloat();
        ElectricBill(eNum);
    }
}
