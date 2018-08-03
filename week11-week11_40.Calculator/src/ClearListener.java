
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
public class ClearListener implements ActionListener {
private JTextField field;
private JButton clear;
private JTextField input;
    public ClearListener(JTextField resultsField, JButton clear, JTextField input) {
        this.field = resultsField;
        this.input = input;
        this.clear = clear;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.field.setText("0");
        this.clear.setEnabled(false);
        this.input.setText("");
    }
    
}
