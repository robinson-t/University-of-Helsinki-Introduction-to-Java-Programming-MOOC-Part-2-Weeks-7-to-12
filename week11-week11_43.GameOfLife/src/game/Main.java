package game;

import gameoflife.Simulator;

public class Main {

    public static void main(String[] args) {
        // test your program here
        PersonalBoard board = new PersonalBoard(300, 300);
        board.initiateRandomCells(0.1);

        Simulator simulator = new Simulator(board);
        simulator.simulate();
        

}
}
