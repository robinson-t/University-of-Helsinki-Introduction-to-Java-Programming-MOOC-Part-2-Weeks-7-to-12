/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

/**
 *
 * @author tomro
 */
import java.io.File;
import java.util.Scanner;
public class Analysis {
    private File file;

    public Analysis(File file) {
        this.file = file;
    }
    
    public int lines() {
        Scanner reader = null;
        
        try {
            reader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("could not open file: " + e.getMessage());
        }
        
        
        int noOfLines = 0;
        while (reader.hasNextLine()) {
            reader.nextLine();
            noOfLines++;
        }
        reader.close();
        
        return noOfLines;
    }
    
    public int characters() {
        Scanner reader = null;
        
        try {
            reader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("could not open file: " + e.getMessage());
        }
        
        
        int noOfChars = 0;
        while (reader.hasNextLine()) {
            noOfChars += reader.nextLine().length();
            noOfChars++;
            
        }
        reader.close();
        
        return noOfChars;
    }
    
    
}
