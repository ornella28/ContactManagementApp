package se.lexicon;

import java.util.Arrays;
import java.util.Scanner;

public class ContactDAO {

    static String[] names = new String[10];// accessible everywhere
    static String[] phone = new String[10];
    static int count = 0;//the system will count the number of input




    static boolean addContact(String name, String phoneNumber) {
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name) && phone[i].equalsIgnoreCase(phoneNumber)) {
                return false; // contact already exists
            }
        }
        names[count] = name;
        phone[count] = phoneNumber;
        count++;
        return true; // contact added successfully
    }


    static String[] searchByName(String searchedName) {
        String[] results = new String[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (names[i].toLowerCase().startsWith(searchedName.toLowerCase())) {
                results[resultCount] = names[i] + "|" + phone[i];
                resultCount++;
            }
        }
        String[] finalResults = new String[resultCount];
        System.arraycopy(results, 0, finalResults, 0, resultCount);
        return finalResults;
    }

    static String[] searchByPhone(String searchedPhone) {
        String[] results = new String[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (phone[i].equals(searchedPhone)) {
                results[resultCount] = names[i] + "|" + phone[i];
                resultCount++;
            }
        }
        String[] finalResults = new String[resultCount];
        System.arraycopy(results, 0, finalResults, 0, resultCount);
        return finalResults;
    }

    static String[] getAllContacts() {
        String[] contacts = new String[count];
        for (int i = 0; i < count; i++) {
            contacts[i] = names[i] + "|" + phone[i];
        }
        return contacts;
    }

    static void sortContacts() {
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
    }
    static boolean deleteContact(String nameToDelete) {
        int indexToDelete = -1;
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(nameToDelete)) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1) {
            return false; // contact not found
        }

        for (int i = indexToDelete; i < count - 1; i++) {
            names[i] = names[i + 1];
            phone[i] = phone[i + 1];
        }
        names[count - 1] = null;
        phone[count - 1] = null;
        count--;
        return true; // contact deleted successfully
    }

    static String getContactName(String nameToFind) {
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(nameToFind)) {
                return names[i];
            }
        }
        return null;
    }

    static boolean updateContact(String nameToUpdate, String newName, String newPhone) {
        int indexToUpdate = -1;
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(nameToUpdate)) {
                indexToUpdate = i;
                break;
            }
        }
        if (indexToUpdate == -1) {
            return false; // contact not found
        }
        names[indexToUpdate] = newName;
        phone[indexToUpdate] = newPhone;
        return true; // contact updated successfully
    }




}



