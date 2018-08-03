/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.Set;

/**
 *
 * @author tomro
 */import java.util.*;
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String , Set<String>> words;

    public PersonalMultipleEntryDictionary() {
        this.words = new HashMap<String, Set<String>>();
    }
    
    
    

    @Override
    public void add(String word, String entry) {
        if (!this.words.containsKey(word)) {
            this.words.put(word, new HashSet<String>());
            this.words.get(word).add(entry);
        } else {
            this.words.get(word).add(entry);
        }
    }

    @Override
    public Set<String> translate(String word) {
        if (!this.words.containsKey(word)) {
            return null;
        } else {
            return this.words.get(word);
        }
    }

    @Override
    public void remove(String word) {
        if (this.words.containsKey(word)) {
            this.words.remove(word);
        }
    }
    
    
}
