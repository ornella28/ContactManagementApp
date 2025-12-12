package se.lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class ContactDAO {

    static String[] names = new String[10];// accessible everywhere
    static String[] phone = new String[10];
    static int count = 0;//the system will count the number of input




    static void addNames(Scanner scanner) {
        System.out.println("Please enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the phone number: ");
        String phoneNumber = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name) && phone[i].equalsIgnoreCase(phoneNumber)) {
                System.out.println("The contact already exists!");
                return;
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
                if (names[i].toLowerCase().startsWith(searchedName.toLowerCase())) {
                    System.out.println(names[i] + "|" + phone[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No match found!");
            }
        } else if (option == 2) {
            System.out.println("Enter the phone number you want to search");
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
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (names[i].compareToIgnoreCase(names[j]) > 0) {
                    String swapName = names[i];
                    names[i] = names[j];
                    names[j] = swapName;

                    String swapPhone = phone[i];
                    phone[i] = phone[j];
                    phone[j] = swapPhone;
                }
            }
        }
        System.out.println("Contacts sorted successfully!");
        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + "|" + phone[i]);
        }
    }
    static void deleteContact(Scanner scanner) {
        System.out.println("Enter the name of the contact you want to delete: ");
        String nameToDelete = scanner.nextLine();

        int indexToDelete = -1;
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(nameToDelete)) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1) {
            System.out.println("Contact not found!");
            return;
        }

        System.out.println("Are you sure you want to delete " + names[indexToDelete] + "? (y/n): ");
        String confirmation = scanner.nextLine();
        if (!confirmation.equalsIgnoreCase("y")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        for (int i = indexToDelete; i < count - 1; i++) {
            names[i] = names[i + 1];
            phone[i] = phone[i + 1];
        }
        names[count - 1] = null;
        phone[count - 1] = null;
        count--;
        System.out.println("The contact has been successfully deleted!");
    }

    static void updateContact(Scanner scanner) {
        System.out.println("Enter the name of the contact you want to update");
        String nameToUpdate = scanner.nextLine();

        int indexToUpdate = -1;
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(nameToUpdate)) {
                indexToUpdate = i;
                break;
            }
        }
        if (indexToUpdate == -1) {
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("Enter the new name");
        String newName = scanner.nextLine();
        System.out.println("Enter the new phone");
        String newPhone = scanner.nextLine();

        names[indexToUpdate] = newName;
        phone[indexToUpdate] = newPhone;
        System.out.println("The contact " + nameToUpdate + " has been edited successfully!");
        System.out.println("The new contact is: " + newName + "|" + newPhone);
    }




}



