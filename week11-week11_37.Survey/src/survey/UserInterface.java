package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        this.frame = new JFrame("Survey");
        this.frame.setPreferredSize(new Dimension(300, 400));
        //this.frame.setDefaultCloseOperation(WindowsConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        
        container.setLayout(layout);
        JLabel question = new JLabel("Are you?");
        container.add(question);
        ButtonGroup firstGroup = new ButtonGroup();
        JCheckBox yesBox = new JCheckBox("Yes!");
        firstGroup.add(yesBox);
        container.add(yesBox);
        JCheckBox noBox = new JCheckBox("No!");
        firstGroup.add(noBox);
        container.add(noBox);
        
        JLabel secondQ = new JLabel("Why?");
        container.add(secondQ);
        ButtonGroup secondGroup = new ButtonGroup();
        JRadioButton noReason = new JRadioButton("No reason.");
        secondGroup.add(noReason);
        container.add(noReason);
        JRadioButton becauseFun = new JRadioButton("Because it is fun!");
        secondGroup.add(becauseFun);
        container.add(becauseFun);
        
        JButton done = new JButton("Done!");
        container.add(done);
        
        
    }


    public JFrame getFrame() {
        return frame;
    }
}
