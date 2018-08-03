package movingfigure;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Figure figure;
    private DrawingBoard board;

    public UserInterface(Figure figure) {
        this.figure = figure;
        this.board = new DrawingBoard(this.figure);
    }

    
    
    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        addListeners();

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        
        container.add(board);
        
    }

    private void addListeners() {
        KeyboardListener listener = new KeyboardListener(this.board, this.figure);
        this.frame.addKeyListener(listener);
    }

    public JFrame getFrame() {
        return frame;
    }
}
