/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mooc.logic;

import mooc.ui.*;
/**
 *
 * @author tomro
 */
public class ApplicationLogic {
    private UserInterface ui;

    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }
    
    public void execute(int howManyTimes) {
        int howMany = howManyTimes;
        for (int i = howMany; i>0; i--) {
            System.out.println("The application logic works");
            this.ui.update();
        }
    }
}
