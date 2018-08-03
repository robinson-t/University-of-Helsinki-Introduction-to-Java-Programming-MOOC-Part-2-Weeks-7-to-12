/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author tomro
 */
public class Group implements Movable {
    private List<Movable> movables;

    public Group() {
        this.movables = new ArrayList<Movable>();
    }
    
    public void addToGroup(Movable movable) {
        this.movables.add(movable);
    }
    
    

    @Override
    public void move(int dx, int dy) {
        for (Movable m : this.movables) {
            m.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (Movable m : this.movables) {
            toReturn += m.toString() + "\n";
        }
        return toReturn;
    }
    
    
    
}
