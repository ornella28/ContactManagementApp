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

        //addNames();

        //code to choose options

        int option = scanner.nextInt();
        scanner.nextLine();// to wait for the input first


        switch (option){
            case 1:
                addNames(scanner);
                break;// to stop java from continuing

            case 2:


            case 3:
                searchName();
                break;

            case 4:


        }

        }

    }

    /*static void listNames(){
        String [] names = {"John Smith | 072 0256233", "Ange Ornella Nibaruta | 072 0256233", "Jane Doe| 072 0256634 ", "Robert Johnson| 072 0216533", "Jenna Williams| 078 0258933"};
        for (String name: names){
            System.out.println(name);
        }


    }*/

    static void addNames(Scanner scanner){

        if (count== names.length){
            System.out.println("Constact list is full!");
            return;
        }
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



                // we want to check duplicates
      /* String[]uniqueNames = new String[10];// new array to store unique names
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

        }*/

        System.out.println("Contact: " + name + "|" + phone + " saved! ");



    }

    static void searchName (){

        System.out.println("------List of all names------");

        if (count==0){
            System.out.println("The list is empty, enter new contact");
            return;
        }

        for (int i = 0; i< count; i++){
            System.out.println(names[i]);
        }



    }


}
