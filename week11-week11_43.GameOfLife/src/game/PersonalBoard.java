/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author tomro
 */
public class PersonalBoard extends GameOfLifeBoard {
private int number;
    public PersonalBoard(int width, int height) {
        super(width, height);
        this.number = 0;
    }

    @Override
    public void initiateRandomCells(double d) {
        boolean[][] board = super.getBoard();
        Random random = new Random();
        double currentProb = 0;
        for (int i = 0 ; i< super.getWidth() ; i++) {
            for (int j = 0; j< super.getHeight(); j++) {
                currentProb = random.nextDouble();
                if (currentProb < d) {
                    board[i][j] = true;
                }
            }
        }
        
    }

    @Override
    public boolean isAlive(int i, int i1) {
        int isValid = 1;
        boolean [][] board = super.getBoard();
        if (i < 0 || i > (super.getWidth() - 1)) {
            isValid = 0;
        }
        if (i1 < 0 || i1 > (super.getHeight() - 1)) {
            isValid = 0;
        }
        
        if (isValid == 1) {
            return board[i][i1];
        } else {
            return false;
        }
    }

    @Override
    public void turnToLiving(int i, int i1) {
        int isValid = 1;
        boolean [][] board = super.getBoard();
        if (i < 0 || i > super.getWidth()) {
            isValid = 0;
        }
        if (i1 < 0 || i1 > super.getHeight()) {
            isValid = 0;
        }
        
        if (isValid == 1) {
            board[i][i1] = true;
        }
    }

    @Override
    public void turnToDead(int i, int i1) {
        int isValid = 1;
        boolean [][] board = super.getBoard();
        if (i < 0 || i > super.getWidth()) {
            isValid = 0;
        }
        if (i1 < 0 || i1 > super.getHeight()) {
            isValid = 0;
        }
        
        if (isValid == 1) {
            board[i][i1] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        int no = 0;
        boolean[][] board = super.getBoard();
        int x = i;
        int y = i1;
        
        if (x == 0 && y == (super.getHeight()-1)) {
            checkMidRight(x, y);
            checkBotRight(x, y);
            checkBotMid(x, y);
            
        } else if (x == (super.getWidth() - 1) && y == (super.getHeight() - 1)) {
            checkMidLeft(x, y);
            checkBotLeft(x, y);
            checkBotMid(x, y);
        } else if (x == (super.getWidth() - 1) && y == 0) {
            checkTopMid(x, y);
            checkTopLeft(x, y);
            checkMidLeft(x, y);
        } else if (x == 0 && y == 0) {
            checkTopMid(x, y);
            checkTopRight(x, y);
            checkMidRight(x, y);
        }
        
        else if (y == (super.getHeight() - 1)) {
            checkMidRight(x, y);
            checkBotRight(x, y);
            checkBotMid(x, y);
            checkBotLeft(x, y);
            checkMidLeft(x, y);
        } else if (x == (super.getWidth() - 1)) {
            checkTopMid(x, y);
            checkTopLeft(x, y);
            checkMidLeft(x, y);
            checkBotLeft(x, y);
            checkBotMid(x, y);
        } else if (y == 0) {
            checkMidRight(x, y);
            checkTopRight(x, y);
            checkTopMid(x, y);
            checkTopLeft(x, y);
            checkMidLeft(x, y);
        } else if (x == 0) {
            checkTopMid(x, y);
            checkTopRight(x, y);
            checkMidRight(x, y);
            checkBotRight(x, y);
            checkBotMid(x, y);
        } else {
            checkTopLeft(x, y);
            checkTopMid(x, y);
            checkTopRight(x, y);
            checkMidRight(x, y);
            checkBotRight(x, y);
            checkBotMid(x, y);
            checkBotLeft(x, y);
            checkMidLeft(x, y);
            
            
        }
        no = this.number;
        this.number = 0;
        return no;
        
        
        
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        boolean[][] board = super.getBoard();
        if (getNumberOfLivingNeighbours(x, y) < 2) {
            board[x][y] = false;
        }
        if (getNumberOfLivingNeighbours(x, y) > 3) {
            board[x][y] = false;
        }
        if (getNumberOfLivingNeighbours(x , y) == 3) {
            board[x][y] = true;
        }
    }
    
    private void checkTopLeft(int x , int y) {
        boolean[][] board = super.getBoard();
        if (isAlive(x-1, y+1)) {
            number++;
        }
        
    }
    private void checkTopMid(int x , int y) {
        boolean[][] board = super.getBoard();
        if (isAlive(x, y+1)) {
            number++;
        }
        
    }
    private void checkTopRight(int x , int y) {
        boolean[][] board = super.getBoard();
        if (isAlive(x+1, y+1)) {
            number++;
        }
        
    }
    private void checkMidRight(int x , int y) {
        boolean[][] board = super.getBoard();
        if (isAlive(x+1, y)) {
            number++;
        }
        
    }
    private void checkBotRight(int x , int y) {
        boolean[][] board = super.getBoard();
        if (isAlive(x+1, y-1)) {
            number++;
        }
        
    }
    private void checkBotMid(int x , int y) {
        boolean[][] board = super.getBoard();
        if (isAlive(x, y-1)) {
            number++;
        }
        
    }
    private void checkBotLeft(int x , int y) {
        boolean[][] board = super.getBoard();
        if (isAlive(x-1, y-1)) {
            number++;
        }
        
    }
    private void checkMidLeft(int x , int y) {
        boolean[][] board = super.getBoard();
        if (isAlive(x-1, y)) {
            number++;
        }
        
    }

    
    
}
