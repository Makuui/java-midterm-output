package midterms;

import java.util.Scanner;
import java.util.ArrayList;

public class Midterms {

    public static Scanner maku = new Scanner(System.in); //scanner accessible to all classes.
    public static ArrayList<String> uName = new ArrayList<>(); //name list
    public static ArrayList<Integer> uAge = new ArrayList<>();  // age list

     //ADD ENTRY
    static void addEntry(ArrayList<String> userNames, ArrayList<Integer> userAges) {
        System.out.println("=======Add Entry========");
        System.out.print("Enter Name: ");
        String name = maku.next();
        userNames.add(name);

        System.out.print("Enter Age: ");
        int age = maku.nextInt();
        userAges.add(age);
        reading(userNames, userAges);
    }

    //DELETE ENTRY
    static void delEntry(ArrayList<String> userNames, ArrayList<Integer> userAges) {
        System.out.println("======Delete Entry======");

        System.out.print("Enter a Name to Delete: ");
        String delUser = maku.next();

        if (userNames.contains(delUser)) {
            for (int i = 0; i < userNames.size(); i++) {
                if (delUser.equals(userNames.get(i))) {
                    System.out.println(userNames.get(i) + " has been deleted!");
                    userNames.remove(i);
                    userAges.remove(i);
                    break;
                }
            }
        } else {
            System.out.println("No " + delUser + " in the list");
        }
        reading(userNames, userAges);
    }

    // VIEW ENTRY
    static void viewEntry(ArrayList<String> userNames, ArrayList<Integer> userAges) {
        System.out.println("======VIEW ALL ENTRIES=======");

        for (int i = 0; i < userNames.size(); i++) {
            System.out.println(userNames.get(i) + " is " + userAges.get(i));
        }
        reading(userNames, userAges);
    }

    //UPDATE ENTRY
    static void upEntry(ArrayList<String> userNames, ArrayList<Integer> userAges) {
        System.out.println("======Update an Entry=======");

        System.out.print("Enter a Name to Update: ");
        String userUpdate = maku.next();

        if (userNames.contains(userUpdate)) {
            for (int i = 0; i < userNames.size(); i++) {
                if (userUpdate.equals(userNames.get(i))) {
                    System.out.print("Enter New Name: ");
                    String name = maku.next();
                    userNames.set(i, name);
                    System.out.print("Enter New Age: ");
                    int age = maku.nextInt();
                    userAges.set(i, age);
                    break;
                }
            }
        } else {
            System.out.println("No " + userUpdate + " in the list");
        }

        reading(userNames, userAges);

    }

    //EXIT 
    static void exEntry(ArrayList<String> userNames, ArrayList<Integer> userAges) {
        System.out.println("Good Bye!");
        System.out.println("""
                           *************************************************************
                           *                       MIDTERMS EXAM                       *
                           *          CODED BY MARK VINCENT ATINON BSCS 2B AI          *
                           *************************************************************""");
        System.exit(0);
    }
    //OUPUT 
    static void reading(ArrayList<String> names, ArrayList<Integer> ages) {

        System.out.println("""
                           *************************************************************
                           *                       MIDTERMS EXAM                       *
                           *          CODED BY MARK VINCENT ATINON BSCS 2B AI          *
                           *  Create an arraylist which has 2 fields for each person.  *
                           *                      The name and age.                    *
                           *************************************************************
                           *  CHOOSE FROM THE FOLLOWING OPTIONS :                      *
                           *                       1. ADD ENTRY                        *
                           *                       2. DELETE ENTRY                     *
                           *                       3. VIEW ALL ENTRIES                 *
                           *                       4. UPDATE AN ENTRY                  *
                           *                       0. EXIT                             *
                           *************************************************************""");

        int userIn = 0;
        System.out.print("Please Enter Your Choice: ");
        try {
            userIn = maku.nextInt();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Invalid input, please try again");
            System.exit(0);
        }
        switch (userIn) {

            case 0 ->
                exEntry(names, ages);
            case 1 ->
                addEntry(names, ages);
            case 2 ->
                delEntry(names, ages);
            case 3 ->
                viewEntry(names, ages);
            case 4 ->
                upEntry(names, ages);
            default -> {
                System.out.println("Invalid input, please try again");
                reading(names, ages);
            } 
        }        
    }

    public static void main(String[] args) {
        reading(uName, uAge);

    } 
}