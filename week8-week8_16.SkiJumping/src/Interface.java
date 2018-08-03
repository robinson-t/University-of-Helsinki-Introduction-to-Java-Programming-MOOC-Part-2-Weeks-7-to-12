/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.Scanner;
public class Interface {
    private Scanner reader;

    public Interface(Scanner reader) {
        this.reader = reader;
    }
    
    
    
    public void start() {
        LineUp jumpers = new LineUp();
        Judge judge = new Judge();
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.println("  Participant name: ");
            String name = reader.nextLine();
            if (name.equals("")) {
                break;
            } else {
                Participant jumper = new Participant(name);
                jumpers.add(jumper);
            }
            
        }
        System.out.println("");
        System.out.println("The tournament begins!");
        System.out.println("");
        int round = 1;
        
        while (true) {
            System.out.println("Write \"jump\" to jump; otherwise you quit: ");
            String input = reader.nextLine();
            if (!input.equals("jump")) {
                break;
            }
            System.out.println("");
            System.out.println("Round " + round);
            System.out.println("");
            jumpers.print();
            System.out.println("");
            System.out.println("Results of round " + round);
            jumpers.printResults();
            round++;
            
        }
        System.out.println("");
        System.out.println("Thanks!");
        System.out.println("");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        jumpers.finalResults();
        
        

    }
    
}
