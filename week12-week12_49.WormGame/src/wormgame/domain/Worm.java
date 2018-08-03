/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author tomro
 */
public class Worm {
    
    private Direction direction;
    private List<Piece> components;
    private boolean shouldGrow;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        
        this.direction = originalDirection;
        
        this.components = new ArrayList<Piece>();
        this.components.add(new Piece(originalX, originalY));
        shouldGrow = true;
        
        
    }
    
    public Direction getDirection() {
        return this.direction;
    }
    
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
    
    public int getLength() {
        int l = 0;
        for (Piece p : this.components) {
            l++;
        }
        return l;
    }
    
    public List<Piece> getPieces() {
        return this.components;
    }
    
    public void move() {
        int headX = this.components.get(0).getX();
        int headY = this.components.get(0).getY();
        int changeX = this.components.get(this.components.size()-1).getX();
        int changeY = this.components.get(this.components.size()-1).getY();
        if (direction == Direction.LEFT) {
            changeX--;
        } else if (direction == Direction.RIGHT) {
            changeX++;
        } else if (direction == Direction.UP) {
            changeY--;
        } else {
            changeY++;
        }
        
        Piece newPiece = new Piece(changeX, changeY);
        
        if (this.shouldGrow) {
            this.components.add(newPiece);
            int l = 0;
            for (Piece p : this.components) {
                l++;
                
            }
            if (l >= 3) {
                shouldGrow = false;
            }
        } else {
            this.components.remove(0);
            this.components.add(newPiece);
        }
        /*
        if (this.components.size() < 3) {
            this.grow();
        }
        Piece newPiece = new Piece(this.components.get(this.components.size() - 1).getX(), this.components.get(this.components.size() - 1).getY());

        if (this.direction == Direction.UP) {
            newPiece.move(0, -1);
        } else if (this.direction == Direction.LEFT) {
            newPiece.move(-1, 0);
        } else if (this.direction == Direction.DOWN) {
            newPiece.move(0, 1);
        } else {
            newPiece.move(1, 0);
        }
        this.components.add(newPiece);
        if (!this.shouldGrow) {
            this.components.remove(0);
        } else {
            this.shouldGrow = false;
        }*/
        
        
        
    }
    
    public void grow() {
        this.shouldGrow = true;
    }
    
    public boolean runsInto(Piece piece) {
        for (Piece p : this.components) {
            if (p.runsInto(piece)) {
                return true;
            }
            
        }
        return false;
    }
    
    public boolean runsIntoItself() {
        for (Piece p1 : this.components) {
            for (Piece p2 : this.components) {
                if (p1.equals(p2)) {
                    continue;
                }
                if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
                    return true;
                }
            }
        }
        return false;
    }
}
