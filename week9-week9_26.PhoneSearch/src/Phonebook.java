/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.*;
public class Phonebook {
    private final Scanner reader;
    private final List<Person> persons;

    public Phonebook(Scanner reader) {
        this.reader = reader;
        this.persons = new ArrayList<Person>();
    }
    
    public void start() {
        ui();
    }
    
    private void ui() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
        
        while (true) {
            System.out.println("");
            System.out.println("command: ");
            String choice = reader.nextLine();
            
            if (choice.equals("x")) {
                break;
            } else if (choice.equals("1")) {
                System.out.println("whose number: ");
                String name = reader.nextLine();
                System.out.println("number: ");
                String number = reader.nextLine();
                Person newEntry = new Person(name);
                newEntry.addNumber(number);
                int isIn = 0;
                for (Person p : this.persons) {
                    if (p.getName().equals(name)) {
                        isIn = 1;
                        p.addNumber(number);
                    }
                }
                if (isIn == 0) {
                    this.persons.add(newEntry);
                }
            } else if (choice.equals("2")) {
                System.out.println("whose number: ");
                String nameToSearch = reader.nextLine();
                int isIn = 0;
                for (Person p : this.persons) {
                    if (p.getName().equals(nameToSearch)) {
                        for (String s : p.getNumbers()) {
                            System.out.println(" " + s);
                            isIn = 1;
                        }
                    }
                }
                if (isIn == 0) {
                    System.out.println("  not found");
                }
            } else if (choice.equals("3")) {
                System.out.println("number: ");
                String numToFind = reader.nextLine();
                int isIn = 0;
                for (Person p : this.persons) {
                    if (p.hasNumber(numToFind)) {
                        System.out.println(" " + p.getName());
                        isIn = 1;
                    }
                }
                if (isIn == 0) {
                    System.out.println(" not found");
                }
            } else if (choice.equals("4")) {
                System.out.println("whose address: ");
                String whose = reader.nextLine();
                System.out.println("street: ");
                String street = reader.nextLine();
                System.out.println("city: ");
                String city = reader.nextLine();
                int isIn = 0;
                for (Person p : this.persons) {
                    if (p.getName().equals(whose)) {
                        p.addAddress(street + " " + city);
                        isIn = 1;
                    }
                }
                if (isIn == 0) {
                    Person newEntry = new Person(whose);
                    newEntry.addAddress(street + " " + city);
                    this.persons.add(newEntry);
                }
            } else if (choice.equals("5")) {
                System.out.println("whose information: ");
                String whose = reader.nextLine();
                int isIn = 0;
                for (Person p : this.persons) {
                    if (p.getName().equals(whose)) {
                        p.printInfo();
                        isIn = 1;
                    }
                }
                if (isIn == 0) {
                    System.out.println("  not found");
                }
            } else if (choice.equals("6")) {
                System.out.println("whose information: ");
                String toRemove = reader.nextLine();
                Iterator<Person> iter = this.persons.iterator();
                while (iter.hasNext()) {
                    Person p = iter.next();
                    if (p.getName().equals(toRemove)) {
                        iter.remove();
                    }
                }
            } else if (choice.equals("7")) {
                Collections.sort(persons);
                System.out.println("keyword (if empty, all listed): ");
                String keyWord = reader.nextLine();
                if (keyWord.equals("")) {
                    for (Person p : this.persons) {
                        System.out.println("");
                        System.out.println(" " + p.getName());
                        p.printInfo();
                    }
                } else {
                    int isIn = 0;
                    for (Person p : this.persons) {
                        if (p.hasKey(keyWord)) {
                            System.out.println("");
                            System.out.println("  " + p.getName());
                            p.printInfo();
                            isIn = 1;
                        }
                    }
                    if (isIn == 0) {
                    System.out.println(" keyword not found");
                    }
                }
                
                
            }
            
        }
        
        
    }
        
    
    
}
