/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author tomro
 */
public class ActionEventListener implements ActionListener {
    private JLabel label;
    private JTextField field;

    public ActionEventListener(JLabel label, JTextField field) {
        this.label = label;
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String toCopy = field.getText();
        this.label.setText(toCopy);
        this.field.setText("");
    }
    
    
}
