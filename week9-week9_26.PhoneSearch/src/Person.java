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
public class Person implements Comparable<Person> {
    private String name;
    private Set<String> addresses;
    private Set<String> numbers;
    private String latestAddress; //sort

    public Person(String name) {
        this.name = name;
        this.addresses = new HashSet<String>();
        this.numbers = new HashSet<String>();
    }
    
    public void addNumber(String number) {
        if (!this.numbers.contains(number)) {
            this.numbers.add(number);
        }
    }
    
    public void addAddress(String address) {
        if (!this.addresses.contains(address)) {
            this.addresses.add(address);
        }
        this.latestAddress = address; //half-arsed
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean hasNumber(String toFind) {
        for (String s : this.numbers) {
            if (s.equals(toFind)) {
                return true;
            }
        }
        return false;
    }
    
    public Set<String> getNumbers() {
        return this.numbers;
    }
    
    public boolean hasKey(String key) {
        if (this.name.contains(key)) {
            return true;
        }
        for (String s : this.numbers) {
            if (s.contains(key)) {
                return true;
            }
        }
        for (String s : this.addresses) {
            if (s.contains(key)) {
                return true;
            }
        }
        return false;
    }
    
    public void printInfo() {
        boolean hasNumber = true;
        boolean hasAddress = true;
        if (this.numbers.isEmpty()) {
            hasNumber = false;
        }
        if (this.addresses.isEmpty()) {
            hasAddress = false;
        }
        
        if (hasAddress) {
            System.out.println("  address: " + this.latestAddress);
        } else {
            System.out.println("  address unknown");
        }
        
        if (hasNumber) {
            System.out.println("  phone numbers:");
            for (String s : this.numbers) {
                System.out.println("   " + s);
            }
        } else {
            System.out.println("  phone number not found");
        }
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }
    
    
    
    
    
    
}
