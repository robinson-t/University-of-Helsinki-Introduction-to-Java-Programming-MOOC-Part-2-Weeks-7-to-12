/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author tomro
 */
public class Player extends Moveable {

    public Player() {
        super(0, 0);
    }

    @Override
    public String toString() {
        return "@ " + super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
