/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;
import java.util.Scanner;
/**
 *
 * @author tomro
 */
public class Interface {
    private Scanner reader;
    private Dungeon dungeon;

    public Interface(Scanner reader) {
        this.reader = reader;
    }
    
    public void start(Dungeon dungeon) {
        this.dungeon = dungeon;
        
        while (true) {
            dungeon.printMovesRemaining();
            System.out.println("");
            dungeon.printAllCharacters();
            System.out.println("");
            dungeon.printBoard();
            System.out.println("");
            String playerInput = reader.nextLine();
            processMove(playerInput);
            int state = this.dungeon.checkWinLose();
            if (state == 0) {
                System.out.println("YOU LOSE");
                break;
            } else if (state == 1) {
                System.out.println("YOU WIN");
                break;
            }
            
        }
    }
    
    private void processMove(String input) {
        for (int i = 0; i < input.length() ; i++) {
            char currentInput = input.charAt(i);
            if (currentInput == 's') {
                dungeon.turn(0, 1);
            } else if (currentInput == 'w') {
                dungeon.turn(0, -1);
            } else if (currentInput == 'a') {
                dungeon.turn(-1, 0);
            } else if (currentInput == 'd') {
                dungeon.turn(1, 0);
            }
        }
        this.dungeon.loseLight();
        
    }
    
    
    
}
