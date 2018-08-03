package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        
        this.frame = new JFrame("Title");
        this.frame.setPreferredSize(new Dimension(500,200));
        createComponents(this.frame.getContentPane());
        frame.pack();
        this.frame.setVisible(true);
        
        
        
        
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        this.frame.setLayout(layout);
        
        JTextField textField = new JTextField();
        JButton button = new JButton("Copy!");
        JLabel text = new JLabel();
        
        ActionEventListener listener = new ActionEventListener(text , textField);
        button.addActionListener(listener);
        
        container.add(textField);
        container.add(button);
        container.add(text);
        
    }
}
