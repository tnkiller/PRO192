package LAB1;

import java.util.Scanner;

public class Lesson4 {

    //show menu method
    static void displayMenu() {
        System.out.println("1. Show academic ability");
        System.out.println("2. Show sorted list");
        System.out.println("3. Show student with highest score");
        System.out.println("4. Calculate average mark");
        System.out.println("5. Normalize all names");
        System.out.println("0. Exit");
        System.out.println("-------------------------------");
        System.out.print("Enter your choice: ");
    }

    //a. show information method
    static void showInfor(String[] student, float[] mark) {
        System.out.println("-----ORIGIN-----");
        System.out.format("%-20s %-5s", "Full name", "Mark");
        System.out.println();
        for (int i = 0; i < student.length; i++) {
            System.out.format("%-20s %-5.2f\n", student[i], mark[i]);
        }
    }

    //b. generate random mark method
    static void randomizeMark(float[] score) {
        for (int i = 0; i < score.length; i++) {
            score[i] = (float) (Math.random() * 9) + 1;
        }
    }

    //c. show ability method
    static void showAcademicAbility(String[] student, float[] mark) {
        String[] ability = new String[student.length];
        for (int i = 0; i < student.length; i++) {
            if (mark[i] < 5) ability[i] = "Weak";
            else if (mark[i] >= 5 && mark[i] < 6.5) ability[i] = "Average";
            else if (mark[i] >= 6.5 && mark[i] < 7.5) ability[i] = "Good";
            else if (mark[i] >= 7.5 && mark[i] < 9) ability[i] = "Excellent";
            else ability[i] = "Very Excellent";
        }
        System.out.println("-----Student ability-----");
        System.out.format("%-20s %-5s %-15s\n", "Full name", "Mark", "Ability");
        for (int i = 0; i < student.length; i++) {
            System.out.format("%-20s %-5.2f %-15s\n", student[i], mark[i], ability[i]);
        }
    }

    //d. sorting method (Insertion sort)
    static void sortingList(String[] student, float[] mark) {
        for (int i = 0; i < student.length; i++) {
            float key = mark[i];
            String keyName = student[i];
            int j = i - 1;
            while (j >= 0 && key > mark[j]) {
                mark[j + 1] = mark[j];
                student[j + 1] = student[j];
                j--;
            }
            mark[j + 1] = key;
            student[j + 1] = keyName;
        }
        System.out.println("----After sorted----");
        System.out.format("%-20s %-5s", "Full name", "Mark");
        System.out.println();
        for (int i = 0; i < student.length; i++) {
            System.out.format("%-20s %-5.2f\n", student[i], mark[i]);
        }
    }

    //e. find the highest score method
    static void showHighestScore(String[] student, float[] mark) {
        float max = mark[0];
        int index = 0;
        for (int i = 1; i < mark.length; i++) {
            if (mark[i] > max) {
                max = mark[i];
                index = i;
            }
        }
        System.out.printf("The student with highest score: %s with %.2f", student[index], mark[index]);
        System.out.println();
    }

    //f. Calculate the average score of the students
    static void averageScore(float[] mark) {
        float sum = 0;
        for (float i : mark) {
            sum += i;
        }
        System.out.printf("Average score: %.3f\n", sum / mark.length);
    }

    //g. normalize method
    static void normalizeName(String[] student, float[] mark) {
        for (int i = 0; i < student.length; i++) {
            String low_name = student[i].toLowerCase();
            String[] separateWord = low_name.split(" ");
            for (int j = 0; j < separateWord.length; j++) {
                separateWord[j] = separateWord[j].substring(0, 1).toUpperCase() + separateWord[j].substring(1);
            }
            student[i] = String.join(" ", separateWord);
        }
        System.out.println("----After Standardization----");
        System.out.format("%-20s %-5s", "Full name", "Mark");
        System.out.println();
        for (int i = 0; i < student.length; i++) {
            System.out.format("%-20s %-5.2f\n", student[i], mark[i]);
        }
    }

    //main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of students: ");
        int numOfStudent = sc.nextInt();
        String[] student = new String[numOfStudent];
        for (int i = 0; i < numOfStudent; i++) {
            System.out.print("Name[" + i + "]: ");
            if (i == 0) sc.nextLine();
            student[i] = sc.nextLine();
        }
        float[] mark = new float[numOfStudent];
        randomizeMark(mark);
        showInfor(student, mark);

        //MENU
        byte option;
        do {
            displayMenu();
            option = sc.nextByte();
            switch (option) {
                case 1 -> showAcademicAbility(student, mark);
                case 2 -> sortingList(student, mark);
                case 3 -> showHighestScore(student, mark);
                case 4 -> averageScore(mark);
                case 5 -> normalizeName(student, mark);
                case 0 -> System.out.print("See you soon!");
                default -> System.out.println("Invalid!");
            }
        } while (option != 0);
    }
}
