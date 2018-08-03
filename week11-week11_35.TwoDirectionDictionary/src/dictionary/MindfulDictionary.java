/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author tomro
 */
public class MindfulDictionary {
private Map<String, String> words;
private File file;
private Scanner reader;
    public MindfulDictionary() {
        this.words = new HashMap<String, String>();
        
    }
    
    public MindfulDictionary(String file) {
        this.words = new HashMap<String, String>();
        this.file = new File(file);
        
    }
    
    public boolean load() {
        try {
            

            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.words.put(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void add(String word, String translation) {
        if (!this.words.keySet().contains(word) && !this.words.values().contains(word)) {
            this.words.put(word, translation);
        }
    }
    
    public String translate(String word) {
        /*if (this.words.containsKey(word)) {
            return this.words.get(word);
        } else if (this.words.values().contains(word)) {
            for (String s : this.words.keySet()) {
                if (this.words.get(s).equals(word)) {
                    return s;
                }
            }
        }*/
        /*load();
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] parts = line.split(":");
            if (parts[0].equals(word)) {
                return parts[1];
            } else if (parts[1].equals(word)) {
                return parts[0];
            }
            
            
        }
        return null;*/
        

        if (this.words.containsKey(word)) {
            return this.words.get(word);
        } else if (this.words.containsValue(word)) {
            for (String key : this.words.keySet()) {
                if (this.words.get(key).equals(word)){
                    return key;
                }
            }
        }
        return null;
    }
    
    
    public void remove(String word) {
        
        if (this.words.keySet().contains(word)) {
            this.words.remove(word);
        } else if (this.words.values().contains(word)) {
            String toRemove = null;
            for (String s : this.words.keySet()) {
                if (this.words.get(s).equals(word)) {
                    toRemove = s;
                }
            }
            if (toRemove != null) {
                this.words.remove(toRemove);
            }
        }
    }
    
    public boolean save() {
        FileWriter writer;
        try {
            writer = new FileWriter(file);
            for (String key : this.words.keySet()) {
                writer.write(key + ":" + this.words.get(key));
                writer.write("\n");
            }
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
        
        
    }
    
}
