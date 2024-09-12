package LAB1;

import java.util.Scanner;

public class Lesson1 {

    /*
    Write a program to solve quadratic equations in which the
coefficients a, b and c are entered from the keyboard.
     */
    /*
    Form: a^2 + bx + c = 0(a != 0)
     */

    //method solve quadratic equation
    static void findRoot(float a, float b, float c) {
        if (a == 0) {
            if (b == 0 && c == 0) {
                System.out.println("Infinity solution!");
            } else if (b == 0) {
                System.out.println("No solution!");
            } else {
                System.out.println("Only solution: " + (-c / b));
            }
        } else {
            float delta = b * b - 4 * a * c;
            float x1, x2;
            if (delta > 0) {
                x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                System.out.println("Separate solution: \n" + "x1 = " + x1 + "\nx2 = " + x2);
            } else if (delta == 0) {
                x1 = (-b / (2 * a));
                System.out.println("Double solution: " + "x1 = x2 = " + x1);
            } else {
                System.out.println("No solution!");
            }
        }
    }

    //main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a = ");
        float a = sc.nextFloat();
        System.out.print("b = ");
        float b = sc.nextFloat();
        System.out.print("c = ");
        float c = sc.nextFloat();
        findRoot(a, b, c);
    }
}
