package greeter.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Swing on");
        this.frame.setPreferredSize(new Dimension(400, 200));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JLabel textBox = new JLabel("Hi!");
        container.add(textBox);
    }

    public JFrame getFrame() {
        return frame;
    }
}
