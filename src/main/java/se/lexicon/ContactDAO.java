package se.lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class ContactDAO {

    static String[] names = new String[10];// accessible everywhere
    static String[] phone = new String[10];
    static int count = 0;//the system will count the number of input


    public static void addContact(String name, String phoneNumber) {



        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name) && phone[i].equalsIgnoreCase(phoneNumber)) {
                System.out.println("The contact already exists!");
                return;//stops adding names
            }
        }

        names[count] = name;
        phone[count] = phoneNumber;
        count++;

        System.out.println("Contact: " + name + "|" + phoneNumber + " saved! ");

    }


    static void searchName(Scanner scanner) {


        System.out.println("Choose searching by name or by phone:");
        System.out.println("1. Searching by name");
        System.out.println("2. Searching by phone");

        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            System.out.println("Enter the name you want to search");

            String searchedName = scanner.nextLine();

            boolean found = false;

            for (int i = 0; i < count; i++) {


                if (names[i].toLowerCase().startsWith(searchedName.toLowerCase())) { // the search will not be case sensitive
                    System.out.println(names[i] + "|" + phone[i]);
                    found = true;

                }

            }
            if (!found) {
                System.out.println("No match found!");
            }
        } else if (option == 2) {
            System.out.println("Enter th phone number you want to search");
            String searchedPhone = scanner.nextLine();

            boolean found = false;
            for (int i = 0; i < count; i++) {

                if (phone[i].equals(searchedPhone)) {
                    System.out.println(names[i] + "|" + phone[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No match found!");

            }

        }


    }

    static void listName() {

        System.out.println("------List of all names------");

        if (count == 0) {
            System.out.println("The list is empty, enter new contact");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + "|" + phone[i]);
        }


    }

    static void sortContact() {

        for (int i=0; i<count-1; i++){//the first name in the array

            for (int j= i+1; j<count; j++){// the second name in the array
                if (names[i].compareToIgnoreCase(names[j])> 0)  {// this will compare two names alphabetically
                    String swapName = names[i];// this new parameter will swap names alphabetically
                    names[i] = names[j];
                    names[j] = swapName;

                    String swapPhone = phone[i];
                    phone[i]= phone[j];
                    phone[j] = swapPhone;

                }
            }
        }
        System.out.println("Contacts sorted successfully!");
        for (int i=0; i<count; i++){
            System.out.println(names[i] + "|" + phone[i]);
        }

    }




}



