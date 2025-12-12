package se.lexicon;

import java.util.Scanner;

public class ConsoleUI {
    
    private Scanner scanner = new Scanner(System.in);
    private ContactDAO contactDAO = new ContactDAO();

    public void start() {
        while (true) {

            showMenu();
            if (!scanner.hasNextInt()){
                System.out.println("Invalid input. Please enter a number!");
                scanner.nextLine();
                continue;
            }
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    listContacts();
                    break;
                case 4:
                    sortContacts();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    updateContact();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option!");
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

    private void addContact() {
        System.out.println("Please enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        
        if (contactDAO.addContact(name, phoneNumber)) {
            System.out.println("Contact: " + name + "|" + phoneNumber + " saved! ");
        } else {
            System.out.println("The contact already exists!");
        }
    }

    private void searchContact() {
        System.out.println("Choose searching by name or by phone:");
        System.out.println("1. Searching by name");
        System.out.println("2. Searching by phone");
        
        int option = scanner.nextInt();
        scanner.nextLine();
        
        if (option == 1) {
            System.out.println("Enter the name you want to search");
            String searchedName = scanner.nextLine();
            String[] results = contactDAO.searchByName(searchedName);
            
            if (results.length == 0) {
                System.out.println("No match found!");
            } else {
                for (String result : results) {
                    System.out.println(result);
                }
            }
        } else if (option == 2) {
            System.out.println("Enter the phone number you want to search");
            String searchedPhone = scanner.nextLine();
            String[] results = contactDAO.searchByPhone(searchedPhone);
            
            if (results.length == 0) {
                System.out.println("No match found!");
            } else {
                for (String result : results) {
                    System.out.println(result);
                }
            }
        }
    }

    private void listContacts() {
        System.out.println("------List of all names------");
        String[] contacts = contactDAO.getAllContacts();
        
        if (contacts.length == 0) {
            System.out.println("The list is empty, enter new contact");
        } else {
            for (String contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private void sortContacts() {
        contactDAO.sortContacts();
        System.out.println("Contacts sorted successfully!");
        String[] contacts = contactDAO.getAllContacts();
        for (String contact : contacts) {
            System.out.println(contact);
        }
    }

    private void deleteContact() {
        System.out.println("Enter the name of the contact you want to delete: ");
        String nameToDelete = scanner.nextLine();
        
        String contactName = contactDAO.getContactName(nameToDelete);
        if (contactName == null) {
            System.out.println("Contact not found!");
            return;
        }
        
        System.out.println("Are you sure you want to delete " + contactName + "? (y/n): ");
        String confirmation = scanner.nextLine();
        if (!confirmation.equalsIgnoreCase("y")) {
            System.out.println("Deletion cancelled.");
            return;
        }
        
        if (contactDAO.deleteContact(nameToDelete)) {
            System.out.println("The contact has been successfully deleted!");
        }
    }

    private void updateContact() {
        System.out.println("Enter the name of the contact you want to update");
        String nameToUpdate = scanner.nextLine();
        
        if (contactDAO.getContactName(nameToUpdate) == null) {
            System.out.println("Contact not found!");
            return;
        }
        
        System.out.println("Enter the new name");
        String newName = scanner.nextLine();
        System.out.println("Enter the new phone");
        String newPhone = scanner.nextLine();
        
        if (contactDAO.updateContact(nameToUpdate, newName, newPhone)) {
            System.out.println("The contact " + nameToUpdate + " has been edited successfully!");
            System.out.println("The new contact is: " + newName + "|" + newPhone);
        }
    }
}