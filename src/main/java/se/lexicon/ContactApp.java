package se.lexicon;

public class ContactApp {

    void main(){
        System.out.println("=====Contact Management App========");
        System.out.println("1. Add contacts");
        System.out.println("2. Search by name");
        System.out.println("3. Display all contacts");
        System.out.println("0. Exit");



        addNames();
    }

    static void addNames(){
        String [] names = {"John Smith", "Ange Ornella Nibaruta", "Jane Doe ", "Robert Johnson", "Jenna Williams"};
        for (String name: names){
            System.out.println(name);
        }


    }


}
