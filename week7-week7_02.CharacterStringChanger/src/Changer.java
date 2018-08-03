/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.ArrayList;
import java.util.List;
public class Changer {
    List<Change> changes;
    public Changer() {
        this.changes = new ArrayList<Change>();
        
    }
    
    public void addChange(Change change) {
        this.changes.add(change);
    }
    
    public String change(String characterString) {
        String changed = characterString;
        for (Change current : this.changes) {
            changed = current.change(changed);
        }
        return changed;
    }
}
