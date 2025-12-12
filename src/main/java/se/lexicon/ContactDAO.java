package se.lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class ContactDAO {

    static String[] names = new String[10];// accessible everywhere
    static String[] phone = new String[10];
    static int count = 0;//the system will count the number of input

    Scanner scanner = new Scanner(System.in);

    void main() { // menu

        while (true) {//keeps showing the menu until user chooses to exit


            System.out.println("=====Contact Management App========");
            System.out.println("1. Add contacts");
            System.out.println("2. Search by name");
            System.out.println("3. Display all contacts");
            System.out.println("4. Sort contact");
            System.out.println("5. Delete a contact");
            System.out.println("6. Exit");

            System.out.println("Choose an option:");

            //code to choose options

            int option = scanner.nextInt();
            scanner.nextLine();// to wait for the input first


            switch (option) {
                case 1:
                    addNames(scanner);
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
                    deleteContact(scanner);
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    return;// stops the whole program

                default:
                    System.out.println("Invalid option. Please choose a valid option!");


            }

        }

    }


    static void addNames(Scanner scanner) {

        System.out.println("Please enter the name: ");
        String name = scanner.nextLine();// asks for the name

        System.out.println("Please enter the phone number: ");
        String phoneNumber = scanner.nextLine();//asks for the phone and saves it

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
        for (int i=0; i<count-1; i++){ //the first name in the array
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
    static void deleteContact(Scanner scanner){
        System.out.println("Enter the name of the contact you want to delete: ");
        String nameToDelete = scanner.nextLine();

        int indexToDelete = -1;// we assume that the contact is not found

        for (int i=0; i<count; i++){
            if (names[i].equalsIgnoreCase(nameToDelete)){
                indexToDelete = i;
                break;
            }
        }
        if(indexToDelete== -1){
            System.out.println("Contact not found!");
            return;
        }

        //shifts all contacts left after deleting one item
        for(int i= indexToDelete; i<count -1; i++){
            names[i] = names[i+1];
            phone[i] = phone[i+1];
        }

        //clear last item to avoid duplicates and update count
        names[count-1] = null;
        phone[count-1] = null;
        count--;

        System.out.println("The contact have been successfully deleted!");

    }




}



