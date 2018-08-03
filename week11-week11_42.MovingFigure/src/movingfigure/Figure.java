/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;

/**
 *
 * @author tomro
 */
public abstract class Figure {
    private int x;
    private int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract void draw(Graphics graphics);
    
    
    public void move(int dx , int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    
    
    
}
