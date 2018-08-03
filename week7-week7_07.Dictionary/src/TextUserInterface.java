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
public class TextUserInterface {
    private Scanner reader;
    private Dictionary dict;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dict = dictionary;
    }
    
    public void start() {
        while (true) {
            System.out.println("Statement: ");
            String input = this.reader.nextLine();
            if (input.equals("quit")) {
                break;
            } else if (input.equals("add")) {
                System.out.println("In Finnish: ");
                String inFin = this.reader.nextLine();
                System.out.println("Translation: ");
                String inEng = this.reader.nextLine();
                this.dict.add(inFin, inEng);
                
            } else if (input.equals("translate")) {
                System.out.println("Give a word: ");
                String word = this.reader.nextLine();
                String translation = this.dict.translate(word);
                System.out.println("Translation: " + translation);
            }
            
            
            
            else {
                System.out.println("Unknown statement");
            }
            
            
        }
        System.out.println("Cheers!");
    }
    
    
}
