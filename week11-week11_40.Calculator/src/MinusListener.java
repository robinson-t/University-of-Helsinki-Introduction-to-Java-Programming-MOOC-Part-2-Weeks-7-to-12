
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
public class MinusListener implements ActionListener{
    private JTextField output;
    private JTextField input;
    private JButton clear;

    public MinusListener(JTextField output, JTextField input, JButton clear) {
        this.output = output;
        this.input = input;
        this.clear = clear;
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try { 
        Integer.parseInt(this.input.getText()); 
        } catch(NumberFormatException a) { 
            this.input.setText("");
            return;
        } catch(NullPointerException b) {
            this.input.setText("");
            return;
        }
        
        int current = Integer.parseInt(this.output.getText());
        int nowIs = current - Integer.parseInt(this.input.getText());
        this.output.setText(nowIs + "");
        this.input.setText("");
        if (this.output.getText().equals("0")) {
            this.clear.setEnabled(false);
        } else {
            this.clear.setEnabled(true);
        }
        
    }
    
    
    
}
