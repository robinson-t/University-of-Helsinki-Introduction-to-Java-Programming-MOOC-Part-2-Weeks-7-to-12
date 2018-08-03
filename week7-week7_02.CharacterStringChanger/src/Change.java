/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
public class Change {
    private char fromCharacter;
    private char toCharacter;

    public Change(char fromCharacter, char toCharacter) {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }
    
    public String change(String characterString) {
        String changed = "";
        String original = characterString;
        for (int i = 0; i < original.length() ; i++) {
            if (original.charAt(i) == this.fromCharacter) {
                changed += toCharacter;
            } else {
                changed += original.charAt(i);
            }
        }
        return changed;
    }
    
}
