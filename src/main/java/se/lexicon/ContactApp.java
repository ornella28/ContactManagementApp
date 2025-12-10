package se.lexicon;

import java.util.Scanner;

public class ContactApp {

    Scanner scanner = new Scanner(System.in);

    void main(){
        System.out.println("=====Contact Management App========");
        System.out.println("1. Add contacts");
        System.out.println("2. Search by name");
        System.out.println("3. Display all contacts");
        System.out.println("0. Exit");

        System.out.println("Choose an option:");

        //addNames();

        //code to choose options
        int option = scanner.nextInt();
        scanner.nextLine();// to wait for the input first


        switch (option){
            case 1:
                addNames(scanner);
                break;// to stop java from continuing
        }






    }

    /*static void listNames(){
        String [] names = {"John Smith | 072 0256233", "Ange Ornella Nibaruta | 072 0256233", "Jane Doe| 072 0256634 ", "Robert Johnson| 072 0216533", "Jenna Williams| 078 0258933"};
        for (String name: names){
            System.out.println(name);
        }


    }*/

    static void addNames(Scanner scanner){
        //Scanner scanner = new Scanner(System.in);

        String [] names= new String[10];

        System.out.println("Please enter the name: ");
        names[0] = scanner.nextLine();// asks for the name

        System.out.println("Please enter the phone number: ");
        names[1] = scanner.nextLine();//asks for the phone and saves it

        // we want to check duplicates
        String[]uniqueNames = new String[10];// new array to store unique names
        int uniqueCount = 0;//how many unique names we have added
        for (int i=0; i< names.length; i++){
            boolean alreadyExists = false;

            //checks if the name is already in the unique array
            for (int j=0; j<uniqueCount; j++){
                if (names[i]== uniqueNames[j]){
                    alreadyExists=true;
                    break;//found a duplicate, stops the loop
                }
            }
            if (!alreadyExists){
                uniqueNames[uniqueCount] = names[i];
                uniqueCount++;
            }

        }

        System.out.println("Contact: " + names[0] + "|" + names[1] + " saved! ");



    }


}
