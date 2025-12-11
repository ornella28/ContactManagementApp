package se.lexicon;

import java.util.Scanner;

public class ConsoleUI {

    static Scanner scanner = new Scanner(System.in);

    public void run(){

        while (true) {//keeps showing the menu until user chooses to exit


            System.out.println("=====Contact Management App========");
            System.out.println("1. Add contacts");
            System.out.println("2. Search by name");
            System.out.println("3. Display all contacts");
            System.out.println("4. Sort contact");
            System.out.println("5. Exit");

            System.out.println("Choose an option:");

            //code to choose options

            int option = scanner.nextInt();
            scanner.nextLine();// to wait for the input first


            switch (option) {
                case 1:
                    handleAddContact();
                    break;// to stop java from continuing

                case 2:
                    searchName(scanner);
                    break;

                case 3:
                    listName();
                    break;


                case 4:
                    sortContact();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;// stops the whole program

                default:
                    System.out.println("Invalid option. Please choose a valid option!");


            }

        }
    }

    public static void printMainMenu(){

        System.out.println("=====Contact Management App========");
        System.out.println("1. Add contacts");
        System.out.println("2. Search by name");
        System.out.println("3. Display all contacts");
        System.out.println("4. Sort contact");
        System.out.println("5. Exit");

        System.out.println("Choose an option:");

    }

    public static void handleAddContact(){

        System.out.println("Please enter the name: ");
        String name = scanner.nextLine();// asks for the name

        System.out.println("Please enter the phone number: ");
        String phoneNumber = scanner.nextLine();//asks for the phone and saves it

        ContactDAO.addContact(name, phoneNumber);

    }
}
