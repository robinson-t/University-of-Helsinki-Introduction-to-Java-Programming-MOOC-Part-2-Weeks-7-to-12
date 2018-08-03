/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;
import java.util.*;
/**
 *
 * @author tomro
 */
public class Dungeon {
private int length;
private int height;
private int vampiresNo;
private int noOfMoves;
private boolean vampiresMove;
private List<Moveable> vampires;
private Moveable playerCharacter;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampiresNo = vampires;
        this.noOfMoves = moves;
        this.vampiresMove = vampiresMove;
        this.vampires = new ArrayList<Moveable>();
        this.playerCharacter = new Player();
        generateNewVampires(vampires);
    }
    
    public void run() {
        Scanner reader = new Scanner(System.in);
        Interface ui = new Interface(reader);
        ui.start(this);
    }
    
    public void printMovesRemaining() {
        System.out.println(this.noOfMoves);
    }
    
    public void printAllCharacters() {
        System.out.println(this.playerCharacter);
        for (Moveable m : this.vampires) {
            System.out.println(m);
        }
        
    }
    
    public void printBoard() {
        for (int i = 0; i < this.height ; i++) {
            String line = "";
            for (int j = 0; j < this.length; j++) {
                if (this.playerCharacter.getXPosition() == j && this.playerCharacter.getYPosition() == i) {
                    line += "@";
                } else {
                    int isIn = 0;
                    for (Moveable m : this.vampires) {
                        if (m.getXPosition() == j && m.getYPosition() == i) {
                            line += "v";
                            isIn = 1;
                        }
                    }
                    if (isIn == 0) {
                        line += ".";
                    }
                }
            }
            System.out.println(line);
        }
    }
    
    public boolean checkIfPlayerMoveIsValid(int xChange , int yChange) {
        if ((this.playerCharacter.getXPosition() + xChange) > this.length -1) {
            return false;
        } else if (this.playerCharacter.getXPosition() + xChange < 0) {
            return false;
        } else if (this.playerCharacter.getYPosition() + yChange > this.height -1) {
            return false;
        } else if (this.playerCharacter.getYPosition() + yChange < 0) {
            return false;
        }
        return true;
    }
    
    public boolean checkIfVampirePositionIsValid(int x, int y) {
        for (Moveable m : this.vampires) {
            if (m.getXPosition() == x && m.getYPosition() == y) {
                return false;
            } 
        }
        if (x > this.length) {
            return false;
        } else if (x < 0) {
            return false;
        } else if (y > this.height) {
            return false;
        } else if (y < 0) {
            return false;
        }
        
        return true;
    }
    
    private void generateNewVampires(int noOf) {
        
        Random random = new Random();
        for (int i = 0; i < noOf; i++) {
            while (true) {
                int x = random.nextInt(this.length - 1) + 1;
                int y = random.nextInt(this.height - 1) + 1; //ensure not 0 for either value
                if (checkIfVampirePositionIsValid(x , y)) {
                    this.vampires.add(new Vampire(x , y));
                    break;
                }
            }
        }
    }
    
    public void loseLight () {
        this.noOfMoves--;
    }
    
    private void checkCollision() {
        ArrayList<Moveable> toBeRemoved = new ArrayList<Moveable>();
        for (Moveable m : this.vampires) {
            if (m.getXPosition() == this.playerCharacter.getXPosition()) {
                if (m.getYPosition() == this.playerCharacter.getYPosition()) {
                    toBeRemoved.add(m);
                }
            }
        }
        this.vampires.removeAll(toBeRemoved);
    }
    
    public void turn(int xChange, int yChange) {
        Random random = new Random();
        if (checkIfPlayerMoveIsValid(xChange , yChange)) {
            this.playerCharacter.move(xChange, yChange);
            checkCollision();
        }
        if (!this.vampiresMove) {
            return;
        }
        for (Moveable m : this.vampires) {
            int change = random.nextInt(3); //possibly implement loop for valid moves
            int VxChange = 0;
            int VyChange = 0;
            if (change == 0) {
                VxChange = -1;
            } else if (change == 1) {
                VxChange = 1;
            } else if (change == 2) {
                VyChange = -1;
            } else {
                VyChange = 1;
            }
            if (checkIfVampirePositionIsValid((m.getXPosition() + VxChange), (m.getYPosition() + VyChange))) {
                m.move(VxChange, VyChange);
            }
        }
        checkCollision();
    }
    
    public int checkWinLose() {
        if (this.noOfMoves == 0 && !this.vampires.isEmpty()) {
            return 0;
        } else if (this.vampires.isEmpty()) {
            return 1;
        } else return 7;
    }
    
    
    
    

    
    
}
