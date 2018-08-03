/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
public class Calculator {
    private int operations;
    private Reader reader;
    
    public Calculator() {
        this.reader = new Reader();
        this.operations = 0;
    }
    
    public void start() {
        while (true) {
            System.out.println("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }
            
            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
                
            } else if (command.equals("product")) {
                product();
            }
        }
        
        statistics();
    }
    
    private void statistics() {
        System.out.println("Calculations done "+ this.operations);
    }
    
    private void sum() {
        System.out.println("value1: ");
        int value1 = reader.readInteger();
        System.out.println("value2: ");
        int value2 = reader.readInteger();
        System.out.println("sum of the values " + (value1 + value2));
        operations++;
    }
    
    private void difference() {
        System.out.println("value1: ");
        int value1 = reader.readInteger();
        System.out.println("value2: ");
        int value2 = reader.readInteger();
        int difference;
        
        /*if (value1 > value2) {
            difference = value1-value2;
        } else if (value2 > value1 ) {
            difference = value2 - value1 ;
        } */
        if (value1 != value2) {
            difference = value1 - value2;
        }
        else {
            difference = 0;
        }
        System.out.println("difference of the values " + difference);
        operations++;
        
    }
    
    private void product() {
        System.out.println("value1: ");
        int value1 = reader.readInteger();
        System.out.println("value2: ");
        int value2 = reader.readInteger();
        System.out.println("product of the values " + (value1 * value2));
        operations++;
    }
    
    
}
