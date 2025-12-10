package se.lexicon;

import java.util.Scanner;

public class ContactApp {

    static String [] names= new String[10];// accessible everywhere
    static int count = 0;//the system will count the number of input

    Scanner scanner = new Scanner(System.in);

    void main(){

        while (true){//keeps showing the menu until user chooses to exit


        System.out.println("=====Contact Management App========");
        System.out.println("1. Add contacts");
        System.out.println("2. Search by name");
        System.out.println("3. Display all contacts");
        System.out.println("0. Exit");

        System.out.println("Choose an option:");

        //code to choose options

        int option = scanner.nextInt();
        scanner.nextLine();// to wait for the input first


        switch (option){
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
                System.out.println("Goodbye!");
                break;// stops the loop

            default:
                System.out.println("Invalid option. Please choose a valid option!");


        }

        }

    }


    static void addNames(Scanner scanner){

        /*if (count== names.length){
            System.out.println("Constact list is full!");
            return;
        }*/
        System.out.println("Please enter the name: ");
        String name= scanner.nextLine();// asks for the name

        System.out.println("Please enter the phone number: ");
        String phone= scanner.nextLine();//asks for the phone and saves it

        String newContact = name + "|" + phone;

        for (int i=0; i<count; i++){
            if (names[i].equalsIgnoreCase(newContact)){
                System.out.println("The contact already exists!");
                return;//stops adding names
            }
        }
        names[count]= newContact;
        count++;// to update the count, otherwise , the list will still be empty

        System.out.println("Contact: " + name + "|" + phone + " saved! ");

    }


    static void searchName(Scanner scanner){

        System.out.println("Enter the name you want to search");

        String searchedName = scanner.nextLine();

        boolean found = false;


        for (int i=0; i<count; i++){


            if (names[i].toLowerCase().startsWith(searchedName.toLowerCase())){ // the search will not be case sensitive
                System.out.println(names[i]);
                found=true;


            }

        }
        if(!found){
            System.out.println("No match found!");
        }



    }

    static void listName (){

        System.out.println("------List of all names------");

        if (count==0){
            System.out.println("The list is empty, enter new contact");
            return;
        }

        for (int i = 0; i< count; i++){
            System.out.println(names[i]);
        }



    }

    static void exit(){

    }


}
