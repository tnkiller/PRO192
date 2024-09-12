package LAB1;

import java.util.Scanner;

public class Lesson3 {
       /*
    Write a program to organize a menu consisting of 2 functions that
call the above 2 function of lesson1,2 and a function that exits the application.
     */

    //method show menu
    static void displayMenu() {
        System.out.println("1. Lesson 1");
        System.out.println("2. Lesson 2");
        System.out.println("0. Exit");
        System.out.println("----------------------");
        System.out.print("Enter your choice: ");
    }

    //main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte choice;
        do {
            displayMenu();
            choice = sc.nextByte();
            switch (choice) {
                case 1 -> {
                    System.out.print("a = ");
                    float a = sc.nextFloat();
                    System.out.print("b = ");
                    float b = sc.nextFloat();
                    System.out.print("c = ");
                    float c = sc.nextFloat();
                    Lesson1.findRoot(a, b, c);
                }
                case 2 -> {
                    System.out.print("Input the number of electricity: ");
                    float elecNum = sc.nextFloat();
                    Lesson2.ElectricBill(elecNum);
                }
                case 0 -> System.out.println("See you soon!");
                default -> System.out.println("Invalid. Please choose again!");
            }
        } while (choice != 0);
    }
}


