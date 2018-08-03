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
public class Reader {
    private Scanner reader;
    
    public Reader() {
        this.reader = new Scanner(System.in);
        
    }
    
    public String readString() {
        String input = reader.nextLine();
        return input;
    }
    
    public int readInteger() {
        int input = Integer.parseInt(reader.nextLine());
        return input;
    }
    
    
}
