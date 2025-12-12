package se.lexicon;

import java.util.Scanner;

public class ConsoleUI {
    
    private Scanner scanner = new Scanner(System.in);
    private ContactDAO contactDAO = new ContactDAO();

    public void start() {
        while (true) {
            showMenu();
            try {
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        contactDAO.addNames(scanner);
                        break;
                    case 2:
                        contactDAO.searchName(scanner);
                        break;
                    case 3:
                        contactDAO.listName();
                        break;
                    case 4:
                        contactDAO.sortContact();
                        break;
                    case 5:
                        contactDAO.deleteContact(scanner);
                        break;
                    case 6:
                        contactDAO.updateContact(scanner);
                        break;
                    case 7:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Please choose a valid option!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 1-7.");
                scanner.nextLine();
            }
        }
    }

    private void showMenu() {
        System.out.println("=====Contact Management App========");
        System.out.println("1. Add contacts");
        System.out.println("2. Search by name");
        System.out.println("3. Display all contacts");
        System.out.println("4. Sort contact");
        System.out.println("5. Delete a contact");
        System.out.println("6. Update a contact");
        System.out.println("7. Exit");
        System.out.println("Choose an option:");
    }


}