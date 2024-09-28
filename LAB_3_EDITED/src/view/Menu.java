package view;

public class Menu {
    
    public static void showMainMenu(){
        System.out.println("\t\t\t~~~~~~~~~~M.E.N.U~~~~~~~~~~");
        System.out.println("1. Add employee");
        System.out.println("2. Display employee");
        System.out.println("3. Sorting according to salary (descending)");
        System.out.println("4. Delete employee");
        System.out.println("5. Export average salary with each type of employee");
        System.out.println("0. Exit");
    }
    
    
    public static void showSubMenu(){
        System.out.println("1. Full time employee");
        System.out.println("2. Part time employee");
        System.out.println("3. Back");
    }
    
    public static void showDetailMenu(){
        System.out.println("1. Show all");
        System.out.println("2. Show detail");
        System.out.println("3. Back");
    }

}
