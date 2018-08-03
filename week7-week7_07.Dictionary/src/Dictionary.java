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
public class Dictionary {
    private Map<String, String> words;
    

    public Dictionary() {
        this.words = new HashMap<String, String>();
    }
    
    public String translate(String word) {
        if (this.words.containsKey(word)) {
            return this.words.get(word);
        }
        return null;
    }
    
    public void add(String word, String translation) {
        this.words.put(stringCleaner(word) , stringCleaner(translation));
                
    }
    
    private String stringCleaner(String toClean) {
        if (toClean == null) {
            return null;
        }
        
        
        String clean = toClean;
        clean = clean.toLowerCase();
        clean = clean.trim();
        return clean;
    }
    
    public int amountOfWords() {
        int no = 0;
        for (String s : this.words.keySet()) {
            no++;
        }
        return no;
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> allWords = new ArrayList<String>();
        for (String key : this.words.keySet()) {
            String current = key + " = " + this.words.get(key);
            allWords.add(current);
        }
        
        return allWords;
    }
}
