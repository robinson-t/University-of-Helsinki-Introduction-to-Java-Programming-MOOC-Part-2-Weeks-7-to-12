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
public class Moveable {
    private int x;
    private int y;

    public Moveable(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void move(int xChange , int yChange) {
        this.x += xChange;
        this.y += yChange;
    }
    
    public int getXPosition() {
        return this.x;
    }
    
    public int getYPosition() {
        return this.y;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }
    
    
    
}
