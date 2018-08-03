
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Calculator");
        this.frame.setPreferredSize(new Dimension(400, 400));
        createComponents(this.frame.getContentPane());
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        this.frame.setLayout(layout);
        JTextField resultsField = new JTextField("0");
        resultsField.setEnabled(false);
        JTextField inputField = new JTextField();
        container.add(resultsField);
        container.add(inputField);
        
        JPanel panel = new JPanel();
        JButton button3 = new JButton("Z");
        button3.setEnabled(false);
        panel.setLayout(new GridLayout(1 , 3));
        JButton button1 = new JButton("+");
        button1.addActionListener(new AddListener(resultsField, inputField, button3));
        JButton button2 = new JButton("-");
        button2.addActionListener(new MinusListener(resultsField, inputField, button3));
        
        button3.addActionListener(new ClearListener(resultsField, button3, inputField));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        container.add(panel);
        
        
    }

    public JFrame getFrame() {
        return frame;
    }
}